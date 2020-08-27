package order_java.classes;
import java.awt.image.*;
import java.util.*;

import javax.swing.*;
public class Apparel{
    private char size;
    private double price;
    char bgColor;
    ImageIcon shirtImg;
    int quantity;
    public static ArrayList<Apparel> apparelsInOrder = new ArrayList<Apparel>();    
    static int totalSold[][];
    static double prices[][];

    public Apparel() {
    }

    public Apparel(char size, char bgColor, ImageIcon shirtImg, int quantity) {
        this.size = size;
        this.bgColor = bgColor;
        this.shirtImg = shirtImg;
        this.quantity = quantity;
    }

    public char getSize(){
        return this.size;
    }
    public void setSize(char size) {
        this.size = size;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getBgColor() {
        return this.bgColor;
    }

    public void setBgColor(char bgColor) {
        this.bgColor = bgColor;
    }

    public ImageIcon getShirtImg() {
        return this.shirtImg;
    }

    public void setShirtImg(ImageIcon shirtImg) {
        this.shirtImg = shirtImg;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Apparel size(char size) {
        this.size = size;
        return this;
    }

    public Apparel price(double price) {
        this.price = price;
        return this;
    }

    public Apparel bgColor(char bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public Apparel shirtImg(ImageIcon shirtImg) {
        this.shirtImg = shirtImg;
        return this;
    }

    public Apparel quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " size='" + getSize() + "'" +
            ", price='" + getPrice() + "'" +
            ", bgColor='" + getBgColor() + "'" +
            ", shirtImg='" + getShirtImg() + "'" +
            ", quantity='" + getQuantity() + "'" +
            "}";
    }

    

}