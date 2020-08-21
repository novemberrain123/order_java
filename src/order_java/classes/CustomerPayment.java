package order_java.classes;

public class CustomerPayment extends PaymentCalc{
    private char luckyLetter;
    private final static double luckyDiscountRate = 0.05;
    private static char luckyLetter1 = (char)('a' + (Math.random() * ('i' - 'a' + 1)));
    private static char luckyLetter2 = (char)('j' + (Math.random() * ('q' - 'j' + 1)));
    private static char luckyLetter3 = (char)('r' + (Math.random() * ('z' - 'r' + 1)));

    public CustomerPayment(){

    }

    public void setLuckyLetter(char luckyLetter){
        this.luckyLetter = luckyLetter;
    }

    public char getLuckyLetter(){
        return luckyLetter;
    }

    @Override
    public void calculateDiscountAmount(){ // Call only when lucky letter is matched
        double discountAmount = super.getRawTotal() * luckyDiscountRate;
        super.setDiscountAmount(discountAmount);
    }

    public boolean matchLuckyLetter(){
        luckyLetter = Character.toLowerCase(luckyLetter);
        if (luckyLetter == luckyLetter1){
            luckyLetter1 = '0';
            return true;
        }
        else if (luckyLetter == luckyLetter2){
            luckyLetter2 = '0';
            return true;
        }
        else if (luckyLetter == luckyLetter3){
            luckyLetter3 = '0';
            return true;
        }
        else
            return false;
    }
}
