<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.PhongChieuDao303" %>
<%@ page import="model.PhongChieu303" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chọn ngày, giờ và phòng chiếu</title>
    <link rel="stylesheet" type="text/css" href="css/chonngaygiophongchieu303.css">
</head>
<body>
    <h2>Chọn ngày, giờ và phòng chiếu</h2>
    <form method="post">
        <label for="ngayChieu">Ngày chiếu:</label>
        <input type="date" id="ngayChieu" name="ngayChieu" required><br><br>
        <label for="gioChieu">Giờ chiếu:</label>
        <input type="time" id="gioChieu" name="gioChieu" required><br><br>
        <button type="submit">Tìm phòng chiếu trống</button>
    </form>

    <%
        String ngayChieu = request.getParameter("ngayChieu");
        String gioChieu = request.getParameter("gioChieu");
        if (ngayChieu != null && gioChieu != null) {
            PhongChieuDao303 phongChieuDao = new PhongChieuDao303();
            List<PhongChieu303> danhSachPhongChieu = phongChieuDao.timPhongChieuTrong(ngayChieu, gioChieu);

            if (danhSachPhongChieu != null && !danhSachPhongChieu.isEmpty()) {
    %>
                <form action="gdChonphim303.jsp" method="post">
                    <input type="hidden" name="ngayChieu" value="<%= ngayChieu %>">
                    <input type="hidden" name="gioChieu" value="<%= gioChieu %>">
                    <label for="phongChieu">Chọn phòng chiếu:</label>
                    <select id="phongChieu" name="phongChieu" required>
                        <%
                            for (PhongChieu303 phongChieu : danhSachPhongChieu) {
                        %>
                            <option value="<%= phongChieu.getId() %>"><%= phongChieu.getTenPhong() %></option>
                        <%
                            }
                        %>
                    </select><br><br>
                    <button type="submit">Tiếp tục</button>
                </form>
    <%
            } else {
    %>
                <p>Không có phòng chiếu trống vào thời gian này.</p>
    <%
            }
        }
    %>
</body>
</html>