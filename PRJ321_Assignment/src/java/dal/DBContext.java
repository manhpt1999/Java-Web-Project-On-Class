/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.CustomerAccount;
import model.CustomerOrder;
import model.Drink;
import model.Pizza;
import model.PizzaOrderCustomer;
import model.PizzaOrderHistory;
import model.Size;
import model.Topping;

/**
 *
 * @author sonnt
 */
public class DBContext {

    Connection connection;

    public DBContext() {
        try {
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://DESKTOP-0T2CP3K:1433;databaseName=PizzaOrder";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Pizza> getAllPizzas() {
        String sql = "SELECT * from pizzas";
        ArrayList<Pizza> pizzas = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Pizza p = new Pizza();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getString("price"));

                byte[] raw_img = rs.getBytes("pizza_image");
                String img_base64 = Base64.encode(raw_img);
                p.setImage(img_base64);
                p.setDetails(rs.getString("details"));
                pizzas.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pizzas;
    }

    public ArrayList<Topping> getAllToppings() {
        String sql = "SELECT * from toppings";
        ArrayList<Topping> toppings = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Topping t = new Topping();
                t.setTopping(rs.getString("name"));
                toppings.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return toppings;
    }

    public ArrayList<Size> getAllSizes() {
        String sql = "SELECT * from sizes";
        ArrayList<Size> sizes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Size s = new Size();
                s.setSize(rs.getString("name"));
                s.setTimePrice(rs.getString("price"));
                sizes.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sizes;
    }

    public int count() {
        String sql = "SELECT COUNT(*) as totalrow FROM pizzas";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("totalrow");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Pizza> paging(int pageindex, int pagesize) {
        String sql = "SELECT id, name, price, pizza_image, details \n"
                + "FROM\n"
                + "(SELECT ROW_NUMBER() OVER (ORDER BY id ASC) as rownum, id, name, price, pizza_image, details FROM pizzas) tblpizzas\n"
                + "                WHERE rownum >= (?-1)*? +1 AND rownum <= ?*?";
        ArrayList<Pizza> pizzas = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pageindex);
            statement.setInt(2, pagesize);
            statement.setInt(3, pageindex);
            statement.setInt(4, pagesize);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Pizza p = new Pizza();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getString("price"));

