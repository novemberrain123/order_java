package order_java;
import java.awt.*;
import javax.swing.*;

public class PageMarket{
    public static Image rescaleImage(ImageIcon img,int x,int y,int s){
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(x, y, s);
        return newimg;
    }
    public static void addComponentsToMarketHomePane(Container pane){
        JPanel midPane = new JPanel();
        midPane.setLayout(new GridLayout(2,2));

        JButton btnCustomShirt = new JButton("Design Your Own T-Shirt");
        JButton btnBrowse = new JButton("Browse Our Selection");

        ImageIcon customShirt = new ImageIcon("img/shirt1.png");
        customShirt = new ImageIcon(rescaleImage(customShirt, 100, 100, 4));
        JLabel customShirtLabel = new JLabel("");
        customShirtLabel.setIcon(customShirt);

        ImageIcon browse = new ImageIcon("img/shirts.png");
        browse = new ImageIcon(rescaleImage(browse, 100, 100, 4));
        JLabel browseLabel = new JLabel("");
        browseLabel.setIcon(browse);

        midPane.add(customShirtLabel);
        midPane.add(browseLabel);
        midPane.add(btnCustomShirt);
        midPane.add(btnBrowse);
        
        pane.add(midPane,BorderLayout.CENTER);
    }
}