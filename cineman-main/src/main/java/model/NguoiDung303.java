package model;

import java.util.Date;

public abstract class NguoiDung303 {
    private int id;
    private String tenDangNhap;
    private String matKhau;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private String vaiTro;

    // Constructor
    public NguoiDung303() {
        super();
    }

    // Getter và Setter cho 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // Getter và Setter cho 'tenDangNhap'
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
    
    // Getter và Setter cho 'matKhau'
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    // Getter và Setter cho 'hoTen'
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    // Getter và Setter cho 'ngaySinh'
    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    // Getter và Setter cho 'gioiTinh'
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    // Getter và Setter cho 'email'
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // Getter và Setter cho 'soDienThoai'
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    // Getter và Setter cho 'diaChi'
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    // Getter và Setter cho 'vaiTro'
    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
}