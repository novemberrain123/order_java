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
        midPane.setLayout(new GridLayout(2,1));
        
        JPanel topMidPane = new JPanel();
        JPanel btmMidPane = new JPanel();
        JButton btnCustomShirt = new JButton("Design Your Own T-Shirt");
        btnCustomShirt.setPreferredSize(new Dimension(200,40));
        JButton btnBrowse = new JButton("Browse Our Selection");
        btnBrowse.setPreferredSize(new Dimension(200,40));

        ImageIcon customShirt = new ImageIcon("img/shirt1.png");
        customShirt = new ImageIcon(rescaleImage(customShirt, 200, 200, 4));
        JLabel customShirtLabel = new JLabel("");
        customShirtLabel.setIcon(customShirt);

        ImageIcon browse = new ImageIcon("img/shirts.png");
        browse = new ImageIcon(rescaleImage(browse, 200, 200, 4));
        JLabel browseLabel = new JLabel("");
        browseLabel.setIcon(browse);

        topMidPane.add(customShirtLabel);
        topMidPane.add(browseLabel);
        btmMidPane.add(btnCustomShirt);
        btmMidPane.add(btnBrowse);
        
        midPane.add(topMidPane);
        midPane.add(btmMidPane);
        pane.add(midPane,BorderLayout.CENTER);
    }
}