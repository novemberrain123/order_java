package order_java;

import java.awt.*;
import javax.swing.*;

public class PagePayMethod {
    public static Image rescaleImage(ImageIcon img,int x,int y,int s){
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(x, y, s);
        return newimg;
    }
    public static void addComponentsToPayMethodPane(Container pane){
        JPanel payMethodPane = new JPanel(new GridLayout(1,2,20,0)); // Create panel to store card and cash button
        Font wordFont = new Font("", Font.PLAIN, 15); // For setting word font purpose
        Font importantWordFont = new Font ("", Font.BOLD, 13); 
        
        // Create card and cash button
        ImageIcon cardIcon = new ImageIcon("img/cardIcon.png");
        cardIcon = new ImageIcon(rescaleImage(cardIcon, 135, 135, 4));
        JButton cardButton = new JButton("By Card", cardIcon);
        cardButton.setFont(importantWordFont);
        cardButton.setForeground(Color.red);
        ImageIcon cashIcon = new ImageIcon("img/cashIcon.png");
        cashIcon = new ImageIcon(rescaleImage(cashIcon, 135, 135, 4));
        JButton cashButton = new JButton("By Cash", cashIcon);
        cashButton.setFont(importantWordFont);
        cashButton.setForeground(Color.red);

        // Set alignment and position for icon and text
        cardButton.setHorizontalAlignment(SwingConstants.CENTER);
        cardButton.setHorizontalTextPosition(SwingConstants.LEFT);
        cashButton.setHorizontalAlignment(SwingConstants.CENTER);
        cashButton.setHorizontalTextPosition(SwingConstants.LEFT);

        // Add button to payment method panel
        payMethodPane.add(cardButton);
        payMethodPane.add(cashButton);

        // Create panel at the center of middle of main panel 
        JPanel midPaneCenter = new JPanel(new BorderLayout());
        JPanel codeEnter = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)); // To store discount code info
        JLabel lbCode = new JLabel("Enter code for discount (Not necessary) : ");
        lbCode.setFont(wordFont);
        JTextField tfCode = new JTextField(5);
        tfCode.setFont(wordFont);
        codeEnter.add(lbCode);
        codeEnter.add(tfCode);

        // Add code and payment method panel into midPaneCenter panel
        midPaneCenter.add(codeEnter, BorderLayout.PAGE_START);
        midPaneCenter.add(payMethodPane, BorderLayout.CENTER);

        // Title panel
        JLabel lbTitle = new JLabel("Payment Method");
        lbTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        JPanel titlePane = new JPanel(new FlowLayout());
        titlePane.add(lbTitle);

        // Bottom panel 
        JLabel lbBottom = new JLabel("Not a member? Sign up now for more priviledges!");
        lbBottom.setFont(wordFont);
        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(importantWordFont);
        btnSignUp.setForeground(Color.red);
        JPanel bottomPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        bottomPane.add(lbBottom);
        bottomPane.add(btnSignUp);

        // Add title panel, bottom panel and midPaneCenter to the middle of main panel
        JPanel midPane = new JPanel(new BorderLayout());
        midPane.add(titlePane, BorderLayout.PAGE_START);
        midPane.add(bottomPane, BorderLayout.PAGE_END);
        midPane.add(midPaneCenter, BorderLayout.CENTER);
        
        // Add to center of main panel
        pane.add(midPane, BorderLayout.CENTER);
    }
}