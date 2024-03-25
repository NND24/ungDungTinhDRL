/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import models.NganhModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ACER
 */
public class NganhCtrl {

    public static List<NganhModel> timTatCaNganh() throws ClassNotFoundException {
        List<NganhModel> dsNganh = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM Nganh
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                NganhModel nganh = new NganhModel(
                        resultSet.getString("MaNganh"),
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenNganh"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsNganh.add(nganh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNganh;
    }

    public static List<NganhModel> timTatCaNganhHienThi() throws ClassNotFoundException {
        List<NganhModel> dsNganh = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM Nganh WHERE TrangThaiHienThi=1
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                NganhModel nganh = new NganhModel(
                        resultSet.getString("MaNganh"),
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenNganh"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsNganh.add(nganh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNganh;
    }

    public static ArrayList<String> timTatCaMaKhoa() throws ClassNotFoundException {
        ArrayList<String> dsMaKhoa = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT MaKhoa
                     FROM Khoa
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String item = resultSet.getString("MaKhoa");
                dsMaKhoa.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsMaKhoa;
    }

    public static void themNganh(NganhModel nganh) throws ClassNotFoundException {
        String sql = "INSERT INTO Nganh (MaNganh, MaKhoa, TenNganh, TrangThaiHienThi) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nganh.getMaNganh());
            statement.setString(2, nganh.getMaKhoa());
            statement.setString(3, nganh.getTenNganh());
            statement.setInt(4, nganh.getTrangThaiHienThi());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatNganh(NganhModel nganh) throws ClassNotFoundException {
        String sql = "UPDATE Nganh SET MaKhoa=?, TenNganh=?, TrangThaiHienThi=? WHERE MaNganh=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nganh.getMaKhoa());
            statement.setString(2, nganh.getTenNganh());
            statement.setInt(3, nganh.getTrangThaiHienThi());
            statement.setString(4, nganh.getMaNganh());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LopCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaNganh(String maNganh) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Nganh WHERE MaNganh=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maNganh);
            statement.executeUpdate();
        }
    }

    public static boolean kiemTraMaNganhDaTonTai(String maNganh) throws ClassNotFoundException {
        String sql = """
                 SELECT MaNganh FROM Nganh
                 WHERE MaNganh=?
                 """;
        boolean flag = false;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maNganh);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraNganhDaDuocSuDung(String maNganh) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT DISTINCT Nganh.MaNganh FROM Nganh
                     JOIN Lop ON Lop.MaNganh=Nganh.MaNganh
                     WHERE Nganh.MaNganh=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maNganh);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void xuatFileExcel(List<NganhModel> dsNganh, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachNganh");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã ngành");
            headerRow.createCell(1).setCellValue("Mã khoa");
            headerRow.createCell(2).setCellValue("Tên ngành");
            headerRow.createCell(3).setCellValue("Trạng thái hiển thị");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (NganhModel nganh : dsNganh) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(nganh.getMaNganh());
                row.createCell(1).setCellValue(nganh.getMaKhoa());
                row.createCell(2).setCellValue(nganh.getTenNganh());
                String trangThai = "";
                if (nganh.getTrangThaiHienThi() == 0) {
                    trangThai = "Ẩn";
                } else {
                    trangThai = "Hiển thị";
                }
                row.createCell(3).setCellValue(trangThai);
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
