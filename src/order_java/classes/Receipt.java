package order_java.classes;

import java.util.*;
import java.text.*;

public class Receipt{
    private int receiptNo;
    private Date transactionDate;
    private static int nextReceiptNo = 1001;
    
    public Receipt(){
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
}