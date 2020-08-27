package order_java;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import order_java.GUI.*;
import order_java.classes.*;
public class Main{

    public static void main(String args[]) throws IOException{
        // BufferedImage img = ImageIO.read(new File("img/browse90.png"));
        // BufferedImage img2 = new BufferedImage(300,300,img.getType());
        // Graphics g=img2.createGraphics();
        // g.drawImage(img, 0,0,300,300,null);
        // g.dispose();
        // ApparelType obj = new ApparelType("Hello", 20.00, 'H', img2);
        // obj.generatePane();
        // JFrame frame = new JFrame("Custom T-Shirt Shop");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(600,400);
        // frame.add(obj.pane);
        // frame.setVisible(true);
        MiscFunctions.generateDefaultFrame();
    }
}