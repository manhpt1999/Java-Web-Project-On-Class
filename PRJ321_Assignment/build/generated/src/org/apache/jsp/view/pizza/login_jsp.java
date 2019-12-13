package org.apache.jsp.view.pizza;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.CustomerAccount;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.2.0/css/all.css\" integrity=\"sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ\"\n");
      out.write("              crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"../css/pizza.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Login</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("   ");

        CustomerAccount account = (CustomerAccount) session.getAttribute("account");
    
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"introduce\">\n");
      out.write("            <div id=\"login-link\">\n");
      out.write("                ");

                    if (account != null) {
                
      out.write("<i class=\"fas fa-user\"></i>\n");
      out.write("                Hello ");
      out.print(account.getName());
      out.write("\n");
      out.write("                <br>Click <a href=\"logout\" >Here</a> for logout!\n");
      out.write("                ");
} else {
      out.write("\n");
      out.write("                <i class=\"fas fa-user\"></i><a href=\"login\">Login</a>\n");
      out.write("                <i class=\"fas fa-user\"></i><a href=\"register\">Register</a>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div><h1>P   I   Z   Z   A</h1></div>\n");
      out.write("            <div id=\"order-link\"><a href=\"order\">Order now</a></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <div id=\"nav-bar\">\n");
      out.write("            <a href=\"home\">Home</a>\n");
      out.write("            <a href=\"pizza\">Pizza</a>\n");
      out.write("            <a href=\"drink\">Drink</a>\n");
      out.write("            <a href=\"contact\" class=\"\">Contact</a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"pizzas\" style=\"width: 50%\">\n");
      out.write("            <form action=\"login\" method=\"POST\">\n");
      out.write("                <p3 style=\"margin-left: 20px; font-size: 18px;\">Username:</p3><input type=\"text\" name=\"username\" style=\"margin: 20px; padding: 5px;\"/> <br/>\n");
      out.write("                <p3 style=\"margin-left: 20px; font-size: 18px;\">Password:</p3><input type=\"password\" name=\"password\" style=\"margin: 20px; padding: 5px;\"/><br/>\n");
      out.write("                <input type=\"checkbox\" name=\"remember\" value=\"remember\" style=\"margin: 20px;\"/> Remember me!<br/>\n");
      out.write("                <p style=\"margin-left: 20px; font-size: 18px; color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.notify}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<p>\n");
      out.write("                <input type=\"submit\" value=\"Login\" class=\"form-submit\"/>\n");
      out.write("            </form>    \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
