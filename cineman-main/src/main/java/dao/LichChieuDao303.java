package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.LichChieu303;

public class LichChieuDao303 extends DAO303 {

    public LichChieuDao303() {
        super();
    }

    public boolean luuLichChieuMoi(LichChieu303 lichChieu, int quanLyId) {
        // In thông tin của lịch chiếu mới
        System.out.printf("Lịch chiếu mới: Ngày chiếu = %s, Giờ chiếu = %s, Thời gian kết thúc = %s, Ngày kết thúc = %s, Phòng chiếu ID = %d, Phim ID = %d, Quản lý ID = %d%n",
                lichChieu.getNgayChieu(), lichChieu.getGioChieu(), lichChieu.getThoiGianKetThuc(), lichChieu.getNgayKetThuc(), lichChieu.getPhongChieuId(), lichChieu.getPhimId(), quanLyId);

        // Lấy tất cả các lịch chiếu có ngayChieu hoặc ngayKetThuc trùng với ngayChieu của lịch chiếu mới
        List<LichChieu303> danhSachLichChieu = layDanhSachLichChieu(lichChieu.getNgayChieu(), lichChieu.getGioChieu());

        // Sắp xếp danh sách lịch chiếu theo ngayChieu
        Collections.sort(danhSachLichChieu, new Comparator<LichChieu303>() {
            public int compare(LichChieu303 lc1, LichChieu303 lc2) {
                return lc1.getNgayChieu().compareTo(lc2.getNgayChieu());
            }
        });

        // Lọc danh sách lịch chiếu cùng phòng và cùng ngày
        List<LichChieu303> danhSachLichChieuCungPhong = new ArrayList<>();
        for (LichChieu303 lc : danhSachLichChieu) {
            if (lc.getPhongChieuId() == lichChieu.getPhongChieuId() &&
                lc.getNgayChieu().equals(lichChieu.getNgayChieu())) {
                danhSachLichChieuCungPhong.add(lc);
            }
        }

        // Sắp xếp danh sách lịch chiếu cùng phòng theo gioChieu
        Collections.sort(danhSachLichChieuCungPhong, new Comparator<LichChieu303>() {
            public int compare(LichChieu303 lc1, LichChieu303 lc2) {
                return lc1.getGioChieu().compareTo(lc2.getGioChieu());
            }
        });

        LocalTime gioChieuMoi = lichChieu.getGioChieu().toLocalTime();
        LocalTime gioKetThucMoi = lichChieu.getThoiGianKetThuc().toLocalTime();

        if (danhSachLichChieuCungPhong.size() == 1) {
            LichChieu303 lichChieuCu = danhSachLichChieuCungPhong.get(0);
            LocalTime gioChieuCu = lichChieuCu.getGioChieu().toLocalTime();

            if ((gioChieuMoi.isBefore(gioChieuCu) && gioKetThucMoi.isAfter(gioChieuCu)) ||
                    (!lichChieu.getNgayChieu().equals(lichChieu.getNgayKetThuc()) && gioChieuMoi.isBefore(gioChieuCu))) {
                    System.out.println("Lịch chiếu mới trùng với lịch chiếu cũ. Không thể lưu lịch chiếu mới.");
                    return false;
                }
        } else {
            for (int i = 0; i < danhSachLichChieuCungPhong.size(); i++) {
                LichChieu303 lichChieuCu = danhSachLichChieuCungPhong.get(i);
                LocalTime gioChieuCu = lichChieuCu.getGioChieu().toLocalTime();
                LocalTime gioKetThucCu = lichChieuCu.getThoiGianKetThuc().toLocalTime();

                if ((gioChieuMoi.isBefore(gioKetThucCu) && gioKetThucMoi.isAfter(gioChieuCu)) ||
                    gioChieuMoi.equals(gioChieuCu) || gioKetThucMoi.equals(gioKetThucCu)) {
                    System.out.println("Lịch chiếu mới trùng với lịch chiếu cũ. Không thể lưu lịch chiếu mới.");
                    return false;
                }
            }
        }

        // Lưu lịch chiếu mới vào cơ sở dữ liệu
        String sql = "INSERT INTO tblLichChieu303 (ngayChieu, gioChieu, thoiGianKetThuc, ngayKetThuc, phongChieuId, phimId, quanLyId) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, lichChieu.getNgayChieu());
            ps.setTime(2, lichChieu.getGioChieu());
            ps.setTime(3, lichChieu.getThoiGianKetThuc());
            ps.setDate(4, lichChieu.getNgayKetThuc());
            ps.setInt(5, lichChieu.getPhongChieuId());
            ps.setInt(6, lichChieu.getPhimId());
            ps.setInt(7, quanLyId);

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<LichChieu303> layDanhSachLichChieu(Date ngayChieu, Time gioChieu) {
        List<LichChieu303> danhSachLichChieu = new ArrayList<>();
        String sql = "SELECT * FROM tblLichChieu303 WHERE ngayChieu = ? OR ngayKetThuc = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, ngayChieu);
            ps.setDate(2, ngayChieu);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LichChieu303 lichChieu = new LichChieu303();
                    lichChieu.setId(rs.getInt("id"));
                    lichChieu.setNgayChieu(rs.getDate("ngayChieu"));
                    lichChieu.setGioChieu(rs.getTime("gioChieu"));
                    lichChieu.setThoiGianKetThuc(rs.getTime("thoiGianKetThuc"));
                    lichChieu.setNgayKetThuc(rs.getDate("ngayKetThuc"));
                    lichChieu.setPhongChieuId(rs.getInt("phongChieuId"));
                    lichChieu.setPhimId(rs.getInt("phimId"));
                    lichChieu.setQuanLyId(rs.getInt("quanLyId"));
                    danhSachLichChieu.add(lichChieu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachLichChieu;
    }
}