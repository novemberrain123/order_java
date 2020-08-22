package order_java.classes;

public class MemberPayment extends PaymentCalc{
    private final static double memberDiscount = 0.1;
    private final static double memberFees = 20.0;
    private final double discountRate500 = 0.03;
    private final double discountRate1000 = 0.07;
    private final double discountRate1500 = 0.12;
    private int generatedLuckyNumber;
    
    public MemberPayment(){
        generatedLuckyNumber = (int)(Math.random() * 6);
    }

    public void addMemberFees(){ // When new member sign up
        setAdjTotal(memberFees);
    }

    @Override
    public void calculateDiscountAmount(){  // When member no redeem points
        setDiscountAmount(getRawTotal() * memberDiscount);
    }

    public void calculateDiscountAmount(int pointsSelection){ // When member redeem points
        double total = getRawTotal();
        calculateDiscountAmount();
        if (pointsSelection == 0){
            total -= getDiscountAmount();
            setDiscountAmount(getDiscountAmount() + (total * discountRate500));
        }
        else if (pointsSelection == 1){
            total -= getDiscountAmount();
            setDiscountAmount(getDiscountAmount() + (total * discountRate1000));
        }
        else {
            total -= getDiscountAmount();
            setDiscountAmount(getDiscountAmount() + (total * discountRate1500));
        }
    }

    public int getGeneratedLuckyNumber(){
        return generatedLuckyNumber;
    }

    public boolean matchLuckyNumber(Customer member){
        if (((Member)member).getLuckyNumber() == generatedLuckyNumber)
            return true;
        else
            return false;
    } 
}