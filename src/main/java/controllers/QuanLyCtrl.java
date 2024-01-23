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
import models.QuanLyModel;

public class QuanLyCtrl {

    public static void themQuanLy(QuanLyModel ql) throws ClassNotFoundException {
        String sql = "INSERT INTO QuanLy (MaQuanLy, HoTen, GioiTinh, NgaySinh, SoDienThoai, CanCuoc, QueQuan) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, ql.getMaQuanLy());
            statement.setString(2, ql.getHoTen());
            statement.setString(3, ql.getGioiTinh());
            statement.setDate(4, ql.getNgaySinh());
            statement.setString(5, ql.getSoDienThoai());
            statement.setString(6, ql.getCanCuoc());
            statement.setString(7, ql.getQueQuan());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<QuanLyModel> timTatCaQuanLy() throws ClassNotFoundException {
        List<QuanLyModel> dsQuanLy = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "SELECT DISTINCT *, QuanLy.TrangThaiXoa AS TrangThaiXoaQL,  TaiKhoan.TrangThaiXoa AS TrangThaiXoaTK FROM QuanLy INNER JOIN TaiKhoan ON QuanLy.MaQuanLy = TaiKhoan.MaTaiKhoan";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                if (resultSet.getInt("TrangThaiXoaQL") == 0 && resultSet.getInt("TrangThaiXoaTK") == 0) {
                    QuanLyModel ql = new QuanLyModel(
                            resultSet.getString("MaQuanLy"),
                            resultSet.getString("HoTen"),
                            resultSet.getString("Email"),
                            resultSet.getString("GioiTinh"),
                            resultSet.getString("SoDienThoai"),
                            resultSet.getString("CanCuoc"),
                            resultSet.getString("QueQuan"),
                            resultSet.getDate("NgaySinh")
                    );
                    dsQuanLy.add(ql);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsQuanLy;
    }

    public static void capNhatQuanLy(QuanLyModel ql) {
        String sql = "UPDATE QuanLy SET HoTen=?, NgaySinh=?, GioiTinh=?, SoDienThoai=?, CanCuoc=?, QueQuan=? WHERE MaQuanLy=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ql.getHoTen());
            statement.setDate(2, ql.getNgaySinh());
            statement.setString(3, ql.getGioiTinh());
            statement.setString(4, ql.getSoDienThoai());
            statement.setString(5, ql.getCanCuoc());
            statement.setString(6, ql.getQueQuan());
            statement.setString(7, ql.getMaQuanLy());

            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaQuanLy(String maQuanLy) {
        String sql = "UPDATE QuanLy SET TrangThaiXoa='1' WHERE MaQuanLy=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maQuanLy);

            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
