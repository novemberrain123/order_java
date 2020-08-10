package order_java.GUI;
import java.awt.*;
import javax.swing.*;

public class Main{

    public static void main(String args[]){
        JFrame frame = Windows.createShowGUI(2);
        PageStaffLogin.addComponentsToStaffPane(frame.getContentPane());
        frame.setVisible(true);
        JFrame frame1 = Windows.createShowGUI(2);
        PageCart.addComponentsToCartPane(frame1.getContentPane());
        frame1.setVisible(true);
        JFrame frame2 = Windows.createShowGUI(2);
        PageReport.addComponentToReportPane(frame2.getContentPane());
        frame2.setVisible(true);
        JFrame frame3 = Windows.createShowGUI(2);
        PageMemberLogin.addComponentsToMemberPane(frame3.getContentPane());
        frame3.setVisible(true);
        





    }
}