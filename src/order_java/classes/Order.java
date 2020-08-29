package order_java.classes;

import java.util.*;

public class Order {
    private int orderID;
    private int numofShirts;
    private ArrayList<Apparel> shirts = new ArrayList<Apparel>();
    private Date date;
    private static int count=1; 

    public Order() {
        orderID = count + 100;
        count += 1;
        numofShirts = shirts.size();
        date = new Date();
    }

    public int getOrderID() {
        return this.orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getNumofShirts() {
        return this.numofShirts;
    }

    public void setNumofShirts(int numofShirts) {
        this.numofShirts = numofShirts;
    }

    public ArrayList<Apparel> getShirts() {
        return this.shirts;
    }

    public void setShirts(ArrayList<Apparel> shirts) {
        this.shirts = shirts;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void addShirtToOrder(Apparel a) {
        boolean isAdded = false;
        for (Apparel x : shirts) {
            if (x.equals(a)) {
                x.setQuantity(a.getQuantity());
                isAdded = true;
            }
            if (isAdded == true)
                break;
        }
        if (isAdded == false)
            shirts.add(a);
            numofShirts+=1;
    }

    public void removeShirtFromOrder(Apparel a){
        for(Apparel x:shirts) {
            if(x.equals(a)){
                x.decreaseTotalSold();
                shirts.remove(x);
                numofShirts-=1;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "{" +
            " orderID='" + orderID + "'" +
            ", numofShirts='" + numofShirts + "'" +
            ", shirts='" + shirts + "'" +
            ", date='" + date + "'" +
            "}";
    }
 
}