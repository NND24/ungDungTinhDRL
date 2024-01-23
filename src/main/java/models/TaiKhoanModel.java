package models;

public class TaiKhoanModel {

    private String maTaiKhoan, email, matKhau, chucVu;

    public TaiKhoanModel(String maTaiKhoan, String email, String matKhau, String chucVu) {
        this.maTaiKhoan = maTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

}
