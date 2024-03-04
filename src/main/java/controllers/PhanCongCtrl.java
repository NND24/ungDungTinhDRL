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
import models.PhanCongModel;

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

    public static List<PhanCongModel> timTatCaPhanCong() throws ClassNotFoundException {
        List<PhanCongModel> dsPhanCong = new ArrayList<>();
        String sql = """
                     SELECT DISTINCT PhanCong.MaCoVan, HoTen, TenLop, NamHoc FROM PhanCong, CoVan
                     WHERE PhanCong.MaCoVan=CoVan.MaCoVan
                     AND PhanCong.TrangThaiXoa=0
                     AND CoVan.TrangThaiXoa=0
                     """;
        try (Connection connection = ConnectDB.getConnection(); Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                PhanCongModel drl = new PhanCongModel(
                        resultSet.getString("MaCoVan"),
                        resultSet.getString("HoTen"),
                        resultSet.getString("TenLop"),
                        resultSet.getString("NamHoc"));
                dsPhanCong.add(drl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPhanCong;
    }
}
