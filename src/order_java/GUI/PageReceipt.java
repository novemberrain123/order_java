package order_java.GUI;

import order_java.classes.*;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class PageReceipt {
    public static void createPageReceipt(){
        Customer user = new Customer(); // Regular customer Demo
        PaymentCalc paymentCalc = new CustomerPayment(); // Regular customer Demo
        // Customer user = new Member("LimJUNSHEN", 105, "823hnr", 2039); // New member Demo
        // Customer user = new Member(); // Regular member Demo
        // PaymentCalc paymentCalc = new MemberPayment(); // Member Demo
        paymentCalc.setRawTotal(2039); // Demo for all
        paymentCalc.setDiscountAmount(283); // Demo for all 
        paymentCalc.setAdjTotal(1792); // Demo for all 
        paymentCalc.setPayMethod("Card"); // Set pay method Demo for all 
        CardInfo cardInfo = new CardInfo("823489234", "20/30", 321);
        user.setCardInfo(cardInfo);
        
        // ((MemberPayment)paymentCalc).setIsRedeemPoints(false); // Set redeem or not Demo
        Receipt receipt = new Receipt(user, paymentCalc); // Create receipt object
        
        JPanel pane = new JPanel(new BorderLayout());
        Font wordFont = new Font("", Font.PLAIN, 15);
        int rowNum; // Number of rows presented in payment details page
        if (user instanceof Member && paymentCalc.getPayMethod() == "Cash")
            rowNum = 10;
        else if (user instanceof Member && paymentCalc.getPayMethod() == "Card")
            rowNum = 9;
        else if (paymentCalc.getPayMethod() == "Cash")
            rowNum = 8;
        else 
            rowNum = 7;
        
        JPanel[] paneReceiptLabels = new JPanel[rowNum]; // To store every receipt labels
        for (int i = 0; i < rowNum; i++){
            paneReceiptLabels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        }

        // Labels for receipt details
        JLabel lbReceiptNo = new JLabel("Receipt Number : ");
        JLabel lbCustomerName = new JLabel("Customer Name : ");
        JLabel lbMemberID = new JLabel("Member ID : ");
        JLabel lbAccumulatedPoints = new JLabel("Accumulated Points : ");
        JLabel lbTransactionDate = new JLabel("Transaction Date : ");
        JLabel lbTransactionTime = new JLabel("Transaction Time : ");
        JLabel lbPayMethod = new JLabel("Payment Method : ");
        JLabel lbAmount = new JLabel("Amount : ");
        JLabel lbCardNumber = new JLabel("Card Number : ");
        JLabel lbPaidCash = new JLabel("Paid Cash : ");
        JLabel lbChange = new JLabel("Change : ");

        // Set Font
        lbReceiptNo.setFont(wordFont);
        lbCustomerName.setFont(wordFont);
        lbMemberID.setFont(wordFont);
        lbAccumulatedPoints.setFont(wordFont);
        lbTransactionDate.setFont(wordFont);
        lbTransactionTime.setFont(wordFont);
        lbPayMethod.setFont(wordFont);
        lbAmount.setFont(wordFont);
        lbCardNumber.setFont(wordFont);
        lbPaidCash.setFont(wordFont);
        lbChange.setFont(wordFont);

        // Store receipt labels to each label panel
        int indexMidPanel; // Start index of middle panel
        paneReceiptLabels[0].add(lbReceiptNo);
        paneReceiptLabels[1].add(lbCustomerName);
        if (user instanceof Member){ // Member
            paneReceiptLabels[2].add(lbMemberID);
            paneReceiptLabels[3].add(lbAccumulatedPoints);
            indexMidPanel = 4;
        }
        else
            indexMidPanel = 2;
        
        // Middle fixed panels for customer or member
        paneReceiptLabels[indexMidPanel].add(lbTransactionDate);
        paneReceiptLabels[indexMidPanel + 1].add(lbTransactionTime);
        paneReceiptLabels[indexMidPanel + 2].add(lbPayMethod);
        paneReceiptLabels[indexMidPanel + 3].add(lbAmount);

        // Bottom fixed panels for different pay method
        if (paymentCalc.getPayMethod() == "Card"){
            paneReceiptLabels[rowNum - 1].add(lbCardNumber);
        }
        else {
            paneReceiptLabels[rowNum - 2].add(lbPaidCash);
            paneReceiptLabels[rowNum - 1].add(lbChange);
        }

        // Create panel to include all panels of receipt labels
        JPanel midLeftPane = new JPanel(new GridLayout(rowNum,1));
        for (int i = 0; i < rowNum; i++){
            midLeftPane.add(paneReceiptLabels[i]);
        }

        JPanel[] paneReceiptInfo = new JPanel[rowNum]; // To store every receipt information
        for (int i = 0; i < rowNum; i++){
            paneReceiptInfo[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        }

        // Information for receipt details
        JLabel infoReceiptNo = new JLabel(String.valueOf(receipt.getReceiptNo()));
        JLabel infoCustomerName = new JLabel(String.valueOf(receipt.getCustomer().getName()));
        JLabel infoMemberID = new JLabel();
        JLabel infoAccumulatedPoints = new JLabel();
        if (user instanceof Member) {
            infoMemberID = new JLabel(String.valueOf(((Member)receipt.getCustomer()).getMemberID()));
            infoAccumulatedPoints = new JLabel(String.valueOf(((Member)receipt.getCustomer()).getPoints()));
        }
        JLabel infoTransactionDate = new JLabel(receipt.getTransactionDate());
        JLabel infoTransactionTime = new JLabel(receipt.getTransactionTime());
        JLabel infoPayMethod = new JLabel(receipt.getPaymentCalc().getPayMethod());
        JLabel infoAmount = new JLabel(String.valueOf(receipt.getPaymentCalc().getAdjTotal()));
        if (user instanceof Member && (Member.getNextMemberID() - 1) == ((Member)user).getMemberID()) // New Member
            infoAmount.setText(infoAmount.getText() + " (Included member fees)");
        JLabel infoCardNumber = new JLabel(receipt.getCustomer().getCardInfo().getCardNo());
        JLabel infoPaidCash = new JLabel();
        JLabel infoChange = new JLabel();
        if (paymentCalc.getPayMethod() == "Cash"){
            infoPaidCash = new JLabel(String.valueOf(receipt.getCustomer().getCashPayment().getPayment()));
            infoChange = new JLabel(String.valueOf(receipt.getPaymentCalc().getChange()));
        }

        // Set Font
        infoReceiptNo.setFont(wordFont);
        infoCustomerName.setFont(wordFont);
        infoMemberID.setFont(wordFont);
        infoAccumulatedPoints.setFont(wordFont);
        infoTransactionDate.setFont(wordFont);
        infoTransactionTime.setFont(wordFont);
        infoPayMethod.setFont(wordFont);
        infoAmount.setFont(wordFont);
        infoCardNumber.setFont(wordFont);
        infoPaidCash.setFont(wordFont);
        infoChange.setFont(wordFont);

        // Store receipt information to each label panel
        paneReceiptInfo[0].add(infoReceiptNo);
        paneReceiptInfo[1].add(infoCustomerName);
        if (user instanceof Member){ // Member
            paneReceiptInfo[2].add(infoMemberID);
            paneReceiptInfo[3].add(infoAccumulatedPoints);
        }
        
        // Middle fixed panels for customer or member
        paneReceiptInfo[indexMidPanel].add(infoTransactionDate);
        paneReceiptInfo[indexMidPanel + 1].add(infoTransactionTime);
        paneReceiptInfo[indexMidPanel + 2].add(infoPayMethod);
        paneReceiptInfo[indexMidPanel + 3].add(infoAmount);

        // Bottom fixed panels for different pay method
        if (paymentCalc.getPayMethod() == "Card"){
            paneReceiptInfo[rowNum - 1].add(infoCardNumber);
        }
        else {
            paneReceiptInfo[rowNum - 2].add(infoPaidCash);
            paneReceiptInfo[rowNum - 1].add(infoChange);
        }

        // Create panel to include all panels of receipt information
        JPanel midRightPane = new JPanel(new GridLayout(rowNum,1));
        for (int i = 0; i < rowNum; i++){
            midRightPane.add(paneReceiptInfo[i]);
        }

        // Create top panel
        JPanel midTopPane = new JPanel();
        JLabel lbTitle = new JLabel("Customer Receipt");
        lbTitle.setFont(new Font("", Font.BOLD, 30));
        midTopPane.add(lbTitle);

        // Create bottom panel
        JPanel midBtmPane = new JPanel(new FlowLayout());
        JButton btnContShop = new JButton("Back to home page");
        JButton btnStopShop = new JButton("Stop shopping");
        btnContShop.setFont(new Font("", Font.BOLD, 20));
        btnContShop.setBackground(Color.black);
        btnContShop.setForeground(Color.red);
        btnStopShop.setFont(new Font("", Font.BOLD, 20));
        btnStopShop.setBackground(Color.black);
        btnStopShop.setForeground(Color.red);

        // Event handling
        btnContShop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards,"Hompage");
            }
        });
        // btnStopShop.addActionListener(new ActionListener(){
        //    public void actionPerformed(ActionEvent e){
        //        // Codes to stop shopping
        // });
        midBtmPane.add(btnContShop);
        midBtmPane.add(btnStopShop);

        // Create middle panel
        JPanel midPane = new JPanel(new BorderLayout());
        midPane.add(midTopPane, BorderLayout.PAGE_START);
        midPane.add(midBtmPane, BorderLayout.PAGE_END);
        midPane.add(midLeftPane, BorderLayout.LINE_START);
        midPane.add(midRightPane, BorderLayout.CENTER);
        pane.add(midPane, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "Receipt");
    }
}