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
import models.PhieuDRLModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PhieuDRLCtrl {

    public static List<PhieuDRLModel> timTatCaPhieuDRL() throws ClassNotFoundException {
        List<PhieuDRLModel> dsPhanCong = new ArrayList<>();
        String sql = """
                     SELECT DISTINCT MaLop, NamHoc, HocKy, NgayBatDau, NgayKetThuc FROM PhieuDRL
                     JOIN SinhVien ON PhieuDRL.MaSinhVien=SinhVien.MaSinhVien
                     JOIN NamHoc ON PhieuDRL.MaNamHoc=NamHoc.MaNamHoc
                     """;
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                PhieuDRLModel drl = new PhieuDRLModel(
                        resultSet.getString("MaLop"),
                        resultSet.getString("NamHoc"),
                        resultSet.getInt("HocKy"),
                        resultSet.getDate("NgayBatDau"),
                        resultSet.getDate("NgayKetThuc"));
                dsPhanCong.add(drl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuDRLCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPhanCong;
    }

    public static void themPhieuDRL(PhieuDRLModel phieu) throws ClassNotFoundException {
        String sql = "INSERT INTO PhieuDRL (MaPhieuDRL, MaSinhVien, MaNamHoc, HocKy, NgayBatDau, NgayKetThuc) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, phieu.getMaPhieuDRL());
            statement.setString(2, phieu.getMaSinhVien());
            statement.setInt(3, phieu.getMaNamHoc());
            statement.setInt(4, phieu.getHocKy());
            statement.setDate(5, phieu.getNgayBatDau());
            statement.setDate(6, phieu.getNgayKetThuc());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatPhieuDRL(PhieuDRLModel phieu) throws ClassNotFoundException {
        String sql = "UPDATE PhieuDRL SET NgayBatDau=?, NgayKetThuc=? WHERE MaPhieuDRL=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, phieu.getNgayBatDau());
            statement.setDate(2, phieu.getNgayKetThuc());
            statement.setString(3, phieu.getMaPhieuDRL());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaPhieuDRL(String maPhieuDRL) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM PhieuDRL WHERE MaPhieuDRL=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maPhieuDRL);
            statement.executeUpdate();
        }
    }

    public static void xuatFileExcel(List<PhieuDRLModel> dsPhieuDRL, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachPhieuDiemRenLuyen");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Lớp");
            headerRow.createCell(1).setCellValue("Năm học");
            headerRow.createCell(2).setCellValue("Học kỳ");
            headerRow.createCell(3).setCellValue("Ngày bắt đầu");
            headerRow.createCell(4).setCellValue("Ngày kết thuc");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (PhieuDRLModel phieu : dsPhieuDRL) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(phieu.getMaLop());
                row.createCell(1).setCellValue(phieu.getNamHoc());
                row.createCell(2).setCellValue(Integer.toString(phieu.getHocKy()));
                row.createCell(3).setCellValue(phieu.getNgayBatDau());
                row.createCell(4).setCellValue(phieu.getNgayKetThuc());
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
