package model;

import java.sql.Date;
import java.sql.Time;

public class LichChieu303 {
    private int id;
    private Date ngayChieu;
    private Time gioChieu;
    private Time thoiGianKetThuc;
    private Date ngayKetThuc;
    private int phongChieuId;
    private int phimId;
    private int quanLyId;

    // Getter và Setter cho từng thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Time getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(Time gioChieu) {
        this.gioChieu = gioChieu;
    }

    public Time getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Time thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
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
    
    public int getQuanLyId() {
        return quanLyId;
    }

    public void setQuanLyId(int quanLyId) {
        this.quanLyId = quanLyId;
    }
}