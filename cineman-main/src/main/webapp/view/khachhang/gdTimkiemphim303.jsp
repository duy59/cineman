<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.PhimDao303" %>
<%@ page import="model.Phim303" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tìm kiếm phim</title>
    <link rel="stylesheet" type="text/css" href="css/timkiemphim.css">
</head>
<body>
    <h2>Tìm kiếm phim</h2>
    <form method="post" accept-charset="UTF-8">
        <input type="text" name="tuKhoa" placeholder="Nhập tên phim" required>
        <button type="submit">Tìm kiếm</button>
    </form>

    <%
    request.setCharacterEncoding("UTF-8");
    String tuKhoa = request.getParameter("tuKhoa");
    if (tuKhoa != null && !tuKhoa.trim().isEmpty()) {
        // In ra giá trị của tuKhoa để kiểm tra
        out.println("Từ khóa tìm kiếm: " + tuKhoa);

        PhimDao303 phimDao = new PhimDao303();
        List<Phim303> danhSachPhim = phimDao.timKiemPhim(tuKhoa);

        if (danhSachPhim != null && !danhSachPhim.isEmpty()) {
    %>
                <h3>Kết quả tìm kiếm cho "<%= tuKhoa %>":</h3>
                <div class="table-container">
                    <table border="1" cellpadding="5" cellspacing="0">
                        <tr>
                            <th>Mã phim</th>
                            <th>Tên phim</th>
                            <th>Năm sản xuất</th>
                            <th>Thể loại</th>
                            <th>Thời lượng</th>
                            <th>Hành động</th>
                        </tr>
                        <%
                            for (Phim303 phim : danhSachPhim) {
                        %>
                        <tr>
                            <td><%= phim.getId() %></td>
                            <td><%= phim.getTenPhim() %></td>
                            <td><%= phim.getNamsanxuat() %></td>
                            <td><%= phim.getTheLoai() %></td>
                            <td><%= phim.getThoigian() %> phút</td>
                            <td><a href="gdChitietphim303.jsp?id=<%= phim.getId() %>">Xem chi tiết</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
    <%
        } else {
    %>
                <p>Không tìm thấy phim nào với từ khóa "<%= tuKhoa %>".</p>
    <%
        }
    }
    %>
</body>
</html>