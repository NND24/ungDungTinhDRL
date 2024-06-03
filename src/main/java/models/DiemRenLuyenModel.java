package models;

import java.sql.Date;

public class DiemRenLuyenModel extends SinhVienModel {

    private String maPhieuDRL, hocKy, namHoc, nguoiCham, maNguoiCham, xepLoai, trangThaiCham;
    private float tongDiem;
    private int d11, d12, d13;
    private float d14;
    private int d15;
    private float d1;
    private int d21, d22, d23, d2, d31, d32, d33, d34;
    private int d35, d3, d41, d42, d43, d44, d45, d46, d4, d51, d52, d53, d5;
    private Date ngayBatDau, ngayKetThuc;

    public DiemRenLuyenModel() {
    }

    public DiemRenLuyenModel(String hocKy, String namHoc, String nguoiCham, String xepLoai, String trangThaiCham, float tongDiem, int d11, int d12, int d13, float d14, int d15, float d1, int d21, int d22, int d23, int d2, int d31, int d32, int d33, int d34, int d35, int d3, int d41, int d42, int d43, int d44, int d45, int d46, int d4, int d51, int d52, int d53, int d5, String maSinhVien, String tenLop, String hoTen, Date ngaySinh, Date ngayKetThuc) {
        super(maSinhVien, tenLop, hoTen, ngaySinh);
        this.hocKy = hocKy;
        this.namHoc = namHoc;
        this.nguoiCham = nguoiCham;
        this.xepLoai = xepLoai;
        this.trangThaiCham = trangThaiCham;
        this.tongDiem = tongDiem;
        this.d11 = d11;
        this.d12 = d12;
        this.d13 = d13;
        this.d14 = d14;
        this.d15 = d15;
        this.d1 = d1;
        this.d21 = d21;
        this.d22 = d22;
        this.d23 = d23;
        this.d2 = d2;
        this.d31 = d31;
        this.d32 = d32;
        this.d33 = d33;
        this.d34 = d34;
        this.d35 = d35;
        this.d3 = d3;
        this.d41 = d41;
        this.d42 = d42;
        this.d43 = d43;
        this.d44 = d44;
        this.d45 = d45;
        this.d46 = d46;
        this.d4 = d4;
        this.d51 = d51;
        this.d52 = d52;
        this.d53 = d53;
        this.d5 = d5;
        this.ngayKetThuc = ngayKetThuc;
    }

    public DiemRenLuyenModel(String hocKy, String namHoc, String xepLoai, String trangThaiCham, float tongDiem, float d1, int d2, int d3, int d4, int d5, String maSinhVien, String hoTen) {
        super(maSinhVien, hoTen);
        this.hocKy = hocKy;
        this.namHoc = namHoc;
        this.xepLoai = xepLoai;
        this.trangThaiCham = trangThaiCham;
        this.tongDiem = tongDiem;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
    }

