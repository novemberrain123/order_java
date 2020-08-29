package order_java.classes;

public class Customer {
    private String name;
    private String address;
    private String phoneNo;
    private Order order;
    private CardInfo cardInfo;
    private CashPayment cash;
    private static Customer user;

    public Customer(){

    }

    public Customer(String name){ // Constructor used by member class to assign name for regular member
        this.name = name;
    }

    public Customer(Order order){ // Constructor to create a customer object when a new order has been made
        this.order = order;
    }

    public static void createCustomer(Order order){ // Create a customer object once an order is made
        user = new Customer(order);
    }

    // Called by member class to points static var (user) to a new member object when new member signed up
    public static void pointsToNewMem(){ 
        user = new Member();
    }

    // Called by member class to points static var (user) to a new member object when regular member login
    public static void pointsToRegMem(String name, int memberID, String password, int points){
        user = new Member(name, memberID, password, points);
    }

    // Transfer customer order from a customer object to a new member object when new member signed up
    public static void transferOrder(Order order){ 
        user.setOrder(order);
    }

    // Set new member details
    public static void setNewMemberDetails(String name, String address, String phoneNo){
        user.setName(name);
        user.setAddress(address);
        user.setPhoneNo(phoneNo);
    }

    public static Customer getCustomer(){ 
        return user;
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