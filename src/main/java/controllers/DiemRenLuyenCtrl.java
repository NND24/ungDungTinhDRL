package controllers;

import database.ConnectDB;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DiemRenLuyenModel;
import models.LopModel;
import models.SinhVienModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DiemRenLuyenCtrl {

    public static List<DiemRenLuyenModel> timTatCaDRL() throws ClassNotFoundException {
        List<DiemRenLuyenModel> dsDiemRenLuyen = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                         SELECT SinhVien.MaSinhVien, SinhVien.HoTen, HocKy, NamHoc, NguoiCham, TongDiem, XepLoai,
                         TrangThaiCham, d1, d2, d3, d4, d5, NgayBatDau, NgayKetThuc
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
                     AND NamHoc.TrangThaiHienThi=1
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
                        resultSet.getString("HoTen"),
                        resultSet.getDate("NgayBatDau"),
                        resultSet.getDate("NgayKetThuc")
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
                     SELECT SinhVien.MaSinhVien, SinhVien.HoTen, HocKy, NamHoc, NguoiCham, TongDiem, XepLoai, TrangThaiCham, d1, d2, d3, d4, d5, NgayBatDau, NgayKetThuc
                     FROM DiemRenLuyen
                     INNER JOIN PhieuDRL ON PhieuDRL.MaPhieuDRL = DiemRenLuyen.MaPhieuDRL
                     INNER JOIN SinhVien ON PhieuDRL.MaSinhVien = SinhVien.MaSinhVien
                     INNER JOIN Lop ON Lop.MaLop = SinhVien.MaLop
                     INNER JOIN NamHoc ON PhieuDRL.MaNamHoc = NamHoc.MaNamHoc
                     WHERE (SinhVien.MaSinhVien LIKE ? OR SinhVien.HoTen LIKE ?)
                     AND SinhVien.MaLop = ?
                     AND HocKy = ?
                     AND NamHoc = ?
                     AND NguoiCham = 'CoVan'
                     AND Lop.TrangThaiHienThi = 1
                     AND NamHoc.TrangThaiHienThi = 1
                     AND GETDATE() >= NgayBatDau;
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
                        resultSet.getString("HoTen"),
                        resultSet.getDate("NgayBatDau"),
                        resultSet.getDate("NgayKetThuc")
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
                            resultSet.getInt("d12"),
                            resultSet.getInt("d13"),
                            resultSet.getFloat("d14"),
                            resultSet.getInt("d15"),
                            resultSet.getFloat("d1"),
                            resultSet.getInt("d21"),
                            resultSet.getInt("d22"),
                            resultSet.getInt("d23"),
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
                    AND (SinhVien.MaSinhVien LIKE ? OR SinhVien.HoTen LIKE ? OR TrangThaiCham LIKE ?)
                    AND (Lop.MaLop=? OR ?='') AND (NamHoc.MaNamHoc=? OR ?='') AND (HocKy=? OR ?='')
                    AND Lop.TrangThaiHienThi=1 AND NamHoc.TrangThaiHienThi=1
                    AND GETDATE() >= NgayBatDau
                    """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, "%" + tuKhoa + "%");
            statement.setString(4, lop);
            statement.setString(5, lop);
            statement.setInt(6, maNamHoc);
            statement.setInt(7, maNamHoc);
            statement.setString(8, hocKy);
            statement.setString(9, hocKy);

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
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void chamDiemRenLuyen(DiemRenLuyenModel drl) throws ClassNotFoundException {
        String sql = "UPDATE DiemRenLuyen SET TongDiem=?, XepLoai=?, d11=?, d12=?, d13=?, d14=?, d15=?, d1=?, d21=?, d22=?, d23=?, d2=?, d31=?, d32=?, d33=?, d34=?, d35=?, d3=?, d41=?, d42=?, d43=?, d44=?, d45=?, d46=?, d4=?, d51=?, d52=?, d53=?, d5=? WHERE MaPhieuDRL=? AND NguoiCham=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setFloat(1, drl.getTongDiem());
            statement.setString(2, drl.getXepLoai());
            statement.setFloat(3, drl.getD11());
            statement.setInt(4, drl.getD12());
            statement.setInt(5, drl.getD13());
            statement.setFloat(6, drl.getD14());
            statement.setInt(7, drl.getD15());
            statement.setFloat(8, drl.getD1());
            statement.setInt(9, drl.getD21());
            statement.setInt(10, drl.getD22());
            statement.setInt(11, drl.getD23());
            statement.setInt(12, drl.getD2());
            statement.setInt(13, drl.getD31());
            statement.setInt(14, drl.getD32());
            statement.setInt(15, drl.getD33());
            statement.setInt(16, drl.getD34());
            statement.setInt(17, drl.getD35());
            statement.setInt(18, drl.getD3());
            statement.setInt(19, drl.getD41());
            statement.setInt(20, drl.getD42());
            statement.setInt(21, drl.getD43());
            statement.setInt(22, drl.getD44());
            statement.setInt(23, drl.getD45());
            statement.setInt(24, drl.getD46());
            statement.setInt(25, drl.getD4());
            statement.setInt(26, drl.getD51());
            statement.setInt(27, drl.getD52());
            statement.setInt(28, drl.getD53());
            statement.setInt(29, drl.getD5());
            statement.setString(30, drl.getMaPhieuDRL());
            statement.setString(31, drl.getNguoiCham());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DiemRenLuyenCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xuatFileExcel(List<DiemRenLuyenModel> dsDiemRenLuyen) throws ClassNotFoundException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachNamHoc");
            int rowNum = 0;

            Row headerRow15 = sheet.createRow(rowNum++);
            headerRow15.createCell(0).setCellValue("HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG");
            headerRow15.createCell(6).setCellValue("CỘNG HOÀ XÃ HỘI CHỦ NGHĨA VIỆT NAM");

            Row headerRow16 = sheet.createRow(rowNum++);
            headerRow16.createCell(0).setCellValue("HỌC VIỆN CNBCVT CƠ SỞ TẠI TP HỒ CHÍ MINH");
            headerRow16.createCell(6).setCellValue("Độc lập - Tự do - Hạnh phúc");

            Calendar cal = Calendar.getInstance();
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0
            int year = cal.get(Calendar.YEAR);

            rowNum++;
            Row headerRow17 = sheet.createRow(rowNum++);
            headerRow17.createCell(5).setCellValue("Tp. Hồ Chí Minh, ngày " + day + " tháng " + month + " năm " + year);

            rowNum++;
            Row headerRow0 = sheet.createRow(rowNum++);
            headerRow0.createCell(3).setCellValue("TỔNG HỢP KẾT QUẢ RÈN LUYỆN CỦA SINH VIÊN");

            String hocKy = "";
            String namHoc = "";
            String maSinhVien = "";
            for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
                hocKy = drl.getHocKy();
                namHoc = drl.getNamHoc();
                maSinhVien = drl.getMaSinhVien();
                break;
            }
            SinhVienModel sv = SinhVienCtrl.timSinhVienTheoMaSV(maSinhVien);
            LopModel lop = LopCtrl.timKiemLop(sv.getMaLop()).get(0);

            rowNum++;
            Row headerRow1 = sheet.createRow(rowNum++);
            headerRow1.createCell(1).setCellValue("Lớp: " + sv.getMaLop());
            headerRow1.createCell(6).setCellValue("Khoa: " + lop.getKhoa());

            Row headerRow2 = sheet.createRow(rowNum++);
            headerRow2.createCell(1).setCellValue("Học kỳ: " + hocKy);
            headerRow2.createCell(6).setCellValue("Năm học: " + namHoc);

            rowNum++;
            Row headerRow3 = sheet.createRow(rowNum++);
            headerRow3.createCell(0).setCellValue("TT");
            headerRow3.createCell(1).setCellValue("Họ và tên");
            headerRow3.createCell(2).setCellValue("Mã sinh viên");
            headerRow3.createCell(3).setCellValue("Nội dung 1");
            headerRow3.createCell(4).setCellValue("Nội dung 2");
            headerRow3.createCell(5).setCellValue("Nội dung 3");
            headerRow3.createCell(6).setCellValue("Nội dung 4");
            headerRow3.createCell(7).setCellValue("Nội dung 5");
            headerRow3.createCell(8).setCellValue("Tổng điểm");
            headerRow3.createCell(9).setCellValue("XẾP LOẠI RÈN LUYỆN");
            headerRow3.createCell(10).setCellValue("GHI CHÚ");

            float tt = 0;
            float soSVXuatSac = 0;
            float soSVTot = 0;
            float soSVKha = 0;
            float soSVTrungBinh = 0;
            float soSVYeu = 0;
            float soSVKem = 0;
            for (DiemRenLuyenModel drl : dsDiemRenLuyen) {
                Row row = sheet.createRow(rowNum++);
                tt++;
                row.createCell(0).setCellValue(tt);
                row.createCell(1).setCellValue(drl.getHoTen());
                row.createCell(2).setCellValue(drl.getMaSinhVien());
                row.createCell(3).setCellValue(drl.getD1());
                row.createCell(4).setCellValue(drl.getD2());
                row.createCell(5).setCellValue(drl.getD3());
                row.createCell(6).setCellValue(drl.getD4());
                row.createCell(7).setCellValue(drl.getD5());
                row.createCell(8).setCellValue(drl.getTongDiem());
                row.createCell(9).setCellValue(drl.getXepLoai());
                row.createCell(10).setCellValue("");

                if (drl.getXepLoai().equals("Xuất sắc")) {
                    soSVXuatSac++;
                }
                if (drl.getXepLoai().equals("Tốt")) {
                    soSVTot++;
                }
                if (drl.getXepLoai().equals("Khá")) {
                    soSVKha++;
                }
                if (drl.getXepLoai().equals("Trung bình")) {
                    soSVTrungBinh++;
                }
                if (drl.getXepLoai().equals("Yếu")) {
                    soSVYeu++;
                }
                if (drl.getXepLoai().equals("Kém")) {
                    soSVKem++;
                }
            }

            rowNum++;
            Row headerRow4 = sheet.createRow(rowNum++);
            headerRow4.createCell(1).setCellValue("Danh sách có");
            headerRow4.createCell(2).setCellValue(tt);
            headerRow4.createCell(3).setCellValue("sinh viên");

            rowNum++;
            Row headerRow5 = sheet.createRow(rowNum++);
            headerRow5.createCell(0).setCellValue("Lưu ý: Kết quả điểm rèn luyện được phân thành các loại: Xuất sắc, Tốt, Khá, Trung bình, Yếu, Kém");

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            rowNum++;
            Row headerRow6 = sheet.createRow(rowNum++);
            headerRow6.createCell(2).setCellValue("- Loại xuất sắc: Từ 90 - đến 100 điểm:");
            headerRow6.createCell(7).setCellValue(soSVXuatSac);
            headerRow6.createCell(8).setCellValue("Sinh viên");
            headerRow6.createCell(9).setCellValue(decimalFormat.format((soSVXuatSac / tt) * 100));
            headerRow6.createCell(10).setCellValue("%");

            Row headerRow7 = sheet.createRow(rowNum++);
            headerRow7.createCell(2).setCellValue("- Loại tốt: Từ 80 - đến 90 điểm:");
            headerRow7.createCell(7).setCellValue(soSVTot);
            headerRow7.createCell(8).setCellValue("Sinh viên");
            headerRow7.createCell(9).setCellValue(decimalFormat.format((soSVTot / tt) * 100));
            headerRow7.createCell(10).setCellValue("%");

            Row headerRow8 = sheet.createRow(rowNum++);
            headerRow8.createCell(2).setCellValue("- Loại khá: Từ 65 - đến dưới 80 điểm:");
            headerRow8.createCell(7).setCellValue(soSVKha);
            headerRow8.createCell(8).setCellValue("Sinh viên");
            headerRow8.createCell(9).setCellValue(decimalFormat.format((soSVKha / tt) * 100));
            headerRow8.createCell(10).setCellValue("%");

            Row headerRow9 = sheet.createRow(rowNum++);
            headerRow9.createCell(2).setCellValue("- Loại trung bình: Từ 50 - đến dưới 65 điểm:");
            headerRow9.createCell(7).setCellValue(soSVTrungBinh);
            headerRow9.createCell(8).setCellValue("Sinh viên");
            headerRow9.createCell(9).setCellValue(decimalFormat.format((soSVTrungBinh / tt) * 100));
            headerRow9.createCell(10).setCellValue("%");

            Row headerRow10 = sheet.createRow(rowNum++);
            headerRow10.createCell(2).setCellValue("- Loại yếu: Từ 35 - đến dưới 50 điểm:");
            headerRow10.createCell(7).setCellValue(soSVYeu);
            headerRow10.createCell(8).setCellValue("Sinh viên");
            headerRow10.createCell(9).setCellValue(decimalFormat.format((soSVYeu / tt) * 100));
            headerRow10.createCell(10).setCellValue("%");

            Row headerRow11 = sheet.createRow(rowNum++);
            headerRow11.createCell(2).setCellValue("- Loại kém: Dưới 35 điểm:");
            headerRow11.createCell(7).setCellValue(soSVKem);
            headerRow11.createCell(8).setCellValue("Sinh viên");
            headerRow11.createCell(9).setCellValue(decimalFormat.format((soSVKem / tt) * 100));
            headerRow11.createCell(10).setCellValue("%");

            rowNum++;
            Row headerRow12 = sheet.createRow(rowNum++);
            headerRow12.createCell(1).setCellValue("Khoa đào tạo");
            headerRow12.createCell(5).setCellValue("Cố vấn học tập");
            headerRow12.createCell(9).setCellValue("Lớp trưởng");

            Row headerRow13 = sheet.createRow(rowNum++);
            headerRow13.createCell(1).setCellValue("");
            headerRow13.createCell(5).setCellValue("(Ký và ghi rõ họ tên)");
            headerRow13.createCell(9).setCellValue("(Ký và ghi rõ họ tên)");

            rowNum++;
            rowNum++;
            rowNum++;
            Row headerRow14 = sheet.createRow(rowNum++);
            headerRow14.createCell(1).setCellValue("....................");
            headerRow14.createCell(5).setCellValue("....................");
            headerRow14.createCell(9).setCellValue("....................");

            // Xuất workbook ra file Excel
            try (FileOutputStream fileOut = new FileOutputStream("src/main/java/files/DSDiemRenLuyen-Lop" + sv.getMaLop() + "-HK" + hocKy + "-NH" + namHoc + ".xlsx")) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
