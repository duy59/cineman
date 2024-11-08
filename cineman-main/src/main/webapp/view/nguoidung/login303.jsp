<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.NguoiDungDAO303" %>
<%@ page import="model.NguoiDung303" %>
<%@ page import="model.NhanVienQuanLy303" %>
<%@ page import="model.NhanVienBanHang303" %>
<%@ page import="model.KhachHang303" %>
<%@ page session="true" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String errorMessage = null;

    if (username != null && password != null) {
        NguoiDungDAO303 nguoiDungDAO = new NguoiDungDAO303();
        NguoiDung303 nguoiDung = nguoiDungDAO.kiemtraDangnhap(username, password);

        if (nguoiDung != null) {
            session.setAttribute("nguoiDung", nguoiDung);
            System.out.println("ID người dùng sau khi đăng nhập: " + nguoiDung.getId()); // Thêm dòng này để kiểm tra ID người dùng sau khi đăng nhập

            if (nguoiDung instanceof NhanVienQuanLy303) {
                response.sendRedirect("../quanly/gdQuanlychinh303.jsp");
            } else if (nguoiDung instanceof NhanVienBanHang303) {
                response.sendRedirect("../nhanvien/gdNhanvienchinh303.jsp");
            } else if (nguoiDung instanceof KhachHang303) {
                response.sendRedirect("../khachhang/gdKhachhangchinh303.jsp");
            }
        } else {
            errorMessage = "Tên đăng nhập và mật khẩu không đúng";
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" type="text/css" href="login303.css">
</head>
<body>
    <div class="container">
        <h2>Đăng nhập</h2>
        <form action="login303.jsp" method="post">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" id="username" name="username" required><br><br>
            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required><br><br>
            <button type="submit">Đăng nhập</button>
        </form>
        <%
            if (errorMessage != null) {
        %>
            <p class="error-message"><%= errorMessage %></p>
        <%
            }
        %>
    </div>
</body>
</html>