    public DiemRenLuyenModel(String hocKy, String namHoc, String xepLoai, String trangThaiCham, float tongDiem, float d1, int d2, int d3, int d4, int d5, String maSinhVien, String hoTen, Date ngayBatDau, Date ngayKetThuc) {
        super(maSinhVien, hoTen);
        this.hocKy = hocKy;
        this.namHoc = namHoc;
        this.xepLoai = xepLoai;
        this.trangThaiCham = trangThaiCham;
        this.tongDiem = tongDiem;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public DiemRenLuyenModel(String maPhieuDRL, String nguoiCham, String xepLoai, float tongDiem, int d11, int d12, int d13, float d14, int d15, float d1, int d21, int d22, int d23, int d2, int d31, int d32, int d33, int d34, int d35, int d3, int d41, int d42, int d43, int d44, int d45, int d46, int d4, int d51, int d52, int d53, int d5) {
        super();
        this.maPhieuDRL = maPhieuDRL;
        this.nguoiCham = nguoiCham;
        this.xepLoai = xepLoai;
        this.tongDiem = tongDiem;
        this.d11 = d11;
        this.d12 = d12;
        this.d13 = d13;
        this.d14 = d14;
        this.d15 = d15;
        this.d1 = d1;
        this.d21 = d21;
        this.d22 = d22;
        this.d23 = d23;
        this.d2 = d2;
        this.d31 = d31;
        this.d32 = d32;
        this.d33 = d33;
        this.d34 = d34;
        this.d35 = d35;
        this.d3 = d3;
        this.d41 = d41;
        this.d42 = d42;
        this.d43 = d43;
        this.d44 = d44;
        this.d45 = d45;
        this.d46 = d46;
        this.d4 = d4;
        this.d51 = d51;
        this.d52 = d52;
        this.d53 = d53;
        this.d5 = d5;
    }

    public DiemRenLuyenModel(String maPhieuDRL, String nguoiCham, String xepLoai, String trangThaiCham, float tongDiem, int d11, int d12, int d13, float d14, int d15, float d1, int d21, int d22, int d23, int d2, int d31, int d32, int d33, int d34, int d35, int d3, int d41, int d42, int d43, int d44, int d45, int d46, int d4, int d51, int d52, int d53, int d5) {
        super();
        this.maPhieuDRL = maPhieuDRL;
        this.nguoiCham = nguoiCham;
        this.xepLoai = xepLoai;
        this.trangThaiCham = trangThaiCham;
        this.tongDiem = tongDiem;
        this.d11 = d11;
        this.d12 = d12;
        this.d13 = d13;
        this.d14 = d14;
        this.d15 = d15;
        this.d1 = d1;
        this.d21 = d21;
        this.d22 = d22;
        this.d23 = d23;
        this.d2 = d2;
        this.d31 = d31;
        this.d32 = d32;
        this.d33 = d33;
        this.d34 = d34;
        this.d35 = d35;
        this.d3 = d3;
        this.d41 = d41;
        this.d42 = d42;
        this.d43 = d43;
        this.d44 = d44;
        this.d45 = d45;
        this.d46 = d46;
        this.d4 = d4;
        this.d51 = d51;
        this.d52 = d52;
        this.d53 = d53;
        this.d5 = d5;
    }

    public String getMaPhieuDRL() {
        return maPhieuDRL;
    }

    public void setMaPhieuDRL(String maPhieuDRL) {
        this.maPhieuDRL = maPhieuDRL;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getNguoiCham() {
        return nguoiCham;
    }

    public void setNguoiCham(String nguoiCham) {
        this.nguoiCham = nguoiCham;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    public String getTrangThaiCham() {
        return trangThaiCham;
    }

    public void setTrangThaiCham(String trangThaiCham) {
        this.trangThaiCham = trangThaiCham;
    }

    public float getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(float tongDiem) {
        this.tongDiem = tongDiem;
    }

    public int getD11() {
        return d11;
    }

    public void setD11(int d11) {
        this.d11 = d11;
    }

    public int getD12() {
        return d12;
    }

    public void setD12(int d12) {
        this.d12 = d12;
    }

    public int getD13() {
        return d13;
    }

    public void setD13(int d13) {
        this.d13 = d13;
    }

    public float getD14() {
        return d14;
    }

    public void setD14(float d14) {
        this.d14 = d14;
    }

    public int getD15() {
        return d15;
    }

    public void setD15(int d15) {
        this.d15 = d15;
    }

    public float getD1() {
        return d1;
    }

    public void setD1(float d1) {
        this.d1 = d1;
    }

    public int getD21() {
        return d21;
    }

    public void setD21(int d21) {
        this.d21 = d21;
    }

    public int getD22() {
        return d22;
    }

    public void setD22a(int d22) {
        this.d22 = d22;
    }

    public int getD23() {
        return d23;
    }

    public void setD23a(int d23) {
        this.d23 = d23;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public int getD31() {
        return d31;
    }

    public void setD31(int d31) {
        this.d31 = d31;
    }

    public int getD32() {
        return d32;
    }

    public void setD32(int d32) {
        this.d32 = d32;
    }

    public int getD33() {
        return d33;
    }

    public void setD33(int d33) {
        this.d33 = d33;
    }

    public int getD34() {
        return d34;
    }

    public void setD34(int d34) {
        this.d34 = d34;
    }

    public int getD35() {
        return d35;
    }

    public void setD35(int d35) {
        this.d35 = d35;
    }

    public int getD3() {
        return d3;
    }

    public void setD3(int d3) {
        this.d3 = d3;
    }

    public int getD41() {
        return d41;
    }

    public void setD41(int d41) {
        this.d41 = d41;
    }

    public int getD42() {
        return d42;
    }

    public void setD42(int d42) {
        this.d42 = d42;
    }

    public int getD43() {
        return d43;
    }

    public void setD43(int d43) {
        this.d43 = d43;
    }

    public int getD44() {
        return d44;
    }

    public void setD44(int d44) {
        this.d44 = d44;
    }

    public int getD45() {
        return d45;
    }

    public void setD45(int d45) {
        this.d45 = d45;
    }

    public int getD46() {
        return d46;
    }

    public void setD46(int d46) {
        this.d46 = d46;
    }

    public int getD4() {
        return d4;
    }

    public void setD4(int d4) {
        this.d4 = d4;
    }

    public int getD51() {
        return d51;
    }

    public void setD51(int d51) {
        this.d51 = d51;
    }

    public int getD52() {
        return d52;
    }

    public void setD52(int d52) {
        this.d52 = d52;
    }

    public int getD53() {
        return d53;
    }

    public void setD53(int d53) {
        this.d53 = d53;
    }

    public int getD5() {
        return d5;
    }

    public void setD5(int d5) {
        this.d5 = d5;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaNguoiCham() {
        return maNguoiCham;
    }

    public void setMaNguoiCham(String maNguoiCham) {
        this.maNguoiCham = maNguoiCham;
    }

}
