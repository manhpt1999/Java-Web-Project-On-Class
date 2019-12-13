/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class PizzaOrderCustomer {

    private String id;
    private String size;
    private String pizza_id;
    private String topping1;
    private String topping2;
    private String price;

    public PizzaOrderCustomer() {
    }

    public PizzaOrderCustomer(String id, String pizza_id, String size, String topping1, String topping2, String price) {
        this.id = id;
        this.pizza_id = pizza_id;
        this.size = size;
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPizza_id() {
        return pizza_id;
    }

    public void setPizza_id(String pizza_id) {
        this.pizza_id = pizza_id;
    }

    public String getTopping1() {
        return topping1;
    }

    public void setTopping1(String topping1) {
        this.topping1 = topping1;
    }

    public String getTopping2() {
        return topping2;
    }

    public void setTopping2(String topping2) {
        this.topping2 = topping2;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PizzaOrderCustomer{" + "id=" + id + ", size=" + size + ", pizza_id=" + pizza_id + ", topping1=" + topping1 + ", topping2=" + topping2 + ", price=" + price + '}';
    }

}
