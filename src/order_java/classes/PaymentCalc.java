package order_java.classes;

import java.util.*;

public abstract class PaymentCalc {
    private double rawTotal;
    private double adjTotal;
    private double discountAmount;
    private double change;
    private String payMethod; 
    private static PaymentCalc paymentCalc;

    protected PaymentCalc(){
        
    }

    public static void pointsToCusPayment(){
        paymentCalc = new CustomerPayment();
    }

    public static void pointsToMemPayment(){
        paymentCalc = new MemberPayment();
    }

    public static PaymentCalc getPaymentCalc(){
        return paymentCalc;
    }

    public void setRawTotal(double rawTotal){
        this.rawTotal = rawTotal;
    }

    public double getRawTotal(){
        return rawTotal;
    }

    public void setDiscountAmount(double discountAmount){
        this.discountAmount = discountAmount;
    }

    public double getDiscountAmount(){
        return discountAmount;
    }

    public void setAdjTotal(double adjTotal){
        this.adjTotal = adjTotal;
    }

    public double getAdjTotal(){
        return adjTotal;
    }

    public void setChange(double change){
        this.change = change;
    }

    public double getChange(){
        return change;
    }

    public void setPayMethod(String payMethod){
        this.payMethod = payMethod;
    }

    public String getPayMethod(){
        return payMethod;
    }

    public void calculateRawTotal(){
        ArrayList<Apparel> apparel = Customer.getCustomer().getOrder().getShirts();
        for (Apparel app : apparel){
            rawTotal += app.getQuantity() * app.getPrice();
        }
    }

    public void calculateAdjTotal(){
        adjTotal += rawTotal - discountAmount;
    }

    public void calculateChange(CashPayment cash){
        change = cash.getPayment() - adjTotal;
    }

    public abstract void calculateDiscountAmount(); // Abstract method
}