package models;

public class PhanCongModel {

    private String maCoVan, tenCoVan, maLop, namHoc;
    private int maNamHoc, maPhanCong, trangThaiHienThi;

    public PhanCongModel(String maCoVan, String maLop, int maNamHoc, int trangThaiHienThi) {
        this.maCoVan = maCoVan;
        this.maLop = maLop;
        this.maNamHoc = maNamHoc;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public PhanCongModel(int maPhanCong, String maCoVan, String tenCoVan, String maLop, String namHoc, int trangThaiHienThi) {
        this.maPhanCong = maPhanCong;
        this.maCoVan = maCoVan;
        this.tenCoVan = tenCoVan;
        this.namHoc = namHoc;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public PhanCongModel(String maCoVan, String maLop, int maNamHoc, int maPhanCong, int trangThaiHienThi) {
        this.maCoVan = maCoVan;
        this.maLop = maLop;
        this.maNamHoc = maNamHoc;
        this.maPhanCong = maPhanCong;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public int getMaPhanCong() {
        return maPhanCong;
    }

    public void setMaPhanCong(int maPhanCong) {
        this.maPhanCong = maPhanCong;
    }

    public String getMaCoVan() {
        return maCoVan;
    }

    public void setMaCoVan(String maCovan) {
        this.maCoVan = maCovan;
    }

    public String getTenCoVan() {
        return tenCoVan;
    }

    public void setTenCoVan(String tenCoVan) {
        this.tenCoVan = tenCoVan;
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

    public int getTrangThaiHienThi() {
        return trangThaiHienThi;
    }

    public void setTrangThaiHienThi(int trangThaiHienThi) {
        this.trangThaiHienThi = trangThaiHienThi;
    }

}
