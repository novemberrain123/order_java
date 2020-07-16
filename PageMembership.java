package order_java;

import java.awt.*;
import javax.swing.*;

public class PageMembership {
    public static void addComponentsToMembershipPane(Container pane){
        JLabel title = new JLabel("Membership Application");
        pane.add(title, BorderLayout.PAGE_START);

        JPanel midLeftPanel = new JPanel();
        midLeftPanel.setLayout(new GridLayout(8,1));
        midLeftPanel.add(new JLabel("Name"));
        midLeftPanel.add(new JLabel("E-mail"));
        midLeftPanel.add(new JLabel("Date of Birth"));
        midLeftPanel.add(new JLabel("Handphone no."));
        midLeftPanel.add(new JLabel("Address"));
        midLeftPanel.add(new JLabel(""));
        midLeftPanel.add(new JLabel(""));
        midLeftPanel.add(new JLabel(""));
        pane.add(midLeftPanel, BorderLayout.LINE_START);

        JPanel midRightPanel = new JPanel();
        midRightPanel.setLayout(new GridLayout(8,1));
        JPanel[] midRightSegment = new JPanel[8];

        midRightSegment[0].add(new JLabel("First Name"));
        midRightSegment[0].add(new JTextField(""));
        midRightSegment[0].add(new JLabel("Last Name"));
        midRightSegment[0].add(new JTextField(""));

        midRightSegment[1].add(new JTextField(35));

        midRightSegment[2].add(new JLabel("Date"));
        JComboBox<String> jcb1 = new JComboBox<>(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
        midRightSegment[2].add(jcb1);
        midRightSegment[2].add(new JLabel("Month"));
        JComboBox<String> jcb2 = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        midRightSegment[2].add(new JLabel("Year"));
        String[] year = new String[100];
        for (int i = 0; i < 100; i++){
            year[i] = ("1920" + i);
        }
        midRightSegment[2].add(jcb2);
        JComboBox<String> jcb3 = new JComboBox<>(year);
        midRightSegment[2].add(jcb3);

        midRightSegment[3].add(new JTextField(15));

        midRightSegment[4].add(new JTextField(30));
        midRightSegment[5].add(new JTextField(30));
        midRightSegment[6].add(new JTextField(30));

        midRightSegment[7].add(new JLabel("Poscode"));
        midRightSegment[7].add(new JTextField(5));
        JComboBox<String> jcb4 = new JComboBox<>(new String[]{"Wilayah Persekutuan Kuala Lumpur", "Selangor", "Melaka", "Negeri Sembilan", "Perak", "Penang", "Kedah", "Perlis", "Putrajaya", "Johot", "Kelantan", "Terrenganu", "Pahang", "Sabah", "Sarawak", "Labuan"});
        midRightSegment[7].add(jcb4);

        for (int i = 0; i < 8; i++){
            midRightPanel.add(midRightSegment[i]);
        }
        pane.add(midRightPanel, BorderLayout.CENTER);

        JButton btnSignUp = new JButton("Sign Up");
        JButton btnCancel = new JButton("Cancel");
        JPanel btmPanel = new JPanel();
        btmPanel.add(btnSignUp);
        btmPanel.add(btnCancel);
        pane.add(btmPanel, BorderLayout.PAGE_END);
    }
}