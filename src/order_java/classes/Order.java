package order_java.classes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class Order{
    private int orderID=001;
    private int numofShirts;
    private Apparel[] shirts;
    private LocalDateTime DateTime;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    
    public Order (int orderID, int numofShirts, Apparel[] shirts, LocalDateTime DateTime)
    {
       this.orderID=orderID;
       this.numofShirts=numofShirts;
       this.shirts=shirts;
       this.DateTime=LocalDateTime.now();
       orderID++;
    }

    public int getorderId()
    {
        return orderID;
    }
    public int getnumofShirts() 
    {
        return numofShirts; 
    }
    public String getDateTime()
    {
        return dtf.format(DateTime);
    }

    public void setorderId()
    {
        this.orderID=orderID;
    }
    public void setnumofShirts() 
    {
        this.numofShirts=numofShirts; 
    }
    public void setDateTime()
    {
        this.DateTime=LocalDateTime.now();
    }

    public void addToCart(Apparel[] shirts)
    {
       this.shirts=shirts;
       this.numofShirts=numofShirts;
       
    }

    public void removeFromCart()
    {
        this.shirts=null;
        
    }

    public void showCart()
    {
       addToCart(shirts);
    }



}