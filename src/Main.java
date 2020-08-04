package order_java;
import java.awt.*;
import javax.swing.*;

public class Main{

    public static void main(String args[]){
        JFrame frame = Windows.createShowGUI(2);
        JFrame frame2 = Windows.createShowGUI(2);
        PageMarket.addComponentsToMarketHomePane(frame.getContentPane());
        frame.setVisible(true);
        PageMarket.addComponentsToBrowsePane(frame2.getContentPane());
        frame2.setVisible(true);

     }
}