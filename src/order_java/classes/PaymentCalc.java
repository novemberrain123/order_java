package order_java.classes;

public class PaymentCalc{
    private double rawTotal;
    private double adjTotal;
    private double discountAmount;
    private double change;
    private final double discountPercent = 0.1;

    public PaymentCalc(){

    }

    public double calculateTotal(Apparel.price[] prices, Apparel.quantity[] quantities){
        for (int i = 0; i < prices.length; i++){
            rawTotal += prices[i] * quantities[i];
        }
        return rawTotal;
    }

    public double applyDiscount(){
        discountAmount = rawTotal * discountPercent;
        return discountAmount;
    }

    public double applyDiscount(double redeemPointsDiscount){
        discountAmount = rawTotal * discountPercent + redeemPointsDiscount;
        return discountAmount;
    }

    public double getAdjTotal(){
        adjTotal = rawTotal - discountAmount;
        return adjTotal;
    }

    public double calculateChange(CashPayment cash){
        change = cash.getPayment() - adjTotal;
        return change;
    }
}
