package order_java.GUI;

import java.awt.*;
import javax.swing.*;

import order_java.classes.*;

import java.awt.event.*;

public class PagePayMethod {
    public static Image rescaleImage(ImageIcon img,int x,int y,int s){
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(x, y, s);
        return newimg;
    }

    public static void checkRedeemPoints(Customer user, PaymentCalc paymentCalc){
        if (((Member)user).getPoints() >= 1500){
            Object[] points1 = {"500(3%)", "1000(7%)", "1500(12%)", "Cancel"};
            int option1 = JOptionPane.showOptionDialog(null, "You have " + ((Member)user).getPoints() + " points.\nDo you want to redeem them for discount ?\nPoints :", "Redeem points", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, points1, points1[0]);
            if (option1 == 3)
                ((MemberPayment)paymentCalc).calculateDiscountAmount();
            else {
                ((Member)user).redeemPoints(option1);
                ((MemberPayment)paymentCalc).setIsRedeemPoints(true);
                ((MemberPayment)paymentCalc).setPointsRedeemed(option1);
                ((MemberPayment)paymentCalc).calculateDiscountAmount(option1);
            }
        }
        else if (((Member)user).getPoints() >= 1000){
            Object[] points2 = {"500(3%)", "1000(7%)", "Cancel"};
            int option2 = JOptionPane.showOptionDialog(null, "You have " + ((Member)user).getPoints() + " points.\nDo you want to redeem them for discount ?\nPoints :", "Redeem points", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, points2, points2[0]);
            if (option2 == 2)
                ((MemberPayment)paymentCalc).calculateDiscountAmount();
            else {
                ((Member)user).redeemPoints(option2);
                ((MemberPayment)paymentCalc).setIsRedeemPoints(true);
                ((MemberPayment)paymentCalc).setPointsRedeemed(option2);
                ((MemberPayment)paymentCalc).calculateDiscountAmount(option2);
            }
        }
        else if (((Member)user).getPoints() >= 500){
            Object[] points3 = {"500(3%)", "Cancel"};
            int option3 = JOptionPane.showOptionDialog(null, "You have " + ((Member)user).getPoints() + " points.\nDo you want to redeem them for discount ?\nPoints :", "Redeem points", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, points3, points3[0]);
            if (option3 == 1)
                ((MemberPayment)paymentCalc).calculateDiscountAmount();
            else {
                ((Member)user).redeemPoints(option3);
                ((MemberPayment)paymentCalc).setIsRedeemPoints(true);
                ((MemberPayment)paymentCalc).setPointsRedeemed(option3);
                ((MemberPayment)paymentCalc).calculateDiscountAmount(option3);
            }
        }
        paymentCalc.calculateAdjTotal();
    }

    public static void checkLuckyCharacter(Customer user, PaymentCalc paymentCalc, String luckyLetter){
        if (luckyLetter == "Ignore") {
            if (user instanceof Member)
                checkRedeemPoints(user, paymentCalc);
            else
                paymentCalc.calculateAdjTotal();
            CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
            cl.show(MiscFunctions.masterCards, "Payment Details"); 
        }
        else {
            if (user instanceof Member){
                checkRedeemPoints(user, paymentCalc);
                CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards, "Payment Details");
            }
            else {
                if (luckyLetter.length() > 1)
                    JOptionPane.showMessageDialog(null, "Lucky letter can only be one character.\nPlease try again.", "Invalid lucky letter", JOptionPane.ERROR_MESSAGE);
                else {
                    ((CustomerPayment)paymentCalc).setLuckyLetter(luckyLetter.charAt(0));
                    if (Character.isLetter(((CustomerPayment)paymentCalc).getLuckyLetter()) == true){
                        if (((CustomerPayment)paymentCalc).matchLuckyLetter()){
                            JOptionPane.showMessageDialog(null, "Your lucky letter is matched.\nYou are given a 5% discount for your purchase.\nHave a nice day!", "Congratulation!", JOptionPane.INFORMATION_MESSAGE);
                            ((CustomerPayment)paymentCalc).calculateDiscountAmount();
                            paymentCalc.calculateAdjTotal();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Your lucky letter is not matched.\nIt's okay. Try again next time :) !", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                        paymentCalc.calculateAdjTotal();
                        CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                        cl.show(MiscFunctions.masterCards, "Payment Details");
                    }
                    else 
                        JOptionPane.showMessageDialog(null, "Lucky letter entered is not a letter.\nPlease try again", "Invalid Lucky letter", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void createPagePayMethod(){
        // Customer user = new Customer(); // Demonstration purpose 
        // Customer user = new Member();
        // PaymentCalc paymentCalc = new MemberPayment();
        // PaymentCalc paymentCalc = new CustomerPayment(); // Demonstration purpose
        // paymentCalc.calculateRawTotal(prices, quantities); // Calculate raw total

        // Order order = new Order(); // Customer demo
        // Customer.createCustomer(order); // Customer demo
        Customer.createMember("Lim Jun Shen", 110, "ventusora219", 2234); // Member demo
        Customer user = Customer.getCustomer();
        
        if (user instanceof Member)
            PaymentCalc.createMemberPayment();
        else 
            PaymentCalc.createCustomerPayment();

        PaymentCalc paymentCalc = PaymentCalc.getPaymentCalc();
        paymentCalc.setRawTotal(2039); // Demo

        JPanel pane = new JPanel(new BorderLayout());
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
        JPanel luckyLetterEnter = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)); //To store discount code info
        JLabel lbLuckyLetter = new JLabel("Enter a lucky letter and stand a chance to get 5% discount (Only eligible for customer without membership) : ");
        lbLuckyLetter.setFont(wordFont);
        JTextField tfLuckyLetter = new JTextField(1);
        tfLuckyLetter.setFont(wordFont);
        luckyLetterEnter.add(lbLuckyLetter);
        luckyLetterEnter.add(tfLuckyLetter);

        // Add lucky letter and payment method panel into midPaneCenter panel
        midPaneCenter.add(luckyLetterEnter, BorderLayout.PAGE_START);
        midPaneCenter.add(payMethodPane, BorderLayout.CENTER);

        // Add action listener to buttons
        cardButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (user instanceof Member)
                    ((Member)user).addPoints(paymentCalc.getRawTotal());
                String luckyLetter = tfLuckyLetter.getText();
                if (luckyLetter == null || luckyLetter.trim().isEmpty())
                    luckyLetter = "Ignore";
                paymentCalc.setPayMethod("Card");
                checkLuckyCharacter(user, paymentCalc, luckyLetter); // Need change for same payment page
            }
        });
        cashButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (user instanceof Member)
                    ((Member)user).addPoints(paymentCalc.getRawTotal());
                String luckyLetter = tfLuckyLetter.getText();
                if (luckyLetter == null || luckyLetter.trim().isEmpty())
                    luckyLetter = "Ignore";
                paymentCalc.setPayMethod("Cash");
                checkLuckyCharacter(user, paymentCalc, luckyLetter); // Need change
            }
        });

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
        btnSignUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (user instanceof Member){
                    JOptionPane.showMessageDialog(null, "Member cannot sign up again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                    cl.show(MiscFunctions.masterCards,"Membership");
                }
            }
        });
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
        MiscFunctions.addCardtoMasterCards(pane, "Pay Method");
    }
}