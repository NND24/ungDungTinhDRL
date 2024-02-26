/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author quang
 */
public class HocKyModel {
    private String hocKy, trangThaiHocKy;

    public HocKyModel(String hocKy, String trangThaiHocKy) {
        this.hocKy = hocKy;
        this.trangThaiHocKy = trangThaiHocKy;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getTrangThaiHocKy() {
        return trangThaiHocKy;
    }

    public void setTrangThaiHocKy(String trangThaiHocKy) {
        this.trangThaiHocKy = trangThaiHocKy;
    }
    
}
