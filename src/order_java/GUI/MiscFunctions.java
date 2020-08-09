package order_java.GUI;

import javax.swing.*;
import java.awt.*;

public class MiscFunctions {
    public static JFrame generateDefaultFrame() {
        JFrame frame = new JFrame("Custom T-Shirt Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        return frame;
    }

    public static void addDefaultComponentsToPane(Container pane) {
        ImageIcon logo = new ImageIcon("img/mindnew.png");
        Image image = logo.getImage(); // Resize Image
        Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        logo = new ImageIcon(newimg); // transform it back
        JLabel logoLabel = new JLabel("");
        logoLabel.setFont(new Font("", Font.PLAIN, 20)); // Set font style and size
        logoLabel.setIcon(logo);
        // Set cart button
        JButton btnCart = new JButton("");
        ImageIcon cart = new ImageIcon("img/cart.png");
        image = cart.getImage(); // Resize Image
        newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        cart = new ImageIcon(newimg);
        btnCart.setIcon(cart);
        // PAGE_START
        JPanel topPane = new JPanel();
        topPane.setLayout(new BoxLayout(topPane, BoxLayout.X_AXIS));
        topPane.add(logoLabel);
        topPane.add(Box.createHorizontalGlue());
        topPane.add(btnCart);
        // PAGE_END add Back button
        JPanel btmPane = new JPanel();
        btmPane.setLayout(new BoxLayout(btmPane, BoxLayout.X_AXIS));
        JButton btnBack = new JButton("");
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