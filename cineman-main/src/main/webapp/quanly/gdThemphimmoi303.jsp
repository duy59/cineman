<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.PhimDao303" %>
<%@ page import="model.Phim303" %>

<%
    // Thiết lập encoding cho request và response
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm phim mới</title>
</head>
<body>
    <h2>Thêm phim mới</h2>
    <form action="themphimmoi303.jsp" method="post" accept-charset="UTF-8">
        <label for="tenPhim">Tên phim:</label>
        <input type="text" id="tenPhim" name="tenPhim" required><br><br>
        <label for="namsanxuat">Năm sản xuất:</label>
        <input type="text" id="namsanxuat" name="namsanxuat" required><br><br>
        <label for="theLoai">Thể loại:</label>
        <input type="text" id="theLoai" name="theLoai" required><br><br>
        <label for="daoDien">Đạo diễn:</label>
        <input type="text" id="daoDien" name="daoDien" required><br><br>
        <label for="dienVienChinh">Diễn viên chính:</label>
        <input type="text" id="dienVienChinh" name="dienVienChinh" required><br><br>
        <label for="thoigian">Thời lượng (phút):</label>
        <input type="number" id="thoigian" name="thoigian" required><br><br>
        <label for="moTa">Mô tả:</label>
        <textarea id="moTa" name="moTa" required></textarea><br><br>
        <label for="ngonngu">Ngôn ngữ:</label>
        <input type="text" id="ngonngu" name="ngonngu" required><br><br>
        <button type="submit">Lưu phim</button>
    </form>

    <%
        String tenPhim = request.getParameter("tenPhim");
        if (tenPhim != null) {
            String namsanxuat = request.getParameter("namsanxuat");
            String theLoai = request.getParameter("theLoai");
            String daoDien = request.getParameter("daoDien");
            String dienVienChinh = request.getParameter("dienVienChinh");
            int thoigian = Integer.parseInt(request.getParameter("thoigian"));
            String moTa = request.getParameter("moTa");
            String ngonngu = request.getParameter("ngonngu");

            Phim303 phim = new Phim303();
            phim.setTenPhim(tenPhim);
            phim.setNamsanxuat(namsanxuat);
            phim.setTheLoai(theLoai);
            phim.setDaoDien(daoDien);
            phim.setDienVienChinh(dienVienChinh);
            phim.setThoigian(thoigian);
            phim.setMoTa(moTa);
            phim.setNgonngu(ngonngu);

            PhimDao303 phimDao = new PhimDao303();
            boolean ketQua = phimDao.luuPhimMoi(phim);

            if (ketQua) {
                response.sendRedirect("chonphim303.jsp");
            } else {
    %>
                <p>Đã xảy ra lỗi khi lưu phim.</p>
    <%
            }
        }
    %>
</body>
</html>