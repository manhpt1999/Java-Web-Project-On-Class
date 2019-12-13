package org.apache.jsp.view.pizza;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.CustomerAccount;
import util.HtmlHelper;

public final class pizza_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.2.0/css/all.css\" integrity=\"sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ\"\n");
      out.write("              crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"../css/pizza.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Pizza</title>\n");
      out.write("\n");
      out.write("        ");

            Integer totalpage = (Integer) request.getAttribute("totalpage");
            Integer pageindex = (Integer) request.getAttribute("pageindex");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("  ");

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
      out.write("        <!-- Navigation -->\n");
      out.write("        <div id=\"nav-bar\">\n");
      out.write("            <a href=\"home\">Home</a>\n");
      out.write("            <a href=\"pizza\">Pizza</a>\n");
      out.write("            <a href=\"drink\">Drink</a>\n");
      out.write("            <a href=\"contact\" class=\"\">Contact</a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Slide Show -->\n");
      out.write("        <div id=\"section\">\n");
      out.write("            <img class=\"mySlides\" src=\"../img/home/slideshow/Capture3.PNG\" >\n");
      out.write("            <img class=\"mySlides\" src=\"../img/home/slideshow/Capture.PNG\" >\n");
      out.write("            <img class=\"mySlides\" src=\"../img/home/slideshow/Capture3.PNG\" >\n");
      out.write("            <img class=\"mySlides\" src=\"../img/home/slideshow/Capture.PNG\" >\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"paging\">\n");
      out.write("            ");
      out.print(HtmlHelper.pager(2, pageindex, totalpage));
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"show-pizza\">\n");
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"paging\">\n");
      out.write("            ");
      out.print(HtmlHelper.pager(2, pageindex, totalpage));
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("// Automatic Slideshow - change image every 3 seconds\n");
      out.write("            var myIndex = 0;\n");
      out.write("            carousel();\n");
      out.write("\n");
      out.write("            function carousel() {\n");
      out.write("                var i;\n");
      out.write("                var x = document.getElementsByClassName(\"mySlides\");\n");
      out.write("                for (i = 0; i < x.length; i++) {\n");
      out.write("                    x[i].style.display = \"none\";\n");
      out.write("                }\n");
      out.write("                myIndex++;\n");
      out.write("                if (myIndex > x.length) {\n");
      out.write("                    myIndex = 1\n");
      out.write("                }\n");
      out.write("                x[myIndex - 1].style.display = \"block\";\n");
      out.write("                setTimeout(carousel, 3000);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.pizzas}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("p");
    _jspx_th_c_forEach_0.setVarStatus("loop");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \n");
          out.write("                <div class=\"pizzas\">\n");
          out.write("                    <div >\n");
          out.write("                        <img class=\"pizza-img\" src=\"data:image/png;base64,");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                    </div>\n");
          out.write("                    <div class=\"pizza-detail\">\n");
          out.write("                        <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.details}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                        <p class=\"p-bold\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" $</p>\n");
          out.write("                    </div>\n");
          out.write("                    <div class=\"form-submit\">\n");
          out.write("                        <form action=\"order\" method=\"GET\">\n");
          out.write("                            <input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" name=\"pizza_id\">\n");
          out.write("                            <input type=\"submit\" value=\"Order now\" id=\"button-order\">\n");
          out.write("                        </form>\n");
          out.write("                    </div>\n");
          out.write("                </div>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
