package order_java.classes;

public class CashPayment{
   private double payment; 

   public CashPayment(){
      
   }

   public CashPayment(double payment){
      this.payment = payment;
   }

   public double getPayment(){
      return payment;
   }
}