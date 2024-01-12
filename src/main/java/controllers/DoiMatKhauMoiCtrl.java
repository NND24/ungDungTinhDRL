package controllers;

import utils.PasswordHashing;
import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoiMatKhauMoiCtrl {

    public static void doiMatKhau(String email, String newPassword) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE NHANVIEN SET MatKhau=? WHERE Email=?";
            statement = connection.prepareCall(sql);
            String hashedPassword = PasswordHashing.hashPassword(newPassword);
            statement.setString(1, hashedPassword);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DoiMatKhauMoiCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DoiMatKhauMoiCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DoiMatKhauMoiCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
