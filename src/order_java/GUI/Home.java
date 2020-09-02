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
import javax.swing.JLabel;
import javax.swing.JPanel;

import order_java.classes.*;

public class Home {

    public static Home home;

	public Home() {

        ImageIcon logo = new ImageIcon("img/mindnew.png");
        Image image = logo.getImage(); // Resize Image
        Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        logo = new ImageIcon(newimg); // transform it back
        JLabel logoLabel = new JLabel("SUPERMIND T-SHIRT");
        logoLabel.setFont(new Font("", Font.PLAIN, 20)); // Set font style and size
        logoLabel.setIcon(logo);
        // Set cart button

        // PAGE_START
        JPanel topPane = new JPanel();
        // topPane.setLayout(new BoxLayout(topPane,BoxLayout.X_AXIS));
        topPane.add(logoLabel);
        topPane.add(Box.createHorizontalGlue());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
        JPanel login = new JPanel();
        login.setLayout(new BoxLayout(login, BoxLayout.X_AXIS));
        JLabel loginx = new JLabel("WELCOME TO OUR STORE");
        login.add(loginx);
        loginx.setFont(new Font("SansSerif", Font.BOLD, 18));
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel identity = new JLabel("You are a : ");
        identity.setFont(new Font("Times", Font.BOLD, 14));
        identity.setLayout(new BoxLayout(identity, BoxLayout.X_AXIS));
        identity.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnStaff = new JButton("Staff");
        btnStaff.setLayout(new BoxLayout(btnStaff, BoxLayout.X_AXIS));
        btnStaff.setMaximumSize(new Dimension(150, 20));
        btnStaff.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards, "StaffLogin");
            }
        });

        JButton btnMember = new JButton("Member");
        btnMember.setLayout(new BoxLayout(btnMember, BoxLayout.X_AXIS));
        btnMember.setMaximumSize(new Dimension(150, 20));
        btnMember.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMember.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards, "MemberLogin");
            }
        });

        JButton btnCustomer = new JButton("Customer");
        btnCustomer.setLayout(new BoxLayout(btnCustomer, BoxLayout.X_AXIS));
        btnCustomer.setMaximumSize(new Dimension(150, 20));
        btnCustomer.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Customer.createCustomer(new Order());
                CardLayout cl = (CardLayout) (MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards, "Market");
            }
        });

        // add login and name_pass into controlpanel (nested )
        controlPanel.add(Box.createRigidArea(new Dimension(100, 70)));
        controlPanel.add(login);
        controlPanel.add(Box.createRigidArea(new Dimension(100, 60)));
        controlPanel.add(identity);
        controlPanel.add(Box.createRigidArea(new Dimension(100, 40)));
        controlPanel.add(btnStaff);
        controlPanel.add(Box.createRigidArea(new Dimension(100, 20)));
        controlPanel.add(btnMember);
        controlPanel.add(Box.createRigidArea(new Dimension(100, 20)));
        controlPanel.add(btnCustomer);

        JPanel pane = new JPanel();
        // Adding to the panel
        pane.add(controlPanel, BorderLayout.CENTER);

        JPanel pane1 = new JPanel();
        pane1.add(topPane, BorderLayout.PAGE_START);
        pane1.add(pane, BorderLayout.CENTER);

        MiscFunctions.addCardtoMasterCards(pane1, "Home");
    }

}