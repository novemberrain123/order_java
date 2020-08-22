package order_java.GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PageCashPayment {
    public static void createPageCashPayment(){
        JPanel pane = new JPanel(new BorderLayout());
        Font wordFont = new Font("", Font.PLAIN, 15);
        JPanel[] midPaneLabels = new JPanel[5];
        for (int i = 0; i < 5; i++){
            midPaneLabels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        }
        
        JLabel lbTotalAmount = new JLabel("Total Amount : ");
        JLabel lbDiscountAmount = new JLabel("Discount Amount : ");
        JLabel lbAmountToPay = new JLabel("Amount to pay : ");
        JLabel lbAmountReceived = new JLabel("Amount received : ");
        JLabel lbBalance = new JLabel("Balance : ");
        lbTotalAmount.setFont(wordFont);
        lbDiscountAmount.setFont(wordFont);
        lbAmountToPay.setFont(wordFont);
        lbAmountReceived.setFont(wordFont);
        lbBalance.setFont(wordFont);
        midPaneLabels[0].add(lbTotalAmount);
        midPaneLabels[1].add(lbDiscountAmount);
        midPaneLabels[2].add(lbAmountToPay);
        midPaneLabels[3].add(lbAmountReceived);
        midPaneLabels[4].add(lbBalance);

        JLabel infoTotalAmount = new JLabel("RM197.20");
        JLabel infoDiscountAmount = new JLabel("RM27.20");
        JLabel infoAmountToPay = new JLabel("RM170.00");
        JLabel lbRM = new JLabel("RM");
        JTextField tfAmountReceived = new JTextField(10);
        JLabel infoBalance = new JLabel("RM30.00");
        infoTotalAmount.setFont(wordFont);
        infoDiscountAmount.setFont(wordFont);
        infoAmountToPay.setFont(wordFont);
        lbRM.setFont(wordFont);
        tfAmountReceived.setFont(wordFont);
        infoBalance.setFont(wordFont);

        JPanel[] midPaneInfo = new JPanel[5];
        for (int i = 0; i < 5; i++){
            midPaneInfo[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        }
        midPaneInfo[0].add(infoTotalAmount);
        midPaneInfo[1].add(infoDiscountAmount);
        midPaneInfo[2].add(infoAmountToPay);
        midPaneInfo[3].add(lbRM);
        midPaneInfo[3].add(tfAmountReceived);
        midPaneInfo[4].add(infoBalance);

        JPanel midPaneLeft = new JPanel(new GridLayout(5,1));
        JPanel midPaneRight = new JPanel(new GridLayout(5,1));
        for (int i = 0; i < 5; i++){
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
        MiscFunctions.addCardtoMasterCards(pane, "Cash Payment");
    }
}