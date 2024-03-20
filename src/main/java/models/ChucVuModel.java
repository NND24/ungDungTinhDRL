package models;

public class ChucVuModel {

    private String maChucVu, tenChucVu;
    private int trangThaiHienThi;

    public ChucVuModel(String maChucVu, String tenChucVu, int trangThaiHienThi) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public int getTrangThaiHienThi() {
        return trangThaiHienThi;
    }

    public void setTrangThaiHienThi(int trangThaiHienThi) {
        this.trangThaiHienThi = trangThaiHienThi;
    }

}
