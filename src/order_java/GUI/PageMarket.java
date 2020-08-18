package order_java.GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PageMarket{
    public static Image rescaleImage(ImageIcon img,int x,int y,int s){
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(x, y, s);
        return newimg;
    }
    public static void createPageMarket(){
        JPanel pane = new JPanel(); //main pane 
        JPanel midPane = new JPanel();
        midPane.setLayout(new GridLayout(2,1));
        
        JPanel topMidPane = new JPanel();
        JPanel btmMidPane = new JPanel();
        JButton btnCustomShirt = new JButton("Design Your Own T-Shirt");
        btnCustomShirt.setPreferredSize(new Dimension(200,40));
        
        JButton btnBrowse = new JButton("Browse Our Selection");
        btnBrowse.setPreferredSize(new Dimension(200,40));
        btnBrowse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards,"Browse");
            }
        });
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
        MiscFunctions.addCardtoMasterCards(pane, "Market");
    }
    static String allStr = "All";
    static String hoodieStr= "Hoodie";
    static String tshirtStr = "T-Shirt";
    public static void createPageBrowse(){
        JPanel pane = new JPanel(new BorderLayout());
        //pass in main JPanel and name of previous page for back btn
        MiscFunctions.addDefaultComponentsToPane(pane, "Market",1);

        JRadioButton btnAll = new JRadioButton(allStr);
        btnAll.setActionCommand(allStr);
        btnAll.setSelected(true);

        JRadioButton btnHoodie = new JRadioButton(hoodieStr);
        btnAll.setActionCommand(hoodieStr);
        
        JRadioButton btnTshirt = new JRadioButton(tshirtStr);
        btnAll.setActionCommand(tshirtStr);

        ButtonGroup group = new ButtonGroup();
        group.add(btnAll);
        group.add(btnHoodie);
        group.add(btnTshirt);

        JPanel filterPane = new JPanel();
        filterPane.setLayout(new BoxLayout(filterPane, BoxLayout.Y_AXIS));
        filterPane.add(new JLabel("Apparel Type"));
        filterPane.add(btnAll);
        filterPane.add(btnHoodie);
        filterPane.add(btnTshirt);

        pane.add(filterPane, BorderLayout.LINE_START);


        JPanel[] shirtPane = new JPanel[10];
        for(int i=0; i<10; i++){
            shirtPane[i]=new JPanel();
            shirtPane[i].setLayout(new BoxLayout(shirtPane[i], BoxLayout.Y_AXIS));

            ImageIcon img = new ImageIcon("img/browse"+ Integer.toString(i) +".png");
            img=new ImageIcon(rescaleImage(img,150,150,4));
            JLabel lbl = new JLabel("");
            lbl.setIcon(img);

            shirtPane[i].add(lbl);
        }

        shirtPane[0].add(new JLabel("Supermind T-Shirt"));
        shirtPane[1].add(new JLabel("Mountain T-Shirt"));
        shirtPane[2].add(new JLabel("Jurassic T-Shirt"));
        shirtPane[3].add(new JLabel("Leonardo Da Corona T-Shirt"));
        shirtPane[4].add(new JLabel("Green T-Shirt"));
        shirtPane[5].add(new JLabel("Heaven T-Shirt"));
        shirtPane[6].add(new JLabel("Marriage T-Shirt"));
        shirtPane[7].add(new JLabel("WayTooDank T-Shirt"));
        shirtPane[8].add(new JLabel("FoxNews T-Shirt"));
        shirtPane[9].add(new JLabel("Inspirational T-Shirt"));
        
        JPanel midPane = new JPanel();
        for(int i=0;i<10;i++){
            midPane.add(shirtPane[i]);
        }
        pane.add(midPane,BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "Browse");
    }
}