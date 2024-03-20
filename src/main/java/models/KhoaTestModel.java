package models;

public class KhoaTestModel {

    private int maKhoa;
    private String tenKhoa;
    private int trangThaiHienThi;

    public KhoaTestModel(int maKhoa, String tenKhoa, int trangThaiHienThi) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public KhoaTestModel(String tenKhoa, int trangThaiHienThi) {
        this.tenKhoa = tenKhoa;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(int maKhoa) {
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
