package models;

import java.sql.Date;

public class SinhVienModel extends TaiKhoanModel {

    private String maSinhVien, maTaiKhoan, maLop, hoTen, chucVu, email, matKhau, gioiTinh, soDienThoai, canCuoc, queQuan, daNghiHoc;
    private Date ngaySinh;

    public SinhVienModel() {
        super();
    }

    public SinhVienModel(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public SinhVienModel(String maSinhVien, String chucVu, String email, String matKhau) {
        this.maSinhVien = maSinhVien;
        this.chucVu = chucVu;
        this.email = email;
        this.matKhau = matKhau;
    }

    public SinhVienModel(String maSinhVien, String maLop, String hoTen, String chucVu, String gioiTinh, String soDienThoai, String canCuoc, String queQuan, String daNghiHoc, Date ngaySinh) {
        this.maSinhVien = maSinhVien;
        this.maLop = maLop;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.daNghiHoc = daNghiHoc;
        this.ngaySinh = ngaySinh;
    }

    public SinhVienModel(String maSinhVien, String maLop, String email, String hoTen, String gioiTinh, String soDienThoai, String canCuoc, String queQuan, Date ngaySinh, String daNghiHoc, String maTaiKhoan) {
        super(maTaiKhoan);
        this.maSinhVien = maSinhVien;
        this.maLop = maLop;
        this.email = email;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.daNghiHoc = daNghiHoc;
        this.ngaySinh = ngaySinh;
    }

    public SinhVienModel(String maSinhVien, String maLop, String hoTen, String chucVu, String email, String matKhau, String gioiTinh, Date ngaySinh, String soDienThoai, String canCuoc, String queQuan) {
        this.maSinhVien = maSinhVien;
        this.maLop = maLop;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.email = email;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
    }

    public SinhVienModel(String maSinhVien, String maTaiKhoan, String maLop, String hoTen, String email, String gioiTinh, Date ngaySinh, String soDienThoai, String canCuoc, String queQuan, String daNghiHoc) {
        this.maSinhVien = maSinhVien;
        this.maTaiKhoan = maTaiKhoan;
        this.maLop = maLop;
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.daNghiHoc = daNghiHoc;
    }

    public SinhVienModel(String maSinhVien, String maLop, String hoTen, Date ngaySinh) {
        this.maSinhVien = maSinhVien;
        this.maLop = maLop;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    public SinhVienModel(String maSinhVien, String maLop, String hoTen, String chucVu, String email, String gioiTinh, String soDienThoai, String canCuoc, String queQuan, String daNghiHoc, Date ngaySinh) {
        this.maSinhVien = maSinhVien;
        this.maLop = maLop;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.daNghiHoc = daNghiHoc;
        this.ngaySinh = ngaySinh;
    }

    public SinhVienModel(String maSinhVien, String hoTen) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
    }

    public String getDaNghiHoc() {
        return daNghiHoc;
    }

    public void setDaNghiHoc(String daNghiHoc) {
        this.daNghiHoc = daNghiHoc;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

}
