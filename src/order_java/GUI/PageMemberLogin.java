package order_java.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import order_java.classes.Member;

public class PageMemberLogin {

    public static void createPageMember() {

        JPanel pane = new JPanel(new BorderLayout());
        MiscFunctions.addDefaultComponentsToPane(pane, "Home", 2);
        // create a controlPanel that included login panel and name Pane
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));

        JPanel login = new JPanel();
        login.setLayout(new BoxLayout(login, BoxLayout.X_AXIS));
        JLabel loginx = new JLabel("SUPERMIND T-SHIRT MEMBER LOGIN");
        login.add(loginx);
        loginx.setFont(new Font("SansSerif", Font.BOLD, 17));
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel memberID = new JPanel();
        memberID.setLayout(new BoxLayout(memberID, BoxLayout.X_AXIS));
        memberID.add(new JLabel("MemberID :  "));
        JTextField memberIDlogin = new JTextField(10);
        memberID.add(memberIDlogin);
        memberID.setMaximumSize(new Dimension(171, 20));
        memberID.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setLayout(new BoxLayout(btnLogin, BoxLayout.X_AXIS));
        btnLogin.setMaximumSize(new Dimension(100, 20));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel pass = new JPanel();
        pass.add(new JLabel("Password   :"));
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setMaximumSize(new Dimension(100, 20));


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String memberId = memberIDlogin.getText();
                String password = String.valueOf(passwordField.getPassword());
                try {  
                   
                    if (performCheck(memberId, password) == true) {
                        CardLayout cl = (CardLayout) (MiscFunctions.masterCards.getLayout());
                        cl.show(MiscFunctions.masterCards, "Market");
                        

                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect password");
                    }
                } catch (HeadlessException | FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                }
            });
            
        passwordField.setEchoChar('*');
        pass.add(passwordField);
        pass.setAlignmentX(Component.CENTER_ALIGNMENT);




        // add login and name_pass into controlpanel (nested )
        controlPanel.add(Box.createRigidArea(new Dimension(100,110)));
        controlPanel.add(login);
        controlPanel.add(Box.createRigidArea(new Dimension(100,60)));
        controlPanel.add(memberID);
        controlPanel.add(Box.createRigidArea(new Dimension(100,10)));
        controlPanel.add(pass);
        controlPanel.add(Box.createRigidArea(new Dimension(100,20)));
        controlPanel.add(btnLogin);



        
        //Adding to the panel

        pane.add(controlPanel, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "MemberLogin");
    }



    private static boolean performCheck(String id, String pass) throws FileNotFoundException {
        boolean x =false;
        File myObj = new File("./././ID/members.txt");
        Scanner read = new Scanner(myObj);
        read.useDelimiter("[\\s]+");

        String memID;
        String memPass;
        String memPoints;
        String name;
        
            while (read.hasNextLine() && read.hasNext() )
            {

                    memID = read.next();
                    memPass = read.next();
                    memPoints = read.next();
                    name=read.next();

                    if(memID.equals(id) && memPass.equals(pass))
                    {

                        x=true;
                        int ID =Integer.parseInt(memID);
                        double points = Double.parseDouble(memPoints);
                        Member.createRegMember(name, ID, memPass, points);
                        break;
                    }
            }
           


        read.close();
        return x;
    }
   





}