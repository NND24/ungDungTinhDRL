package models;

public class LopModelTest {

    String maLop, nganh, khoa, trangThaiHienThi;

    public LopModelTest(String maLop) {
        this.maLop = maLop;
    }

    public LopModelTest(String maLop, String nganh, String khoa, String trangThaiHienThi) {
        this.maLop = maLop;
        this.nganh = nganh;
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
