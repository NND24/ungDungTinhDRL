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
import models.CoVanTestModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CoVanTestCtrl {

    public static void themCoVan(CoVanTestModel coVan) throws ClassNotFoundException {
        String sql = "INSERT INTO CoVan (MaCoVan, MaTaiKhoan, MaKhoa, HoTen, Email, NgaySinh, GioiTinh, SoDienThoai, CanCuoc, QueQuan, HocVi, HocHam, ChuyenMon, DaNghi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, coVan.getMaCoVan());
            statement.setString(2, coVan.getMaTaiKhoan());
            statement.setString(3, coVan.getMaKhoa());
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
            statement.setInt(14, coVan.getDaNghi());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoVanTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<CoVanTestModel> timTatCaCoVan() throws ClassNotFoundException {
        List<CoVanTestModel> dsCoVan = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "SELECT DISTINCT * FROM CoVan, Khoa WHERE CoVan.MaKhoa=Khoa.MaKhoa";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                CoVanTestModel coVan = new CoVanTestModel(
                        resultSet.getString("MaCoVan"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("Email"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan"),
                        resultSet.getString("HocVi"),
                        resultSet.getString("HocHam"),
                        resultSet.getString("ChuyenMon"),
                        resultSet.getString("MaKhoa"),
                        resultSet.getInt("GioiTinh"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getInt("DaNghi")
                );
                dsCoVan.add(coVan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoVanTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsCoVan;
    }

    public static CoVanTestModel timCoVanTheoTenDangNhap(String tenDangNhap) throws ClassNotFoundException {
        String sql = """
                     SELECT MaCoVan, Khoa.TenKhoa, Khoa.MaKhoa, HoTen, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan, DaNghi, HocVi, HocHam, ChuyenMon
                     FROM CoVan
                     JOIN Khoa ON CoVan.MaKhoa=Khoa.MaKhoa
                     JOIN TaiKhoan ON TaiKhoan.MaTaiKhoan=CoVan.MaTaiKhoan
                     AND TenDangNhap=?
                     """;
        CoVanTestModel coVan = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tenDangNhap);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CoVanTestModel cv = new CoVanTestModel(
                        resultSet.getString("MaCoVan"),
                        resultSet.getString("TenKhoa"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("Email"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan"),
                        resultSet.getString("HocVi"),
                        resultSet.getString("HocHam"),
                        resultSet.getString("ChuyenMon"),
                        resultSet.getString("MaKhoa"),
                        resultSet.getInt("GioiTinh"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getInt("DaNghi")
                );
                coVan = cv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coVan;
    }

    public static List<CoVanTestModel> timKiemCoVan(String tuKhoa, String khoa) throws ClassNotFoundException {
        List<CoVanTestModel> dsCoVan = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(
                """
                SELECT MaCoVan, Khoa.TenKhoa, Khoa.MaKhoa, HoTen, Email,  GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan, DaNghi, HocVi, HocHam, ChuyenMon
                FROM CoVan
                JOIN Khoa ON Khoa.MaKhoa = CoVan.MaKhoa
                AND (MaCoVan LIKE ? OR HoTen LIKE ? OR Email LIKE ? OR SoDienThoai LIKE ? OR CanCuoc LIKE ?) """
                + (khoa.isEmpty() ? "" : "AND Khoa.MaKhoa=?"))) {
            statement.setString(1, "%" + tuKhoa + "%");
            statement.setString(2, "%" + tuKhoa + "%");
            statement.setString(3, "%" + tuKhoa + "%");
            statement.setString(4, "%" + tuKhoa + "%");
            statement.setString(5, "%" + tuKhoa + "%");
            if (!khoa.isEmpty()) {
                statement.setString(6, khoa);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CoVanTestModel cv = new CoVanTestModel(
                            resultSet.getString("MaCoVan"),
                            resultSet.getString("TenKhoa"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("Email"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("QueQuan"),
                            resultSet.getString("HocVi"),
                            resultSet.getString("HocHam"),
                            resultSet.getString("ChuyenMon"),
                            resultSet.getString("MaKhoa"),
                            resultSet.getInt("GioiTinh"),
                            resultSet.getDate("NgaySinh"),
                            resultSet.getInt("DaNghi")
                    );
                    dsCoVan.add(cv);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsCoVan;
    }

    public static void capNhatCoVan(CoVanTestModel coVan) {
        String sql = "UPDATE CoVan SET HoTen=?, Email=?, NgaySinh=?, GioiTinh=?, SoDienThoai=?, CanCuoc=?, QueQuan=?, HocVi=?, HocHam=?, ChuyenMon=?, MaKhoa=?, DaNghi=? WHERE MaCoVan=?";
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
            statement.setString(11, coVan.getMaKhoa());
            statement.setInt(12, coVan.getDaNghi());
            statement.setString(13, coVan.getMaCoVan());

            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CoVanTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaCoVan(String maCoVan) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM CoVan WHERE MaCoVan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maCoVan);
            statement.executeUpdate();
        }
    }

    public static boolean kiemTraCoVanDaPhanCong(String maCoVan) throws ClassNotFoundException {
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

    public static boolean kiemTraCoVanDaChamDiem(String maCoVan) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT CoVan.MaCoVan FROM CoVan
                     JOIN PhieuDRL ON PhieuDRL.MaCoVanCham=CoVan.MaCoVan
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

    public static boolean kiemTraCanCuocTrung(String maCoVan, String canCuoc) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaCoVan FROM CoVan
                     WHERE MaCoVan!=? AND CanCuoc=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maCoVan);
            statement.setString(2, canCuoc);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraSoDienThoaiTrung(String maCoVan, String soDienThoai) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaCoVan FROM CoVan
                     WHERE MaCoVan!=? AND SoDienThoai=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maCoVan);
            statement.setString(2, soDienThoai);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static String layMaTaiKhoanCV(String maCoVan) throws ClassNotFoundException {
        String maTaiKhoan = "";
        String sql = "SELECT CoVan.MaTaiKhoan FROM CoVan,TaiKhoan WHERE CoVan.MaTaiKhoan=TaiKhoan.MaTaiKhoan AND MaCoVan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maCoVan);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    maTaiKhoan = resultSet.getString("MaTaiKhoan");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return maTaiKhoan;
    }

    public static int layMaCoVanCuoiCung() throws ClassNotFoundException {
        int maCV = 0;
        String sql = """
                     SELECT TOP 1
                    RIGHT(MaCoVan, 3) AS MaCoVan
                    FROM
                    CoVan
                    ORDER BY
                    MaCoVan DESC;
                     """;
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                maCV = resultSet.getInt("MaCoVan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maCV;
    }

    public static void xuatFileExcel(List<CoVanTestModel> dsCoVan, String filePath) {
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
            headerRow.createCell(8).setCellValue("Học vị");
            headerRow.createCell(9).setCellValue("Học hàm");
            headerRow.createCell(10).setCellValue("Chuyên môn");
            headerRow.createCell(11).setCellValue("Trạng thái");

            // Ghi dữ liệu vào sheet
            int rowNum = 1;
            for (CoVanTestModel coVan : dsCoVan) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(coVan.getMaCoVan());
                row.createCell(1).setCellValue(coVan.getHoTen());
                row.createCell(2).setCellValue(coVan.getEmail());
                row.createCell(3).setCellValue(coVan.getGioiTinh());
                row.createCell(4).setCellValue(coVan.getNgaySinh());
                row.createCell(5).setCellValue(coVan.getSoDienThoai());
                row.createCell(6).setCellValue(coVan.getCanCuoc());
                row.createCell(7).setCellValue(coVan.getQueQuan());
                row.createCell(8).setCellValue(coVan.getHocVi());
                row.createCell(9).setCellValue(coVan.getHocHam());
                row.createCell(10).setCellValue(coVan.getChuyenMon());
                String trangThai = "";
                if (coVan.getDaNghi() == 0) {
                    trangThai = "Còn làm";
                } else {
                    trangThai = "Đã nghỉ";
                }
                row.createCell(11).setCellValue(trangThai);
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
