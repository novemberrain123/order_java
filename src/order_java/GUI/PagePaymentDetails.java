package order_java.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import order_java.classes.CardInfo;
import order_java.classes.CashPayment;
import order_java.classes.Customer;
import order_java.classes.Member;
import order_java.classes.MemberPayment;
import order_java.classes.PaymentCalc;

public class PagePaymentDetails {
    public static PagePaymentDetails ppd;

	public static void checkCardInfo(Customer user, JTextField tfCardNumber, JTextField tfCVCode, JComboBox<String> cbMonth, JComboBox<String> cbYear){ // Check whether card is valid or not
        CardInfo cardInfo; 
        cardInfo = new CardInfo(tfCardNumber.getText(), (String)cbMonth.getSelectedItem() + "/" + (String)cbYear.getSelectedItem(), Integer.parseInt(tfCVCode.getText())); // Create new card info
        if (cardInfo.validateCard()){ // Valid card
            user.setCardInfo(cardInfo); // Set card info
            CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
            PageReceipt.pr = new PageReceipt(); // "Receipt"
            cl.show(MiscFunctions.masterCards,"Receipt");
        }
        else  // Invalid card
            JOptionPane.showMessageDialog(null, "Your card information is incorrect.\nPlease check again", "Invalid card", JOptionPane.ERROR_MESSAGE);
    }

    public static void checkCashPayment(Customer user, PaymentCalc paymentCalc, JTextField tfPaidAmount){
        CashPayment cashPayment;
        cashPayment = new CashPayment(Double.parseDouble(tfPaidAmount.getText()));
        if (cashPayment.validateCash(paymentCalc.getAdjTotal())){ // Sufficient cash amount
            user.setCashPayment(cashPayment); // Set cash payment
            paymentCalc.calculateChange(cashPayment);
            CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
            PageReceipt.pr = new PageReceipt(); // "Receipt"
            cl.show(MiscFunctions.masterCards,"Receipt");
        }
        else // Insufficient cash amount
            JOptionPane.showMessageDialog(null, "Your cash payment is insufficient.\nPlease check again", "Insufficient cash payment", JOptionPane.ERROR_MESSAGE);
    }

    public static void setCustomerDetails(Customer user, JTextField infoName, JTextField infoAddress, JTextField infoPhoneNo){
        user.setName(infoName.getText()); // Set customer name
        user.setAddress(infoAddress.getText()); // Set customer address
        user.setPhoneNo(infoPhoneNo.getText()); // Set customer phone number
    }

