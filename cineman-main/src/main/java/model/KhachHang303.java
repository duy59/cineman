package model;

public class KhachHang303 extends NguoiDung303 {
    private String maKhachHang;
    private int soLanDatVe;

    // Getters và Setters
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getSoLanDatVe() {
        return soLanDatVe;
    }

    public void setSoLanDatVe(int soLanDatVe) {
        this.soLanDatVe = soLanDatVe;
    }
}