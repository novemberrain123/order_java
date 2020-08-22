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
}