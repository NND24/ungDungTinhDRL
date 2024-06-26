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
import models.KhoaModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class KhoaCtrl {

    public static void themKhoa(KhoaModel khoa) throws ClassNotFoundException {
        String sql = "INSERT INTO Khoa (MaKhoa, TenKhoa, TrangThaiHienThi) VALUES (?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, khoa.getMaKhoa());
            statement.setString(2, khoa.getTenKhoa());
            statement.setInt(3, khoa.getTrangThaiHienThi());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatKhoa(KhoaModel khoa) throws ClassNotFoundException {
        String sql = "UPDATE Khoa SET TenKhoa=?, TrangThaiHienThi=? WHERE MaKhoa=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, khoa.getTenKhoa());
            statement.setInt(2, khoa.getTrangThaiHienThi());
            statement.setString(3, khoa.getMaKhoa());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<KhoaModel> timTatCaKhoa() throws ClassNotFoundException {
        List<KhoaModel> dsKhoa = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM Khoa
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                KhoaModel khoa = new KhoaModel(
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsKhoa.add(khoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKhoa;
    }

    public static List<KhoaModel> timTatCaKhoaHienThi() throws ClassNotFoundException {
        List<KhoaModel> dsKhoa = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM Khoa WHERE TrangThaiHienThi=1
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                KhoaModel khoa = new KhoaModel(
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsKhoa.add(khoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKhoa;
    }

    public static boolean kiemTraKhoaDaSuDung(String maKhoa) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT Khoa.MaKhoa FROM KHOA
                     JOIN Nganh ON KHOA.MaKhoa=Nganh.MaKhoa
                     WHERE Khoa.MaKhoa=?
                     UNION
                     SELECT Khoa.MaKhoa FROM KHOA
                     JOIN CoVan ON Khoa.MaKhoa=CoVan.MaKhoa
                     WHERE Khoa.MaKhoa=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maKhoa);
            statement.setString(2, maKhoa);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void xoaKhoa(String maKhoa) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Khoa WHERE MaKhoa=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maKhoa);
            statement.executeUpdate();
        }
    }

    public static boolean kiemTraMaKhoaDaTonTai(String maKhoa) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaKhoa FROM Khoa
                     WHERE MaKhoa=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maKhoa);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void xuatFileExcel(List<KhoaModel> dsKhoa, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachKhoa");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã khoa");
            headerRow.createCell(1).setCellValue("Tên khoa");
            headerRow.createCell(2).setCellValue("Trạng thái hiển thị");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (KhoaModel khoa : dsKhoa) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(khoa.getMaKhoa());
                row.createCell(1).setCellValue(khoa.getTenKhoa());
                row.createCell(2).setCellValue(khoa.getTrangThaiHienThi());
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
