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
        String sql = "INSERT INTO TaiKhoan (IdTaiKhoan, MatKhau, MaChucVu) VALUES (?, ?, ?)";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tk.getIdTaiKhoan());
            String hashedPassword = PasswordHashing.hashPassword(tk.getMatKhau());
            statement.setString(2, hashedPassword);
            statement.setString(3, tk.getMaChucVu());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String layIdTaiKhoan(String maTaiKhoan) throws ClassNotFoundException {
        String idTaiKhoan = "";
        try (Connection connection = ConnectDB.getConnection()) {
            String sql = """
                         SELECT MaTaiKhoan, IdTaiKhoan FROM
                         (SELECT SinhVien.MaSinhVien AS MaTaiKhoan, SinhVien.IdTaiKhoan FROM TaiKhoan
                         JOIN SinhVien ON TaiKhoan.IdTaiKhoan = SinhVien.IdTaiKhoan
                         WHERE TaiKhoan.TrangThaiXoa=0 AND SinhVien.TrangThaiXoa=0
                         UNION
                         SELECT CoVan.MaCoVan AS MaTaiKhoan, CoVan.IdTaiKhoan FROM TaiKhoan
                         JOIN CoVan ON TaiKhoan.IdTaiKhoan = CoVan.IdTaiKhoan
                         WHERE TaiKhoan.TrangThaiXoa=0 AND CoVan.TrangThaiXoa=0
                         UNION
                         SELECT QuanLy.MaQuanLy AS MaTaiKhoan, QuanLy.IdTaiKhoan FROM TaiKhoan
                         JOIN QuanLy ON TaiKhoan.IdTaiKhoan = QuanLy.IdTaiKhoan
                         WHERE TaiKhoan.TrangThaiXoa=0 AND QuanLy.TrangThaiXoa=0) TK
                         WHERE MaTaiKhoan=?
                         """;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, maTaiKhoan);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    idTaiKhoan = resultSet.getString("MaChucVu");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idTaiKhoan;
    }

    public static String dangNhap(String maTaiKhoan, String matKhau) throws ClassNotFoundException {
        String maChucVu = "";
        try (Connection connection = ConnectDB.getConnection()) {
            String sql = """
                         SELECT MatKhau, MaChucVu FROM
                         (SELECT SinhVien.MaSinhVien AS MaTaiKhoan, MatKhau, MaChucVu FROM TaiKhoan
                         JOIN SinhVien ON TaiKhoan.IdTaiKhoan = SinhVien.IdTaiKhoan
                         WHERE TaiKhoan.TrangThaiXoa=0 AND SinhVien.TrangThaiXoa=0
                         UNION
                         SELECT CoVan.MaCoVan AS MaTaiKhoan, MatKhau, MaChucVu FROM TaiKhoan
                         JOIN CoVan ON TaiKhoan.IdTaiKhoan = CoVan.IdTaiKhoan
                         WHERE TaiKhoan.TrangThaiXoa=0 AND CoVan.TrangThaiXoa=0
                         UNION
                         SELECT QuanLy.MaQuanLy AS MaTaiKhoan, MatKhau, MaChucVu FROM TaiKhoan
                         JOIN QuanLy ON TaiKhoan.IdTaiKhoan = QuanLy.IdTaiKhoan
                         WHERE TaiKhoan.TrangThaiXoa=0 AND QuanLy.TrangThaiXoa=0) TK
                         WHERE MaTaiKhoan=?
                         """;
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
        String sql = """
                     SELECT * FROM
                     (SELECT SinhVien.MaSinhVien AS MaTaiKhoan FROM TaiKhoan
                     JOIN SinhVien ON TaiKhoan.IdTaiKhoan = SinhVien.IdTaiKhoan
                     WHERE TaiKhoan.TrangThaiXoa=0 AND SinhVien.TrangThaiXoa=0
                     UNION
                     SELECT CoVan.MaCoVan AS MaTaiKhoan FROM TaiKhoan
                     JOIN CoVan ON TaiKhoan.IdTaiKhoan = CoVan.IdTaiKhoan
                     WHERE TaiKhoan.TrangThaiXoa=0 AND CoVan.TrangThaiXoa=0
                     UNION
                     SELECT QuanLy.MaQuanLy AS MaTaiKhoan FROM TaiKhoan
                     JOIN QuanLy ON TaiKhoan.IdTaiKhoan = QuanLy.IdTaiKhoan
                     WHERE TaiKhoan.TrangThaiXoa=0 AND QuanLy.TrangThaiXoa=0) TK
                     WHERE TK.MaTaiKhoan = ?
                     """;
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

    public static boolean kiemTraEmailCoDungTaiKhoan(String email, String maTaiKhoan) throws ClassNotFoundException {
        boolean flag = false;
        String sql = """
                     SELECT Email, MaTaiKhoan FROM
                     (SELECT SinhVien.Email AS Email, SinhVien.MaSinhVien AS MaTaiKhoan FROM TaiKhoan
                     JOIN SinhVien ON TaiKhoan.IdTaiKhoan = SinhVien.IdTaiKhoan
                     WHERE TaiKhoan.TrangThaiXoa=0 AND SinhVien.TrangThaiXoa=0
                     UNION
                     SELECT CoVan.Email AS Email, CoVan.MaCoVan AS MaTaiKhoan FROM TaiKhoan
                     JOIN CoVan ON TaiKhoan.IdTaiKhoan = CoVan.IdTaiKhoan
                     WHERE TaiKhoan.TrangThaiXoa=0 AND CoVan.TrangThaiXoa=0
                     UNION
                     SELECT QuanLy.Email AS Email, QuanLy.MaQuanLy AS MaTaiKhoan FROM TaiKhoan
                     JOIN QuanLy ON TaiKhoan.IdTaiKhoan = QuanLy.IdTaiKhoan
                     WHERE TaiKhoan.TrangThaiXoa=0 AND QuanLy.TrangThaiXoa=0) TK
                     WHERE Email=? AND MaTaiKhoan=?
                     """;
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

    public static void doiMatKhau(String idTaiKhoan, String newPassword) throws ClassNotFoundException {
        String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE IdTaiKhoan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            String hashedPassword = PasswordHashing.hashPassword(newPassword);
            statement.setString(1, hashedPassword);
            statement.setString(2, idTaiKhoan);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void xoaTaiKhoan(String idTaiKhoan) {
        String sql = "UPDATE TaiKhoan SET TrangThaiXoa='1' WHERE IdTaiKhoan=?";
        try (Connection connection = ConnectDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idTaiKhoan);

            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TaiKhoanCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
