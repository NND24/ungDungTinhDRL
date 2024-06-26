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
import models.PhanCongModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.DialogHelper;

public class PhanCongCtrl {

    public static List<String> timDSLopPhanCong(String tenDangNhap) throws ClassNotFoundException {
        List<String> dsDiemRenLuyen = new ArrayList<>();
        String sql = """
                     SELECT DISTINCT PhanCong.MaLop FROM PhanCong
                     JOIN CoVan ON  CoVan.MaCoVan=PhanCong.MaCoVan
                     JOIN Lop ON PhanCong.MaLop=Lop.MaLop
                     JOIN TaiKhoan ON TaiKhoan.MaTaiKhoan=CoVan.MaTaiKhoan
                     JOIN NamHoc ON NamHoc.MaNamHoc=PhanCong.MaNamHoc
                     WHERE TenDangNhap = ? AND PhanCong.TrangThaiHienThi=1
                     AND Lop.TrangThaiHienThi=1 AND NamHoc.TrangThaiHienThi=1
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tenDangNhap);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String drl = resultSet.getString("MaLop");
                dsDiemRenLuyen.add(drl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDiemRenLuyen;
    }

    public static List<NamHocModel> timDSNamHocPhanCong(String tenDangNhap, String maLop) throws ClassNotFoundException {
        List<NamHocModel> dsNamHoc = new ArrayList<>();
        String sql = """
                     SELECT DISTINCT PhanCong.MaNamHoc, NamHoc, NamHoc.TrangThaiHienThi FROM PhanCong
                     JOIN CoVan ON  CoVan.MaCoVan=PhanCong.MaCoVan
                     JOIN Lop ON PhanCong.MaLop=Lop.MaLop
                     JOIN TaiKhoan ON TaiKhoan.MaTaiKhoan=CoVan.MaTaiKhoan
                     JOIN NamHoc ON NamHoc.MaNamHoc=PhanCong.MaNamHoc
                     WHERE TenDangNhap = ?  AND PhanCong.MaLop=?
                     AND PhanCong.TrangThaiHienThi=1 AND Lop.TrangThaiHienThi=1 AND NamHoc.TrangThaiHienThi=1
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tenDangNhap);
            statement.setString(2, maLop);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NamHocModel nh = new NamHocModel(resultSet.getInt("MaNamHoc"),
                        resultSet.getString("NamHoc"),
                        resultSet.getInt("TrangThaiHienThi"));
                dsNamHoc.add(nh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNamHoc;
    }

    public static List<PhanCongModel> timTatCaPhanCong() throws ClassNotFoundException {
        List<PhanCongModel> dsPhanCong = new ArrayList<>();
        String sql = """
                     SELECT DISTINCT PhanCong.MaPhanCong, PhanCong.MaCoVan, HoTen, PhanCong.MaLop, NamHoc, PhanCong.TrangThaiHienThi FROM PhanCong, CoVan, Lop, NamHoc
                     WHERE PhanCong.MaCoVan=CoVan.MaCoVan AND PhanCong.MaLop=Lop.MaLop
                     AND PhanCong.MaNamHoc=NamHoc.MaNamHoc
                     """;
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                PhanCongModel drl = new PhanCongModel(
                        resultSet.getInt("MaPhanCong"),
                        resultSet.getString("MaCoVan"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("MaLop"),
                        resultSet.getString("NamHoc"),
                        resultSet.getInt("TrangThaiHienThi"));
                dsPhanCong.add(drl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPhanCong;
    }

    public static void themPhanCong(PhanCongModel phanCong) throws ClassNotFoundException {
        String sql = "INSERT INTO PhanCong (MaLop, MaNamHoc, MaCoVan, TrangThaiHienThi) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, phanCong.getMaLop());
            statement.setInt(2, phanCong.getMaNamHoc());
            statement.setString(3, phanCong.getMaCoVan());
            statement.setInt(4, phanCong.getTrangThaiHienThi());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PhanCongCtrl.class.getName()).log(Level.SEVERE, null, ex);

            String constraintName = "";
            if (ex.getMessage().contains("UNIQUE KEY constraint")) {
                // Lấy tên của ràng buộc UNIQUE từ thông báo lỗi
                int startIndex = ex.getMessage().indexOf("UNIQUE KEY constraint '") + "UNIQUE KEY constraint '".length();
                int endIndex = ex.getMessage().indexOf("'", startIndex);
                constraintName = ex.getMessage().substring(startIndex, endIndex);
            }

            if (!constraintName.isEmpty()) {
                DialogHelper.showError("Bị trùng cố vấn, lớp, năm học. Vui lòng nhập lại");
            } else {
                DialogHelper.showError("Lỗi khi thực hiện thao tác với cơ sở dữ liệu");
            }
        }
    }

