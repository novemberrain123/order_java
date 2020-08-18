package order_java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiscFunctions {
    // Stores all pages
    static JPanel masterCards = new JPanel(new CardLayout());

    public static void generateDefaultFrame() {
        JFrame frame = new JFrame("Custom T-Shirt Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        //for testing change function

        HomePage.createHome();  // “Hompage"
        PageMemberLogin.createPageMember(); // "MemberLogin", pass=12345oop , name=limjunshen,ganyihwee,johnwick
        PageMarket.createPageMarket();  //"Market"
        PageMarket.createPageBrowse(); //"Browse"
        PagePayMethod.createPagePayMethod(); //"Pay Method"
        PageMembership.createPageMembership(); //"Membership"
        PageCardPayment.createPageCardPayment();//"Card Payment"
        PageCashPayment.createPageCashPayment();//"Cash Payment"
        PageReceipt.createPageReceipt(); // "Receipt"
        PageStaffLogin.createPageStaffLogin(); // "StaffLogin", pass=12345fat
        PageReport.createPageReport(); // "Reports"
        PageCart.createPageCart();  // "Cart"
         
        // PageMarket.createPageBrowse();
        frame.getContentPane().add(MiscFunctions.masterCards);
        frame.setVisible(true);
    }

    public static void addCardtoMasterCards(JPanel card, String s) {
        masterCards.add(card, s);
    }

    public static void addDefaultComponentsToPane(JPanel pane, String s, int c) {
        JPanel topPane = new JPanel();
        topPane.setLayout(new BoxLayout(topPane, BoxLayout.X_AXIS));
        ImageIcon logo = new ImageIcon("img/mindnew.png");
        Image image = logo.getImage(); // Resize Image
        Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        logo = new ImageIcon(newimg); // transform it back
        JLabel logoLabel = new JLabel("");
        logoLabel.setFont(new Font("", Font.PLAIN, 20)); // Set font style and size
        logoLabel.setIcon(logo);
        topPane.add(logoLabel);
        topPane.add(Box.createHorizontalGlue());

        // Set cart button
        if (c == 1) {
            JButton btnCart = new JButton("");
            btnCart.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                    cl.show(MiscFunctions.masterCards,"Cart");
                }
            });
            ImageIcon cart = new ImageIcon("img/cart.png");
            image = cart.getImage(); // Resize Image
            newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            cart = new ImageIcon(newimg);
            btnCart.setIcon(cart);
            topPane.add(btnCart);
        }
        // PAGE_END add Back button
        JPanel btmPane = new JPanel();
        btmPane.setLayout(new BoxLayout(btmPane, BoxLayout.X_AXIS));
        JButton btnBack = new JButton("");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards, s);
            }
        });

        btnBack.setPreferredSize(new Dimension(35, 35));
        ImageIcon back = new ImageIcon("img/back.png");
        image = back.getImage(); // Resize Image
        newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        back = new ImageIcon(newimg);
        btnBack.setIcon(back);
        btmPane.add(btnBack);

        // Adding to the panel
        pane.add(btmPane, BorderLayout.PAGE_END);
        pane.add(topPane, BorderLayout.PAGE_START);
    }
}