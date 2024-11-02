<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.PhimDao303" %>
<%@ page import="model.Phim303" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chọn phim</title>
    <link rel="stylesheet" type="text/css" href="css/chonphim303.css">
</head>
<body>
    <h2>Chọn phim</h2>
    <%
        String ngayChieu = request.getParameter("ngayChieu");
        String gioChieu = request.getParameter("gioChieu");
        String phongChieu = request.getParameter("phongChieu");
        PhimDao303 phimDao = new PhimDao303();
        List<Phim303> danhSachPhim = phimDao.timKiemPhim("");

        if (danhSachPhim != null && !danhSachPhim.isEmpty()) {
    %>
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>Tên phim</th>
                <th>Thời lượng (phút)</th>
                <th>Năm sản xuất</th>
                <th>Hành động</th>
            </tr>
            <%
                for (Phim303 phim : danhSachPhim) {
            %>
            <tr>
                <td><%= phim.getTenPhim() %></td>
                <td><%= phim.getThoigian() %></td>
                <td><%= phim.getNamsanxuat() %></td>
                <td>
                    <form action="gdXacnhanlichchieu303.jsp" method="post">
                        <input type="hidden" name="ngayChieu" value="<%= ngayChieu %>">
                        <input type="hidden" name="gioChieu" value="<%= gioChieu %>">
                        <input type="hidden" name="phongChieu" value="<%= phongChieu %>">
                        <input type="hidden" name="phim" value="<%= phim.getId() %>">
                        <input type="hidden" name="thoiGianKetThuc" value="<%= phim.getThoigian() %>">
                        <button type="submit">Chọn phim</button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>Không có phim nào để chọn.</p>
        <button onclick="window.location.href='gdThemphimmoi303.jsp'">Thêm phim mới</button>
    <%
        }
    %>
   
</body>
</html>