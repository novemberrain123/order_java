package order_java.GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PageCardPayment {
    public static void createPageCardPayment(){
        JPanel pane = new JPanel(); 
        Font wordFont = new Font("", Font.PLAIN, 15);
        JPanel[] midPaneLabels = new JPanel[6];
        for (int i = 0; i < 6; i++){
            midPaneLabels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        }
        
        JLabel lbTotalAmount = new JLabel("Total Amount : ");
        JLabel lbDiscountAmount = new JLabel("Discount Amount : ");
        JLabel lbAmountToPay = new JLabel("Amount to pay : ");
        JLabel lbCardNumber = new JLabel("Card Number : ");
        JLabel lbExpirationDate = new JLabel("Expiration Date : ");
        JLabel lbCVCode = new JLabel("CV Code : ");
        lbTotalAmount.setFont(wordFont);
        lbDiscountAmount.setFont(wordFont);
        lbAmountToPay.setFont(wordFont);
        lbCardNumber.setFont(wordFont);
        lbExpirationDate.setFont(wordFont);
        lbCVCode.setFont(wordFont);
        midPaneLabels[0].add(lbTotalAmount);
        midPaneLabels[1].add(lbDiscountAmount);
        midPaneLabels[2].add(lbAmountToPay);
        midPaneLabels[3].add(lbCardNumber);
        midPaneLabels[4].add(lbExpirationDate);
        midPaneLabels[5].add(lbCVCode);

        JLabel infoTotalAmount = new JLabel("RM197.20");
        JLabel infoDiscountAmount = new JLabel("RM27.20");
        JLabel infoAmountToPay = new JLabel("RM170.00");
        JTextField tfCardNumber = new JTextField(20);
        JComboBox<String> cbMonth = new JComboBox<>(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"});
        JLabel lbSlash = new JLabel("/");
        JComboBox<String> cbYear = new JComboBox<>(new String[]{"2020", "2021", "2022", "2023", "2024", "2025"});
        JTextField tfCVCode = new JTextField(3);
        tfCVCode.setToolTipText("Enter 3 numbers");
        infoTotalAmount.setFont(wordFont);
        infoDiscountAmount.setFont(wordFont);
        infoAmountToPay.setFont(wordFont);
        tfCardNumber.setFont(wordFont);
        cbMonth.setFont(wordFont);
        cbYear.setFont(wordFont);
        tfCVCode.setFont(wordFont);

        JPanel[] midPaneInfo = new JPanel[6];
        for (int i = 0; i < 6; i++){
            midPaneInfo[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        }
        midPaneInfo[0].add(infoTotalAmount);
        midPaneInfo[1].add(infoDiscountAmount);
        midPaneInfo[2].add(infoAmountToPay);
        midPaneInfo[3].add(tfCardNumber);
        midPaneInfo[4].add(cbMonth);
        midPaneInfo[4].add(lbSlash);
        midPaneInfo[4].add(cbYear);
        midPaneInfo[5].add(tfCVCode);

        JPanel midPaneLeft = new JPanel(new GridLayout(6,1));
        JPanel midPaneRight = new JPanel(new GridLayout(6,1));
        for (int i = 0; i < 6; i++){
            midPaneLeft.add(midPaneLabels[i]);
            midPaneRight.add(midPaneInfo[i]);
        }
        
        JPanel midPaneTop = new JPanel(new FlowLayout());
        JLabel lbTitle = new JLabel("Payment Details");
        lbTitle.setFont(new Font("", Font.BOLD, 30));
        midPaneTop.add(lbTitle);
        JPanel midPaneBtm = new JPanel(new FlowLayout());
        JButton btnPay = new JButton("Pay");
        btnPay.setFont(new Font("", Font.BOLD, 20));
        btnPay.setBackground(Color.black);
        btnPay.setForeground(Color.red);
        btnPay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards,"Receipt");
            }
        });
        midPaneBtm.add(btnPay);

        JPanel midPane = new JPanel(new BorderLayout());
        midPane.add(midPaneLeft, BorderLayout.LINE_START);
        midPane.add(midPaneRight, BorderLayout.CENTER);
        midPane.add(midPaneTop, BorderLayout.PAGE_START);
        midPane.add(midPaneBtm, BorderLayout.PAGE_END);
        pane.add(midPane, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "Card Payment");
    }
}