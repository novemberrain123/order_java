package order_java.GUI;

import javax.lang.model.element.Name;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

     public static void createHome(){
         
        ImageIcon logo = new ImageIcon("img/mindnew.png");
        Image image = logo.getImage(); //Resize Image
        Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        logo = new ImageIcon(newimg);  // transform it back
        JLabel logoLabel = new JLabel ("SUPERMIND T-SHIRT");
        logoLabel.setFont(new Font("",Font.PLAIN,20)); //Set font style and size
        logoLabel.setIcon(logo);
        //Set cart button
        
        //PAGE_START
        JPanel topPane=new JPanel();
        //topPane.setLayout(new BoxLayout(topPane,BoxLayout.X_AXIS));
        topPane.add(logoLabel);
        topPane.add(Box.createHorizontalGlue());



         JPanel controlPanel = new JPanel();
         controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
         JPanel login =new JPanel();
         login.setLayout(new BoxLayout(login, BoxLayout.X_AXIS));
         JLabel loginx = new JLabel("WELCOME TO OUR STORE");
         login.add(loginx);
         loginx.setFont(new Font("SansSerif", Font.BOLD, 18));
         login.setAlignmentX(Component.CENTER_ALIGNMENT);
         JLabel identity=new JLabel("You are a : ");
         identity.setFont(new Font("Times", Font.BOLD, 14));
         identity.setLayout(new BoxLayout(identity, BoxLayout.X_AXIS));
         identity.setAlignmentX(Component.CENTER_ALIGNMENT);

         JButton btnStaff=new JButton("Staff");
         btnStaff.setLayout(new BoxLayout(btnStaff, BoxLayout.X_AXIS));
         btnStaff.setMaximumSize(new Dimension(100, 20));
         btnStaff.setAlignmentX(Component.CENTER_ALIGNMENT);
         btnStaff.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards,"StaffLogin");
            }
        });

         JButton btnCustomer=new JButton("Customer");
         btnCustomer.setLayout(new BoxLayout(btnCustomer, BoxLayout.X_AXIS));
         btnCustomer.setMaximumSize(new Dimension(100, 20));
         btnCustomer.setAlignmentX(Component.CENTER_ALIGNMENT);
         btnCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards,"MemberLogin");
            }
        });
 
         // add login and name_pass into controlpanel (nested )
         controlPanel.add(Box.createRigidArea(new Dimension(100,70)));
         controlPanel.add(login);
         controlPanel.add(Box.createRigidArea(new Dimension(100,60)));
         controlPanel.add(identity);
         controlPanel.add(Box.createRigidArea(new Dimension(100,40)));
         controlPanel.add(btnStaff);
         controlPanel.add(Box.createRigidArea(new Dimension(100,20)));
         controlPanel.add(btnCustomer);

        
        
 
         JPanel pane = new JPanel();
         //Adding to the panel
         pane.add(controlPanel, BorderLayout.CENTER);

         JPanel pane1 = new JPanel();
         pane1.add(topPane,BorderLayout.PAGE_START);
        pane1.add(pane,BorderLayout.CENTER);
         
         MiscFunctions.addCardtoMasterCards(pane1, "Home");
     }
    
}