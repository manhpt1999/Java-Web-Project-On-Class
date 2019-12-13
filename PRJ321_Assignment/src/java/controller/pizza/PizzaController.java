/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pizza;

import dal.DBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pizza;

/**
 *
 * @author Admin
 */
public class PizzaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DBContext db = new DBContext();
        String page = request.getParameter("page");
        if (page == null || page.length() == 0) {
            page = "1";
        }
        int pageindex = Integer.parseInt(page);
        int pagesize = 4;
        int totalrow = db.count();
        int totalpage = (totalrow % pagesize == 0) ? totalrow / pagesize : totalrow / pagesize + 1;

        ArrayList<Pizza> pizzas = db.paging(pageindex, pagesize);
        request.setAttribute("pizzas", pizzas);
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);
        request.getRequestDispatcher("../view/pizza/pizza.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String price = request.getParameter("price");
        String name = request.getParameter("name");
        String recipe = request.getParameter("recipe");

        if (name.equals("") && price.equals("") && recipe.equals("")) {
            DBContext db = new DBContext();
            String page = request.getParameter("page");
            if (page == null || page.length() == 0) {
                page = "1";
            }
            int pageindex = Integer.parseInt(page);
            int pagesize = 4;
            int totalrow = db.count();
            int totalpage = (totalrow % pagesize == 0) ? totalrow / pagesize : totalrow / pagesize + 1;

            ArrayList<Pizza> pizzas = db.paging(pageindex, pagesize);
            request.setAttribute("pizzas", pizzas);
            request.setAttribute("totalpage", totalpage);
            request.setAttribute("pageindex", pageindex);
            request.getRequestDispatcher("../view/pizza/pizza.jsp").forward(request, response);
        }

        DBContext db = new DBContext();
        ArrayList<Pizza> pizzas = db.pizzasFilter(name, price, recipe);

        int pageindex = 0;
        int totalpage = 0;
        request.setAttribute("pizzas", pizzas);
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageindex);
        request.getRequestDispatcher("../view/pizza/pizza.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
