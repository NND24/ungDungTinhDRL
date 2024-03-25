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
import models.LopModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LopCtrl {

    public static void themLop(LopModel lop) throws ClassNotFoundException {
        String sql = "INSERT INTO Lop (MaNganh, MaLop, Khoa, TrangThaiHienThi) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lop.getMaNganh());
            statement.setString(2, lop.getMaLop());
            statement.setString(3, lop.getKhoa());
            statement.setInt(4, lop.getTrangThaiHienThi());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LopCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void capNhatLop(LopModel lop) throws ClassNotFoundException {
        String sql = "UPDATE Lop SET MaNganh=?, MaLop=?, Khoa=?, TrangThaiHienThi=? WHERE MaLop=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lop.getMaNganh());
            statement.setString(2, lop.getMaLop());
            statement.setString(3, lop.getKhoa());
            statement.setInt(4, lop.getTrangThaiHienThi());
            statement.setString(5, lop.getMaLop());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LopCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<LopModel> timTatCaLop() throws ClassNotFoundException {
        List<LopModel> dsLop = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM Lop
                     JOIN Nganh ON Nganh.MaNganh=Lop.MaNganh
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                LopModel lop = new LopModel(
                        resultSet.getString("MaLop"),
                        resultSet.getString("MaNganh"),
                        resultSet.getString("TenNganh"),
                        resultSet.getString("Khoa"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsLop.add(lop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLop;
    }

    public static List<LopModel> timTatCaLopHienThi() throws ClassNotFoundException {
        List<LopModel> dsLop = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM Lop
                     JOIN Nganh ON Nganh.MaNganh=Lop.MaNganh
                     WHERE Lop.TrangThaiHienThi=1
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                LopModel lop = new LopModel(
                        resultSet.getString("MaLop"),
                        resultSet.getString("MaNganh"),
                        resultSet.getString("TenNganh"),
                        resultSet.getString("Khoa"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsLop.add(lop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLop;
    }

    public static List<LopModel> timLopTheoKhoa(String maKhoa) throws ClassNotFoundException {
        String sql = """
                     SELECT Lop.MaLop, Lop.MaNganh, Khoa, Lop.TrangThaiHienThi, TenNganh FROM KHOA
                     JOIN Nganh ON Khoa.MaKhoa=Nganh.MaKhoa
                     JOIN Lop ON Nganh.MaNganh=Lop.MaNganh
                     WHERE Khoa.TrangThaiHienThi=1 AND Lop.TrangThaiHienThi=1
                     AND Khoa.MaKhoa=?
                     """;
        List<LopModel> dsLop = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maKhoa);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                LopModel lop = new LopModel(
                        resultSet.getString("MaLop"),
                        resultSet.getString("MaNganh"),
                        resultSet.getString("TenNganh"),
                        resultSet.getString("Khoa"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsLop.add(lop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLop;
    }

    public static List<LopModel> timKiemLop(String tuKhoa) throws ClassNotFoundException {
        String sql = """
                     SELECT Lop.MaLop, Lop.MaNganh, Khoa, Lop.TrangThaiHienThi, TenNganh FROM KHOA
                     JOIN Nganh ON Khoa.MaKhoa=Nganh.MaKhoa
                     JOIN Lop ON Nganh.MaNganh=Lop.MaNganh
                     WHERE Khoa.TrangThaiHienThi=1
                     AND Khoa.MaKhoa LIKE ? OR TenKhoa LIKE ? OR MaLop LIKE ? OR KHOA LIKE ?
                     """;
        List<LopModel> dsLop = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, "%" + tuKhoa + "%");
            statement.setString(4, "%" + tuKhoa + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                LopModel lop = new LopModel(
                        resultSet.getString("MaLop"),
                        resultSet.getString("MaNganh"),
                        resultSet.getString("TenNganh"),
                        resultSet.getString("Khoa"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsLop.add(lop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
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

    public static boolean kiemTraLopDaDuocSuDung(String maLop) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT DISTINCT Lop.MaLop FROM Lop
                     JOIN SinhVien ON Lop.MaLop=SinhVien.MaLop
                     WHERE Lop.MaLop=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maLop);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraMaLopDaTonTai(String maLop) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaLop FROM Lop
                     WHERE MaLop=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maLop);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void xuatFileExcel(List<LopModel> dsLop, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachLop");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã lớp");
            headerRow.createCell(1).setCellValue("Mã ngành");
            headerRow.createCell(2).setCellValue("Tên lớp");
            headerRow.createCell(3).setCellValue("Khóa");
            headerRow.createCell(4).setCellValue("Trạng thái hiển thị");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (LopModel lop : dsLop) {
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
