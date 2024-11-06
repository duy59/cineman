/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.96
 * Generated at: 2024-11-04 17:50:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.quanly;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.LichChieuDao303;
import model.LichChieu303;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import model.NguoiDung303;

public final class gdXacnhanlichchieu303_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(10);
    _jspx_imports_classes.add("dao.LichChieuDao303");
    _jspx_imports_classes.add("java.time.temporal.ChronoUnit");
    _jspx_imports_classes.add("java.time.LocalDate");
    _jspx_imports_classes.add("java.time.format.DateTimeFormatter");
    _jspx_imports_classes.add("java.time.LocalTime");
    _jspx_imports_classes.add("model.LichChieu303");
    _jspx_imports_classes.add("model.NguoiDung303");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Xác nhận lịch chiếu</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/xacnhanlichchieu303.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h2>Xác nhận lịch chiếu</h2>\r\n");
      out.write("        ");

            String ngayChieu = request.getParameter("ngayChieu");
            String gioChieu = request.getParameter("gioChieu");
            String phongChieu = request.getParameter("phongChieu");
            String phim = request.getParameter("phim");
            String thoiLuongPhim = request.getParameter("thoiGianKetThuc");

            // Convert thoiLuongPhim to hours, minutes, and seconds
            int durationMinutes = Integer.parseInt(thoiLuongPhim);
            LocalTime gioChieuTime = LocalTime.parse(gioChieu, DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime thoiGianKetThucTime = gioChieuTime.plus(durationMinutes, ChronoUnit.MINUTES);

            LocalDate ngayChieuDate = LocalDate.parse(ngayChieu);
            LocalDate ngayKetThucDate = ngayChieuDate;

            // Adjust ngayKetThucDate if thoiGianKetThucTime is before gioChieuTime
            if (thoiGianKetThucTime.isBefore(gioChieuTime)) {
                ngayKetThucDate = ngayChieuDate.plusDays(1);
            }

            LichChieu303 lichChieu = new LichChieu303();
            lichChieu.setNgayChieu(ngayChieu);
            lichChieu.setGioChieu(gioChieu);
            lichChieu.setThoiGianKetThuc(thoiGianKetThucTime.toString());
            lichChieu.setNgayKetThuc(ngayKetThucDate.toString());
            lichChieu.setPhongChieuId(Integer.parseInt(phongChieu));
            lichChieu.setPhimId(Integer.parseInt(phim));

            // Lấy ID người dùng từ session
            NguoiDung303 nguoiDung = (NguoiDung303) session.getAttribute("nguoiDung");
            int quanLyId = nguoiDung.getId();
            System.out.println("ID người dùng từ session: " + quanLyId); // Thêm dòng này để kiểm tra ID người dùng từ session
        
      out.write("\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Ngày chiếu</th>\r\n");
      out.write("                <th>Giờ chiếu</th>\r\n");
      out.write("                <th>Thời gian kết thúc</th>\r\n");
      out.write("                <th>Phim</th>\r\n");
      out.write("                <th>Phòng chiếu</th>\r\n");
      out.write("                <th>Ngày kết thúc</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( ngayChieu );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( gioChieu );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( thoiGianKetThucTime );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( phim );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( phongChieu );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( ngayKetThucDate );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <form method=\"post\" action=\"gdXacnhanlichchieu303.jsp\">\r\n");
      out.write("            <input type=\"hidden\" name=\"ngayChieu\" value=\"");
      out.print( ngayChieu );
      out.write("\">\r\n");
      out.write("            <input type=\"hidden\" name=\"gioChieu\" value=\"");
      out.print( gioChieu );
      out.write("\">\r\n");
      out.write("            <input type=\"hidden\" name=\"phongChieu\" value=\"");
      out.print( phongChieu );
      out.write("\">\r\n");
      out.write("            <input type=\"hidden\" name=\"phim\" value=\"");
      out.print( phim );
      out.write("\">\r\n");
      out.write("            <input type=\"hidden\" name=\"thoiGianKetThuc\" value=\"");
      out.print( thoiLuongPhim );
      out.write("\">\r\n");
      out.write("            <input type=\"hidden\" name=\"quanLyId\" value=\"");
      out.print( quanLyId );
      out.write("\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"save\">\r\n");
      out.write("            <button type=\"submit\">Lưu</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        <button onclick=\"window.location.href='gdQuanlychinh303.jsp'\">Quay lại trang chủ quản lý</button>\r\n");
      out.write("\r\n");
      out.write("        ");

            if ("save".equals(request.getParameter("action"))) {
                LichChieuDao303 lichChieuDao = new LichChieuDao303();
                boolean ketQua = lichChieuDao.luuLichChieuMoi(lichChieu, quanLyId);

                if (ketQua) {
        
      out.write("\r\n");
      out.write("                    <p>Lịch chiếu đã được lưu thành công.</p>\r\n");
      out.write("        ");

                } else {
        
      out.write("\r\n");
      out.write("                    <p>Đã xảy ra lỗi khi lưu lịch chiếu.</p>\r\n");
      out.write("        ");

                }
            }
        
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
