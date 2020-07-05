package order_java;

import java.awt.*;
import javax.swing.*;

public class a{
    public static void addComponentsToPane(Container pane){
        //Refer to https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        //Declaring and linking logo and its label
        ImageIcon logo = new ImageIcon("mindnew.png");
        Image image = logo.getImage(); //Resize Image
        Image newimg = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        logo = new ImageIcon(newimg);  // transform it back
        JLabel logoLabel = new JLabel ("Supermind T-Shirts");
        logoLabel.setFont(new Font("",Font.PLAIN,20)); //Set font style and size
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
    private static void createShowGUI(){
        //Set new frame
        JFrame frame = new JFrame("Custom T-Shirt Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        addComponentsToPane(frame.getContentPane()); //adding the panels
        //Display the window.
        frame.setVisible(true);
        }
    public static void main(String args[]){
        createShowGUI();
    
     }
}