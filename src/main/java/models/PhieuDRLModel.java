package models;

import java.sql.Date;

public class PhieuDRLModel {

    private String maPhieuDRL, maNguoiCham, maSinhVien, tenSinhVien, maBanCanSuCham, tenBanCanSu, maCoVanCham, tenCoVan, maLop, namHoc, trangThaiCham;
    private int maNamHoc, hocKy;
    private Date ngayBatDau, ngayKetThuc;

    public PhieuDRLModel(String maPhieuDRL, String trangThaiCham) {
        this.maPhieuDRL = maPhieuDRL;
        this.trangThaiCham = trangThaiCham;
    }

    public PhieuDRLModel(String maPhieuDRL, Date ngayBatDau, Date ngayKetThuc) {
        this.maPhieuDRL = maPhieuDRL;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public PhieuDRLModel(String maPhieuDRL, String maNguoiCham, String trangThaiCham) {
        this.maPhieuDRL = maPhieuDRL;
        this.maNguoiCham = maNguoiCham;
        this.trangThaiCham = trangThaiCham;
    }

    public PhieuDRLModel(String maLop, String namHoc, int hocKy, Date ngayBatDau, Date ngayKetThuc) {
        this.maLop = maLop;
        this.namHoc = namHoc;
        this.hocKy = hocKy;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public PhieuDRLModel(String maPhieuDRL, String maSinhVien, int maNamHoc, int hocKy, String trangThaiCham, Date ngayBatDau, Date ngayKetThuc) {
        this.maPhieuDRL = maPhieuDRL;
        this.maSinhVien = maSinhVien;
        this.maNamHoc = maNamHoc;
        this.hocKy = hocKy;
        this.trangThaiCham = trangThaiCham;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public PhieuDRLModel(String maSinhVien, String tenSinhVien, String maBanCanSuCham, String tenBanCanSu, String maCoVanCham, String tenCoVan, String maLop, String trangThaiCham) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.maBanCanSuCham = maBanCanSuCham;
        this.tenBanCanSu = tenBanCanSu;
        this.maCoVanCham = maCoVanCham;
        this.tenCoVan = tenCoVan;
        this.maLop = maLop;
        this.trangThaiCham = trangThaiCham;
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

    public String getMaBanCanSuCham() {
        return maBanCanSuCham;
    }

    public void setMaBanCanSuCham(String maBanCanSuCham) {
        this.maBanCanSuCham = maBanCanSuCham;
    }

    public String getMaCoVanCham() {
        return maCoVanCham;
    }

    public void setMaCoVanCham(String maCoVanCham) {
        this.maCoVanCham = maCoVanCham;
    }

    public String getTrangThaiCham() {
        return trangThaiCham;
    }

    public void setTrangThaiCham(String trangThaiCham) {
        this.trangThaiCham = trangThaiCham;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getTenBanCanSu() {
        return tenBanCanSu;
    }

    public void setTenBanCanSu(String tenBanCanSu) {
        this.tenBanCanSu = tenBanCanSu;
    }

    public String getTenCoVan() {
        return tenCoVan;
    }

    public void setTenCoVan(String tenCoVan) {
        this.tenCoVan = tenCoVan;
    }

    public String getMaNguoiCham() {
        return maNguoiCham;
    }

    public void setMaNguoiCham(String maNguoiCham) {
        this.maNguoiCham = maNguoiCham;
    }

}
