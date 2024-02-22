package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.PasswordHashing;
import models.TaiKhoanModel;

public class TaiKhoanCtrl {

    public static void themTaiKhoan(TaiKhoanModel tk) throws ClassNotFoundException {
        String sql = "INSERT INTO TaiKhoan (MaTaiKhoan, Email, MatKhau, MaChucVu) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tk.getMaTaiKhoan());
            statement.setString(2, tk.getEmail());
            String hashedPassword = PasswordHashing.hashPassword(tk.getMatKhau());
            statement.setString(3, hashedPassword);
            statement.setString(4, tk.getMaChucVu());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String dangNhap(String maTaiKhoan, String matKhau) throws ClassNotFoundException {
        String maChucVu = "";
        try (Connection connection = ConnectDB.getConnection()) {
            String sql = "SELECT MatKhau, MaChucVu FROM TaiKhoan WHERE MaTaiKhoan=? ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, maTaiKhoan);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String storedPasswordHash = resultSet.getString("MatKhau");
                    if (PasswordHashing.checkPassword(matKhau, storedPasswordHash)) {
                        maChucVu = resultSet.getString("MaChucVu");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maChucVu;
    }

    public static boolean kiemTraTaiKhoanCoTonTai(String maTaiKhoan) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM TaiKhoan WHERE MaTaiKhoan=? AND TrangThaiXoa='0'";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maTaiKhoan);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    flag = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM TaiKhoan WHERE Email=? AND TrangThaiXoa='0'";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    flag = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static boolean kiemTraEmailCoDungTaiKhoan(String email, String maTaiKhoan) throws ClassNotFoundException {
        boolean flag = false;
        String sql = "SELECT * FROM TaiKhoan WHERE Email=? AND MaTaiKhoan=? AND TrangThaiXoa='0'";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, maTaiKhoan);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    flag = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static void doiMatKhau(String maTaiKhoan, String newPassword) throws ClassNotFoundException {
        String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaTaiKhoan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            String hashedPassword = PasswordHashing.hashPassword(newPassword);
            statement.setString(1, hashedPassword);
            statement.setString(2, maTaiKhoan);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaTaiKhoan(String maTaiKhoan) {
        String sql = "UPDATE TaiKhoan SET TrangThaiXoa='1' WHERE MaTaiKhoan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maTaiKhoan);

            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
