package order_java.classes;

public class Customer {
    String name;
    String address;
    String phoneNo;
    Order order;
    CardInfo cardInfo;
    CashPayment cash;

    public Customer(){

    }

    public Customer(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public Order getOrder(){
        return order;
    }

    public void setCardInfo(CardInfo cardInfo){
        this.cardInfo = cardInfo;
    }

    public CardInfo getCardInfo(){
        return cardInfo;
    }

    public void setCashPayment(CashPayment cash){
        this.cash = cash;
    }

    public CashPayment getCashPayment(){
        return cash;
    }
}