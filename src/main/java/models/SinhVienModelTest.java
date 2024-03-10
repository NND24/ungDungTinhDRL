package models;

import java.sql.Date;

public class SinhVienModelTest extends TaiKhoanModel {

    private String maSinhVien, tenLop, hoTen, chucVu, email, matKhau, gioiTinh, soDienThoai, canCuoc, queQuan;
    private Date ngaySinh;

    public SinhVienModelTest() {
        super();
    }

    public SinhVienModelTest(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public SinhVienModelTest(String maSinhVien, String chucVu, String email, String matKhau) {
        this.maSinhVien = maSinhVien;
        this.chucVu = chucVu;
        this.email = email;
        this.matKhau = matKhau;
    }

    public SinhVienModelTest(String maSinhVien, String tenLop, String hoTen, String gioiTinh, String soDienThoai, String canCuoc, String queQuan, Date ngaySinh, String maTaiKhoan) {
        super(maTaiKhoan);
        this.maSinhVien = maSinhVien;
        this.tenLop = tenLop;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
    }

    public SinhVienModelTest(String maSinhVien, String tenLop, String hoTen, String chucVu, String email, String matKhau, String gioiTinh, Date ngaySinh, String soDienThoai, String canCuoc, String queQuan) {
        this.maSinhVien = maSinhVien;
        this.tenLop = tenLop;
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

    public SinhVienModelTest(String maSinhVien, String tenLop, String hoTen, String email, String gioiTinh, Date ngaySinh, String soDienThoai, String canCuoc, String queQuan) {
        this.maSinhVien = maSinhVien;
        this.tenLop = tenLop;
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.canCuoc = canCuoc;
        this.queQuan = queQuan;
    }

    public SinhVienModelTest(String maSinhVien, String tenLop, String hoTen, Date ngaySinh) {
        this.maSinhVien = maSinhVien;
        this.tenLop = tenLop;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    public SinhVienModelTest(String maSinhVien, String hoTen) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
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

}
