/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.96
 * Generated at: 2024-11-02 13:57:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.nguoidung;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.NguoiDungDAO303;
import model.NguoiDung303;
import model.NhanVienQuanLy303;
import model.NhanVienBanHang303;
import model.KhachHang303;

public final class login303_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.LinkedHashSet<>(7);
    _jspx_imports_classes.add("model.NhanVienQuanLy303");
    _jspx_imports_classes.add("dao.NguoiDungDAO303");
    _jspx_imports_classes.add("model.NhanVienBanHang303");
    _jspx_imports_classes.add("model.KhachHang303");
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

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String errorMessage = null;

    if (username != null && password != null) {
        NguoiDungDAO303 nguoiDungDAO = new NguoiDungDAO303();
        NguoiDung303 nguoiDung = nguoiDungDAO.kiemtraDangnhap(username, password);

        if (nguoiDung != null) {
            session.setAttribute("nguoiDung", nguoiDung);

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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Đăng nhập</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"login303.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h2>Đăng nhập</h2>\r\n");
      out.write("        <form action=\"login303.jsp\" method=\"post\">\r\n");
      out.write("            <label for=\"username\">Tên đăng nhập:</label>\r\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\" required><br><br>\r\n");
      out.write("            <label for=\"password\">Mật khẩu:</label>\r\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" required><br><br>\r\n");
      out.write("            <button type=\"submit\">Đăng nhập</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");

            if (errorMessage != null) {
        
      out.write("\r\n");
      out.write("            <p class=\"error-message\">");
      out.print( errorMessage );
      out.write("</p>\r\n");
      out.write("        ");

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
