package order_java.classes;

import java.util.ArrayList;

public class Log {
    public static Log log;
    private ArrayList<Order> orders = new ArrayList<Order>();

    public Log() {
    }

    public void cloneToOrders(Order order) throws CloneNotSupportedException {
        orders.add((Order) order.clone());
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

}