package models;

public class PhanCongModel {

    String maCovan, tenCoVan, tenLop, namHoc;

    public PhanCongModel(String maCovan, String tenCoVan, String tenLop, String namHoc) {
        this.maCovan = maCovan;
        this.tenCoVan = tenCoVan;
        this.tenLop = tenLop;
        this.namHoc = namHoc;
    }

    public String getTenCoVan() {
        return tenCoVan;
    }

    public void setTenCoVan(String tenCoVan) {
        this.tenCoVan = tenCoVan;
    }

    public String getMaCovan() {
        return maCovan;
    }

    public void setMaCovan(String maCovan) {
        this.maCovan = maCovan;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

}
