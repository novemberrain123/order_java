package order_java.classes;

public class MemberPayment extends PaymentCalc{
    private final static double memberDiscount = 0.1; // Permanent discount for member
    private final static double memberFees = 20.0; // Amount of member fees
    private final static double discountRate500 = 0.03; // Discount rate for redeeming 500 points
    private final static double discountRate1000 = 0.07; // Discount rate for redeeming 1000 points
    private final static double discountRate1500 = 0.12; // Discount rate for redeeming 1500 points
    private boolean isRedeemPoints; // Check whether a member is redeeming their points
    private int pointsRedeemed; // Quantity of points redeemed by member
    private int generatedLuckyNumber; // To perform matching with lucky number entered by new member

    public MemberPayment(){

    }

    public static void createMemberPayment(){
        pointsToMemPayment();
    }

    public static double getMemberFees(){
        return memberFees;
    }

    public void addMemberFees(){ // When new member sign up
        setAdjTotal(memberFees);
    }

    public void setIsRedeemPoints(boolean isRedeemPoints){
        this.isRedeemPoints = isRedeemPoints;
    }

    public boolean getIsRedeemPoints(){
        return isRedeemPoints;
    }

    public void setPointsRedeemed(int option){
        if (option == 0)
            this.pointsRedeemed = 500;
        else if (option == 1)
            this.pointsRedeemed = 1000;
        else
            this.pointsRedeemed = 1500;
    }

    public int getPointsRedeemed() {
        return pointsRedeemed;
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

    public void generateLuckyNumber(){ // Generate lucky number when new member signed up
        generatedLuckyNumber = (int)(1 + Math.random() * 5);
    }

    public int getGeneratedLuckyNumber(){
        return generatedLuckyNumber;
    }

    public boolean matchLuckyNumber(Customer member){ // Check for matching of lucky number for raffle purpose
        if (((Member)member).getLuckyNumber() == generatedLuckyNumber)
            return true;
        else
            return false;
    } 
}