/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ACER
 */
public class NganhModel {
    private String maNganh;
    private String maKhoa;
    private String tenNganh;
    private int trangThaiHienThi;

    public NganhModel(String maNganh, String maKhoa, String tenNganh, int trangThaiHienThi) {
        this.maNganh = maNganh;
        this.maKhoa = maKhoa;
        this.tenNganh = tenNganh;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public NganhModel(String maNganh, String maKhoa, String tenNganh) {
        this.maNganh = maNganh;
        this.maKhoa = maKhoa;
        this.tenNganh = tenNganh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public int getTrangThaiHienThi() {
        return trangThaiHienThi;
    }

    public void setTrangThaiHienThi(int trangThaiHienThi) {
        this.trangThaiHienThi = trangThaiHienThi;
    }
    
    
}
