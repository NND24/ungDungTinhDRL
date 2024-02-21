
package models;

public class KhoaHocModel {
    private String khoaHoc, trangThaiKhoaHoc;
    
    public KhoaHocModel(String khoaHoc, String trangThaiKhoaHoc){
        this.khoaHoc = khoaHoc;
        this.trangThaiKhoaHoc = trangThaiKhoaHoc;
    }
    
    public KhoaHocModel(String khoaHoc){
        this.khoaHoc = khoaHoc;
    }
    
    public String getKhoaHoc(){
        return this.khoaHoc;
    }
    
    public String getTrangThaiKhoaHoc(){
        return this.trangThaiKhoaHoc;
    }
    
    public void setKhoaHoc(String khoaHoc){
        this.khoaHoc = khoaHoc;
    }
    
    public void setTrangThaiKhoaHoc(String trangThaiKhoaHoc){
        this.trangThaiKhoaHoc = trangThaiKhoaHoc;
    }
}

