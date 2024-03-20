package models;

import java.sql.Date;

public class PhieuDRLModel {

    private String maPhieuDRL, maSinhVien, maLop, namHoc;
    private int maNamHoc, hocKy;
    private Date ngayBatDau, ngayKetThuc;

    public PhieuDRLModel(String maPhieuDRL, Date ngayBatDau, Date ngayKetThuc) {
        this.maPhieuDRL = maPhieuDRL;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public PhieuDRLModel(String maLop, String namHoc, int hocKy, Date ngayBatDau, Date ngayKetThuc) {
        this.maLop = maLop;
        this.namHoc = namHoc;
        this.hocKy = hocKy;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public PhieuDRLModel(String maPhieuDRL, String maSinhVien, int maNamHoc, int hocKy, Date ngayBatDau, Date ngayKetThuc) {
        this.maPhieuDRL = maPhieuDRL;
        this.maSinhVien = maSinhVien;
        this.maNamHoc = maNamHoc;
        this.hocKy = hocKy;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public PhieuDRLModel(String maPhieuDRL) {
        this.maPhieuDRL = maPhieuDRL;
    }

    public String getMaPhieuDRL() {
        return maPhieuDRL;
    }

    public void setMaPhieuDRL(String maPhieuDRL) {
        this.maPhieuDRL = maPhieuDRL;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public int getMaNamHoc() {
        return maNamHoc;
    }

    public void setMaNamHoc(int maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
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

}
