package order_java.GUI;

import order_java.classes.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PagePaymentDetails {
    public static void checkCardInfo(Customer user, JTextField tfCardNumber, JTextField tfCVCode, JComboBox<String> cbMonth, JComboBox<String> cbYear){
        CardInfo cardInfo; 
        cardInfo = new CardInfo(tfCardNumber.getText(), (String)cbMonth.getSelectedItem() + "/" + (String)cbYear.getSelectedItem(), Integer.parseInt(tfCVCode.getText())); // Create new card info
        if (cardInfo.validateCard()){
            user.setCardInfo(cardInfo);
            CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
            cl.show(MiscFunctions.masterCards,"Receipt");
        }
        else 
            JOptionPane.showMessageDialog(null, "Your card information is incorrect.\nPlease check again", "Invalid card", JOptionPane.ERROR_MESSAGE);
    }

    public static void checkCashPayment(Customer user, PaymentCalc paymentCalc, JTextField tfPaidAmount){
        CashPayment cashPayment;
        cashPayment = new CashPayment(Integer.parseInt(tfPaidAmount.getText()));
        if (cashPayment.validateCash(paymentCalc.getAdjTotal())){
            user.setCashPayment(cashPayment);
            CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
            cl.show(MiscFunctions.masterCards,"Receipt");
        }
        else 
            JOptionPane.showMessageDialog(null, "Your cash payment is insufficient.\nPlease check again", "Insufficient cash payment", JOptionPane.ERROR_MESSAGE);
    }

    public static void setCustomerDetails(Customer user, JTextField infoName, JTextField infoAddress, JTextField infoPhoneNo){
        user.setName(infoName.getText()); // Set customer name
        user.setAddress(infoAddress.getText()); // Set customer address
        user.setPhoneNo(infoPhoneNo.getText()); // Set customer phone number
    }

    public static void createPagePaymentDetails(){
        // Customer user = new Customer(); // Regular customer Demo
        // PaymentCalc paymentCalc = new CustomerPayment(); // Regular customer Demo
        Customer user = new Member("LimJUNSHEN", 105, "823hnr", 2039); // New member Demo
        // Customer user = new Member(); // Regular member Demo
        PaymentCalc paymentCalc = new MemberPayment(); // Member Demo
        paymentCalc.setRawTotal(2039); // Demo for all
        paymentCalc.setDiscountAmount(283); // Demo for all 
        paymentCalc.setAdjTotal(1792); // Demo for all 
        paymentCalc.setPayMethod("Cash"); // Set pay method Demo for all 
        // ((MemberPayment)paymentCalc).setIsRedeemPoints(false); // Set redeem or not Demo

        JPanel pane = new JPanel(new BorderLayout()); 
        Font wordFont = new Font("", Font.PLAIN, 15);
        int rowNum; // Number of rows presented in payment details page
        if (user instanceof Member && ((MemberPayment)paymentCalc).getIsRedeemPoints() == false && paymentCalc.getPayMethod() == "Cash" && (Member.getNextMemberID() - 1) != ((Member)user).getMemberID())
            rowNum = 5;
        else if (user instanceof Member && (Member.getNextMemberID() - 1) == ((Member)user).getMemberID() && paymentCalc.getPayMethod() == "Cash" || user instanceof Member && ((MemberPayment)paymentCalc).getIsRedeemPoints() == true && paymentCalc.getPayMethod() == "Cash")
            rowNum = 6;
        else if (user instanceof Member && ((MemberPayment)paymentCalc).getIsRedeemPoints() == false && paymentCalc.getPayMethod() == "Card" && (Member.getNextMemberID() - 1) != ((Member)user).getMemberID()|| (!(user instanceof Member)) && paymentCalc.getPayMethod() == "Cash") // No redeem
            rowNum = 7;
        else if (user instanceof Member && (Member.getNextMemberID() - 1) == ((Member)user).getMemberID() && paymentCalc.getPayMethod() == "Card" || user instanceof Member && ((MemberPayment)paymentCalc).getIsRedeemPoints() == true && paymentCalc.getPayMethod() == "Card") // New member or redeem point
            rowNum = 8;
        else // Regular customer using card method
            rowNum = 9;
        JPanel[] midPaneLabels = new JPanel[rowNum];
        for (int i = 0; i < rowNum; i++){
            midPaneLabels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        }
        
        // Labels for payment details
        JLabel lbName = new JLabel("Name : ");
        JLabel lbAddress = new JLabel("Address : ");
        JLabel lbPhoneNo = new JLabel("Phone No. : ");
        JLabel lbTotalAmount = new JLabel("Total Amount : ");
        JLabel lbDiscountAmount = new JLabel("Discount Amount : ");
        JLabel lbMemberFees = new JLabel("Member fees : "); // Display only when new member sign up
        JLabel lbAmountToPay = new JLabel("Amount to pay : ");
        JLabel lbAddPoints = new JLabel("Add points : "); // Display when member made a purchase
        JLabel lbRedeemPoints = new JLabel("Redeem points : "); // Display when member redeem points
        JLabel lbCardNumber = new JLabel("Card Number : ");
        JLabel lbExpirationDate = new JLabel("Expiration Date : ");
        JLabel lbCVCode = new JLabel("CV Code : ");
        JLabel lbPaidAmount = new JLabel("Paid Amount : ");

        // Set Font for labels
        lbName.setFont(wordFont);
        lbAddress.setFont(wordFont);
        lbPhoneNo.setFont(wordFont);
        lbTotalAmount.setFont(wordFont);
        lbDiscountAmount.setFont(wordFont);
        lbMemberFees.setFont(wordFont);
        lbAmountToPay.setFont(wordFont);
        lbAddPoints.setFont(wordFont);
        lbRedeemPoints.setFont(wordFont);
        lbCardNumber.setFont(wordFont);
        lbExpirationDate.setFont(wordFont);
        lbCVCode.setFont(wordFont);
        lbPaidAmount.setFont(wordFont);

        // Add labels to each label panel
        if (user instanceof Member && (Member.getNextMemberID() - 1) == ((Member)user).getMemberID()){ // New member
            midPaneLabels[0].add(lbTotalAmount);
            midPaneLabels[1].add(lbDiscountAmount);
            midPaneLabels[2].add(lbMemberFees);
            midPaneLabels[3].add(lbAmountToPay);
            midPaneLabels[4].add(lbAddPoints);
        }
        else if (user instanceof Member && ((MemberPayment)paymentCalc).getIsRedeemPoints() == true){ // Redeem 
            midPaneLabels[0].add(lbTotalAmount);
            midPaneLabels[1].add(lbDiscountAmount);
            midPaneLabels[2].add(lbAmountToPay);
            midPaneLabels[3].add(lbAddPoints);
            midPaneLabels[4].add(lbRedeemPoints);
        }
        else if (user instanceof Member && ((MemberPayment)paymentCalc).getIsRedeemPoints() == false){ // No redeem
            midPaneLabels[0].add(lbTotalAmount);
            midPaneLabels[1].add(lbDiscountAmount);
            midPaneLabels[2].add(lbAmountToPay);
            midPaneLabels[3].add(lbAddPoints);
        }
        else { // Regular customer using card method
            midPaneLabels[0].add(lbName);
            midPaneLabels[1].add(lbAddress);
            midPaneLabels[2].add(lbPhoneNo);
            midPaneLabels[3].add(lbTotalAmount);
            midPaneLabels[4].add(lbDiscountAmount);
            midPaneLabels[5].add(lbAmountToPay);
        }

        // Bottom fixed panels for different pay method
        if (paymentCalc.getPayMethod() == "Card"){
            midPaneLabels[rowNum - 3].add(lbCardNumber);
            midPaneLabels[rowNum - 2].add(lbExpirationDate);
            midPaneLabels[rowNum - 1].add(lbCVCode);
        }
        else    
            midPaneLabels[rowNum - 1].add(lbPaidAmount);
        
        // Information for payment details
        JTextField infoName = new JTextField(35);
        JTextField infoAddress = new JTextField(70);
        JTextField infoPhoneNo = new JTextField(15);
        JLabel infoTotalAmount = new JLabel("RM " + String.valueOf(paymentCalc.getRawTotal()));
        JLabel infoDiscountAmount = new JLabel("RM " + String.valueOf(paymentCalc.getDiscountAmount())); 
        JLabel infoMemberFees = new JLabel("RM " + String.valueOf(MemberPayment.getMemberFees()));
        JLabel infoAmountToPay = new JLabel("RM " + String.valueOf(paymentCalc.getAdjTotal()));
        JLabel infoAddPoints = new JLabel(String.valueOf(Member.getAddPoints(paymentCalc.getRawTotal())));
        JLabel infoRedeemPoints = new JLabel();
        if (user instanceof Member)
            infoRedeemPoints = new JLabel(String.valueOf(((MemberPayment)paymentCalc).getPointsRedeemed())); 
        JTextField tfCardNumber = new JTextField(20);
        JComboBox<String> cbMonth = new JComboBox<>(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"});
        JLabel lbSlash = new JLabel("/");
        JComboBox<String> cbYear = new JComboBox<>(new String[]{"2020", "2021", "2022", "2023", "2024", "2025"});
        JTextField tfCVCode = new JTextField(3);
        JTextField tfPaidAmount = new JTextField(10);

        // Set font for information
        infoName.setFont(wordFont);
        infoAddress.setFont(wordFont);
        infoPhoneNo.setFont(wordFont);
        infoTotalAmount.setFont(wordFont);
        infoDiscountAmount.setFont(wordFont);
        infoMemberFees.setFont(wordFont);
        infoAmountToPay.setFont(wordFont);
        infoAddPoints.setFont(wordFont);
        infoRedeemPoints.setFont(wordFont);
        tfCardNumber.setFont(wordFont);
        cbMonth.setFont(wordFont);
        cbYear.setFont(wordFont);
        tfCVCode.setFont(wordFont);
        tfCVCode.setToolTipText("Enter 3 numbers");
        tfPaidAmount.setFont(wordFont);

        // Add information to each information panel
        JPanel[] midPaneInfo = new JPanel[rowNum];
        for (int i = 0; i < rowNum; i++){
            midPaneInfo[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        }
        if (user instanceof Member && (Member.getNextMemberID() - 1) == ((Member)user).getMemberID()){ // New member
            midPaneInfo[0].add(infoTotalAmount);
            midPaneInfo[1].add(infoDiscountAmount);
            midPaneInfo[2].add(infoMemberFees);
            midPaneInfo[3].add(infoAmountToPay);
            midPaneInfo[4].add(infoAddPoints);
        }
        else if (user instanceof Member && ((MemberPayment)paymentCalc).getIsRedeemPoints() == true){ // Redeem 
            midPaneInfo[0].add(infoTotalAmount);
            midPaneInfo[1].add(infoDiscountAmount);
            midPaneInfo[2].add(infoAmountToPay);
            midPaneInfo[3].add(infoAddPoints);
            midPaneInfo[4].add(infoRedeemPoints);
        }
        else if (user instanceof Member && ((MemberPayment)paymentCalc).getIsRedeemPoints() == false){ // No redeem
            midPaneInfo[0].add(infoTotalAmount);
            midPaneInfo[1].add(infoDiscountAmount);
            midPaneInfo[2].add(infoAmountToPay);
            midPaneInfo[3].add(infoAddPoints);
        }
        else { // Regular customer
            midPaneInfo[0].add(infoName);
            midPaneInfo[1].add(infoAddress);
            midPaneInfo[2].add(infoPhoneNo);
            midPaneInfo[3].add(infoTotalAmount);
            midPaneInfo[4].add(infoDiscountAmount);
            midPaneInfo[5].add(infoAmountToPay);
        }

        // Bottom fixed information for different pay method
        if (paymentCalc.getPayMethod() == "Card"){
            midPaneInfo[rowNum - 3].add(tfCardNumber);
            midPaneInfo[rowNum - 2].add(cbMonth);
            midPaneInfo[rowNum - 2].add(lbSlash);
            midPaneInfo[rowNum - 2].add(cbYear);
            midPaneInfo[rowNum - 1].add(tfCVCode);
        }
        else 
            midPaneInfo[rowNum - 1].add(tfPaidAmount);

        // Add each label and information panel to mid left panel and mid right panel
        JPanel midPaneLeft = new JPanel(new GridLayout(rowNum,1));
        JPanel midPaneRight = new JPanel(new GridLayout(rowNum,1));
        for (int i = 0; i < rowNum; i++){
            midPaneLeft.add(midPaneLabels[i]);
            midPaneRight.add(midPaneInfo[i]);
        }
        
        // Top title part
        JPanel midPaneTop = new JPanel(new FlowLayout());
        JLabel lbTitle = new JLabel("Payment Details");
        lbTitle.setFont(new Font("", Font.BOLD, 30));
        midPaneTop.add(lbTitle);

        // Bottom button part
        JPanel midPaneBtm = new JPanel(new FlowLayout());
        JButton btnPay = new JButton("Pay");
        btnPay.setFont(new Font("", Font.BOLD, 20));
        btnPay.setBackground(Color.black);
        btnPay.setForeground(Color.red);
        btnPay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (user instanceof Member){ // Check for member
                    if (paymentCalc.getPayMethod() == "Card"){
                        if (tfCardNumber.getText() == null || tfCardNumber.getText().trim().isEmpty() || tfCVCode.getText() == null || tfCVCode.getText().trim().isEmpty()) 
                            JOptionPane.showMessageDialog(null, "There is column left blank.\nPlease check again.", "Unable to proceed", JOptionPane.ERROR_MESSAGE);
                        else {
                            checkCardInfo(user, tfCardNumber, tfCVCode, cbMonth, cbYear);
                        }
                    }
                    else {
                        if (tfPaidAmount.getText() == null || tfPaidAmount.getText().trim().isEmpty()) 
                            JOptionPane.showMessageDialog(null, "There is column left blank.\nPlease check again.", "Unable to proceed", JOptionPane.ERROR_MESSAGE);
                        else {
                            checkCashPayment(user, paymentCalc, tfPaidAmount);
                        }
                    }
                }
                else { // Check for customer
                    if (paymentCalc.getPayMethod() == "Card"){
                        if (infoName.getText() == null || infoName.getText().trim().isEmpty() || infoAddress.getText() == null || infoAddress.getText().trim().isEmpty() || infoPhoneNo.getText() == null || infoPhoneNo.getText().trim().isEmpty() || tfCardNumber.getText() == null || tfCardNumber.getText().trim().isEmpty() || tfCVCode.getText() == null || tfCVCode.getText().trim().isEmpty()) 
                            JOptionPane.showMessageDialog(null, "There is column left blank.\nPlease check again.", "Unable to proceed", JOptionPane.ERROR_MESSAGE);
                        else {
                            setCustomerDetails(user, infoName, infoAddress, infoPhoneNo);
                            checkCardInfo(user, tfCardNumber, tfCVCode, cbMonth, cbYear);    
                        }
                    }
                    else {
                        if (infoName.getText() == null || infoName.getText().trim().isEmpty() || infoAddress.getText() == null || infoAddress.getText().trim().isEmpty() || infoPhoneNo.getText() == null || infoPhoneNo.getText().trim().isEmpty() || tfPaidAmount.getText() == null || tfPaidAmount.getText().trim().isEmpty()) 
                            JOptionPane.showMessageDialog(null, "There is column left blank.\nPlease check again.", "Unable to proceed", JOptionPane.ERROR_MESSAGE);
                        else {
                            setCustomerDetails(user, infoName, infoAddress, infoPhoneNo);
                            checkCashPayment(user, paymentCalc, tfPaidAmount);
                        }
                    }
                }
            }
        });
        midPaneBtm.add(btnPay);

        // Middle panel
        JPanel midPane = new JPanel(new BorderLayout());
        midPane.add(midPaneLeft, BorderLayout.LINE_START);
        midPane.add(midPaneRight, BorderLayout.CENTER);
        midPane.add(midPaneTop, BorderLayout.PAGE_START);
        midPane.add(midPaneBtm, BorderLayout.PAGE_END);

        // Main panel
        pane.add(midPane, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "Payment Details");
    }
}