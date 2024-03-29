package models;

import java.sql.Date;

public class CoVanModel {

    private String maCoVan, maTaiKhoan, tenKhoa, hoTen, email, soDienThoai, canCuoc, queQuan, hocVi, hocHam, chuyenMon, maKhoa;
    private int gioiTinh, daNghi;
    private Date ngaySinh;

    public CoVanModel(String maCoVan, String hoTen, String email, String soDienThoai, String canCuoc, String queQuan, String hocVi, String hocHam, String chuyenMon, String maKhoa, int gioiTinh, Date ngaySinh, int daNghi) {
        this.maCoVan = maCoVan;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.hocVi = hocVi;
        this.hocHam = hocHam;
        this.chuyenMon = chuyenMon;
        this.maKhoa = maKhoa;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.daNghi = daNghi;
    }

    public CoVanModel(String maCoVan, String hoTen, String email, String soDienThoai, String canCuoc, String queQuan, String hocVi, String hocHam, String chuyenMon, String maKhoa, int gioiTinh, Date ngaySinh) {
        this.maCoVan = maCoVan;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.hocVi = hocVi;
        this.hocHam = hocHam;
        this.chuyenMon = chuyenMon;
        this.maKhoa = maKhoa;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    public CoVanModel(String maCoVan, String maTaiKhoan, String tenKhoa, String hoTen, String email, String soDienThoai, String canCuoc, String queQuan, String hocVi, String hocHam, String chuyenMon, String maKhoa, int gioiTinh, Date ngaySinh, int daNghi) {
        this.maCoVan = maCoVan;
        this.maTaiKhoan = maTaiKhoan;
        this.tenKhoa = tenKhoa;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.hocVi = hocVi;
        this.hocHam = hocHam;
        this.chuyenMon = chuyenMon;
        this.maKhoa = maKhoa;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.daNghi = daNghi;
    }

    public CoVanModel(String maCoVan, String tenKhoa, String hoTen, String email, String soDienThoai, String canCuoc, String queQuan, String hocVi, String hocHam, String chuyenMon, String maKhoa, int gioiTinh, Date ngaySinh, int daNghi) {
        this.maCoVan = maCoVan;
        this.tenKhoa = tenKhoa;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.hocVi = hocVi;
        this.hocHam = hocHam;
        this.chuyenMon = chuyenMon;
        this.maKhoa = maKhoa;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.daNghi = daNghi;
    }

    public String getMaCoVan() {
        return maCoVan;
    }

    public void setMaCoVan(String maCoVan) {
        this.maCoVan = maCoVan;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
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

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
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
