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
        String sql = "INSERT INTO TaiKhoan (MaTaiKhoan, TenDangNhap, MatKhau, MaChucVu) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tk.getMaTaiKhoan());
            statement.setString(2, tk.getTenDangNhap());
            String hashedPassword = PasswordHashing.hashPassword(tk.getMatKhau());
            statement.setString(3, hashedPassword);
            statement.setString(4, tk.getMaChucVu());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String layMaTaiKhoan(String tenDangNhap) throws ClassNotFoundException {
        String idTaiKhoan = "";
        try (Connection connection = ConnectDB.getConnection()) {
            String sql = """
                         SELECT MaTaiKhoan FROM TaiKhoan WHERE TenDangNhap=?
                         """;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, tenDangNhap);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    idTaiKhoan = resultSet.getString("MaTaiKhoan");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idTaiKhoan;
    }

    public static String dangNhap(String tenDangNhap, String matKhau) throws ClassNotFoundException {
        String maChucVu = "";
        try (Connection connection = ConnectDB.getConnection()) {
            String sql = """
                         SELECT MaChucVu, MatKhau FROM TaiKhoan WHERE TenDangNhap=?
                         """;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, tenDangNhap);

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

    public static boolean kiemTraTaiKhoanCoTonTai(String tenDangNhap) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT MaTaiKhoan FROM TaiKhoan WHERE TenDangNhap=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tenDangNhap);
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
        String sql = """
                     SELECT Email FROM
                     (SELECT SinhVien.Email AS Email FROM TaiKhoan
                     JOIN SinhVien ON TaiKhoan.IdTaiKhoan = SinhVien.IdTaiKhoan
                     WHERE TaiKhoan.TrangThaiXoa=0 AND SinhVien.TrangThaiXoa=0
                     UNION
                     SELECT CoVan.Email AS Email FROM TaiKhoan
                     JOIN CoVan ON TaiKhoan.IdTaiKhoan = CoVan.IdTaiKhoan
                     WHERE TaiKhoan.TrangThaiXoa=0 AND CoVan.TrangThaiXoa=0
                     UNION
                     SELECT QuanLy.Email AS Email FROM TaiKhoan
                     JOIN QuanLy ON TaiKhoan.IdTaiKhoan = QuanLy.IdTaiKhoan
                     WHERE TaiKhoan.TrangThaiXoa=0 AND QuanLy.TrangThaiXoa=0) TK
                     WHERE Email=?
                     """;
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

    public static boolean kiemTraEmailCoDungTaiKhoan(String email, String tenDangNhap) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT Email, TenDangNhap FROM
                     (SELECT SinhVien.Email AS Email, TenDangNhap FROM TaiKhoan
                     JOIN SinhVien ON TaiKhoan.MaTaiKhoan = SinhVien.MaTaiKhoan
                     UNION
                     SELECT CoVan.Email AS Email, TenDangNhap FROM TaiKhoan
                     JOIN CoVan ON TaiKhoan.MaTaiKhoan = CoVan.MaTaiKhoan
                     UNION
                     SELECT QuanLy.Email AS Email, TenDangNhap FROM TaiKhoan
                     JOIN QuanLy ON TaiKhoan.MaTaiKhoan = QuanLy.MaTaiKhoan) TK
                     WHERE Email=? AND TenDangNhap=?
                     """;
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, tenDangNhap);
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
        String sql = "DELETE FROM TaiKhoan WHERE MaTaiKhoan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, maTaiKhoan);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
