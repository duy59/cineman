package model;

public class Phim303 {
    private int id;
    private String tenPhim;
    private String namsanxuat;
    private String theLoai;
    private String daoDien;
    private String dienVienChinh;
    private int thoigian;
    private String moTa;
    private String ngonngu;
    private String status;
    private int quanLyId;
    
    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNamsanxuat() {
        return namsanxuat;
    }

    public void setNamsanxuat(String namsanxuat) {
        this.namsanxuat = namsanxuat;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getDienVienChinh() {
        return dienVienChinh;
    }

    public void setDienVienChinh(String dienVienChinh) {
        this.dienVienChinh = dienVienChinh;
    }

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNgonngu() {
        return ngonngu;
    }

    public void setNgonngu(String ngonngu) {
        this.ngonngu = ngonngu;
    }

    public String getStatus() { // Thêm getter cho status
        return status;
    }

    public void setStatus(String status) { // Thêm setter cho status
        this.status = status;
    }
    public int getQuanLyId() {
        return quanLyId;
    }

    public void setQuanLyId(int quanLyId) {
        this.quanLyId = quanLyId;
    }
}