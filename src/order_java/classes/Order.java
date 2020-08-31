package order_java.classes;

import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.Container;
//import jdk.internal.platform.Container;
import order_java.GUI.MiscFunctions;
import order_java.GUI.PageCart;
import order_java.classes.Apparel;
import order_java.classes.ApparelType;

import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.*;
import java.io.*;

public class Order {
    private int orderID;
    private int numofShirts;
    private static ArrayList<Apparel> shirts = new ArrayList<Apparel>();
    private Date date;
    private static int count = 1;
    public static JPanel Cartpane;
    public boolean visible = true;

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

    public Order Cartpane(JPanel Cartpane) {
        this.Cartpane = Cartpane;
        return this;
    }

    public void addShirtToOrder(Apparel a) {
        boolean isAdded = false;
        for (Apparel x : shirts) {
            if (x.equals(a)) {
                x.setQuantity(a.getQuantity());
                isAdded = true;
                PageCart.addToCart(x, PageCart.OLD_APPAREL);
            }
            if (isAdded == true)
                break;
        }
        if (isAdded == false) {
            shirts.add(a);
            numofShirts += 1;
            a.generateApparelPane();
            PageCart.addToCart(a, PageCart.NEW_APPAREL);
        }
       

    

    }

    public void removeShirtFromOrder(Apparel a) {  
        for (Apparel x : shirts) {
            if (x.equals(a)) {
                PageCart.removeFromCart(shirts.indexOf(x));
                x.decreaseTotalSold();
                shirts.remove(x);
                numofShirts -= 1;     
                break;
            }
            
        }
    }

    @Override
    public String toString() {
        return "{" + " orderID='" + orderID + "'" + ", numofShirts='" + numofShirts + "'" + ", shirts='" + shirts + "'"
                + ", date='" + date + "'" + "}";
    }

    public static Image rescaleImage(ImageIcon img, int x, int y, int s) {
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(x, y, s);
        return newimg;
    }



}