    public static void capNhatPhanCong(PhanCongModel phanCong) throws ClassNotFoundException {
        String sql = "UPDATE PhanCong SET MaLop=?, MaNamHoc=?, MaCoVan=?, TrangThaiHienThi=? WHERE MaPhanCong=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, phanCong.getMaLop());
            statement.setInt(2, phanCong.getMaNamHoc());
            statement.setString(3, phanCong.getMaCoVan());
            statement.setInt(4, phanCong.getTrangThaiHienThi());
            statement.setInt(5, phanCong.getMaPhanCong());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PhanCongCtrl.class.getName()).log(Level.SEVERE, null, ex);

            String constraintName = "";
            if (ex.getMessage().contains("UNIQUE KEY constraint")) {
                // Lấy tên của ràng buộc UNIQUE từ thông báo lỗi
                int startIndex = ex.getMessage().indexOf("UNIQUE KEY constraint '") + "UNIQUE KEY constraint '".length();
                int endIndex = ex.getMessage().indexOf("'", startIndex);
                constraintName = ex.getMessage().substring(startIndex, endIndex);
            }

            if (!constraintName.isEmpty()) {
                DialogHelper.showError("Bị trùng cố vấn, lớp, năm học. Vui lòng nhập lại");
            } else {
                DialogHelper.showError("Lỗi khi thực hiện thao tác với cơ sở dữ liệu");
            }
        }
    }

    public static void xoaPhanCong(int maPhanCong) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM PhanCong WHERE MaPhanCong=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maPhanCong);
            statement.executeUpdate();
        }
    }

    public static List<PhanCongModel> timKiemPhanCong(String tuKhoa) throws ClassNotFoundException {
        String sql = """
                     SELECT DISTINCT PhanCong.MaPhanCong, PhanCong.MaCoVan, HoTen, PhanCong.MaLop, NamHoc, PhanCong.TrangThaiHienThi FROM PhanCong, CoVan, Lop, NamHoc
                     WHERE PhanCong.MaCoVan=CoVan.MaCoVan AND PhanCong.MaLop=Lop.MaLop
                     AND PhanCong.MaNamHoc=NamHoc.MaNamHoc
                     AND (PhanCong.MaPhanCong LIKE ? OR PhanCong.MaCoVan LIKE ? OR HoTen LIKE ? OR PhanCong.MaLop LIKE ? OR NamHoc LIKE ?)
                     """;
        List<PhanCongModel> dsPhanCong = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, "%" + tuKhoa + "%");
            statement.setString(4, "%" + tuKhoa + "%");
            statement.setString(5, "%" + tuKhoa + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PhanCongModel drl = new PhanCongModel(
                        resultSet.getInt("MaPhanCong"),
                        resultSet.getString("MaCoVan"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("MaLop"),
                        resultSet.getString("NamHoc"),
                        resultSet.getInt("TrangThaiHienThi"));
                dsPhanCong.add(drl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPhanCong;
    }

    public static boolean kiemTraLopNamHocDaPhanCong(String maLop, int maNamHoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaPhanCong FROM PhanCong
                     WHERE MaLop=? AND MaNamHoc=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maLop);
            statement.setInt(2, maNamHoc);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraLopNamHocDaPhanCongCoMa(String maLop, int maNamHoc, int maPhanCong) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaPhanCong FROM PhanCong
                     WHERE MaLop=? AND MaNamHoc=? AND MaPhanCong!=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maLop);
            statement.setInt(2, maNamHoc);
            statement.setInt(3, maPhanCong);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void xuatFileExcel(List<PhanCongModel> dsCoVan, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachPhanCong");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã phân công");
            headerRow.createCell(1).setCellValue("Lớp");
            headerRow.createCell(2).setCellValue("Năm học");
            headerRow.createCell(3).setCellValue("Cố vấn");
            headerRow.createCell(4).setCellValue("Trạng thái hiển thị");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (PhanCongModel cv : dsCoVan) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(cv.getMaPhanCong());
                row.createCell(1).setCellValue(cv.getMaLop());
                row.createCell(2).setCellValue(cv.getNamHoc());
                row.createCell(3).setCellValue(cv.getTenCoVan());
                row.createCell(4).setCellValue(cv.getTrangThaiHienThi());
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
