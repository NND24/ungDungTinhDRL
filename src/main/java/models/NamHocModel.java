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
    private String namHoc, trangThaiNamHoc;

    public NamHocModel(String namHoc, String trangThaiNamHoc) {
        this.namHoc = namHoc;
        this.trangThaiNamHoc = trangThaiNamHoc;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getTrangThaiNamHoc() {
        return trangThaiNamHoc;
    }

    public void setTrangThaiNamHoc(String trangThaiNamHoc) {
        this.trangThaiNamHoc = trangThaiNamHoc;
    }
    
}
