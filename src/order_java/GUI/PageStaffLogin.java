    package order_java.GUI;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files
import javax.lang.model.element.Name;
import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageStaffLogin {

    public static void createPageStaffLogin() {

        JPanel pane = new JPanel(new BorderLayout());
        MiscFunctions.addDefaultComponentsToPane(pane, "Home", 2);

        // create a controlPanel that included login panel and name Pane
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));

        JPanel login = new JPanel();
        login.setLayout(new BoxLayout(login, BoxLayout.X_AXIS));
        JLabel loginx = new JLabel("SUPERMIND T-SHIRT STAFF LOGIN");
        login.add(loginx);
        loginx.setFont(new Font("SansSerif", Font.BOLD, 17));
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel name = new JPanel();
        name.setLayout(new BoxLayout(name, BoxLayout.X_AXIS));
        name.add(new JLabel("Name        :  "));
        JTextField name1 = new JTextField(10);
        name.add(name1);
        name.setMaximumSize(new Dimension(171, 20));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setLayout(new BoxLayout(btnLogin, BoxLayout.X_AXIS));
        btnLogin.setMaximumSize(new Dimension(100, 20));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel pass = new JPanel();
        pass.add(new JLabel("Password :"));
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setMaximumSize(new Dimension(100, 20));
        btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    char[] pass = passwordField.getPassword();
                    String username = name1.getText();
                    if (performCheck(pass)==true&&performCheck2(username)==true) {
                         PageReport.createPageReport(); // "Reports"
                         CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                         cl.show(MiscFunctions.masterCards,"Reports");

                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect name or password");
                    }
                                     

            }
        });

        passwordField.setEchoChar('*');
        pass.add(passwordField);
        pass.setAlignmentX(Component.CENTER_ALIGNMENT);

        // add login and name_pass into controlpanel (nested )
        controlPanel.add(Box.createRigidArea(new Dimension(100, 110)));
        controlPanel.add(login);
        controlPanel.add(Box.createRigidArea(new Dimension(100, 60)));
        controlPanel.add(name);
        // controlPanel.add(Box.createRigidArea(new Dimension(100,1)));
        controlPanel.add(pass);
        controlPanel.add(Box.createRigidArea(new Dimension(100, 20)));
        controlPanel.add(btnLogin);
        // JPanel outter = new JPanel();

        // Adding to the panel

        // outter.add(controlPanel, BorderLayout.CENTER);
        // MiscFunctions.addCardtoMasterCards(outter, "StaffLogin");
        pane.add(controlPanel, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "StaffLogin");
    }

    private static boolean performCheck(char[] input) {
        boolean isCorrect = false;
        char[] correctPass = { '1', '2', '3', '4', '5', 'f', 'a', 't' };

        if (input.length != correctPass.length) {
            isCorrect = false;
        }
        if (Arrays.equals(input, correctPass)) {
            isCorrect = true;
        }
        Arrays.fill(correctPass, '0');

        return isCorrect;
    }

    private static boolean performCheck2(String input)  {
        boolean match = false;
        try {
            File myObj = new File("ID/staffs.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                if (input.matches(myReader.nextLine())) {
                    match = true;
                    break;
                } else
                    match = false;
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return match;
    }
}

