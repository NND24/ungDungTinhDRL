/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.NganhModel;

/**
 *
 * @author ACER
 */
public class NganhCtrl {
    public static List<NganhModel> timTatCaNganh() throws ClassNotFoundException {
        List<NganhModel> dsNganh = new ArrayList<>();

        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            String sql = """
                     SELECT * FROM Nganh
                     """;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                NganhModel nganh = new NganhModel(
                        resultSet.getString("MaNganh"),
                        resultSet.getString("MaKhoa"),
                        resultSet.getString("TenNganh"),
                        resultSet.getInt("TrangThaiHienThi")
                );
                dsNganh.add(nganh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopTestCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNganh;
    }
}
