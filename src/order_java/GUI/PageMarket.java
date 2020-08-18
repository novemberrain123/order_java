package order_java.GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PageMarket {
    public static Image rescaleImage(ImageIcon img,int x,int y,int s){
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(x, y, s);
        return newimg;
    }
    public static void createPageMarket(){
        JPanel pane = new JPanel(new BorderLayout()); //main pane 
        MiscFunctions.addDefaultComponentsToPane(pane, "Home", 1);
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
    static JPanel leftPane = new JPanel();
    static JPanel rightPane = new JPanel();

    public static void createPageBrowse(){
        JPanel pane = new JPanel(new BorderLayout());
        //pass in main JPanel and name of previous page for back btn
        MiscFunctions.addDefaultComponentsToPane(pane, "Market",1);

        JRadioButton btnAll = new JRadioButton(allStr);
        btnAll.setActionCommand(allStr);
        btnAll.setSelected(true);

        JRadioButton btnHoodie = new JRadioButton(hoodieStr);
        btnHoodie.setActionCommand(hoodieStr);
         
        JRadioButton btnTshirt = new JRadioButton(tshirtStr);
        btnTshirt.setActionCommand(tshirtStr);
         
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
        
        //add shirts to pane
        shirtPane[0].add(new JLabel("Supermind T-Shirt"));
        shirtPane[1].add(new JLabel("Mountain T-Shirt"));
        shirtPane[2].add(new JLabel("Jurassic T-Shirt"));
        shirtPane[3].add(new JLabel("Leonardo Da Corona T-Shirt"));
        shirtPane[4].add(new JLabel("Green T-Shirt"));
        shirtPane[5].add(new JLabel("Heaven T-Shirt"));
        shirtPane[6].add(new JLabel("Marriage Hoodie"));
        shirtPane[7].add(new JLabel("WayTooDank Hoodie"));
        shirtPane[8].add(new JLabel("FoxNews Hoodie"));
        shirtPane[9].add(new JLabel("Inspirational Hoodie"));

        //Define leftpane and rightpane
        leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.Y_AXIS));
        rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));

        //set actionlistener for rbuttons
        btnAll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                leftPane.removeAll();
                rightPane.removeAll();
                for(int i=0;i<5;i++){
                    leftPane.add(shirtPane[i]);
                }
                for(int i=5;i<10;i++){
                    rightPane.add(shirtPane[i]);
                }
                leftPane.revalidate();
                rightPane.revalidate();

            }
        });
       
        btnTshirt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                leftPane.removeAll();
                rightPane.removeAll();
                for(int i=0;i<3;i++){
                    leftPane.add(shirtPane[i]);
                }
                for(int i=3;i<6;i++){
                    rightPane.add(shirtPane[i]);
                }
                leftPane.revalidate();
                rightPane.revalidate();

            }
        });
 
        btnHoodie.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                leftPane.removeAll();
                rightPane.removeAll();
                for(int i=6;i<8;i++){
                    leftPane.add(shirtPane[i]);
                }
                for(int i=8;i<10;i++){
                    rightPane.add(shirtPane[i]);
                }
                leftPane.revalidate();
                rightPane.revalidate();

            }
        });
 
        //create vertical box layouts for all 3 cards
        // JPanel leftAllPane = new JPanel();
        // leftAllPane.setLayout(new BoxLayout(leftAllPane, BoxLayout.Y_AXIS));
        // JPanel rightAllPane = new JPanel();
        // rightAllPane.setLayout(new BoxLayout(rightAllPane, BoxLayout.Y_AXIS));
        // JPanel leftHoodiePane = new JPanel();
        // leftHoodiePane.setLayout(new BoxLayout(leftHoodiePane, BoxLayout.Y_AXIS));
        // JPanel rightHoodiePane = new JPanel();
        // rightHoodiePane.setLayout(new BoxLayout(rightHoodiePane, BoxLayout.Y_AXIS));
        // JPanel leftShirtPane = new JPanel();
        // leftShirtPane.setLayout(new BoxLayout(leftShirtPane, BoxLayout.Y_AXIS));
        // JPanel rightShirtPane = new JPanel();
        // rightShirtPane.setLayout(new BoxLayout(rightShirtPane,BoxLayout.Y_AXIS));
        // //fill out panes
        // for(int i=0;i<5;i++){
        //     leftAllPane.add(shirtPane[i]);
        // }
        // for(int i=5;i<10;i++){
        //     rightAllPane.add(shirtPane[i]);
        // }
        
        // for(int i=6;i<8;i++){
        //     leftHoodiePane.add(shirtPane[i]);
        // }
        // for(int i=8;i<10;i++){
        //     rightHoodiePane.add(shirtPane[i]);
        // }
        
        // for(int i=0;i<3;i++){
        //     leftShirtPane.add(shirtPane[i]);
        // }
        // for(int i=3;i<6;i++){
        //     rightShirtPane.add(shirtPane[i]);
        // }
        
        // //create cards and add vertical panes to cards
        // JPanel allPane = new JPanel();
        // allPane.add(leftAllPane);
        // allPane.add(rightAllPane);
        // JPanel hoodiePane = new JPanel();
        // hoodiePane.add(leftHoodiePane);
        // hoodiePane.add(rightHoodiePane);
        // JPanel TshirtPane = new JPanel();
        // TshirtPane.add(leftShirtPane);
        // TshirtPane.add(rightShirtPane);

        //add left/right panes to midpane
        JPanel midPane = new JPanel();
        midPane.add(leftPane);
        midPane.add(rightPane);
        //add cardPane to scrollPane
        JScrollPane scrollPane = new JScrollPane(midPane);
        scrollPane.setPreferredSize(new Dimension(400,400));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.add(scrollPane,BorderLayout.CENTER);
        btnAll.doClick();
        MiscFunctions.addCardtoMasterCards(pane, "Browse");
    }

}