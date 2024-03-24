package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DiemRenLuyenModel;

public class DiemRenLuyenCtrl {

    public static List<DiemRenLuyenModel> timTatCaDRL() throws ClassNotFoundException {
        List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                         SELECT SinhVien.MaSinhVien, SinhVien.HoTen, HocKy, NamHoc, NguoiCham, TongDiem, XepLoai,
                         TrangThaiCham, d1, d2, d3, d4, d5
                         FROM DiemRenLuyen, PhieuDRL, SinhVien, NamHoc
                         WHERE PhieuDRL.MaSinhVien=SinhVien.MaSinhVien AND DiemRenLuyen.MaPhieuDRL=PhieuDRL.MaPhieuDRL
                         AND PhieuDRL.MaNamHoc=NamHoc.MaNamHoc
                         NamHoc.TrangThaiHienThi=1
                         AND GETDATE() >= NgayBatDau
                         """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                if (resultSet.getInt("TrangThaiXoa") == 0) {
                    DiemRenLuyenModel drl = new DiemRenLuyenModel(
                            resultSet.getString("HocKy"),
                            resultSet.getString("NamHoc"),
                            resultSet.getString("XepLoai"),
                            resultSet.getString("TrangThaiCham"),
                            resultSet.getFloat("TongDiem"),
                            resultSet.getFloat("d1"),
                            resultSet.getInt("d2"),
                            resultSet.getInt("d3"),
                            resultSet.getInt("d4"),
                            resultSet.getInt("d5"),
                            resultSet.getString("MaSinhVien"),
                            resultSet.getString("HoTen")
                    );
                    dsDiemRenLuyen.add(drl);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemRenLuyenCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDiemRenLuyen;
    }

    public static List<DiemRenLuyenModel> timTatCaDiemCuaSV(String maSinhVien) throws ClassNotFoundException {
        List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();
        String sql = """
                     SELECT SinhVien.MaSinhVien, SinhVien.HoTen, HocKy, NamHoc, NguoiCham, TongDiem, XepLoai,
                     TrangThaiCham, d1, d2, d3, d4, d5, NgayBatDau, NgayKetThuc
                     FROM DiemRenLuyen
                     INNER JOIN PhieuDRL ON DiemRenLuyen.MaPhieuDRL=PhieuDRL.MaPhieuDRL
                     INNER JOIN SinhVien ON PhieuDRL.MaSinhVien=SinhVien.MaSinhVien
                     INNER JOIN NamHoc ON PhieuDRL.MaNamHoc=NamHoc.MaNamHoc
                     WHERE PhieuDRL.MaSinhVien=?
                     AND Lop.TrangThaiHienThi=1 AND NamHoc.TrangThaiHienThi=1
                     AND NguoiCham='CoVan' AND GETDATE() >= NgayBatDau
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maSinhVien);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DiemRenLuyenModel drl = new DiemRenLuyenModel(
                        resultSet.getString("HocKy"),
                        resultSet.getString("NamHoc"),
                        resultSet.getString("XepLoai"),
                        resultSet.getString("TrangThaiCham"),
                        resultSet.getFloat("TongDiem"),
                        resultSet.getFloat("d1"),
                        resultSet.getInt("d2"),
                        resultSet.getInt("d3"),
                        resultSet.getInt("d4"),
                        resultSet.getInt("d5"),
                        resultSet.getString("MaSinhVien"),
                        resultSet.getString("HoTen")
                );
                dsDiemRenLuyen.add(drl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemRenLuyenCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDiemRenLuyen;
    }