    public PagePaymentDetails(){
        Customer user = Customer.getCustomer(); // Local variable pointing to user static variable
        PaymentCalc paymentCalc = PaymentCalc.getPaymentCalc(); // Local variable pointing to paymentCalc static variable

        JPanel pane = new JPanel(new BorderLayout()); // Main panel
        Font wordFont = new Font("", Font.PLAIN, 15);
        int rowNum; // Number of rows presented in payment details page
        // Setting number of rows based on the status of current customer
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
        JPanel[] midPaneLabels = new JPanel[rowNum]; // Individual panels to include payment details labels
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

        // Add labels to each individual label panel
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
        else { // Regular customer 
            midPaneLabels[0].add(lbName);
            midPaneLabels[1].add(lbAddress);
            midPaneLabels[2].add(lbPhoneNo);
            midPaneLabels[3].add(lbTotalAmount);
            midPaneLabels[4].add(lbDiscountAmount);
            midPaneLabels[5].add(lbAmountToPay);
        }

        // Bottom fixed panels for different pay method
        if (paymentCalc.getPayMethod() == "Card"){ // Pay by card
            midPaneLabels[rowNum - 3].add(lbCardNumber);
            midPaneLabels[rowNum - 2].add(lbExpirationDate);
            midPaneLabels[rowNum - 1].add(lbCVCode);
        }
        else // Pay by cash
            midPaneLabels[rowNum - 1].add(lbPaidAmount);
        
        // Information for payment details
        JTextField infoName = new JTextField(35);
        JTextField infoAddress = new JTextField(70);
        JTextField infoPhoneNo = new JTextField(15);
        JLabel infoTotalAmount = new JLabel("RM " + String.format("%-7.2f",paymentCalc.getRawTotal()));
        JLabel infoDiscountAmount = new JLabel("RM " + String.format("%-6.2f",paymentCalc.getDiscountAmount())); 
        JLabel infoMemberFees = new JLabel();
        if (user instanceof Member && (Member.getNextMemberID() - 1) == ((Member)user).getMemberID()){ // New member
            if (((Member)user).getIsFreeMembership()) // Free membership
                infoMemberFees = new JLabel("RM 0.00");
            else 
                infoMemberFees = new JLabel("RM " + String.format("%-4.2f",MemberPayment.getMemberFees()));
        }
        JLabel infoAmountToPay = new JLabel("RM " + String.format("%-7.2f",paymentCalc.getAdjTotal()));
        JLabel infoAddPoints = new JLabel(String.format("%-6.2f",Member.getAddPoints(paymentCalc.getRawTotal())));
        JLabel infoRedeemPoints = new JLabel();
        if (user instanceof Member)
            infoRedeemPoints = new JLabel(String.format("%-4d",((MemberPayment)paymentCalc).getPointsRedeemed())); 
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

        // Add information to each individual information panel
        JPanel[] midPaneInfo = new JPanel[rowNum]; // Individual panels to include payment details information
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

        // Add each label and information panel to middle left panel and middle right panel
        JPanel midPaneLeft = new JPanel(new GridLayout(rowNum,1));
        JPanel midPaneRight = new JPanel(new GridLayout(rowNum,1));
        for (int i = 0; i < rowNum; i++){
            midPaneLeft.add(midPaneLabels[i]);
            midPaneRight.add(midPaneInfo[i]);
        }
        
        // Top title part
        JPanel paneTop = new JPanel(new FlowLayout());
        JLabel lbTitle = new JLabel("Payment Details");
        lbTitle.setFont(new Font("", Font.BOLD, 30));
        paneTop.add(lbTitle);

        // Bottom button part
        JPanel paneBtm = new JPanel(new FlowLayout());
        JButton btnPay = new JButton("Pay");
        btnPay.setFont(new Font("", Font.BOLD, 20));
        btnPay.setBackground(Color.black);
        btnPay.setForeground(Color.red);
        btnPay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (user instanceof Member){ // Check for member
                    if (paymentCalc.getPayMethod() == "Card"){
                        if (tfCardNumber.getText() == null || tfCardNumber.getText().trim().isEmpty() || tfCVCode.getText() == null || tfCVCode.getText().trim().isEmpty()) // Emptied fields
                            JOptionPane.showMessageDialog(null, "There is column left blank.\nPlease check again.", "Unable to proceed", JOptionPane.ERROR_MESSAGE);
                        else { // Check the validity of card information
                            checkCardInfo(user, tfCardNumber, tfCVCode, cbMonth, cbYear);
                        }
                    }
                    else {
                        if (tfPaidAmount.getText() == null || tfPaidAmount.getText().trim().isEmpty()) 
                            JOptionPane.showMessageDialog(null, "There is column left blank.\nPlease check again.", "Unable to proceed", JOptionPane.ERROR_MESSAGE);
                        else { // Check the sufficiency of cash amount
                            checkCashPayment(user, paymentCalc, tfPaidAmount);
                        }
                    }
                }
                else { // Check for customer
                    if (paymentCalc.getPayMethod() == "Card"){
                        if (infoName.getText() == null || infoName.getText().trim().isEmpty() || infoAddress.getText() == null || infoAddress.getText().trim().isEmpty() || infoPhoneNo.getText() == null || infoPhoneNo.getText().trim().isEmpty() || tfCardNumber.getText() == null || tfCardNumber.getText().trim().isEmpty() || tfCVCode.getText() == null || tfCVCode.getText().trim().isEmpty()) // Emptied fields
                            JOptionPane.showMessageDialog(null, "There is column left blank.\nPlease check again.", "Unable to proceed", JOptionPane.ERROR_MESSAGE);
                        else { 
                            setCustomerDetails(user, infoName, infoAddress, infoPhoneNo); // Set customer info
                            checkCardInfo(user, tfCardNumber, tfCVCode, cbMonth, cbYear);    
                        }
                    }
                    else {
                        if (infoName.getText() == null || infoName.getText().trim().isEmpty() || infoAddress.getText() == null || infoAddress.getText().trim().isEmpty() || infoPhoneNo.getText() == null || infoPhoneNo.getText().trim().isEmpty() || tfPaidAmount.getText() == null || tfPaidAmount.getText().trim().isEmpty()) 
                            JOptionPane.showMessageDialog(null, "There is column left blank.\nPlease check again.", "Unable to proceed", JOptionPane.ERROR_MESSAGE);
                        else {
                            setCustomerDetails(user, infoName, infoAddress, infoPhoneNo); // Set customer info
                            checkCashPayment(user, paymentCalc, tfPaidAmount);
                        }
                    }
                }
            }
        });
        paneBtm.add(btnPay);

        // Add each panel to main panel
        pane.add(midPaneLeft, BorderLayout.LINE_START);
        pane.add(midPaneRight, BorderLayout.CENTER);
        pane.add(paneTop, BorderLayout.PAGE_START);
        pane.add(paneBtm, BorderLayout.PAGE_END);

        // Add to master cards panel
        MiscFunctions.addCardtoMasterCards(pane, "Payment Details");
    }
}