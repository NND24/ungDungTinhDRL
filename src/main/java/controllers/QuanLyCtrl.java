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
import models.QuanLyModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QuanLyCtrl {

    public static void themQuanLy(QuanLyModel ql) throws ClassNotFoundException {
        String sql = "INSERT INTO QuanLy (MaQuanLy, MaTaiKhoan, HoTen, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan, DaNghi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, ql.getMaQuanLy());
            statement.setString(2, ql.getIdTaiKhoan());
            statement.setString(3, ql.getHoTen());
            statement.setString(4, ql.getEmail());
            statement.setString(5, ql.getGioiTinh());
            statement.setDate(6, ql.getNgaySinh());
            statement.setString(7, ql.getSoDienThoai());
            statement.setString(8, ql.getCanCuoc());
            statement.setString(9, ql.getQueQuan());
            statement.setInt(10, ql.getDaNghi());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<QuanLyModel> timTatCaQuanLy() throws ClassNotFoundException {
        List<QuanLyModel> dsQuanLy = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "SELECT DISTINCT * FROM QuanLy";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                QuanLyModel ql = new QuanLyModel(
                        resultSet.getString("MaQuanLy"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("Email"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getInt("DaNghi")
                );
                dsQuanLy.add(ql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsQuanLy;
    }

    public static QuanLyModel timQuanLyTheoTenDangNhap(String tenDangNhap) throws ClassNotFoundException {
        String sql = """
                     SELECT MaQuanLy, HoTen, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan, TenChucVu, DaNghi
                     FROM QuanLy, TaiKhoan, ChucVu
                     WHERE  QuanLy.MaTaiKhoan=TaiKhoan.MaTaiKhoan AND TaiKhoan.MaChucVu=ChucVu.MaChucVu
                     AND TenDangNhap=?
                     """;
        QuanLyModel quanLy = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tenDangNhap);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                QuanLyModel ql = new QuanLyModel(
                        resultSet.getString("MaQuanLy"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("Email"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getInt("DaNghi")
                );
                quanLy = ql;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quanLy;
    }

    public static List<QuanLyModel> timKiemQuanLy(String tuKhoa) throws ClassNotFoundException {
        List<QuanLyModel> dsQuanLy = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "SELECT DISTINCT * FROM QuanLy WHERE MaQuanLy LIKE ? OR HoTen LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ? OR Email=?")) {
            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, "%" + tuKhoa + "%");
            statement.setString(4, "%" + tuKhoa + "%");
            statement.setString(5, "%" + tuKhoa + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    QuanLyModel ql = new QuanLyModel(
                            resultSet.getString("MaQuanLy"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("Email"),
                            resultSet.getString("GioiTinh"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("QueQuan"),
                            resultSet.getDate("NgaySinh"),
                            resultSet.getInt("DaNghi")
                    );
                    dsQuanLy.add(ql);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsQuanLy;
    }

    public static void capNhatQuanLy(QuanLyModel ql) {
        String sql = "UPDATE QuanLy SET HoTen=?, Email=?, NgaySinh=?, GioiTinh=?, SoDienThoai=?, CanCuoc=?, QueQuan=?, DaNghi=? WHERE MaQuanLy=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ql.getHoTen());
            statement.setString(2, ql.getEmail());
            statement.setDate(3, ql.getNgaySinh());
            statement.setString(4, ql.getGioiTinh());
            statement.setString(5, ql.getSoDienThoai());
            statement.setString(6, ql.getCanCuoc());
            statement.setString(7, ql.getQueQuan());
            statement.setInt(8, ql.getDaNghi());
            statement.setString(9, ql.getMaQuanLy());

            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaQuanLy(String maQuanLy) {
        String sql = "DELETE FROM QuanLy WHERE MaQuanLy=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maQuanLy);

            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String layMaTaiKhoanQL(String maQuanLy) throws ClassNotFoundException {
        String maTaiKhoan = "";
        String sql = "SELECT QuanLy.MaTaiKhoan FROM QuanLy,TaiKhoan WHERE QuanLy.MaTaiKhoan=TaiKhoan.MaTaiKhoan AND MaQuanLy=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maQuanLy);

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

    public static int layMaQuanLyCuoiCung() throws ClassNotFoundException {
        int maQL = 0;
        String sql = """
                     SELECT TOP 1
                    RIGHT(MaQuanLy, 3) AS MaQuanLy
                    FROM
                    QuanLy
                    ORDER BY
                    MaQuanLy DESC;
                     """;
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                maQL = resultSet.getInt("MaQuanLy");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maQL;
    }

    public static boolean kiemTraCanCuocTrung(String maQuanLy, String canCuoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaQuanLy FROM QuanLy
                     WHERE MaQuanLy!=? AND CanCuoc=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maQuanLy);
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

    public static boolean kiemTraSoDienThoaiTrung(String maQuanLy, String soDienThoai) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaQuanLy FROM QuanLy
                     WHERE MaQuanLy!=? AND SoDienThoai=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maQuanLy);
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

    public static void xuatFileExcel(List<QuanLyModel> dsDichVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachQuanLy");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã quản lý");
            headerRow.createCell(1).setCellValue("Họ tên");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Giới tính");
            headerRow.createCell(4).setCellValue("Ngày sinh");
            headerRow.createCell(5).setCellValue("Số điện thoại");
            headerRow.createCell(6).setCellValue("Căn cước");
            headerRow.createCell(7).setCellValue("Quê quán");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (QuanLyModel bn : dsDichVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(bn.getMaQuanLy());
                row.createCell(1).setCellValue(bn.getHoTen());
                row.createCell(2).setCellValue(bn.getEmail());
                row.createCell(3).setCellValue(bn.getGioiTinh());
                row.createCell(4).setCellValue(bn.getNgaySinh());
                row.createCell(5).setCellValue(bn.getSoDienThoai());
                row.createCell(6).setCellValue(bn.getCanCuoc());
                row.createCell(7).setCellValue(bn.getQueQuan());
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
