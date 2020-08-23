package order_java.classes;

import java.util.*;
import java.text.*;

public class Receipt{
    private int receiptNo;
    private Date transactionDate;
    private Customer user;
    private PaymentCalc paymentCalc;
    private static int nextReceiptNo = 1001;
    
    public Receipt(Customer user, PaymentCalc paymentCalc){
        this.user = user;
        this.paymentCalc = paymentCalc;
        transactionDate = new Date();
        receiptNo = nextReceiptNo;
        nextReceiptNo++;
    }

    public int getReceiptNo(){
        return receiptNo;
    }

    public String getTransactionDate(){
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMM-yyyy");
        return formatDate.format(transactionDate);
    }

    public String getTransactionTime(){
        SimpleDateFormat formatTime = new SimpleDateFormat("dd-MMM-yyyy");
        return formatTime.format(transactionDate);
    }

    public Customer getCustomer(){
        return user;
    }

    public PaymentCalc getPaymentCalc(){
        return paymentCalc;
    }
}