package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Phim303;

public class PhimDao303 extends DAO303 {

    public PhimDao303() {
        super();
    }

    public List<Phim303> timKiemPhim(String tuKhoa) {
        return timKiemPhim(tuKhoa, false); // Mặc định không lọc theo status
    }

    // Phương thức hiện tại với hai tham số
    public List<Phim303> timKiemPhim(String tuKhoa, boolean chiLayPhimDangChieu) {
        List<Phim303> danhSachPhim = new ArrayList<>();
        String sql = "SELECT * FROM tblPhim303 WHERE tenPhim LIKE ?";
        if (chiLayPhimDangChieu) {
            sql += " AND status = 'đang chiếu'";
        }
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + tuKhoa + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Phim303 phim = new Phim303();
                    phim.setId(rs.getInt("id"));
                    phim.setTenPhim(rs.getString("tenPhim"));
                    phim.setNamsanxuat(rs.getString("namsanxuat"));
                    phim.setTheLoai(rs.getString("theLoai"));
                    phim.setDaoDien(rs.getString("daoDien"));
                    phim.setDienVienChinh(rs.getString("dienVienChinh"));
                    phim.setThoigian(rs.getInt("thoigian"));
                    phim.setMoTa(rs.getString("moTa"));
                    phim.setNgonngu(rs.getString("ngonngu"));
                    phim.setStatus(rs.getString("status"));
                    danhSachPhim.add(phim);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachPhim;
    }
    public Phim303 layChiTietPhim(int id) {
        Phim303 phim = null;
        String sql = "SELECT * FROM tblPhim303 WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    phim = new Phim303();
                    phim.setId(rs.getInt("id"));
                    phim.setTenPhim(rs.getString("tenPhim"));
                    phim.setNamsanxuat(rs.getString("namsanxuat"));
                    phim.setTheLoai(rs.getString("theLoai"));
                    phim.setDaoDien(rs.getString("daoDien"));
                    phim.setDienVienChinh(rs.getString("dienVienChinh"));
                    phim.setThoigian(rs.getInt("thoigian"));
                    phim.setMoTa(rs.getString("moTa"));
                    phim.setNgonngu(rs.getString("ngonngu"));
                    phim.setStatus(rs.getString("status"));
                    // Thiết lập các thuộc tính khác nếu cần
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phim;
    }

}