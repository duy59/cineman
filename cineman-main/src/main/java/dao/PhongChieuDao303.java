package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.PhongChieu303;
import model.LichChieu303;

public class PhongChieuDao303 extends DAO303 {

    public PhongChieuDao303() {
        super();
    }

    public List<PhongChieu303> timPhongChieuTrong(Date ngayChieu, Time gioChieu) {
        List<PhongChieu303> danhSachPhongChieu = new ArrayList<>();
        LichChieuDao303 lichChieuDao = new LichChieuDao303();
        List<LichChieu303> danhSachLichChieu = lichChieuDao.layDanhSachLichChieu(ngayChieu, gioChieu);
        
        for (LichChieu303 lichChieu : danhSachLichChieu) {
            System.out.println("LichChieu ID: " + lichChieu.getId());
            System.out.println("Ngay Chieu: " + lichChieu.getNgayChieu());
            System.out.println("Gio Chieu: " + lichChieu.getGioChieu());
            System.out.println("Thoi Gian Ket Thuc: " + lichChieu.getThoiGianKetThuc());
            System.out.println("Ngay Ket Thuc: " + lichChieu.getNgayKetThuc());
            System.out.println("Phong Chieu ID: " + lichChieu.getPhongChieuId());
            System.out.println("Phim ID: " + lichChieu.getPhimId());
            System.out.println("-----------------------------");
        }

        String sql = "SELECT * FROM tblPhongChieu303 WHERE id NOT IN (";
        boolean first = true;
        for (LichChieu303 lichChieu : danhSachLichChieu) {
            LocalTime gioChieuTime = gioChieu.toLocalTime();
            LocalTime gioChieuLich = lichChieu.getGioChieu().toLocalTime();
            LocalTime thoiGianKetThucLich = lichChieu.getThoiGianKetThuc().toLocalTime();

            boolean isOverlapping = false;

            if (lichChieu.getNgayChieu().equals(ngayChieu) && lichChieu.getNgayKetThuc().equals(ngayChieu)) {
                // Check if gioChieu is between gioChieuLich and thoiGianKetThucLich
                if ((gioChieuTime.isAfter(gioChieuLich) || gioChieuTime.equals(gioChieuLich)) &&
                    gioChieuTime.isBefore(thoiGianKetThucLich)) {
                    isOverlapping = true;
                }
            } else {
                // Check if gioChieu is between gioChieuLich and 23:59 on ngayChieu
                if (lichChieu.getNgayChieu().equals(ngayChieu) &&
                    (gioChieuTime.isAfter(gioChieuLich) || gioChieuTime.equals(gioChieuLich))) {
                    isOverlapping = true;
                }
                // Check if gioChieu is between 00:00 and thoiGianKetThucLich on ngayKetThuc
                if (lichChieu.getNgayKetThuc().equals(ngayChieu) &&
                    gioChieuTime.isBefore(thoiGianKetThucLich)) {
                    isOverlapping = true;
                }
            }

            if (isOverlapping) {
                if (!first) {
                    sql += ", ";
                }
                sql += lichChieu.getPhongChieuId();
                first = false;
            }
        }
        sql += ")";

        if (first) {
            // No conflicting schedules, return all rooms
            sql = "SELECT * FROM tblPhongChieu303";
        }

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    PhongChieu303 phongChieu = new PhongChieu303();
                    phongChieu.setId(rs.getInt("id"));
                    phongChieu.setTenPhong(rs.getString("tenPhong"));
                    danhSachPhongChieu.add(phongChieu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachPhongChieu;
    }
}