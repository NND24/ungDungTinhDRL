package models;

public class LopModel {

    private String maLop, maNganh, tenNganh, khoa;
    private int trangThaiHienThi;

    public LopModel(String maLop) {
        this.maLop = maLop;
    }

    public LopModel(String maLop, String maNganh, String tenNganh, String khoa, int trangThaiHienThi) {
        this.maLop = maLop;
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.khoa = khoa;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public int getTrangThaiHienThi() {
        return trangThaiHienThi;
    }

    public void setTrangThaiHienThi(int trangThaiHienThi) {
        this.trangThaiHienThi = trangThaiHienThi;
    }

}
