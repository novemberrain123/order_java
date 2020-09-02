package order_java.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import order_java.classes.Apparel;
import order_java.classes.Customer;
import order_java.classes.Log;

public class PageCart {

    public static PageCart pg;
	public JPanel newpanel = new JPanel();
    public JPanel pane = new JPanel();
    public JFrame cartFrame;

    public static final int NEW_APPAREL = 0;
    public static final int OLD_APPAREL = 1;

    public PageCart() {

        cartFrame = new JFrame("Cart");
        cartFrame.setSize(500, 500);
        cartFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        cartFrame.setVisible(false);
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
        JButton proceedBtn = new JButton("Proceed to Payment");
        proceedBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(Customer.getCustomer().getOrder().getShirts().size()==0)
                {
                    JFrame f=new JFrame();  
                        JOptionPane.showMessageDialog(f,"No items available in cart"); 
                        

                }
                else{
                int option = JOptionPane.showConfirmDialog(null,
                        "Once proceed to payment section,\nyou can never navigate backward to previous page.\nAre you sure to continue ?",
                        "Proceed to payment", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        Log.log.cloneToOrders(Customer.getCustomer().getOrder());
                    } catch (CloneNotSupportedException e1) {
                        e1.printStackTrace();
                    }
                    PageReport.addToLog();
                    CardLayout cl = (CardLayout) (MiscFunctions.masterCards.getLayout());
                    PagePayMethod.ppm = new PagePayMethod(); //"Pay Method"
                    cl.show(MiscFunctions.masterCards, "Pay Method");
                    cartFrame.dispose();
                }
            }
        }
        });
    

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
        pane.add(proceedBtn, BorderLayout.PAGE_END);
        //
        cartFrame.add(pane);

    }

    public void addToCart(Apparel apparel, int t) {
        if (t == NEW_APPAREL) {
            JPanel apparelPane = apparel.getApparelPane();
            newpanel.setLayout(new BoxLayout(newpanel, BoxLayout.Y_AXIS));
            newpanel.add(apparelPane);

        } else {
            JPanel apparelPane = apparel.getApparelPane();
            JSpinner newspinner = (JSpinner) apparelPane.getComponent(3);
            newspinner.setValue(Integer.valueOf(apparel.getQuantity()));

        }

        newpanel.revalidate();
        newpanel.repaint();
    }

    public void removeFromCart(int i) {
        newpanel.remove(i);
        newpanel.revalidate();
        newpanel.repaint();
    }

}
