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
import models.CoVanModelTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CoVanCtrlTest {

    public static void themCoVan(CoVanModelTest coVan) throws ClassNotFoundException {
        String sql = "INSERT INTO CoVan (MaCoVan, MaTaiKhoan, MaKhoa, HoTen, Email, NgaySinh, GioiTinh, SoDienThoai, CanCuoc, QueQuan, HocVi, HocHam, ChuyenMon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, coVan.getMaCoVan());
            statement.setString(2, coVan.getMaTaiKhoan());
            statement.setInt(3, coVan.getMaKhoa());
            statement.setString(4, coVan.getHoTen());
            statement.setString(5, coVan.getEmail());
            statement.setDate(6, coVan.getNgaySinh());
            statement.setInt(7, coVan.getGioiTinh());
            statement.setString(8, coVan.getSoDienThoai());
            statement.setString(9, coVan.getCanCuoc());
            statement.setString(10, coVan.getQueQuan());
            statement.setString(11, coVan.getHocVi());
            statement.setString(12, coVan.getHocHam());
            statement.setString(13, coVan.getChuyenMon());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoVanCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<CoVanModelTest> timTatCaCoVan() throws ClassNotFoundException {
        List<CoVanModelTest> dsCoVan = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "SELECT DISTINCT * FROM CoVan, Khoa WHERE CoVan.MaKhoa=Khoa.MaKhoa";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                CoVanModelTest coVan = new CoVanModelTest(
                        resultSet.getString("MaCoVan"),
                        resultSet.getString("MaTaiKhoan"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("Email"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan"),
                        resultSet.getString("HocVi"),
                        resultSet.getString("HocHam"),
                        resultSet.getString("ChuyenMon"),
                        resultSet.getInt("MaKhoa"),
                        resultSet.getInt("GioiTinh"),
                        resultSet.getDate("NgaySinh")
                );
                dsCoVan.add(coVan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoVanCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsCoVan;
    }

    public static List<CoVanModelTest> timCoVanTheoDK(String tuKhoa, String gioiTinh) throws ClassNotFoundException {
        List<CoVanModelTest> dsCoVan = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectDB.getConnection();

            if (!tuKhoa.isEmpty() && gioiTinh.isEmpty()) {
                String sql = "SELECT DISTINCT * FROM CoVan, Khoa WHERE CoVan.MaKhoa=Khoa.MaKhoa AND (MaCoVan LIKE ? OR HoTen LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + tuKhoa + "%");
                statement.setString(2, "%" + tuKhoa + "%");
                statement.setString(3, "%" + tuKhoa + "%");
                statement.setString(4, "%" + tuKhoa + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    CoVanModelTest coVan = new CoVanModelTest(
                            resultSet.getString("MaCoVan"),
                            resultSet.getString("MaTaiKhoan"),
                            resultSet.getString("TenKhoa"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("Email"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("QueQuan"),
                            resultSet.getString("HocVi"),
                            resultSet.getString("HocHam"),
                            resultSet.getString("ChuyenMon"),
                            resultSet.getInt("MaKhoa"),
                            resultSet.getInt("GioiTinh"),
                            resultSet.getDate("NgaySinh")
                    );
                    dsCoVan.add(coVan);
                }
            } else if (tuKhoa.isEmpty() && !gioiTinh.isEmpty()) {
                String sql = "SELECT DISTINCT * FROM CoVan, Khoa WHERE CoVan.MaKhoa=Khoa.MaKhoa AND GioiTinh LIKE ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + gioiTinh + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    CoVanModelTest coVan = new CoVanModelTest(
                            resultSet.getString("MaCoVan"),
                            resultSet.getString("MaTaiKhoan"),
                            resultSet.getString("TenKhoa"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("Email"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("QueQuan"),
                            resultSet.getString("HocVi"),
                            resultSet.getString("HocHam"),
                            resultSet.getString("ChuyenMon"),
                            resultSet.getInt("MaKhoa"),
                            resultSet.getInt("GioiTinh"),
                            resultSet.getDate("NgaySinh")
                    );
                    dsCoVan.add(coVan);
                }
            } else if (!tuKhoa.isEmpty() && !gioiTinh.isEmpty()) {
                String sql = "SELECT DISTINCT * FROM CoVan, Khoa WHERE CoVan.MaKhoa=Khoa.MaKhoa AND ( MaCoVan LIKE ? OR HoTen LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ?) AND GioiTinh LIKE ?";
                statement = connection.prepareStatement(sql);
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + tuKhoa + "%");
                statement.setString(2, "%" + tuKhoa + "%");
                statement.setString(3, "%" + tuKhoa + "%");
                statement.setString(4, "%" + tuKhoa + "%");
                statement.setString(5, "%" + gioiTinh + "%");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    CoVanModelTest coVan = new CoVanModelTest(
                            resultSet.getString("MaCoVan"),
                            resultSet.getString("MaTaiKhoan"),
                            resultSet.getString("TenKhoa"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("Email"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("QueQuan"),
                            resultSet.getString("HocVi"),
                            resultSet.getString("HocHam"),
                            resultSet.getString("ChuyenMon"),
                            resultSet.getInt("MaKhoa"),
                            resultSet.getInt("GioiTinh"),
                            resultSet.getDate("NgaySinh")
                    );
                    dsCoVan.add(coVan);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CoVanCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CoVanCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CoVanCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dsCoVan;
    }

    public static void capNhatQuanLy(CoVanModelTest coVan) {
        String sql = "UPDATE CoVan SET HoTen=?, Email=?, NgaySinh=?, GioiTinh=?, SoDienThoai=?, CanCuoc=?, QueQuan=?, HocVi=?, HocHam=?, ChuyenMon=?, MaKhoa=? WHERE MaCoVan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, coVan.getHoTen());
            statement.setString(2, coVan.getEmail());
            statement.setDate(3, coVan.getNgaySinh());
            statement.setInt(4, coVan.getGioiTinh());
            statement.setString(5, coVan.getSoDienThoai());
            statement.setString(6, coVan.getCanCuoc());
            statement.setString(7, coVan.getQueQuan());
            statement.setString(8, coVan.getHocVi());
            statement.setString(9, coVan.getHocHam());
            statement.setString(10, coVan.getChuyenMon());
            statement.setInt(11, coVan.getMaKhoa());
            statement.setString(12, coVan.getMaCoVan());

            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CoVanCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaCoVan(String maCoVan) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM CoVan WHERE MaCoVan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maCoVan);
            statement.executeUpdate();
        }
    }

    public static boolean kiemTraKhoaDaSuDung(String maCoVan) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT CoVan.MaCoVan FROM CoVan
                     JOIN PhanCong ON PhanCong.MaCoVan=CoVan.MaCoVan
                     WHERE CoVan.MaCoVan=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maCoVan);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void xuatFileExcel(List<CoVanModelTest> dsCoVan, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachCoVan");

            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã cố vấn");
            headerRow.createCell(1).setCellValue("Họ tên");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Giới tính");
            headerRow.createCell(4).setCellValue("Ngày sinh");
            headerRow.createCell(5).setCellValue("Số điện thoại");
            headerRow.createCell(6).setCellValue("Căn cước");
            headerRow.createCell(7).setCellValue("Quê quán");
            headerRow.createCell(7).setCellValue("Học vị");
            headerRow.createCell(7).setCellValue("Học hàm");
            headerRow.createCell(7).setCellValue("Chuyên môn");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (CoVanModelTest coVan : dsCoVan) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(coVan.getMaCoVan());
                row.createCell(1).setCellValue(coVan.getHoTen());
                row.createCell(2).setCellValue(coVan.getEmail());
                row.createCell(3).setCellValue(coVan.getGioiTinh());
                row.createCell(4).setCellValue(coVan.getNgaySinh());
                row.createCell(5).setCellValue(coVan.getSoDienThoai());
                row.createCell(6).setCellValue(coVan.getCanCuoc());
                row.createCell(7).setCellValue(coVan.getQueQuan());
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
