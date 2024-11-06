package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.KhachHang303;
import model.NguoiDung303;
import model.NhanVien303;
import model.NhanVienBanHang303;
import model.NhanVienQuanLy303;

public class NguoiDungDAO303 extends DAO303 {

    public NguoiDungDAO303() {
        super();
    }

    public NguoiDung303 kiemtraDangnhap(String tenDangNhap, String matKhau) {
        NguoiDung303 nd = null;

        String sql = "SELECT * FROM tblNguoiDung303 WHERE tenDangNhap = ? AND matKhau = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Truy vấn SQL trả về kết quả.");
                    int userId = rs.getInt("id");
                    System.out.println("ID từ ResultSet: " + userId); // Thêm dòng này
                    String vaiTro = rs.getString("vaiTro");
                    System.out.println("Vai trò là " + vaiTro);
                    String viTriCongViec = null;
                    switch (vaiTro) {
                        case "NhanVien":
                            viTriCongViec = getViTriCongViec(userId);
                            if ("QuanLy".equals(viTriCongViec)) {
                                nd = new NhanVienQuanLy303();
                            } else if ("BanHang".equals(viTriCongViec)) {
                                nd = new NhanVienBanHang303();
                            } else {
                                System.out.println("ViTriCongViec không hợp lệ.");
                                return null;
                            }
                            break;
                        case "KhachHang":
                            nd = new KhachHang303();
                            ((KhachHang303) nd).setSoLanDatVe(getSoLanDatVe(userId));
                            break;
                        default:
                            System.out.println("Vai trò không hợp lệ.");
                            return null;
                    }
                    if (nd != null) {
                        nd.setId(userId);
                        nd.setTenDangNhap(rs.getString("tenDangNhap"));
                        nd.setMatKhau(rs.getString("matKhau"));
                        nd.setHoTen(rs.getString("hoTen"));
                        nd.setNgaySinh(rs.getDate("ngaySinh"));
                        nd.setGioiTinh(rs.getString("gioiTinh"));
                        nd.setEmail(rs.getString("email"));
                        nd.setSoDienThoai(rs.getString("soDienThoai"));
                        nd.setDiaChi(rs.getString("diaChi"));
                        nd.setVaiTro(vaiTro);
                        if (nd instanceof NhanVien303) {
                            ((NhanVien303) nd).setViTriCongViec(viTriCongViec);
                        }
                        // In ra các thuộc tính của đối tượng nd
                        System.out.println("Thông tin người dùng:");
                        System.out.println("ID: " + nd.getId());
                        System.out.println("Tên đăng nhập: " + nd.getTenDangNhap());
                        System.out.println("Họ tên: " + nd.getHoTen());
                        System.out.println("Vai trò: " + nd.getVaiTro());
                        if (nd instanceof NhanVien303) {
                            System.out.println("Vị trí công việc: " + ((NhanVien303) nd).getViTriCongViec());
                        }
                    } else {
                        System.out.println("nd là null sau khi khởi tạo.");
                    }
                } else {
                    System.out.println("Truy vấn SQL không trả về kết quả.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nd;
    }

    private String getViTriCongViec(int id) {
        String viTriCongViec = null;
        String sql = "SELECT viTriCongViec FROM tblNhanVien303 WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    viTriCongViec = rs.getString("viTriCongViec");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viTriCongViec;
    }

    private int getSoLanDatVe(int id) {
        int soLanDatVe = 0;
        String sql = "SELECT soLanDatVe FROM tblKhachHang303 WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    soLanDatVe = rs.getInt("soLanDatVe");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLanDatVe;
    }
}