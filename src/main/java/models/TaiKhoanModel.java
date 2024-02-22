package models;

public class TaiKhoanModel {

    private String maTaiKhoan, email, matKhau, maChucVu, tenChucVu;

    public TaiKhoanModel(String maTaiKhoan, String email, String matKhau, String maChucVu) {
        this.maTaiKhoan = maTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.maChucVu = maChucVu;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
