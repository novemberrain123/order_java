package order_java.GUI;

import java.awt.*;
import javax.swing.*;
import order_java.classes.*;
import java.awt.event.*;
import java.io.*;

public class PagePayMethod {
    public static PagePayMethod ppm;

	// Check if member is going to redeem points
    public static void checkRedeemPoints(Customer user, PaymentCalc paymentCalc){
        if (((Member)user).getPoints() >= 1500){ // Member accumulated points more than or equal to 1500
            Object[] points1 = {"500(3%)", "1000(7%)", "1500(12%)", "Cancel"};
            int option1 = JOptionPane.showOptionDialog(null, "You have " + ((Member)user).getPoints() + " points.\nDo you want to redeem them for discount ?\nPoints :", "Redeem points", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, points1, points1[0]);
            if (option1 == 3) // Cancel button is clicked
                ((MemberPayment)paymentCalc).calculateDiscountAmount();
            else {
                ((Member)user).redeemPoints(option1);
                ((MemberPayment)paymentCalc).setIsRedeemPoints(true);
                ((MemberPayment)paymentCalc).setPointsRedeemed(option1);
                ((MemberPayment)paymentCalc).calculateDiscountAmount(option1);
            }
        }
        else if (((Member)user).getPoints() >= 1000){ // Member accumulated points more than or equal to 1000
            Object[] points2 = {"500(3%)", "1000(7%)", "Cancel"};
            int option2 = JOptionPane.showOptionDialog(null, "You have " + ((Member)user).getPoints() + " points.\nDo you want to redeem them for discount ?\nPoints :", "Redeem points", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, points2, points2[0]);
            if (option2 == 2) // Cancel button is clicked
                ((MemberPayment)paymentCalc).calculateDiscountAmount();
            else {
                ((Member)user).redeemPoints(option2);
                ((MemberPayment)paymentCalc).setIsRedeemPoints(true);
                ((MemberPayment)paymentCalc).setPointsRedeemed(option2);
                ((MemberPayment)paymentCalc).calculateDiscountAmount(option2);
            }
        }
        else if (((Member)user).getPoints() >= 500){ // Member accumulated points more than or equal to 500
            Object[] points3 = {"500(3%)", "Cancel"};
            int option3 = JOptionPane.showOptionDialog(null, "You have " + ((Member)user).getPoints() + " points.\nDo you want to redeem them for discount ?\nPoints :", "Redeem points", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, points3, points3[0]);
            if (option3 == 1) // Cancel button is clicked
                ((MemberPayment)paymentCalc).calculateDiscountAmount();
            else {
                ((Member)user).redeemPoints(option3);
                ((MemberPayment)paymentCalc).setIsRedeemPoints(true);
                ((MemberPayment)paymentCalc).setPointsRedeemed(option3);
                ((MemberPayment)paymentCalc).calculateDiscountAmount(option3);
            }
        }
        else 
            ((MemberPayment)paymentCalc).calculateDiscountAmount(); // Member points below 500

        try { // Update member points in text file
            ((Member)user).updatePoints();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        paymentCalc.calculateAdjTotal();
    }

    // Check for lucky letter matching
    public static void checkLuckyLetter(Customer user, PaymentCalc paymentCalc, String luckyLetter){
        if (luckyLetter == "Ignore") { // Text field for lucky letter left blank
            if (user instanceof Member)
                checkRedeemPoints(user, paymentCalc);
            else
                paymentCalc.calculateAdjTotal();
            CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
            PagePaymentDetails.ppd = new PagePaymentDetails(); // "Payment Details"
            cl.show(MiscFunctions.masterCards, "Payment Details"); 
        }
        else {
            if (user instanceof Member){
                checkRedeemPoints(user, paymentCalc);
                CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                PagePaymentDetails.ppd = new PagePaymentDetails(); // "Payment Details"
                cl.show(MiscFunctions.masterCards, "Payment Details");
            }
            else {
                if (luckyLetter.length() > 1) // Lucky letter more than one character
                    JOptionPane.showMessageDialog(null, "Lucky letter can only be one character.\nPlease try again.", "Invalid lucky letter", JOptionPane.ERROR_MESSAGE);
                else {
                    ((CustomerPayment)paymentCalc).setLuckyLetter(luckyLetter.charAt(0));
                    if (Character.isLetter(((CustomerPayment)paymentCalc).getLuckyLetter()) == true){
                        if (((CustomerPayment)paymentCalc).matchLuckyLetter()){ // Lucky letter is matched
                            JOptionPane.showMessageDialog(null, "Your lucky letter is matched.\nYou are given a 5% discount for your purchase.\nHave a nice day!", "Congratulation!", JOptionPane.INFORMATION_MESSAGE);
                            ((CustomerPayment)paymentCalc).calculateDiscountAmount();
                        }
                        else // Lucky letter is not matched
                            JOptionPane.showMessageDialog(null, "Your lucky letter is not matched.\nIt's okay. Try again next time :) !", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                        paymentCalc.calculateAdjTotal();
                        CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                        PagePaymentDetails.ppd = new PagePaymentDetails(); // "Payment Details"
                        cl.show(MiscFunctions.masterCards, "Payment Details");
                    }
                    else // Lucky letter is not letter
                        JOptionPane.showMessageDialog(null, "Lucky letter entered is not a letter.\nPlease try again", "Invalid Lucky letter", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public PagePayMethod(){
        Customer user = Customer.getCustomer(); // Local variable to get user static var
        if (user instanceof Member && (Member.getNextMemberID() - 1) != ((Member)user).getMemberID()){ // Reg Mem
            MemberPayment.createMemberPayment(); 
        }
        else if (!(user instanceof Member)){ // Customer
            CustomerPayment.createCustomerPayment();
        }
        PaymentCalc paymentCalc = PaymentCalc.getPaymentCalc(); // Local variable to get paymentCalc static var

        JPanel pane = new JPanel(new BorderLayout()); // Main panel 
        Font wordFont = new Font("", Font.PLAIN, 15); // Normal word font
        Font importantWordFont = new Font ("", Font.BOLD, 13); // Important word font
        
        // Create card and cash button
        ImageIcon cardIcon = new ImageIcon("img/cardIcon.png");
        cardIcon = new ImageIcon(MiscFunctions.rescaleImage(cardIcon, 135, 135, 4));
        JButton cardButton = new JButton("By Card", cardIcon);
        ImageIcon cashIcon = new ImageIcon("img/cashIcon.png");
        cashIcon = new ImageIcon(MiscFunctions.rescaleImage(cashIcon, 135, 135, 4));
        JButton cashButton = new JButton("By Cash", cashIcon);

        // Set font and color for card and cash button
        cardButton.setFont(importantWordFont);
        cardButton.setForeground(Color.red);
        cashButton.setFont(importantWordFont);
        cashButton.setForeground(Color.red);

        // Set alignment and position for icon and text
        cardButton.setHorizontalAlignment(SwingConstants.CENTER);
        cardButton.setHorizontalTextPosition(SwingConstants.LEFT);
        cashButton.setHorizontalAlignment(SwingConstants.CENTER);
        cashButton.setHorizontalTextPosition(SwingConstants.LEFT);
        
        // Add the two buttons to payment method panel
        JPanel payMethodPane = new JPanel(new GridLayout(1,2,20,0)); // Panel to store card and cash button
        payMethodPane.add(cardButton);
        payMethodPane.add(cashButton);

        // Text area and text field for lucky letter for raffle
        JTextArea taLuckyLetter = new JTextArea("Enter a lucky letter and stand a chance to get 5% discount" + " (Only eligible for customer without membership) : ", 2, 33);
        taLuckyLetter.setFont(wordFont);
        taLuckyLetter.setLineWrap(true);
        taLuckyLetter.setOpaque(false);
        taLuckyLetter.setEditable(false);
        JTextField tfLuckyLetter = new JTextField(1);
        tfLuckyLetter.setFont(wordFont);

        // Add both text area and text field to lucky letter panel
        JPanel luckyLetterEnter = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)); 
        luckyLetterEnter.add(taLuckyLetter);
        luckyLetterEnter.add(tfLuckyLetter);

        // Add lucky letter and payment method panel into middle panel
        JPanel midPane = new JPanel(new BorderLayout());
        midPane.add(luckyLetterEnter, BorderLayout.PAGE_START);
        midPane.add(payMethodPane, BorderLayout.CENTER);

        // Add action listener to buttons
        cardButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                paymentCalc.calculateRawTotal();
                if (user instanceof Member)
                    ((Member)user).addPoints(paymentCalc.getRawTotal()); // Add member points
                String luckyLetter = tfLuckyLetter.getText();
                if (luckyLetter == null || luckyLetter.trim().isEmpty())
                    luckyLetter = "Ignore";
                paymentCalc.setPayMethod("Card"); // Set pay method to card
                checkLuckyLetter(user, paymentCalc, luckyLetter); // Check for matching of lucky letter
            }
        });
        cashButton.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                paymentCalc.calculateRawTotal();
                if (user instanceof Member)
                    ((Member)user).addPoints(paymentCalc.getRawTotal()); // Add member points
                String luckyLetter = tfLuckyLetter.getText();
                if (luckyLetter == null || luckyLetter.trim().isEmpty())
                    luckyLetter = "Ignore";
                paymentCalc.setPayMethod("Cash"); // Set pay method to cash
                checkLuckyLetter(user, paymentCalc, luckyLetter); // Check for matching of lucky letter
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
        JButton btnSignUp = new JButton("Sign Up"); // Sign up button
        btnSignUp.setFont(importantWordFont);
        btnSignUp.setForeground(Color.red);
        btnSignUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (user instanceof Member){
                    JOptionPane.showMessageDialog(null, "Member cannot sign up again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                    PageMembership.pm = new PageMembership();//"Membership"
                    cl.show(MiscFunctions.masterCards,"Membership");
                }
            }
        });
        JPanel bottomPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        bottomPane.add(lbBottom);
        bottomPane.add(btnSignUp);

        // Add title panel, bottom panel and middle panel to main panel
        pane.add(titlePane, BorderLayout.PAGE_START);
        pane.add(bottomPane, BorderLayout.PAGE_END);
        pane.add(midPane, BorderLayout.CENTER);
        
        // Add to master cards panel
        MiscFunctions.addCardtoMasterCards(pane, "Pay Method");
    }
}