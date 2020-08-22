package order_java.GUI;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files
import javax.lang.model.element.Name;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.lang.reflect.Member;


public class PageMemberLogin  {

    public static void createPageMember(){
        
        


        JPanel pane = new JPanel(new BorderLayout());
        MiscFunctions.addDefaultComponentsToPane(pane, "Home",2);
        //create a controlPanel that included login panel and name Pane
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));

        JPanel login =new JPanel();
        login.setLayout(new BoxLayout(login, BoxLayout.X_AXIS));
        JLabel loginx = new JLabel("SUPERMIND T-SHIRT MEMBER LOGIN");
        login.add(loginx);
        loginx.setFont(new Font("SansSerif", Font.BOLD, 17));
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel memberID=new JPanel();
        memberID.setLayout(new BoxLayout(memberID, BoxLayout.X_AXIS));
        memberID.add(new JLabel ("Name        :  "));
        JTextField memberIDlogin = new JTextField(10);
        memberID.add(memberIDlogin);
        memberID.setMaximumSize(new Dimension(171, 20));
        memberID.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton btnLogin=new JButton("LOGIN");
        btnLogin.setLayout(new BoxLayout(btnLogin, BoxLayout.X_AXIS));
        btnLogin.setMaximumSize(new Dimension(100, 20));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel pass=new JPanel();
        pass.add(new JLabel("Password :"));
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setMaximumSize(new Dimension(100, 20));
        
        String memberId = memberIDlogin.getText();
        String password = String.valueOf(passwordField.getPassword());
        
        

        btnLogin.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                   
                    if (performCheck(memberId, password)==true) {
                         CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                         cl.show(MiscFunctions.masterCards,"Market");
                         order_java.classes.Member newMember = new order_java.classes.Member(password);
                         
                         

                       
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect password");
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



    private static boolean performCheck(String id, String pass) {
        boolean match=false;
        StringBuilder check = new StringBuilder(id);
        check.append(id+"-"+pass+"-");
       
        try {
            File myObj = new File("D:\\JAVA\\order_java\\ID\\members.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) 
            {
                if (check.toString().equals(myReader.nextLine())) {
                    match=true;
                    break;
                }
                else
                    match=false;
            }


            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return match;
    }
   





}