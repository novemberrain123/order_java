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
        frame.setVisible(true);
     }
}