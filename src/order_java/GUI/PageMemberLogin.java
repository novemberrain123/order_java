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


public class PageMemberLogin  {

    public static void createPageMember(){

        //create a controlPanel that included login panel and name Pane
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));

        JPanel login =new JPanel();
        login.setLayout(new BoxLayout(login, BoxLayout.X_AXIS));
        JLabel loginx = new JLabel("SUPERMIND T-SHIRT MEMBER LOGIN");
        login.add(loginx);
        loginx.setFont(new Font("SansSerif", Font.BOLD, 17));
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel name=new JPanel();
        name.setLayout(new BoxLayout(name, BoxLayout.X_AXIS));
        name.add(new JLabel ("Name        :  "));
        name.add(new JTextField(10));
        name.setMaximumSize(new Dimension(171, 20));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnLogin=new JButton("LOGIN");
        btnLogin.setLayout(new BoxLayout(btnLogin, BoxLayout.X_AXIS));
        btnLogin.setMaximumSize(new Dimension(100, 20));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel pass=new JPanel();
        pass.add(new JLabel("Password :"));
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setMaximumSize(new Dimension(100, 20));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                char[] input = passwordField.getPassword();
                if (performCheck(input)) {
                    //JOptionPane.showMessageDialog(null, "Correct password");
                    btnLogin.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                            cl.show(MiscFunctions.masterCards,"Market");
                        }
                    });
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
        controlPanel.add(name);
        controlPanel.add(Box.createRigidArea(new Dimension(100,10)));
        controlPanel.add(pass);
        controlPanel.add(Box.createRigidArea(new Dimension(100,20)));
        controlPanel.add(btnLogin);



        JPanel pane = new JPanel();
        //Adding to the panel

        pane.add(controlPanel, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "MemberLogin");
    }

    private static boolean performCheck(char[] input) {
        boolean isCorrect = false;
        char[] correctPass = { '1', '2', '3','4','5','o','o','p' };

        if (input.length != correctPass.length) {
            isCorrect = false;
        }
        if (Arrays.equals(input, correctPass)) {
            isCorrect = true;
        }
        Arrays.fill(correctPass, '0');

        return isCorrect;
    }




}