    public static List<DiemRenLuyenModel> timDiemCuaLop(String tuKhoa, String maLop, String hocKy, String namHoc) throws ClassNotFoundException {
        List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();
        String sql = """
                     SELECT SinhVien.MaSinhVien, SinhVien.HoTen, HocKy, NamHoc, NguoiCham, TongDiem, XepLoai, TrangThaiCham, d1, d2, d3, d4, d5
                     FROM DiemRenLuyen
                     INNER JOIN PhieuDRL ON PhieuDRL.MaPhieuDRL = DiemRenLuyen.MaPhieuDRL
                     INNER JOIN SinhVien ON PhieuDRL.MaSinhVien=SinhVien.MaSinhVien
                     INNER JOIN Lop ON Lop.MaLop = SinhVien.MaLop
                     INNER JOIN NamHoc ON PhieuDRL.MaNamHoc=NamHoc.MaNamHoc
                     WHERE (SinhVien.MaSinhVien LIKE ? OR SinhVien.HoTen LIKE ?)
                     AND (SinhVien.MaLop=? AND HocKy=? AND NamHoc=? AND NguoiCham='CoVan')
                     AND Lop.TrangThaiHienThi=1 AND NamHoc.TrangThaiHienThi=1
                     AND GETDATE() >= NgayBatDau
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, maLop);
            statement.setString(4, hocKy);
            statement.setString(5, namHoc);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DiemRenLuyenModel drl = new DiemRenLuyenModel(
                        resultSet.getString("HocKy"),
                        resultSet.getString("NamHoc"),
                        resultSet.getString("XepLoai"),
                        resultSet.getString("TrangThaiCham"),
                        resultSet.getFloat("TongDiem"),
                        resultSet.getFloat("d1"),
                        resultSet.getInt("d2"),
                        resultSet.getInt("d3"),
                        resultSet.getInt("d4"),
                        resultSet.getInt("d5"),
                        resultSet.getString("MaSinhVien"),
                        resultSet.getString("HoTen")
                );
                dsDiemRenLuyen.add(drl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemRenLuyenCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDiemRenLuyen;
    }

    public static DiemRenLuyenModel timDRLDayDu(String maSinhVien, String hocKy, String namHoc, String nguoiCham) throws ClassNotFoundException {
        DiemRenLuyenModel drl = null;
        String sql = """
                     SELECT DISTINCT *
                     FROM DiemRenLuyen
                     INNER JOIN PhieuDRL ON PhieuDRL.MaPhieuDRL = DiemRenLuyen.MaPhieuDRL
                     INNER JOIN SinhVien ON PhieuDRL.MaSinhVien = SinhVien.MaSinhVien
                     INNER JOIN NamHoc ON PhieuDRL.MaNamHoc=NamHoc.MaNamHoc
                     INNER JOIN Lop ON SinhVien.MaLop=Lop.MaLop
                     WHERE PhieuDRL.MaSinhVien=? AND HocKy=? AND NamHoc=? AND NguoiCham=?
                     AND Lop.TrangThaiHienThi=1 AND NamHoc.TrangThaiHienThi=1
                     AND GETDATE() >= NgayBatDau
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maSinhVien);
            statement.setString(2, hocKy);
            statement.setString(3, namHoc);
            statement.setString(4, nguoiCham);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    drl = new DiemRenLuyenModel(
                            resultSet.getString("HocKy"),
                            resultSet.getString("NamHoc"),
                            resultSet.getString("NguoiCham"),
                            resultSet.getString("XepLoai"),
                            resultSet.getString("TrangThaiCham"),
                            resultSet.getFloat("TongDiem"),
                            resultSet.getInt("d11"),
                            resultSet.getInt("d12a"),
                            resultSet.getInt("d12b"),
                            resultSet.getInt("d12c"),
                            resultSet.getInt("d12d"),
                            resultSet.getInt("d12e"),
                            resultSet.getInt("d12g"),
                            resultSet.getInt("d13"),
                            resultSet.getInt("d13a"),
                            resultSet.getInt("d13b"),
                            resultSet.getInt("d13c"),
                            resultSet.getInt("d13d"),
                            resultSet.getFloat("d14"),
                            resultSet.getInt("d15"),
                            resultSet.getFloat("d1"),
                            resultSet.getInt("d21"),
                            resultSet.getInt("d21a"),
                            resultSet.getInt("d21b"),
                            resultSet.getInt("d22a"),
                            resultSet.getInt("d22b"),
                            resultSet.getInt("d23a"),
                            resultSet.getInt("d23b"),
                            resultSet.getInt("d2"),
                            resultSet.getInt("d31"),
                            resultSet.getInt("d32"),
                            resultSet.getInt("d33"),
                            resultSet.getInt("d34"),
                            resultSet.getInt("d35"),
                            resultSet.getInt("d3"),
                            resultSet.getInt("d41"),
                            resultSet.getInt("d42"),
                            resultSet.getInt("d43"),
                            resultSet.getInt("d44"),
                            resultSet.getInt("d45"),
                            resultSet.getInt("d46"),
                            resultSet.getInt("d4"),
                            resultSet.getInt("d51"),
                            resultSet.getInt("d52"),
                            resultSet.getInt("d53"),
                            resultSet.getInt("d5"),
                            resultSet.getString("MaSinhVien"),
                            resultSet.getString("MaLop"),
                            resultSet.getString("HoTen"),
                            resultSet.getDate("NgaySinh"),
                            resultSet.getDate("NgayKetThuc")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemRenLuyenCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return drl;
    }

