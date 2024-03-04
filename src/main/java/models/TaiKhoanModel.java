package models;

public class TaiKhoanModel {

    private String idTaiKhoan, matKhau, maChucVu, tenChucVu;

    public TaiKhoanModel() {
    }

    public TaiKhoanModel(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public TaiKhoanModel(String idTaiKhoan, String matKhau, String maChucVu) {
        this.idTaiKhoan = idTaiKhoan;
        this.matKhau = matKhau;
        this.maChucVu = maChucVu;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
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

}
