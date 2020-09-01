package order_java.classes;

public class CashPayment {
   private double amount;

   public CashPayment() {

   }

   public CashPayment(double amount) {
      this.amount = amount;
   }

   public void setPayment(double amount) {
      this.amount = amount;
   }

   public double getPayment() {
      return amount;
   }

   // To identify whether cash paid by customer is sufficient or not
   public boolean validateCash(double adjTotal) {
      if (amount >= adjTotal)
         return true;
      else
         return false;
   }
}