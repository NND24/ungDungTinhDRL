package models;

public class TaiKhoanModel {

    private String maTaiKhoan, tenDangNhap, matKhau, maChucVu, tenChucVu;

    public TaiKhoanModel() {
    }

    public TaiKhoanModel(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public TaiKhoanModel(String maTaiKhoan, String matKhau, String maChucVu) {
        this.maTaiKhoan = maTaiKhoan;
        this.matKhau = matKhau;
        this.maChucVu = maChucVu;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
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
