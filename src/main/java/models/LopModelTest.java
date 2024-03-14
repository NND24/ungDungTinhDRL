package models;

public class LopModelTest {

    String maLop, nganh, tenLop, khoa, trangThaiHienThi;

    public LopModelTest(String maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public LopModelTest(String maLop, String nganh, String tenLop, String khoa, String trangThaiHienThi) {
        this.maLop = maLop;
        this.nganh = nganh;
        this.tenLop = tenLop;
        this.khoa = khoa;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getTrangThaiHienThi() {
        return trangThaiHienThi;
    }

    public void setTrangThaiHienThi(String trangThaiHienThi) {
        this.trangThaiHienThi = trangThaiHienThi;
    }

}
