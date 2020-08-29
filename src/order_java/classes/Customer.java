package order_java.classes;

public class Customer {
    private String name;
    private String address;
    private String phoneNo;
    private Order order;
    private CardInfo cardInfo;
    private CashPayment cash;
    private static Customer user;

    public Customer() {

    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(Order order) {
        this.order = order;
    }

    public static void createCustomer(Order order) { // Create a customer object once an order is made
        user = new Customer(order);
    }

    // Used to create regular member at the beginning of the program
    public static void createMember(String name, int memberID, String password, int points) {
        user = new Member(name, memberID, password, points);
    }

    public static void setNewMember() {
        user = new Member();
    }

    public static void transferOrder(Order order) {
        user.setOrder(order);
    }

    public static void setNewMemberDetails(String name, String address, String phoneNo) {
        user.setName(name);
        user.setAddress(address);
        user.setPhoneNo(phoneNo);
    }

    public static Customer getCustomer() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCashPayment(CashPayment cash) {
        this.cash = cash;
    }

    public CashPayment getCashPayment() {
        return cash;
    }
}