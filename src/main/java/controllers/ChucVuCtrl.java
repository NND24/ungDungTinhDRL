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
import models.ChucVuModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ChucVuCtrl {

    public static List<ChucVuModel> timTatCaChuVu() throws ClassNotFoundException {
        List<ChucVuModel> dsChucVu = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM ChucVu
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ChucVuModel chuVu = new ChucVuModel(
                        resultSet.getString("MaChucVu"),
                        resultSet.getString("TenChucVu"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsChucVu.add(chuVu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsChucVu;
    }

    public static void themChucVu(ChucVuModel chucVu) throws ClassNotFoundException {
        String sql = "INSERT INTO ChucVu (MaChucVu, TenChucVu, TrangThaiHienThi) VALUES (?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, chucVu.getMaChucVu());
            statement.setString(2, chucVu.getTenChucVu());
            statement.setInt(3, chucVu.getTrangThaiHienThi());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LopCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatChucVu(ChucVuModel chucVu) throws ClassNotFoundException {
        String sql = "UPDATE ChucVu SET TenChucVu=?, TrangThaiHienThi=? WHERE MaChucVu=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, chucVu.getTenChucVu());
            statement.setInt(2, chucVu.getTrangThaiHienThi());
            statement.setString(3, chucVu.getMaChucVu());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LopCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaNamHoc(String maChucVu) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM ChucVu WHERE MaChucVu=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChucVu);
            statement.executeUpdate();
        }
    }

    public static void xuatFileExcel(List<ChucVuModel> dsChucVu, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachChucVu");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã chức vụ");
            headerRow.createCell(1).setCellValue("Tên chức vụ");
            headerRow.createCell(2).setCellValue("Trạng thái hiển thị");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (ChucVuModel chucVu : dsChucVu) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(chucVu.getMaChucVu());
                row.createCell(1).setCellValue(chucVu.getTenChucVu());
                String trangThai = "";
                if (chucVu.getTrangThaiHienThi() == 0) {
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

    public static boolean kiemTraMaChucVuDaTonTai(String maChucVu) throws ClassNotFoundException {
        String sql = """
                 SELECT MaChucVu FROM ChucVu
                 WHERE MaChucVu=?
                 """;
        boolean flag = false;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChucVu);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraChucVuDaSuDung(String maChucVu) throws ClassNotFoundException {
        String sql = """
                 SELECT DISTINCT ChucVu.MaChucVu FROM ChucVu
                 JOIN TaiKhoan ON TaiKhoan.MaChucVu=ChucVu.MaChucVu
                 WHERE ChucVu.MaChucVu=?
                 """;
        boolean flag = false;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maChucVu);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
