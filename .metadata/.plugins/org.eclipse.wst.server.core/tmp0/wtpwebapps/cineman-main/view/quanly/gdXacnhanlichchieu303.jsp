<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.LichChieuDao303" %>
<%@ page import="model.LichChieu303" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.Time" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="model.NguoiDung303" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xác nhận lịch chiếu</title>
    <link rel="stylesheet" type="text/css" href="css/xacnhanlichchieu303.css">
</head>
<body>
    <div class="container">
        <h2>Xác nhận lịch chiếu</h2>
        <%
            String ngayChieuStr = request.getParameter("ngayChieu");
            String gioChieuStr = request.getParameter("gioChieu");
            int phongChieu = Integer.parseInt(request.getParameter("phongChieu"));
            int phim = Integer.parseInt(request.getParameter("phim"));
            int thoiLuongPhim = Integer.parseInt(request.getParameter("thoiGianKetThuc"));

            Date ngayChieu = Date.valueOf(ngayChieuStr);
            Time gioChieu = Time.valueOf(gioChieuStr); // Thêm giây vào thời gian

            LocalTime gioChieuTime = gioChieu.toLocalTime();
            LocalTime thoiGianKetThucTime = gioChieuTime.plus(thoiLuongPhim, ChronoUnit.MINUTES);

            LocalDate ngayChieuDate = ngayChieu.toLocalDate();
            LocalDate ngayKetThucDate = ngayChieuDate;

            // Adjust ngayKetThucDate if thoiGianKetThucTime is before gioChieuTime
            if (thoiGianKetThucTime.isBefore(gioChieuTime)) {
                ngayKetThucDate = ngayChieuDate.plusDays(1);
            }

            LichChieu303 lichChieu = new LichChieu303();
            lichChieu.setNgayChieu(ngayChieu);
            lichChieu.setGioChieu(gioChieu);
            lichChieu.setThoiGianKetThuc(Time.valueOf(thoiGianKetThucTime));
            lichChieu.setNgayKetThuc(Date.valueOf(ngayKetThucDate));
            lichChieu.setPhongChieuId(phongChieu);
            lichChieu.setPhimId(phim);

            // Lấy ID người dùng từ session
            NguoiDung303 nguoiDung = (NguoiDung303) session.getAttribute("nguoiDung");
            int quanLyId = nguoiDung.getId();
            System.out.println("ID người dùng từ session: " + quanLyId); // Thêm dòng này để kiểm tra ID người dùng từ session
        %>
        <table>
            <tr>
                <th>Ngày chiếu</th>
                <th>Giờ chiếu</th>
                <th>Thời gian kết thúc</th>
                <th>Phim</th>
                <th>Phòng chiếu</th>
                <th>Ngày kết thúc</th>
            </tr>
            <tr>
                <td><%= ngayChieu %></td>
                <td><%= gioChieu %></td>
                <td><%= thoiGianKetThucTime %></td>
                <td><%= phim %></td>
                <td><%= phongChieu %></td>
                <td><%= ngayKetThucDate %></td>
            </tr>
        </table>
        <form method="post" action="gdXacnhanlichchieu303.jsp">
            <input type="hidden" name="ngayChieu" value="<%= ngayChieu %>">
            <input type="hidden" name="gioChieu" value="<%= gioChieu %>">
            <input type="hidden" name="phongChieu" value="<%= phongChieu %>">
            <input type="hidden" name="phim" value="<%= phim %>">
            <input type="hidden" name="thoiGianKetThuc" value="<%= thoiLuongPhim %>">
            <input type="hidden" name="quanLyId" value="<%= quanLyId %>">
            <input type="hidden" name="action" value="save">
            <button type="submit">Lưu</button>
        </form>
        <button onclick="window.location.href='gdQuanlychinh303.jsp'">Quay lại trang chủ quản lý</button>

        <%
            if ("save".equals(request.getParameter("action"))) {
                LichChieuDao303 lichChieuDao = new LichChieuDao303();
                boolean ketQua = lichChieuDao.luuLichChieuMoi(lichChieu, quanLyId);

                if (ketQua) {
        %>
                    <p>Lịch chiếu đã được lưu thành công.</p>
        <%
                } else {
        %>
                    <p>Đã xảy ra lỗi khi lưu lịch chiếu.</p>
        <%
                }
            }
        %>
    </div>
</body>
</html>