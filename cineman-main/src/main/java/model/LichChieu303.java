package model;

public class LichChieu303 {
    private int id;
    private String ngayChieu;
    private String gioChieu;
    private String thoiGianKetThuc;
    private String ngayKetThuc;
    private int phongChieuId;
    private int phimId;

    // Getter và Setter cho từng thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public String getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(String gioChieu) {
        this.gioChieu = gioChieu;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getPhongChieuId() {
        return phongChieuId;
    }

    public void setPhongChieuId(int phongChieuId) {
        this.phongChieuId = phongChieuId;
    }

    public int getPhimId() {
        return phimId;
    }

    public void setPhimId(int phimId) {
        this.phimId = phimId;
    }
}