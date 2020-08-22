package order_java.GUI;

import java.awt.*;
import javax.swing.*;

import order_java.classes.*;

import java.awt.event.*;

public class PageMembership {
    public static void createPageMembership(){
        Customer user = new Customer(); // Demonstration purpose
        PaymentCalc paymentcalc = new CustomerPayment(); // Demonstration purpose
        
        JPanel pane = new JPanel(new BorderLayout());
        JPanel[] paneMemberDetails = new JPanel[10]; // To store every panel for member's details
        for (int i = 0; i < 10; i++){ 
            paneMemberDetails[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        }

        // Member's name
        JTextField tfFirstName = new JTextField("First Name", 25); 
        JTextField tfLastName = new JTextField("Last Name", 10);
        paneMemberDetails[0].add(tfFirstName);
        paneMemberDetails[0].add(tfLastName);

        // Member's email
        JTextField tfEmail = new JTextField(35);
        tfEmail.setToolTipText("Ex : example@hotmail.com");
        paneMemberDetails[1].add(tfEmail);

        // Member's dob
        JLabel lbDate = new JLabel("Date");
        JComboBox<String> cbDate = new JComboBox<>(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});

        JLabel lbMonth = new JLabel("Month");
        JComboBox<String> cbMonth = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});

        JLabel lbYear = new JLabel("Year");
        String[] year = new String[100];
        for (int i = 20; i < 100; i++){
            year[i-20] = "19" + i;
            if (20 <= i && i < 30){
                year[i+60] = "200" + (i-20);
            }
            if (30 <= i && i < 40){
                year[i+60] = "20" + (i-20);
            }
        }
        JComboBox<String> cbYear = new JComboBox<>(year);

        paneMemberDetails[2].add(lbDate);
        paneMemberDetails[2].add(cbDate);
        paneMemberDetails[2].add(lbMonth);
        paneMemberDetails[2].add(cbMonth);
        paneMemberDetails[2].add(lbYear);
        paneMemberDetails[2].add(cbYear);

        // Member's handphone number
        JTextField tfHpFront = new JTextField(3);
        JLabel lbDash = new JLabel("-");
        JTextField tfHpBehind = new JTextField(8);
        paneMemberDetails[3].add(tfHpFront);
        paneMemberDetails[3].add(lbDash);
        paneMemberDetails[3].add(tfHpBehind);

        // Member's address
        JTextField[] tfAddress = new JTextField[3]; 
        for (int i = 4; i < 7; i++){
            tfAddress[i-4] = new JTextField(30);
            paneMemberDetails[i].add(tfAddress[i-4]);
        }

        // Address's poscode and state
        JLabel lbPoscode = new JLabel("Poscode");
        JTextField tfPoscode = new JTextField(5);
        JLabel lbState = new JLabel("State");
        JComboBox<String> cbState = new JComboBox<>(new String[]{"Wilayah Persekutuan Kuala Lumpur", "Selangor", "Melaka", "Negeri Sembilan", "Perak", "Penang", "Kedah", "Perlis", "Putrajaya", "Johot", "Kelantan", "Terrenganu", "Pahang", "Sabah", "Sarawak", "Labuan"});
        paneMemberDetails[7].add(lbPoscode);
        paneMemberDetails[7].add(tfPoscode);
        paneMemberDetails[7].add(lbState);
        paneMemberDetails[7].add(cbState);

        // Member's UserID and password
        JLabel lbUserID = new JLabel(String.valueOf(Member.getNextMemberID()));
        JTextField tfPassword = new JTextField(15);
        tfPassword.setToolTipText("Password has to include at least 8 characters which are made up of at least one digit, one letter and one upper case letter.");
        paneMemberDetails[8].add(lbUserID);
        paneMemberDetails[9].add(tfPassword);

        // Create panel for membership details input
        JPanel midPaneDetails = new JPanel(); 
        midPaneDetails.setLayout(new GridLayout(10,1)); // Set layout to grid layout
        for (int i = 0; i < 10; i++){ 
            midPaneDetails.add(paneMemberDetails[i]);
        }
        
        JPanel[] paneSectionLabels = new JPanel[10]; // To store every panel for section labels
        for (int i = 0; i < 10; i++){ 
            paneSectionLabels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        }

        // Create section labels
        paneSectionLabels[0].add(new JLabel("Name"));
        paneSectionLabels[1].add(new JLabel("Email"));
        paneSectionLabels[2].add(new JLabel("Date of Birth"));
        paneSectionLabels[3].add(new JLabel("Handphone No."));
        paneSectionLabels[4].add(new JLabel("Address"));
        paneSectionLabels[5].add(new JLabel(""));
        paneSectionLabels[6].add(new JLabel(""));
        paneSectionLabels[7].add(new JLabel(""));
        paneSectionLabels[8].add(new JLabel("User ID  :"));
        paneSectionLabels[9].add(new JLabel("Password :"));

        // Create panel to include every panel of section labels
        JPanel midPaneLabels = new JPanel(); 
        midPaneLabels.setLayout(new GridLayout(10,1)); // Set layout to grid layout
        for (int i = 0; i < 10; i++){ 
            midPaneLabels.add(paneSectionLabels[i]);
        }

        // Theme at top
        JPanel midPaneTop = new JPanel();
        JLabel lbTitle = new JLabel("Membership Application");
        lbTitle.setFont(new Font("", Font.BOLD, 30));
        midPaneTop.add(lbTitle);
        
        // Buttons at bottom
        JPanel midPaneBtm = new JPanel();
        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (tfFirstName.getText() == null || tfFirstName.getText().trim().isEmpty() || tfLastName.getText() == null || tfLastName.getText().trim().isEmpty() || tfEmail.getText() == null || tfEmail.getText().trim().isEmpty() || tfHpFront.getText() == null || tfHpFront.getText().trim().isEmpty() || tfHpBehind.getText() == null || tfHpBehind.getText().trim().isEmpty() || tfAddress[0].getText() == null || tfAddress[0].getText().trim().isEmpty() || tfAddress[1].getText() == null || tfAddress[1].getText().trim().isEmpty() || tfAddress[2].getText() == null || tfAddress[2].getText().trim().isEmpty() || tfPoscode.getText() == null || tfPoscode.getText().trim().isEmpty() || tfPassword.getText() == null || tfPassword.getText().trim().isEmpty())
                    JOptionPane.showMessageDialog(null, "There is column left blank.\nPlease check again.", "Unable to proceed", JOptionPane.ERROR_MESSAGE);
                else {
                    if (Member.validatePassword(tfPassword.getText()) == "Valid"){
                        Customer tempUser = user; // Temporarily store customer data
                        Customer user = new Member();
                        user.setName(tempUser.getName()); // Transfer customer data to member data
                        user.setAddress(tempUser.getAddress());
                        user.setPhoneNo(tempUser.getPhoneNo());
                        user.setOrder(tempUser.getOrder());
                        PaymentCalc paymentcalc = new MemberPayment(); // Point to a new member payment object

                        // Store user details
                        user.setName(tfFirstName.getText() + " " + tfLastName.getText()); // Store member name
                        ((Member)user).setEmail(tfEmail.getText()); // Store member email
                        ((Member)user).setDob((String)cbDate.getSelectedItem() + "-" + ((String)cbMonth.getSelectedItem()).substring(0, 3) + "-" + (String)cbYear.getSelectedItem()); // Store member dob
                        user.setPhoneNo(tfHpFront.getText() + "-" + tfHpBehind.getText()); // Store member hp no.
                        user.setAddress(tfAddress[0].getText() + ", " + tfAddress[1].getText() + ", " + tfAddress[2].getText() + ", " + tfPoscode.getText() + " " + (String)cbState.getSelectedItem()); // Store member address
                        ((Member)user).setPassword(tfPassword.getText()); // Store member password

                        ((Member)user).writeToFile(); // Write new member into text file
                        ((Member)user).setLuckyNumber(Integer.parseInt(JOptionPane.showInputDialog(null, "Member fee: RM20.00\nEnter a lucky number and stand a chance to get free membership !\n(Any number from 1 to 5)")));
                        if (((MemberPayment)paymentcalc).matchLuckyNumber(user)){
                            JOptionPane.showMessageDialog(null, "Your lucky number is matched.\nYou are given a free membership.\nHave a nice day!", "Congratulation!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Your lucky number is not matched.\nIt's okay. Try better next time :) !", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                            ((MemberPayment)paymentcalc).addMemberFees();
                        }
                        CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                        cl.show(MiscFunctions.masterCards,"Pay Method");
                    }
                    else
                        JOptionPane.showMessageDialog(null, Member.validatePassword(tfPassword.getText()), "Invalid Password", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards,"Pay Method");
            }
        });
        btnSignUp.setFont(new Font("", Font.BOLD, 18));
        btnCancel.setFont(new Font("", Font.BOLD, 18));
        btnSignUp.setForeground(Color.red);
        btnCancel.setForeground(Color.red);
        btnSignUp.setBackground(Color.black);
        btnCancel.setBackground(Color.black);
        midPaneBtm.add(btnSignUp);
        midPaneBtm.add(btnCancel);

        // Middle panel
        JPanel midPane = new JPanel(new BorderLayout());
        midPane.add(midPaneDetails, BorderLayout.CENTER);
        midPane.add(midPaneLabels, BorderLayout.LINE_START);
        midPane.add(midPaneTop, BorderLayout.PAGE_START);
        midPane.add(midPaneBtm, BorderLayout.PAGE_END);

        // Add middle panel to middle of main panel
        pane.add(midPane, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "Membership");
    }
}