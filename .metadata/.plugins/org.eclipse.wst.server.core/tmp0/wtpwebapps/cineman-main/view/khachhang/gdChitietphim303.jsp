<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="dao.PhimDao303" %>
<%@ page import="model.Phim303" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết phim</title>
    <link rel="stylesheet" type="text/css" href="css/chitietphim303.css">
</head>
<body>
    <div class="container">
        <%
            String idStr = request.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                PhimDao303 phimDao = new PhimDao303();
                Phim303 phim = phimDao.layChiTietPhim(id);

                if (phim != null) {
        %>
                    <h2>Chi tiết phim</h2>
                    <table border="1" cellpadding="5" cellspacing="0">
                        <tr>
                            <th>Mã phim</th>
                            <td><%= phim.getId() %></td>
                        </tr>
                        <tr>
                            <th>Tên phim</th>
                            <td><%= phim.getTenPhim() %></td>
                        </tr>
                        <tr>
                            <th>Thể loại</th>
                            <td><%= phim.getTheLoai() %></td>
                        </tr>
                        <tr>
                            <th>Đạo diễn</th>
                            <td><%= phim.getDaoDien() %></td>
                        </tr>
                        <tr>
                            <th>Diễn viên chính</th>
                            <td><%= phim.getDienVienChinh() %></td>
                        </tr>
                        <tr>
                            <th>Năm sản xuất</th>
                            <td><%= phim.getNamsanxuat() %></td>
                        </tr>
                        <tr>
                            <th>Thời lượng</th>
                            <td><%= phim.getThoigian() %> phút</td>
                        </tr>
                        <tr>
                        	<th>Trạng thái </th>
                        	<td><%= phim.getStatus() %></td>
                        </tr>
                        <tr>
                            <th>Ngôn ngữ</th>
                            <td><%= phim.getNgonngu() %></td>
                        </tr>
                        <tr>
                            <th>Mô tả</th>
                            <td><%= phim.getMoTa() %></td>
                        </tr>
                    </table>
        <%
                } else {
        %>
                    <p class="error-message">Phim không tồn tại.</p>
        <%
                }
            } else {
        %>
            <p class="error-message">ID phim không hợp lệ.</p>
        <%
            }
        %>
    </div>
</body>
</html>