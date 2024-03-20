/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author quang
 */
public class NamHocModel {

    private int maNamHoc;
    private String namHoc;
    private int trangThaiHienThi;

    public NamHocModel(String namHoc, int trangThaiHienThi) {
        this.namHoc = namHoc;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public NamHocModel(int maNamHoc, String namHoc, int trangThaiHienThi) {
        this.maNamHoc = maNamHoc;
        this.namHoc = namHoc;
        this.trangThaiHienThi = trangThaiHienThi;
    }

    public int getMaNamHoc() {
        return maNamHoc;
    }

    public void setMaNamHoc(int maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public int getTrangThaiHienThi() {
        return trangThaiHienThi;
    }

    public void setTrangThaiHienThi(int trangThaiHienThi) {
        this.trangThaiHienThi = trangThaiHienThi;
    }

}
