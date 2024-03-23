package models;

public class KhoaTestModel {

    private String maKhoa, tenKhoa;
    private int trangThaiHienThi;

    public KhoaTestModel(String maKhoa, String tenKhoa, int trangThaiHienThi) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public KhoaTestModel(String tenKhoa, int trangThaiHienThi) {
        this.tenKhoa = tenKhoa;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public int getTrangThaiHienThi() {
        return trangThaiHienThi;
    }

    public void setTrangThaiHienThi(int trangThaiHienThi) {
        this.trangThaiHienThi = trangThaiHienThi;
    }

}
