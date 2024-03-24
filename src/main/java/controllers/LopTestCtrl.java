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
import models.LopModelTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LopTestCtrl {

    public static void themLop(LopModelTest lop) throws ClassNotFoundException {
        String sql = "INSERT INTO Lop (MaNganh, MaLop, Khoa, TrangThaiHienThi) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lop.getMaNganh());
            statement.setString(2, lop.getMaLop());
            statement.setString(3, lop.getKhoa());
            statement.setInt(4, lop.getTrangThaiHienThi());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LopTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatLop(LopModelTest lop) throws ClassNotFoundException {
        String sql = "UPDATE Lop SET MaNganh=?, MaLop=?, Khoa=?, TrangThaiHienThi=? WHERE MaLop=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lop.getMaNganh());
            statement.setString(2, lop.getMaLop());
            statement.setString(3, lop.getKhoa());
            statement.setInt(4, lop.getTrangThaiHienThi());
            statement.setString(5, lop.getMaLop());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LopTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<LopModelTest> timTatCaLop() throws ClassNotFoundException {
        List<LopModelTest> dsLop = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM Lop
                     JOIN Nganh ON Nganh.MaNganh=Lop.MaNganh
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                LopModelTest lop = new LopModelTest(
                        resultSet.getString("MaLop"),
                        resultSet.getString("MaNganh"),
                        resultSet.getString("TenNganh"),
                        resultSet.getString("Khoa"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsLop.add(lop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLop;
    }

    public static List<LopModelTest> timTatCaLopHienThi() throws ClassNotFoundException {
        List<LopModelTest> dsLop = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM Lop
                     JOIN Nganh ON Nganh.MaNganh=Lop.MaNganh
                     WHERE Lop.TrangThaiHienThi=1
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                LopModelTest lop = new LopModelTest(
                        resultSet.getString("MaLop"),
                        resultSet.getString("MaNganh"),
                        resultSet.getString("TenNganh"),
                        resultSet.getString("Khoa"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsLop.add(lop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLop;
    }

    public static List<LopModelTest> timLopTheoKhoa(String maKhoa) throws ClassNotFoundException {
        String sql = """
                     SELECT Lop.MaLop, Lop.MaNganh, Khoa, Lop.TrangThaiHienThi, TenNganh FROM KHOA
                     JOIN Nganh ON Khoa.MaKhoa=Nganh.MaKhoa
                     JOIN Lop ON Nganh.MaNganh=Lop.MaNganh
                     WHERE Khoa.TrangThaiHienThi=1 AND Lop.TrangThaiHienThi=1
                     AND Khoa.MaKhoa=?
                     """;
        List<LopModelTest> dsLop = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maKhoa);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                LopModelTest lop = new LopModelTest(
                        resultSet.getString("MaLop"),
                        resultSet.getString("MaNganh"),
                        resultSet.getString("TenNganh"),
                        resultSet.getString("Khoa"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsLop.add(lop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLop;
    }

    public static List<LopModelTest> timKiemLop(String tuKhoa) throws ClassNotFoundException {
        String sql = """
                     SELECT Lop.MaLop, Lop.MaNganh, Khoa, Lop.TrangThaiHienThi, TenNganh FROM KHOA
                     JOIN Nganh ON Khoa.MaKhoa=Nganh.MaKhoa
                     JOIN Lop ON Nganh.MaNganh=Lop.MaNganh
                     WHERE Khoa.TrangThaiHienThi=1
                     AND Khoa.MaKhoa LIKE ? OR TenKhoa LIKE ? OR MaLop LIKE ? OR KHOA LIKE ?
                     """;
        List<LopModelTest> dsLop = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, "%" + tuKhoa + "%");
            statement.setString(4, "%" + tuKhoa + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                LopModelTest lop = new LopModelTest(
                        resultSet.getString("MaLop"),
                        resultSet.getString("MaNganh"),
                        resultSet.getString("TenNganh"),
                        resultSet.getString("Khoa"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsLop.add(lop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLop;
    }

    public static void xoaLop(String maLop) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Lop WHERE MaLop=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maLop);
            statement.executeUpdate();
        }
    }

    public static void xuatFileExcel(List<LopModelTest> dsLop, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachSinhVien");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã lớp");
            headerRow.createCell(1).setCellValue("Mã ngành");
            headerRow.createCell(2).setCellValue("Tên lớp");
            headerRow.createCell(3).setCellValue("Khóa");
            headerRow.createCell(4).setCellValue("Trạng thái hiển thị");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (LopModelTest lop : dsLop) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(lop.getMaLop());
                row.createCell(1).setCellValue(lop.getTenNganh());
                row.createCell(2).setCellValue(lop.getMaLop());
                row.createCell(3).setCellValue(lop.getKhoa());
                String trangThai = "";
                if (lop.getTrangThaiHienThi() == 0) {
                    trangThai = "Ẩn";
                } else {
                    trangThai = "Hiển thị";
                }
                row.createCell(4).setCellValue(trangThai);
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
