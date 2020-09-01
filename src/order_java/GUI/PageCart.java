package order_java.GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import order_java.classes.Apparel;
import order_java.classes.ApparelType;
import order_java.classes.Customer;
import order_java.classes.Order;

import java.awt.event.*;
import java.util.ArrayList;

public class PageCart extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -2575850135525617539L;

    public static Image rescaleImage(ImageIcon img, int x, int y, int s) {
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(x, y, s);
        return newimg;
    }

    public static JPanel newpanel = new JPanel();
    public static JPanel pane = new JPanel();
    public static ArrayList<JPanel> nested = new ArrayList<>();

    public static final int NEW_APPAREL = 0;
    public static final int OLD_APPAREL = 1;

    public static void createPageCart() {

        JFrame cartFrame = new JFrame("Cart");
        cartFrame.setSize(500, 500);
        cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cartFrame.setVisible(true);
        //
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
        //
        JScrollPane scrollpane = new JScrollPane(newpanel);
        scrollpane.setPreferredSize(new Dimension(350, 350));
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setVisible(true);
        //
        JPanel pane = new JPanel(new BorderLayout()); // the main panel to put inside cart
        pane.setVisible(true);
        JPanel midPane = new JPanel();
        midPane.setLayout(new BoxLayout(midPane, BoxLayout.Y_AXIS));
        JLabel cart1 = new JLabel("Your Cart");
        cart1.setFont(new Font("SansSerif", Font.BOLD, 18));
        midPane.add(cart1, BorderLayout.PAGE_START);

        midPane.add(scrollpane, BorderLayout.CENTER);
        midPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        // midPane.setMaximumSize(new Dimension(100, 700));
        pane.setVisible(true);
        pane.add(midPane, BorderLayout.CENTER);
        pane.add(topPane, BorderLayout.PAGE_START);
        //
        cartFrame.add(pane);

    }

    public static void addToCart(Apparel apparel, int t) {
        if (t == NEW_APPAREL) {
            JPanel apparelPane = apparel.getApparelPane();
            newpanel.add(apparelPane);

        } else {
            JPanel apparelPane = apparel.getApparelPane();
            JSpinner newspinner = (JSpinner) apparelPane.getComponent(3);
            newspinner.setValue(Integer.valueOf(apparel.getQuantity()));

        }

        newpanel.revalidate();
        newpanel.repaint();
    }

    public static void removeFromCart(int i) {
        newpanel.remove(i);
        newpanel.revalidate();
        newpanel.repaint();
    }

}
