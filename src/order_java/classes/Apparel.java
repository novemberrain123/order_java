package order_java.classes;
import java.awt.image.*;
public class Apparel{
    private String size;
    private double price;
    char bgColor;
    BufferedImage shirtImg;
    int quantity;
    
    static int totalSold[][];
    static double prices[][];
<<<<<<< HEAD
=======

    public Apparel() {
    }

    public Apparel(String size, double price, char bgColor, BufferedImage shirtImg, int quantity) {
        this.size = size;
        this.price = price;
        this.bgColor = bgColor;
        this.shirtImg = shirtImg;
        this.quantity = quantity;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
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

    public BufferedImage getShirtImg() {
        return this.shirtImg;
    }

    public void setShirtImg(BufferedImage shirtImg) {
        this.shirtImg = shirtImg;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Apparel size(String size) {
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

    public Apparel shirtImg(BufferedImage shirtImg) {
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

    

>>>>>>> john
}