    public static List<DiemRenLuyenModel> timKiemDRL(String tuKhoa, String lop, int maNamHoc, String hocKy) throws ClassNotFoundException {
        List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();
        String sql = """
                    SELECT DISTINCT SinhVien.MaSinhVien, SinhVien.HoTen, HocKy, NamHoc, NguoiCham,
                    TongDiem, XepLoai, TrangThaiCham, d1, d2, d3, d4, d5, NgayBatDau, NgayKetThuc
                    FROM DiemRenLuyen
                    INNER JOIN PhieuDRL ON PhieuDRL.MaPhieuDRL = DiemRenLuyen.MaPhieuDRL
                    INNER JOIN SinhVien ON PhieuDRL.MaSinhVien=SinhVien.MaSinhVien
                    INNER JOIN Lop ON Lop.MaLop = SinhVien.MaLop
                    INNER JOIN NamHoc ON PhieuDRL.MaNamHoc=NamHoc.MaNamHoc
                    WHERE NguoiCham='CoVan'
                    AND (SinhVien.MaSinhVien LIKE ? OR SinhVien.HoTen LIKE ?)
                    AND (Lop.MaLop=? OR ?='') AND (NamHoc.MaNamHoc=? OR ?='') AND (HocKy=? OR ?='')
                    AND Lop.TrangThaiHienThi=1 AND NamHoc.TrangThaiHienThi=1
                    AND GETDATE() >= NgayBatDau
                    """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, lop);
            statement.setString(4, lop);
            statement.setInt(5, maNamHoc);
            statement.setInt(6, maNamHoc);
            statement.setString(7, hocKy);
            statement.setString(8, hocKy);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    DiemRenLuyenModel drl = new DiemRenLuyenModel(
                            resultSet.getString("HocKy"),
                            resultSet.getString("NamHoc"),
                            resultSet.getString("XepLoai"),
                            resultSet.getString("TrangThaiCham"),
                            resultSet.getFloat("TongDiem"),
                            resultSet.getFloat("d1"),
                            resultSet.getInt("d2"),
                            resultSet.getInt("d3"),
                            resultSet.getInt("d4"),
                            resultSet.getInt("d5"),
                            resultSet.getString("MaSinhVien"),
                            resultSet.getString("HoTen"),
                            resultSet.getDate("NgayBatDau"),
                            resultSet.getDate("NgayKetThuc")
                    );
                    dsDiemRenLuyen.add(drl);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemRenLuyenCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDiemRenLuyen;
    }

    public static String timMaPhieuDRL(String maSinhVien, String hocKy, String namHoc) throws ClassNotFoundException {
        String idPhieuDRL = "";
        String sql = """
                     SELECT DISTINCT DiemRenLuyen.MaPhieuDRL FROM DiemRenLuyen, PhieuDRL, NamHoc
                     WHERE DiemRenLuyen.MaPhieuDRL=PhieuDRL.MaPhieuDRL AND PhieuDRL.MaNamHoc=NamHoc.MaNamHoc
                      AND MaSinhVien = ? AND NamHoc = ? AND HocKy = ?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maSinhVien);
            statement.setString(2, namHoc);
            statement.setString(3, hocKy);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                idPhieuDRL = resultSet.getString("MaPhieuDRL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemRenLuyenCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPhieuDRL;
    }

    public static void themMoiDRL(String maPhieuDRL, String nguoiCham) throws ClassNotFoundException {
        String sql = "INSERT INTO DiemRenLuyen (MaPhieuDRL, NguoiCham) VALUES (?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maPhieuDRL);
            statement.setString(2, nguoiCham);

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void chamDiemSV(DiemRenLuyenModel drl) throws ClassNotFoundException {
        String sql = "UPDATE DiemRenLuyen SET TongDiem=?, XepLoai=?, TrangThaiCham=?, d11=?, d12a=?, d12b=?, d12c=?, d12d=?, d12e=?, d12g=?, d13=?, d13a=?, d13b=?, d13c=?, d13d=?, d14=?, d15=?, d1=?, d21=?, d21a=?, d21b=?, d22a=?, d22b=?, d23a=?, d23b=?, d2=?, d31=?, d32=?, d33=?, d34=?, d35=?, d3=?, d41=?, d42=?, d43=?, d44=?, d45=?, d46=?, d4=?, d51=?, d52=?, d53=?, d5=? WHERE MaPhieuDRL=? AND NguoiCham=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setFloat(1, drl.getTongDiem());
            statement.setString(2, drl.getXepLoai());
            statement.setString(3, drl.getTrangThaiCham());
            statement.setFloat(4, drl.getD11());
            statement.setInt(5, drl.getD12a());
            statement.setInt(6, drl.getD12b());
            statement.setInt(7, drl.getD12c());
            statement.setInt(8, drl.getD12d());
            statement.setInt(9, drl.getD12e());
            statement.setInt(10, drl.getD12g());
            statement.setInt(11, drl.getD13());
            statement.setInt(12, drl.getD13a());
            statement.setInt(13, drl.getD13b());
            statement.setInt(14, drl.getD13c());
            statement.setInt(15, drl.getD13d());
            statement.setFloat(16, drl.getD14());
            statement.setInt(17, drl.getD15());
            statement.setFloat(18, drl.getD1());
            statement.setInt(19, drl.getD21());
            statement.setInt(20, drl.getD21a());
            statement.setInt(21, drl.getD21b());
            statement.setInt(22, drl.getD22a());
            statement.setInt(23, drl.getD22b());
            statement.setInt(24, drl.getD23a());
            statement.setInt(25, drl.getD23b());
            statement.setInt(26, drl.getD2());
            statement.setInt(27, drl.getD31());
            statement.setInt(28, drl.getD32());
            statement.setInt(29, drl.getD33());
            statement.setInt(30, drl.getD34());
            statement.setInt(31, drl.getD35());
            statement.setInt(32, drl.getD3());
            statement.setInt(33, drl.getD41());
            statement.setInt(34, drl.getD42());
            statement.setInt(35, drl.getD43());
            statement.setInt(36, drl.getD44());
            statement.setInt(37, drl.getD45());
            statement.setInt(38, drl.getD46());
            statement.setInt(39, drl.getD4());
            statement.setInt(40, drl.getD51());
            statement.setInt(41, drl.getD52());
            statement.setInt(42, drl.getD53());
            statement.setInt(43, drl.getD5());
            statement.setString(44, drl.getMaPhieuDRL());
            statement.setString(45, drl.getNguoiCham());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DiemRenLuyenCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void chamDiemBCS(DiemRenLuyenModel drl) throws ClassNotFoundException {
        String sql = "UPDATE DiemRenLuyen SET TongDiem=?, XepLoai=?, d11=?, d12a=?, d12b=?, d12c=?, d12d=?, d12e=?, d12g=?, d13=?, d13a=?, d13b=?, d13c=?, d13d=?, d14=?, d15=?, d1=?, d21=?, d21a=?, d21b=?, d22a=?, d22b=?, d23a=?, d23b=?, d2=?, d31=?, d32=?, d33=?, d34=?, d35=?, d3=?, d41=?, d42=?, d43=?, d44=?, d45=?, d46=?, d4=?, d51=?, d52=?, d53=?, d5=? WHERE MaPhieuDRL=? AND NguoiCham=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setFloat(1, drl.getTongDiem());
            statement.setString(2, drl.getXepLoai());
            statement.setFloat(3, drl.getD11());
            statement.setInt(4, drl.getD12a());
            statement.setInt(5, drl.getD12b());
            statement.setInt(6, drl.getD12c());
            statement.setInt(7, drl.getD12d());
            statement.setInt(8, drl.getD12e());
            statement.setInt(9, drl.getD12g());
            statement.setInt(10, drl.getD13());
            statement.setInt(11, drl.getD13a());
            statement.setInt(12, drl.getD13b());
            statement.setInt(13, drl.getD13c());
            statement.setInt(14, drl.getD13d());
            statement.setFloat(15, drl.getD14());
            statement.setInt(16, drl.getD15());
            statement.setFloat(17, drl.getD1());
            statement.setInt(18, drl.getD21());
            statement.setInt(19, drl.getD21a());
            statement.setInt(20, drl.getD21b());
            statement.setInt(21, drl.getD22a());
            statement.setInt(22, drl.getD22b());
            statement.setInt(23, drl.getD23a());
            statement.setInt(24, drl.getD23b());
            statement.setInt(25, drl.getD2());
            statement.setInt(26, drl.getD31());
            statement.setInt(27, drl.getD32());
            statement.setInt(28, drl.getD33());
            statement.setInt(29, drl.getD34());
            statement.setInt(30, drl.getD35());
            statement.setInt(31, drl.getD3());
            statement.setInt(32, drl.getD41());
            statement.setInt(33, drl.getD42());
            statement.setInt(34, drl.getD43());
            statement.setInt(35, drl.getD44());
            statement.setInt(36, drl.getD45());
            statement.setInt(37, drl.getD46());
            statement.setInt(38, drl.getD4());
            statement.setInt(39, drl.getD51());
            statement.setInt(40, drl.getD52());
            statement.setInt(41, drl.getD53());
            statement.setInt(42, drl.getD5());
            statement.setString(43, drl.getMaPhieuDRL());
            statement.setString(44, drl.getNguoiCham());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DiemRenLuyenCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void chamDiemCV(DiemRenLuyenModel drl) throws ClassNotFoundException {
        String sql = "UPDATE DiemRenLuyen SET TongDiem=?, XepLoai=?, TrangThaiCham=?, d11=?, d12a=?, d12b=?, d12c=?, d12d=?, d12e=?, d12g=?, d13=?, d13a=?, d13b=?, d13c=?, d13d=?, d14=?, d15=?, d1=?, d21=?, d21a=?, d21b=?, d22a=?, d22b=?, d23a=?, d23b=?, d2=?, d31=?, d32=?, d33=?, d34=?, d35=?, d3=?, d41=?, d42=?, d43=?, d44=?, d45=?, d46=?, d4=?, d51=?, d52=?, d53=?, d5=?, MaCoVanCham=? WHERE MaPhieuDRL=? AND NguoiCham=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setFloat(1, drl.getTongDiem());
            statement.setString(2, drl.getXepLoai());
            statement.setString(3, drl.getTrangThaiCham());
            statement.setFloat(4, drl.getD11());
            statement.setInt(5, drl.getD12a());
            statement.setInt(6, drl.getD12b());
            statement.setInt(7, drl.getD12c());
            statement.setInt(8, drl.getD12d());
            statement.setInt(9, drl.getD12e());
            statement.setInt(10, drl.getD12g());
            statement.setInt(11, drl.getD13());
            statement.setInt(12, drl.getD13a());
            statement.setInt(13, drl.getD13b());
            statement.setInt(14, drl.getD13c());
            statement.setInt(15, drl.getD13d());
            statement.setFloat(16, drl.getD14());
            statement.setInt(17, drl.getD15());
            statement.setFloat(18, drl.getD1());
            statement.setInt(19, drl.getD21());
            statement.setInt(20, drl.getD21a());
            statement.setInt(21, drl.getD21b());
            statement.setInt(22, drl.getD22a());
            statement.setInt(23, drl.getD22b());
            statement.setInt(24, drl.getD23a());
            statement.setInt(25, drl.getD23b());
            statement.setInt(26, drl.getD2());
            statement.setInt(27, drl.getD31());
            statement.setInt(28, drl.getD32());
            statement.setInt(29, drl.getD33());
            statement.setInt(30, drl.getD34());
            statement.setInt(31, drl.getD35());
            statement.setInt(32, drl.getD3());
            statement.setInt(33, drl.getD41());
            statement.setInt(34, drl.getD42());
            statement.setInt(35, drl.getD43());
            statement.setInt(36, drl.getD44());
            statement.setInt(37, drl.getD45());
            statement.setInt(38, drl.getD46());
            statement.setInt(39, drl.getD4());
            statement.setInt(40, drl.getD51());
            statement.setInt(41, drl.getD52());
            statement.setInt(42, drl.getD53());
            statement.setInt(43, drl.getD5());
            statement.setString(44, drl.getMaNguoiCham());
            statement.setString(45, drl.getMaPhieuDRL());
            statement.setString(46, drl.getNguoiCham());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DiemRenLuyenCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
