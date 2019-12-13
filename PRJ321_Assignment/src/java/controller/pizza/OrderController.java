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
import model.CustomerOrder;
import model.Pizza;
import model.PizzaOrderCustomer;
import model.Size;
import model.Topping;

/**
 *
 * @author Admin
 */
public class OrderController extends HttpServlet {

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
        String id = request.getParameter("pizza_id");
        DBContext db = new DBContext();
        Pizza p = db.getPizzaByID(id);
        ArrayList<Topping> toppings = db.getAllToppings();
        ArrayList<Size> sizes = db.getAllSizes();

        request.setAttribute("pizza", p);
        request.setAttribute("toppings", toppings);
        request.setAttribute("sizes", sizes);
        request.getRequestDispatcher("../view/pizza/order.jsp").forward(request, response);
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
        String pizza_id = request.getParameter("pizza_id");
        String size = request.getParameter("size");
        String topping1 = request.getParameter("topping1");
        String topping2 = request.getParameter("topping2");
        String pizza_price = request.getParameter("pizza_price");

        DBContext db = new DBContext();

        String pizza_order_id = Integer.valueOf(db.getMaxIDPizzaOrder()) + 1 + "";
        String pricebysize = size.equals("L")? "2" : "1";

        String totalprice = Integer.valueOf(pricebysize) * Integer.valueOf(pizza_price) + "";
        
        PizzaOrderCustomer poc = new PizzaOrderCustomer(pizza_order_id, pizza_id, size, topping1, topping2, totalprice);
        
       
        db.insertPizzaOrder(poc);
        
        String customer_order_id = Integer.valueOf(db.getMaxIDCustomerOrder()) + 1 + "";
        String phone = request.getParameter("phone");
        String customer_id = request.getParameter("customer_id");
        
        CustomerOrder co = new CustomerOrder(customer_order_id, customer_id, phone, totalprice);
        db.insertCustomerOrder(co);
        
        db.insertCustomerPizzas(customer_order_id, pizza_order_id);
        request.getRequestDispatcher("../view/pizza/notify.jsp").forward(request, response);
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
