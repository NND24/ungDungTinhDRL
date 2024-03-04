package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.SinhVienModelTest;

public class SinhVienCtrlTest {

    public static void themSinhVien(SinhVienModelTest sv) throws ClassNotFoundException {
        String sql = "INSERT INTO SinhVien (MaSinhVien, TenLop, HoTen, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, sv.getMaSinhVien());
            statement.setString(2, sv.getTenLop());
            statement.setString(3, sv.getHoTen());
            statement.setString(4, sv.getEmail());
            statement.setString(5, sv.getGioiTinh());
            statement.setDate(6, sv.getNgaySinh());
            statement.setString(7, sv.getSoDienThoai());
            statement.setString(8, sv.getCanCuoc());
            statement.setString(9, sv.getQueQuan());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<SinhVienModelTest> timTatCaSinhVien() throws ClassNotFoundException {
        List<SinhVienModelTest> dsSinhVien = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                         SELECT DISTINCT MaSinhVien, TenLop, HoTen, MaChucVu, Email, GioiTinh, NgaySinh, SoDienThoai, CanCuoc,QueQuan
                         FROM SinhVien, TaiKhoan WHERE SinhVien.IdTaiKhoan=TaiKhoan.IdTaiKhoan
                         AND SinhVien.TrangThaiXoa=0 AND TaiKhoan.TrangThaiXoa=0
                         """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                SinhVienModelTest sv = new SinhVienModelTest(
                        resultSet.getString("MaSinhVien"),
                        resultSet.getString("TenLop"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("MaChucVu"),
                        resultSet.getString("Email"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan")
                );
                dsSinhVien.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsSinhVien;
    }

    public static SinhVienModelTest timSinhVienTheoMaSV(String maSV) throws ClassNotFoundException {
        String sql = """
                     SELECT * FROM SinhVien, TaiKhoan
                     WHERE MaSinhVien=? AND SinhVien.IdTaiKhoan=TaiKhoan.IdTaiKhoan
                     AND SinhVien.TrangThaiXoa=0 AND TaiKhoan.TrangThaiXoa=0
                     """;
        SinhVienModelTest sinhVien = null;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maSV);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SinhVienModelTest sv = new SinhVienModelTest(
                        resultSet.getString("MaSinhVien"),
                        resultSet.getString("TenLop"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("MaChucVu"),
                        resultSet.getString("Email"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getString("SoDienThoai"),
                        resultSet.getString("CanCuoc"),
                        resultSet.getString("QueQuan")
                );
                sinhVien = sv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sinhVien;
    }
}
