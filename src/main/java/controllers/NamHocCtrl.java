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
import models.NamHocModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NamHocCtrl {

    public static List<NamHocModel> timTatCaNamHoc() throws ClassNotFoundException {
        List<NamHocModel> dsNamHoc = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM NamHoc
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                NamHocModel namHoc = new NamHocModel(
                        resultSet.getInt("MaNamHoc"),
                        resultSet.getString("NamHoc"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsNamHoc.add(namHoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNamHoc;
    }

    public static List<NamHocModel> timNamHocHienThi() throws ClassNotFoundException {
        List<NamHocModel> dsNamHoc = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM NamHoc WHERE TrangThaiHienThi=1
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                NamHocModel namHoc = new NamHocModel(
                        resultSet.getInt("MaNamHoc"),
                        resultSet.getString("NamHoc"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsNamHoc.add(namHoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNamHoc;
    }

    public static void themNamHoc(NamHocModel namHoc) throws ClassNotFoundException {
        String sql = "INSERT INTO NamHoc (NamHoc, TrangThaiHienThi) VALUES (?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, namHoc.getNamHoc());
            statement.setInt(2, namHoc.getTrangThaiHienThi());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LopTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatNamHoc(NamHocModel namHoc) throws ClassNotFoundException {
        String sql = "UPDATE NamHoc SET NamHoc=?, TrangThaiHienThi=? WHERE MaNamHoc=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, namHoc.getNamHoc());
            statement.setInt(2, namHoc.getTrangThaiHienThi());
            statement.setInt(3, namHoc.getMaNamHoc());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LopTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaNamHoc(String maNamHoc) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM NamHoc WHERE MaNamHoc=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maNamHoc);
            statement.executeUpdate();
        }
    }

    public static boolean kiemTraNamHocDaDuocSuDung(String maNamHoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT NamHoc.MaNamHoc FROM NamHoc
                     LEFT JOIN PhieuDRL ON PhieuDRL.MaNamHoc=NamHoc.MaNamHoc
                     LEFT JOIN PhanCong ON PhanCong.MaNamHoc=NamHoc.MaNamHoc
                     WHERE NamHoc.MaNamHoc=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maNamHoc);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void xuatFileExcel(List<NamHocModel> dsNamHoc, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachNamHoc");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã năm học");
            headerRow.createCell(1).setCellValue("Năm học");
            headerRow.createCell(2).setCellValue("Trạng thái hiển thị");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (NamHocModel namHoc : dsNamHoc) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(namHoc.getMaNamHoc());
                row.createCell(1).setCellValue(namHoc.getNamHoc());
                String trangThai = "";
                if (namHoc.getTrangThaiHienThi() == 0) {
                    trangThai = "Ẩn";
                } else {
                    trangThai = "Hiển thị";
                }
                row.createCell(2).setCellValue(trangThai);
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
