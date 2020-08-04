package order_java;
import java.awt.*;
import javax.swing.*;

public class Main{

    public static void main(String args[]){
        JFrame frame = Windows.createShowGUI(2);
        PageMembership.addComponentsToMembershipPane(frame.getContentPane());
        frame.setVisible(true);
        JFrame frame1 = Windows.createShowGUI(2);
        PagePayMethod.addComponentsToPayMethodPane(frame1.getContentPane());
        frame1.setVisible(true);
        JFrame frame2 = Windows.createShowGUI(2);
        PageCardPayment.addComponentsToCardPaymentPane(frame2.getContentPane());
        frame2.setVisible(true);
        JFrame frame3 = Windows.createShowGUI(2);
        PageCashPayment.addComponentsToCashPaymentPane(frame3.getContentPane());
        frame3.setVisible(true);
        JFrame frame4 = Windows.createShowGUI(2);
        PageReceipt.addComponentsToReceiptPane(frame4.getContentPane());
        frame4.setVisible(true);
     }
}