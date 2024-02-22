package controllers;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhanCongCtrl {

    public static List<String> timDSLop(String maCoVan) throws ClassNotFoundException {
        List<String> dsDiemRenLuyen = new ArrayList<>();
        String sql = "SELECT TenLop, TrangThaiXoa FROM PhanCong WHERE maCoVan = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maCoVan);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("TrangThaiXoa") == 0) {
                    String drl = resultSet.getString("TenLop");
                    dsDiemRenLuyen.add(drl);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDiemRenLuyen;
    }
}
