package order_java.classes;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Apparel extends ApparelType {
    private char size;
    private double price;
    private char bgColor;
    private ImageIcon shirtImg;
    private int quantity;
    public static int totalSold[][] = { { 0, 0, 0 }, { 0, 0, 0 } }; // [Shirt[S,M,L],Hoodie[S,M,L]]
    public final static double prices[][] = { { 15, 20, 25 }, { 17, 22, 27 } }; // [Shirt[S,M,L],Hoodie[S,M,L]

    public Apparel() {
    }

    public Apparel(String shirtName, char shirtType, BufferedImage img, char size, char bgColor, ImageIcon shirtImg,
            int quantity) throws IOException {
        super(shirtName, shirtType, img);
        this.size = size;
        this.bgColor = bgColor;
        this.shirtImg = shirtImg;
        this.quantity = quantity;
        setPriceAndIncrementTotalSold();
    }

    public void setPriceAndIncrementTotalSold() {
        switch (size) {// t-shirt:s,m,l:15,20,25 hoodie:17,22,27
            case 'S':
                switch (getShirtType()){
                    case 'S':
                        price = 15;
                        totalSold[0][0] += quantity;
                    case 'H':
                        price = 17;
                        totalSold[1][0] += quantity;
                }
            case 'M':
                switch (getShirtType()) {
                    case 'S':
                        price = 20;
                        totalSold[0][1] += quantity;
                    case 'H':
                        price = 22;
                        totalSold[1][1] += quantity;
                }
            case 'L':
                switch (getShirtType()){
                    case 'S':
                        price = 25;
                        totalSold[0][2] += quantity;
                    case 'H':
                        price = 27;
                        totalSold[1][2] += quantity;
                }
        }
    }

    public void decreaseTotalSold() {
        switch (size) {// t-shirt:s,m,l:15,20,25 hoodie:17,22,27
            case 'S':
                switch (this.getShirtType()) {
                    case 'S':
                        totalSold[0][0] -= quantity;
                    case 'H':
                        totalSold[1][0] -= quantity;
                }
            case 'M':
                switch (this.getShirtType()) {
                    case 'S':
                        totalSold[0][1] -= quantity;
                    case 'H':
                        totalSold[1][1] -= quantity;
                }
            case 'L':
                switch (this.getShirtType()) {
                    case 'S':
                        totalSold[0][2] -= quantity;
                    case 'H':
                        totalSold[1][2] -= quantity;
                }
        }
    }

    public char getSize() {
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

    public static int[][] getTotalSold() {
        return totalSold;
    }

    public static double[][] getPrices() {
        return prices;
    }

    @Override
    public boolean equals(Object o) {
        final Apparel other = (Apparel) o;
        if (this.size == other.size && this.bgColor == other.bgColor && this.shirtImg == other.shirtImg) {
            return true;
        } else
            return false;
    }

    @Override
    public String toString() {
        return "{" + " size='" + getSize() + "'" + ", price='" + getPrice() + "'" + ", bgColor='" + getBgColor() + "'"
                + ", shirtImg='" + getShirtImg() + "'" + ", quantity='" + getQuantity() + "'" + "}";
    }

}