package order_java.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import order_java.classes.Customer;
import order_java.classes.Order;

public class MiscFunctions {
    // Stores all pages
    public static JPanel masterCards = new JPanel(new CardLayout());
    public static JFrame frame;

    public static void generateDefaultFrame() throws IOException {
        frame = new JFrame("Custom T-Shirt Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // for testing change function

        Home.createHome(); // “Hompage"
        PageMemberLogin.createPageMember(); // "MemberLogin", pass=12345oop , name=limjunshen,ganyihwee,johnwick
        PageMarket.createPageMarket(); // "Market"
        PageMarket.createPageBrowse(); // "Browse"
        PageMarket.createPageCustom(); // "Custom"
        PagePayMethod.createPagePayMethod(); // "Pay Method"
        PageStaffLogin.createPageStaffLogin(); // "StaffLogin", pass=12345fat

        frame.getContentPane().add(MiscFunctions.masterCards);
        frame.setVisible(true);
        Customer.createCustomer(new Order());

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
            btnCart.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    PageCart.createPageCart();
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

    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
            throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
}