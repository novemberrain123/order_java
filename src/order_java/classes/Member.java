package order_java.classes;

public class Member extends Customer{
    private int memberID;
    private String password;
    private double points;
    private static int nextMemberID = 1001;
    private final double convertPoints = 0.3;
    private final double discountRate500 = 0.03;
    private final double discountRate1000 = 0.07;
    private final double discountRate1500 = 0.12;

    public Member(){

    }

    public Member(String password){
        memberID = nextMemberID;
        this.password = password;
        nextMemberID++;
    }

    public int getMemberID(){
        return memberID;
    }
    public void setPoints(int points){
        this.points = points;
    }
    public double getPoints(){
        return points;
    }

    public double redeemPoints(double rawTotal){
        if (points >= 500){
            points -= 500;
            return rawTotal * discountRate500;
        }
        else if (points >= 1000){
            points -= 1000;
            return rawTotal * discountRate1000;
        }
        else {
            points -= 1500;
            return rawTotal * discountRate1500;
        }
}

    public void addPoints(double rawTotal){
        points += rawTotal * convertPoints;
    }

    
}