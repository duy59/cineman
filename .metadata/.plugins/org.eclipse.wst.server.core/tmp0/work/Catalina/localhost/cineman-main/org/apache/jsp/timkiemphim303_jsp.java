/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.96
 * Generated at: 2024-11-01 14:38:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import dao.PhimDao303;
import model.Phim303;

public final class timkiemphim303_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.LinkedHashSet<>(4);
    _jspx_imports_classes.add("dao.PhimDao303");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("model.Phim303");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Tìm kiếm phim</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"timkiemphim303.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h2>Tìm kiếm phim</h2>\r\n");
      out.write("    <form method=\"post\" accept-charset=\"UTF-8\">\r\n");
      out.write("        <input type=\"text\" name=\"tuKhoa\" placeholder=\"Nhập tên phim\" required>\r\n");
      out.write("        <button type=\"submit\">Tìm kiếm</button>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    ");

    request.setCharacterEncoding("UTF-8");
    String tuKhoa = request.getParameter("tuKhoa");
    if (tuKhoa != null && !tuKhoa.trim().isEmpty()) {
        // In ra giá trị của tuKhoa để kiểm tra
        out.println("Từ khóa tìm kiếm: " + tuKhoa);

        PhimDao303 phimDao = new PhimDao303();
        List<Phim303> danhSachPhim = phimDao.timKiemPhim(tuKhoa);

        if (danhSachPhim != null && !danhSachPhim.isEmpty()) {
	
      out.write("\r\n");
      out.write("                <h3>Kết quả tìm kiếm cho \"");
      out.print( tuKhoa );
      out.write("\":</h3>\r\n");
      out.write("                <table border=\"1\" cellpadding=\"5\" cellspacing=\"0\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Mã phim</th>\r\n");
      out.write("                        <th>Tên phim</th>\r\n");
      out.write("                        <th>Năm sản xuất</th>\r\n");
      out.write("                        <th>Thể loại</th>\r\n");
      out.write("                        <th>Thời lượng</th>\r\n");
      out.write("                        <th>Hành động</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");

                        for (Phim303 phim : danhSachPhim) {
                    
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>");
      out.print( phim.getId() );
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( phim.getTenPhim() );
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( phim.getNamsanxuat() );
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( phim.getTheLoai() );
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( phim.getThoigian() );
      out.write(" phút</td>\r\n");
      out.write("                        <td><a href=\"chitietphim303.jsp?id=");
      out.print( phim.getId() );
      out.write("\">Xem chi tiết</a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("    ");

            } else {
    
      out.write("\r\n");
      out.write("                <p>Không tìm thấy phim nào với từ khóa \"");
      out.print( tuKhoa );
      out.write("\".</p>\r\n");
      out.write("    ");

            }
        }
    
      out.write("\r\n");
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