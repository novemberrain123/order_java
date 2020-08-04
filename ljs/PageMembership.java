package order_java;

import java.awt.*;
import javax.swing.*;

public class PageMembership {
    public static void addComponentsToMembershipPane(Container pane){
        JPanel[] paneMemberDetails = new JPanel[8]; // To store every panel for member's details
        for (int i = 0; i < 8; i++){ 
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
        for (int i = 4; i < 7; i++){
            paneMemberDetails[i].add(new JTextField(30));
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

        // Create panel for membership details input
        JPanel midPaneDetails = new JPanel(); 
        midPaneDetails.setLayout(new GridLayout(8,1)); // Set layout to grid layout
        for (int i = 0; i < 8; i++){ 
            midPaneDetails.add(paneMemberDetails[i]);
        }
        
        JPanel[] paneSectionLabels = new JPanel[8]; // To store every panel for section labels
        for (int i = 0; i < 8; i++){ 
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

        // Create panel to include every panel of section labels
        JPanel midPaneLabels = new JPanel(); 
        midPaneLabels.setLayout(new GridLayout(8,1)); // Set layout to grid layout
        for (int i = 0; i < 8; i++){ 
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
        JButton btnCancel = new JButton("Cancel");
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
    }
}