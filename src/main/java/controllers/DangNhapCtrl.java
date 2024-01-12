package controllers;

import utils.PasswordHashing;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DangNhapCtrl {

    public static boolean dangNhap(String email, String matKhau) throws ClassNotFoundException {
        boolean flag = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT MatKhau FROM GIANGVIEN WHERE Email=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPasswordHash = resultSet.getString("MatKhau");
                flag = PasswordHashing.checkPassword(matKhau, storedPasswordHash);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DangNhapCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhapCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhapCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return flag;
    }

    public static boolean kiemTraEmailCoTonTai(String email) throws ClassNotFoundException {
        boolean flag = false;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM GIANGVIEN WHERE Email=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DangNhapCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhapCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DangNhapCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return flag;
    }

}
