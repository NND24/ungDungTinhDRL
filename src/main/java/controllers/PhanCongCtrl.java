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
        String sql = "SELECT TenLop FROM PhanCong, Lop WHERE PhanCong.MaLop=Lop.MaLop AND maCoVan = ?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maCoVan);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String drl = resultSet.getString("TenLop");
                dsDiemRenLuyen.add(drl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienCtrlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDiemRenLuyen;
    }

    public static List<PhanCongModel> timTatCaPhanCong() throws ClassNotFoundException {
        List<PhanCongModel> dsPhanCong = new ArrayList<>();
        String sql = """
                     SELECT DISTINCT PhanCong.MaCoVan, HoTen, TenLop, NamHoc FROM PhanCong, CoVan, Lop, NamHoc
                     WHERE PhanCong.MaCoVan=CoVan.MaCoVan AND PhanCong.MaLop=Lop.MaLop
                     AND PhanCong.MaNamHoc=NamHoc.MaNamHoc AND PhanCong.TrangThaiHienThi=1
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
