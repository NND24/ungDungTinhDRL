package models;

import java.sql.Date;

public class QuanLyModel {

    private String maQuanLy, idTaiKhoan, hoTen, email, gioiTinh, soDienThoai, canCuoc, queQuan;
    private int daNghi;
    private Date ngaySinh;

    public QuanLyModel(String maQuanLy, String idTaiKhoan, String hoTen, String email, String gioiTinh, String soDienThoai, String canCuoc, String queQuan, Date ngaySinh, int daNghi) {
        this.maQuanLy = maQuanLy;
        this.idTaiKhoan = idTaiKhoan;
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.daNghi = daNghi;
    }

    public QuanLyModel(String maQuanLy, String hoTen, String email, String gioiTinh, String soDienThoai, String canCuoc, String queQuan, Date ngaySinh, int daNghi) {
        this.maQuanLy = maQuanLy;
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.daNghi = daNghi;
    }

    public String getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(String maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCanCuoc() {
        return canCuoc;
    }

    public void setCanCuoc(String canCuoc) {
        this.canCuoc = canCuoc;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getDaNghi() {
        return daNghi;
    }

    public void setDaNghi(int daNghi) {
        this.daNghi = daNghi;
    }

}
