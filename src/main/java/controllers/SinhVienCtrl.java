package controllers;

import database.ConnectDB;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.SinhVienModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SinhVienCtrl {

    public static void themSinhVien(SinhVienModel sv) throws ClassNotFoundException {
        String sql = "INSERT INTO SinhVien (MaSinhVien, MaTaiKhoan, MaLop, HoTen, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan, DaNghiHoc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, sv.getMaSinhVien());
            statement.setString(2, sv.getMaTaiKhoan());
            statement.setString(3, sv.getMaLop());
            statement.setString(4, sv.getHoTen());
            statement.setString(5, sv.getEmail());
            statement.setInt(6, Integer.parseInt(sv.getGioiTinh()));
            statement.setDate(7, sv.getNgaySinh());
            statement.setString(8, sv.getSoDienThoai());
            statement.setString(9, sv.getCanCuoc());
            statement.setString(10, sv.getQueQuan());
            statement.setInt(11, Integer.parseInt(sv.getDaNghiHoc()));

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatSinhVien(SinhVienModel sv) throws ClassNotFoundException {
        String sql1 = "UPDATE SinhVien SET HoTen=?, MaLop=?, GioiTinh=?, NgaySinh=?, SoDienThoai=?, CanCuoc=?, QueQuan=?, DaNghiHoc=?  WHERE MaSinhVien=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql1)) {
            statement.setString(1, sv.getHoTen());
            statement.setString(2, sv.getMaLop());
            statement.setInt(3, Integer.parseInt(sv.getGioiTinh()));
            statement.setDate(4, sv.getNgaySinh());
            statement.setString(5, sv.getSoDienThoai());
            statement.setString(6, sv.getCanCuoc());
            statement.setString(7, sv.getQueQuan());
            statement.setInt(8, Integer.parseInt(sv.getDaNghiHoc()));
            statement.setString(9, sv.getMaSinhVien());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql2 = "UPDATE TaiKhoan SET MaChucVu=? WHERE MaTaiKhoan IN (SELECT MaTaiKhoan FROM SinhVien  WHERE MaSinhVien=?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql2)) {
            statement.setString(1, sv.getChucVu());
            statement.setString(2, sv.getMaSinhVien());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<SinhVienModel> timTatCaSinhVien() throws ClassNotFoundException {
        List<SinhVienModel> dsSinhVien = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT MaSinhVien, SinhVien.MaLop, HoTen, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan, DaNghiHoc, TenChucVu
                     FROM SinhVien, Lop, TaiKhoan, ChucVu
                     WHERE SinhVien.MaLop=Lop.MaLop AND SinhVien.MaTaiKhoan=TaiKhoan.MaTaiKhoan AND TaiKhoan.MaChucVu=ChucVu.MaChucVu ORDER BY MaSinhVien ASC
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                SinhVienModel sv = new SinhVienModel(
                        resultSet.getString("MaSinhVien"),
                        resultSet.getString("MaLop"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("TenChucVu"),
                        resultSet.getString("Email"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan"),
                        resultSet.getString("DaNghiHoc"),
                        resultSet.getDate("NgaySinh")
                );
                dsSinhVien.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsSinhVien;
    }

    public static SinhVienModel timSinhVienTheoMaSV(String maSV) throws ClassNotFoundException {
        String sql = """
                     SELECT MaSinhVien, Lop.MaLop, SinhVien.MaLop, HoTen, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan, DaNghiHoc, TenChucVu
                     FROM SinhVien, Lop, TaiKhoan, ChucVu
                     WHERE SinhVien.MaLop=Lop.MaLop AND SinhVien.MaTaiKhoan=TaiKhoan.MaTaiKhoan AND TaiKhoan.MaChucVu=ChucVu.MaChucVu
                     AND MaSinhVien=?
                     """;
        SinhVienModel sinhVien = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maSV);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SinhVienModel sv = new SinhVienModel(
                        resultSet.getString("MaSinhVien"),
                        resultSet.getString("MaLop"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("TenChucVu"),
                        resultSet.getString("Email"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan"),
                        resultSet.getString("DaNghiHoc"),
                        resultSet.getDate("NgaySinh")
                );
                sinhVien = sv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sinhVien;
    }

    public static SinhVienModel timSinhVienTheoTenDangNhap(String tenDangNhap) throws ClassNotFoundException {
        String sql = """
                     SELECT MaSinhVien, SinhVien.MaLop, SinhVien.MaLop, HoTen, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan, DaNghiHoc, TenChucVu
                     FROM SinhVien, Lop, TaiKhoan, ChucVu
                     WHERE SinhVien.MaLop=Lop.MaLop AND SinhVien.MaTaiKhoan=TaiKhoan.MaTaiKhoan AND TaiKhoan.MaChucVu=ChucVu.MaChucVu
                     AND TenDangNhap=?
                     """;
        SinhVienModel sinhVien = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tenDangNhap);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SinhVienModel sv = new SinhVienModel(
                        resultSet.getString("MaSinhVien"),
                        resultSet.getString("MaLop"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("TenChucVu"),
                        resultSet.getString("Email"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan"),
                        resultSet.getString("DaNghiHoc"),
                        resultSet.getDate("NgaySinh")
                );
                sinhVien = sv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sinhVien;
    }

    public static List<SinhVienModel> timSinhVienTheoLop(String maLop) throws ClassNotFoundException {
        List<SinhVienModel> dsSinhVien = new ArrayList<>();
        String sql = """
                     SELECT MaSinhVien, Lop.MaLop, SinhVien.MaLop, HoTen, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan, DaNghiHoc, TenChucVu
                     FROM SinhVien, Lop, TaiKhoan, ChucVu
                     WHERE SinhVien.MaLop=Lop.MaLop AND SinhVien.MaTaiKhoan=TaiKhoan.MaTaiKhoan AND TaiKhoan.MaChucVu=ChucVu.MaChucVu
                     AND Lop.MaLop=? ORDER BY MaSinhVien ASC
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maLop);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SinhVienModel sv = new SinhVienModel(
                        resultSet.getString("MaSinhVien"),
                        resultSet.getString("MaLop"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("TenChucVu"),
                        resultSet.getString("Email"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan"),
                        resultSet.getString("DaNghiHoc"),
                        resultSet.getDate("NgaySinh")
                );
                dsSinhVien.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsSinhVien;
    }

    public static List<SinhVienModel> timKiemSinhVien(String tuKhoa, String lop) throws ClassNotFoundException {
        List<SinhVienModel> dsSinhVien = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "SELECT MaSinhVien, Lop.MaLop, SinhVien.MaLop, HoTen, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan, DaNghiHoc, TenChucVu "
                + "FROM SinhVien "
                + "JOIN Lop ON Lop.MaLop = SinhVien.MaLop "
                + "JOIN TaiKhoan ON SinhVien.MaTaiKhoan=TaiKhoan.MaTaiKhoan "
                + "JOIN ChucVu ON TaiKhoan.MaChucVu=ChucVu.MaChucVu "
                + "WHERE Lop.TrangThaiHienThi = 1 "
                + "AND (MaSinhVien LIKE ? OR HoTen LIKE ? OR Email LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ?) "
                + (lop.isEmpty() ? "" : "AND SinhVien.MaLop=?"))) {
            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, "%" + tuKhoa + "%");
            statement.setString(4, "%" + tuKhoa + "%");
            statement.setString(5, "%" + tuKhoa + "%");
            if (!lop.isEmpty()) {
                statement.setString(6, lop);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    SinhVienModel sv = new SinhVienModel(
                            resultSet.getString("MaSinhVien"),
                            resultSet.getString("MaLop"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("TenChucVu"),
                            resultSet.getString("Email"),
                            resultSet.getString("GioiTinh"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("QueQuan"),
                            resultSet.getString("DaNghiHoc"),
                            resultSet.getDate("NgaySinh")
                    );
                    dsSinhVien.add(sv);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsSinhVien;
    }

    public static int layMaSinhVienCuoiCuaLop(String maLop) throws ClassNotFoundException {
        int maSV = 0;
        String sql = """
                     SELECT TOP 1
                         RIGHT(MaSinhVien, 3) AS MaSinhVien
                     FROM
                         SinhVien, Lop, TaiKhoan, ChucVu
                     WHERE
                         SinhVien.MaLop = Lop.MaLop
                         AND SinhVien.MaTaiKhoan = TaiKhoan.MaTaiKhoan
                         AND TaiKhoan.MaChucVu = ChucVu.MaChucVu
                         AND Lop.MaLop = ?
                     ORDER BY
                         MaSinhVien DESC;
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maLop);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                maSV = resultSet.getInt("MaSinhVien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maSV;
    }

    public static void xoaSinhVien(String maSinhVien) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM SinhVien WHERE MaSinhVien=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maSinhVien);
            statement.executeUpdate();
        }
    }

    public static String layMaTaiKhoanSV(String maSinhVien) throws ClassNotFoundException {
        String maTaiKhoan = "";
        String sql = "SELECT SinhVien.MaTaiKhoan FROM SinhVien,TaiKhoan WHERE SinhVien.MaTaiKhoan=TaiKhoan.MaTaiKhoan AND MaSinhVien=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maSinhVien);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    maTaiKhoan = resultSet.getString("MaTaiKhoan");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return maTaiKhoan;
    }

    public static boolean kiemTraSinhVienDaChamDiem(String maSinhVien) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT DISTINCT SinhVien.MaSinhVien FROM SinhVien
                     JOIN PhieuDRL ON PhieuDRL.MaSinhVien=SinhVien.MaSinhVien
                     WHERE SinhVien.MaSinhVien=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maSinhVien);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraCanCuocTrung(String maSinhVien, String canCuoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaSinhVien FROM SinhVien
                     WHERE MaSinhVien!=? AND CanCuoc=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maSinhVien);
            statement.setString(2, canCuoc);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraSoDienThoaiTrung(String maSinhVien, String soDienThoai) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaSinhVien FROM SinhVien
                     WHERE MaSinhVien!=? AND SoDienThoai=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maSinhVien);
            statement.setString(2, soDienThoai);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void xuatFileExcel(List<SinhVienModel> dsSinhVien, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachSinhVien");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã sinh viên");
            headerRow.createCell(1).setCellValue("Họ tên");
            headerRow.createCell(2).setCellValue("Lớp");
            headerRow.createCell(3).setCellValue("Giới tính");
            headerRow.createCell(4).setCellValue("Ngày sinh");
            headerRow.createCell(5).setCellValue("Căn cước");
            headerRow.createCell(6).setCellValue("Số điện thoại");
            headerRow.createCell(7).setCellValue("Quê quán");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (SinhVienModel sv : dsSinhVien) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(sv.getMaSinhVien());
                row.createCell(1).setCellValue(sv.getHoTen());
                row.createCell(2).setCellValue(sv.getMaLop());
                row.createCell(3).setCellValue(sv.getGioiTinh());
                row.createCell(4).setCellValue(sv.getNgaySinh());
                row.createCell(5).setCellValue(sv.getCanCuoc());
                row.createCell(6).setCellValue(sv.getSoDienThoai());
                row.createCell(7).setCellValue(sv.getQueQuan());
            }

            // Xuất workbook ra file Excel
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