                byte[] raw_img = rs.getBytes("pizza_image");
                String img_base64 = Base64.encode(raw_img);
                p.setImage(img_base64);
                p.setDetails(rs.getString("details"));
                pizzas.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pizzas;
    }

    public ArrayList<Drink> getAllDrinks() {
        String sql = "SELECT * from drinks";
        ArrayList<Drink> drinks = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Drink d = new Drink();
                d.setName(rs.getString("name"));
                d.setPrice(rs.getString("price"));

                byte[] raw_img = rs.getBytes("drink_image");
                String img_base64 = Base64.encode(raw_img);
                d.setImage(img_base64);
                d.setDetails(rs.getString("drink_details"));
                drinks.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return drinks;
    }

    public void insertCustomerAccount(CustomerAccount ca) {
        try {
            String sql = "INSERT INTO [customer_account]\n"
                    + "           ([id]\n"
                    + "           ,[name]\n"
                    + "           ,[email]\n"
                    + "           ,[password]\n"
                    + "           ,[gender]"
                    + "           ,[phone])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ca.getId());
            statement.setString(2, ca.getName());
            statement.setString(3, ca.getEmail());
            statement.setString(4, ca.getPassword());
            statement.setBoolean(5, ca.isGender());
            statement.setString(6, ca.getPhone());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public CustomerAccount getByEmailAndPassword(String email, String password) {
        String sql = "select id, email, password, name, phone, gender from customer_account";
        ArrayList<CustomerAccount> accs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                CustomerAccount a = new CustomerAccount();
                a.setId(rs.getString("id"));
                a.setEmail(rs.getString("email"));
                a.setPassword(rs.getString("password"));
                a.setName(rs.getString("name"));
                a.setPhone(rs.getString("phone"));
                a.setGender(rs.getBoolean("gender"));
                accs.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (CustomerAccount acc : accs) {
            if (email.equals(acc.getEmail()) && password.equals(acc.getPassword())) {
                CustomerAccount account = new CustomerAccount();
                account.setEmail(email);
                account.setPassword(password);
                account.setName(acc.getName());
                account.setId(acc.getId());
                account.setPhone(acc.getPhone());
                account.setGender(acc.isGender());
                return account;
            }
        }

        return null;
    }

    public ArrayList<PizzaOrderHistory> getPizzaOrderByCustomerID(String id) {
        String sql = "select p.name as pizzaname, p.pizza_image as image, po.size as size, po.totalprice as price\n"
                + "                from customer_pizzas cp, pizzas_order po, pizzas p, customer_order co\n"
                + "                where cp.customer_order_id = co.id\n"
                + "                and cp.pizza_order_id = po.id\n"
                + "                and po.pizza_id = p.id\n"
                + "                and co.customer_id = " + id;

        ArrayList<PizzaOrderHistory> pizzas = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PizzaOrderHistory po = new PizzaOrderHistory();

                byte[] raw_img = rs.getBytes("image");
                String img_base64 = Base64.encode(raw_img);
                po.setName(rs.getString("pizzaname"));
                po.setImage(img_base64);
                po.setSize(rs.getString("size"));
                po.setPrice(rs.getString("price"));

                pizzas.add(po);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pizzas;
    }

    public void update(CustomerAccount ca) {
        try {
            String sql = "UPDATE [PizzaOrder].[dbo].[customer_account]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[phone] = ?\n"
                    + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ca.getName());
            statement.setBoolean(2, ca.isGender());
            statement.setString(3, ca.getPhone());
            statement.setString(4, ca.getId());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Pizza getPizzaByID(String id) {
        String sql = "SELECT * from pizzas where id = '" + id + "'";
        Pizza p = new Pizza();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getString("price"));
                byte[] raw_img = rs.getBytes("pizza_image");
                String img_base64 = Base64.encode(raw_img);
                p.setImage(img_base64);
                p.setDetails(rs.getString("details"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    public String getMaxIDCustomerOrder() {
        String sql = "select MAX(id) as maxid\n"
                + "  from customer_order";
        String id = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                id = rs.getString("maxid");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public String getMaxIDPizzaOrder() {
        String sql = "select MAX(id) as maxid\n"
                + "  from pizzas_order";
        String id = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                id = rs.getString("maxid");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public String getPriceBySize(String size) {

        String sql = "select price\n"
                + "  from sizes"
                + "where name = '" + "L" + "'";
        String price = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                price = rs.getString("price");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }

    public void insertPizzaOrder(PizzaOrderCustomer p) {
        try {
            String sql = "INSERT INTO [pizzas_order]\n"
                    + "([id],[pizza_id],[size],[topping_1],[topping_2],[totalprice])\n"
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getId());
            statement.setString(2, p.getPizza_id());
            statement.setString(3, p.getSize());
            statement.setString(4, p.getTopping1());
            statement.setString(5, p.getTopping2());
            statement.setString(6, p.getPrice());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertCustomerOrder(CustomerOrder p) {
        try {
            String sql = " INSERT INTO [customer_order]\n"
                    + "                             ([id]\n"
                    + "                               ,[customer_id]\n"
                    + "                             ,[phone]\n"
                    + "                               ,[total_price])\n"
                    + "                         VALUES\n"
                    + "                               (?\n"
                    + "                             ,?\n"
                    + "                              ,?\n"
                    + "                            ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getId());
            statement.setString(2, p.getC_id());
            statement.setString(3, p.getPhone());
            statement.setString(4, p.getTotalprice());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertCustomerPizzas(String c_id, String p_id) {
        try {
            String sql = "INSERT INTO [customer_pizzas]\n"
                    + "                             ([customer_order_id]\n"
                    + "                               ,[pizza_order_id])\n"
                    + "                         VALUES\n"
                    + "                               (?\n"
                    + "                            ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c_id);
            statement.setString(2, p_id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertCustomer(Customer p) {
        try {
            String sql = "INSERT INTO [customer]\n"
                    + "([id],[name],[address],[phone])\n"
                    + " VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getId());
            statement.setString(2, p.getName());
            statement.setString(3, p.getAddress());
            statement.setString(4, p.getPhone());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public ArrayList<Pizza> pizzasFilter(String name, String price, String recipe) {
        String sql = "select * from pizzas where name like '%%'";
        if(name.equals("") && price.equals("") && recipe.equals("")){
            return paging(1, 4);
        }else {
            if(!name.equals("")){
                sql = "select * from pizzas where name like '%"+ name +"%'";
            }
            if(!price.equals("")){
                sql += "and price like '%"+ price +"%'";
            }
            if(!recipe.equals("")){
                sql += "and details like '%"+ recipe +"%'";
            }
        }
        
        
        ArrayList<Pizza> pizzas = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Pizza p = new Pizza();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getString("price"));

                byte[] raw_img = rs.getBytes("pizza_image");
                String img_base64 = Base64.encode(raw_img);
                p.setImage(img_base64);
                p.setDetails(rs.getString("details"));
                pizzas.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pizzas;
    }

}
