/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pizza;

import controller.BaseAuthenticationController;
import dal.DBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CustomerAccount;
import model.PizzaOrderHistory;

/**
 *
 * @author Admin
 */
public class ViewAccountServlet extends BaseAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DBContext db = new DBContext();
        ArrayList<PizzaOrderHistory> pizzas_order = db.getPizzaOrderByCustomerID(id);
        request.setAttribute("pizzas_order", pizzas_order);
        request.getRequestDispatcher("../view/pizza/viewacc.jsp").forward(request, response);

    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
