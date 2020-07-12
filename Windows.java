package order_java;

import java.awt.*;
import javax.swing.*;

public class Windows {
    public static void addComponentsToHomePane(Container pane){
        //Refer to https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        //Declaring and linking logo and its label
        ImageIcon logo = new ImageIcon("img/mindnew.png");
        Image image = logo.getImage(); //Resize Image
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        logo = new ImageIcon(newimg);  // transform it back
        JLabel logoLabel = new JLabel ("Supermind T-Shirts");
        logoLabel.setFont(new Font("",Font.PLAIN,22)); //Set font style and size
        logoLabel.setIcon(logo);
        //Adding to the panel
        pane.add(logoLabel, BorderLayout.PAGE_START);

        //Nested FlowLayout Panel in main pane, refer to https://docs.oracle.com/javase/tutorial/uiswing/layout/flow.html
        JPanel midPanel = new JPanel();
        //Adding buttons to pane
        JButton button1 = new JButton("Staff Member");
        button1.setPreferredSize(new Dimension(150,40));
        JButton button2 = new JButton("Customer");
        button2.setPreferredSize(new Dimension(150,40));
        midPanel.add(button1);
        midPanel.add(new JLabel("or"));
        midPanel.add(button2);
        //Adding nested panel to main pane
        pane.add(midPanel,BorderLayout.CENTER);


    }
    public static void addComponentsToPane(Container pane){
        ImageIcon logo = new ImageIcon("img/mindnew.png");
        Image image = logo.getImage(); //Resize Image
        Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        logo = new ImageIcon(newimg);  // transform it back
        JLabel logoLabel = new JLabel ("");
        logoLabel.setFont(new Font("",Font.PLAIN,20)); //Set font style and size
        logoLabel.setIcon(logo);
        //Set cart button
        JButton btnCart = new JButton("");
        ImageIcon cart = new ImageIcon("img/cart.png");
        image = cart.getImage(); //Resize Image
        newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        cart = new ImageIcon(newimg);
        btnCart.setIcon(cart);
        //PAGE_START
        JPanel topPane=new JPanel();
        topPane.setLayout(new BoxLayout(topPane,BoxLayout.X_AXIS));
        topPane.add(logoLabel);
        topPane.add(Box.createHorizontalGlue());
        topPane.add(btnCart);
        //PAGE_END add Back button
        JPanel btmPane=new JPanel();
        btmPane.setLayout(new BoxLayout(btmPane,BoxLayout.X_AXIS));
        JButton btnBack = new JButton("");
        btnBack.setPreferredSize(new Dimension(35,35));
        ImageIcon back = new ImageIcon("img/back.png");
        image = back.getImage(); //Resize Image
        newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        back = new ImageIcon(newimg);
        btnBack.setIcon(back);
        btmPane.add(btnBack);

        //Adding to the panel
        pane.add(btmPane , BorderLayout.PAGE_END);
        pane.add(topPane, BorderLayout.PAGE_START);
    }
    public static void createShowGUI(int n){
        //Set new frame
        JFrame frame = new JFrame("Custom T-Shirt Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        if (n==1) addComponentsToHomePane(frame.getContentPane()); //adding the panels
        else addComponentsToPane(frame.getContentPane());

        }
}