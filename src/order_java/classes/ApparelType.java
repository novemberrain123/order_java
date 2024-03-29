package order_java.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import order_java.GUI.MiscFunctions;
import order_java.GUI.PageMarket;

public class ApparelType implements ActionListener {
    private String shirtName;
    private double basePrice; // t-shirt:s,m,l:15,20,25 hoodie:17,22,27
    private char shirtType;
    public JPanel pane;
    public JPanel rightPane;
    BufferedImage img;
    public static final ApparelType[] apparels = new ApparelType[10];
    private BufferedImage baseComposite;
    private static double shownPrice;

    public ApparelType() {
    }

    public ApparelType(String shirtName, char shirtType, BufferedImage img) throws IOException {
        this.shirtName = shirtName;
        this.shirtType = shirtType;
        switch (shirtType) {
            case 'S':
                basePrice = 20;
                break;
            case 'H':
                basePrice = 22;
        }
        this.img = img;
        generatePane(BROWSE);
    }

    public String getShirtName() {
        return this.shirtName;
    }

    public void setShirtName(String shirtName) {
        this.shirtName = shirtName;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public char getShirtType() {
        return this.shirtType;
    }

    public void setShirtType(char shirtType) {
        this.shirtType = shirtType;
    }

    public JPanel getPane() {
        return this.pane;
    }

    public BufferedImage getImg() {
        return this.img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public ApparelType shirtName(String shirtName) {
        this.shirtName = shirtName;
        return this;
    }

    public ApparelType basePrice(double basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public ApparelType shirtType(char shirtType) {
        this.shirtType = shirtType;
        return this;
    }

    public ApparelType pane(JPanel pane) {
        this.pane = pane;
        return this;
    }

    public ApparelType img(BufferedImage img) {
        this.img = img;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " shirtName='" + getShirtName() + "'" + ", basePrice='" + getBasePrice() + "'" + ", shirtType='"
                + getShirtType() + "'" + ", pane='" + getPane() + "'" + ", img='" + getImg() + "'" + "}";
    }

    JLabel picLabel;
    JLabel price;
    ButtonGroup bgGroup;
    int g;
    public static final int CUSTOM = 1;
    public static final int BROWSE = 0;

    public void generatePane(int t) throws IOException { // param for custom apparel add to cart window without bgColor
                                                         // setting
        pane = new JPanel(new BorderLayout());
        BufferedImage back;
        String typeString;
        // set background bufferedimage; either hoodie or shirt;
        if (shirtType == 'S') {
            typeString = "shirt";
        } else {
            typeString = "hoodie";
        }
        back = ImageIO.read(new File("img/black"+ typeString + ".png"));
        back = MiscFunctions.resizeImage(back, 300, 300);
        img = MiscFunctions.resizeImage(img, 150, 200);
        // create combined img
        if (t == CUSTOM) {
            baseComposite = PageMarket.composite;
        } else {
            baseComposite = generateComposite(back);
        }
        // give label to combined image and cast as ImageIcon and add to main JPanel
        picLabel = new JLabel(new ImageIcon(baseComposite));
        pane.add(picLabel, BorderLayout.LINE_START);
        // create right side of pane with shirtname, choices for bgColor, for size, show
        // price and quantity
        rightPane = new JPanel();
        rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));
        JLabel name = new JLabel(shirtName);
        name.setFont(new Font(new JLabel().getFont().toString(), Font.PLAIN, 30));
        name.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPane.add(Box.createRigidArea(new Dimension(0, 50)));
        rightPane.add(name);
        // bgcolor radio buttons
        if (t == BROWSE) {
            g = 5;
            JRadioButton btnBlack = new JRadioButton("Black");
            JRadioButton btnTurquoise = new JRadioButton("Turquoise");
            JRadioButton btnOrange = new JRadioButton("Orange");
            btnBlack.setActionCommand("black");
            btnTurquoise.setActionCommand("turquoise");
            btnOrange.setActionCommand("orange");
            btnBlack.addActionListener(this);
            btnTurquoise.addActionListener(this);
            btnOrange.addActionListener(this);

            bgGroup = new ButtonGroup();
            bgGroup.add(btnBlack);
            bgGroup.add(btnTurquoise);
            bgGroup.add(btnOrange);
            btnBlack.setSelected(true);
            JPanel bgPanel = new JPanel();
            bgPanel.setLayout(new BoxLayout(bgPanel, BoxLayout.X_AXIS));
            bgPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            bgPanel.add(btnBlack);
            bgPanel.add(btnTurquoise);
            bgPanel.add(btnOrange);
            rightPane.add(bgPanel);
        } else
            g = 4; // for replacing price label when switching size

        // size radio buttons
        JRadioButton btnS = new JRadioButton("S");
        JRadioButton btnM = new JRadioButton("M");
        JRadioButton btnL = new JRadioButton("L");
        btnS.setActionCommand("S");
        btnM.setActionCommand("M");
        btnL.setActionCommand("L");
        btnS.addActionListener(new SizeActionListener());
        btnM.addActionListener(new SizeActionListener());
        btnL.addActionListener(new SizeActionListener());
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(btnS);
        sizeGroup.add(btnM);
        sizeGroup.add(btnL);
        btnM.setSelected(true);
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.X_AXIS));
        sizePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        sizePanel.add(btnS);
        sizePanel.add(btnM);
        sizePanel.add(btnL);
        rightPane.add(sizePanel);
        // price
        shownPrice = basePrice;
        JLabel price = new JLabel(String.format("RM %.2f", shownPrice));
        price.setFont(new Font(new JLabel().getFont().toString(), Font.PLAIN, 20));
        price.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPane.add(Box.createRigidArea(new Dimension(0, 50)));
        rightPane.add(price);
        // quantity
        SpinnerModel value = new SpinnerNumberModel(1, 1, 99, 1);
        JSpinner quantity = new JSpinner(value);
        quantity.setAlignmentX(Component.LEFT_ALIGNMENT);
        quantity.setMaximumSize(new Dimension(100, 40));
        rightPane.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPane.add(quantity);
        // add to cart button
        JButton btnAddtoCart = new JButton("Add to Cart");
        btnAddtoCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int q = (int) quantity.getValue();
                char size = sizeGroup.getSelection().getActionCommand().charAt(0);
                char bg;
                String bgString = "";//
                Customer user = Customer.getCustomer();
                if (t == BROWSE) {
                    bg = Character.toUpperCase(bgGroup.getSelection().getActionCommand().charAt(0));
                    bgString = bgGroup.getSelection().getActionCommand();
                    try {
                        user.getOrder().addShirtToOrder(
                                new Apparel(shirtName, shirtType, img, size, bg, new ImageIcon(baseComposite), q));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else { // for custom apparel
                    PageMarket.custom.setSize(size);
                    PageMarket.custom.setQuantity(q);
                    PageMarket.custom.setPriceAndIncrementTotalSold();
                    PageMarket.custom.generateApparelPane();
                    
                    if (PageMarket.custom.getBgColor() == 'B')
                        bgString = "black";
                    else if (PageMarket.custom.getBgColor() == 'T')
                        bgString = "turquoise";
                    else
                        bgString = "orange";

                    user.getOrder().addShirtToOrder(PageMarket.custom);
                }
                PageMarket.frame.dispatchEvent(new WindowEvent(PageMarket.frame, WindowEvent.WINDOW_CLOSING));
                JOptionPane.showMessageDialog(MiscFunctions.frame,
                        q + " " + size + " " + bgString + " " + shirtName + " added to cart.", "",
                        JOptionPane.INFORMATION_MESSAGE);
                    
                
            }
                
        });
        btnAddtoCart.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPane.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPane.add(btnAddtoCart);
        // add rightpane to main panel
        pane.add(rightPane, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        String type;
        if (shirtType == 'S')
            type = "shirt";
        else
            type = "hoodie";
        try {
            baseComposite = generateComposite(MiscFunctions
                    .resizeImage(ImageIO.read(new File("img/" + e.getActionCommand() + type + ".png")), 300, 300));
        } catch (IOException io) {
            throw new RuntimeException(io);
        }
        pane.remove(picLabel);
        pane.revalidate();
        pane.repaint();
        picLabel = new JLabel(new ImageIcon(baseComposite));
        pane.add(picLabel, BorderLayout.LINE_START);
        pane.revalidate();
        pane.repaint();
    }

    public BufferedImage generateComposite(BufferedImage back) {
        BufferedImage baseComposite = new BufferedImage(back.getWidth(), back.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics g = baseComposite.getGraphics();
        g.drawImage(back, 0, 0, null);
        g.drawImage(img, 75, 70, null);

        g.dispose();
        return baseComposite;
    }

    public BufferedImage generateComposite(BufferedImage back, String s, Color c) {
        BufferedImage baseComposite = new BufferedImage(back.getWidth(), back.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics g = baseComposite.getGraphics();
        g.drawImage(back, 0, 0, null);
        g.drawImage(img, 75, 70, null);
        if (s != null) {
            Font font = new Font("Comic Sans MS", Font.BOLD, 13);
            FontMetrics metrics = g.getFontMetrics(font);
            int x = back.getWidth() / 2 - metrics.stringWidth(s) / 2;
            g.setFont(font);
            g.setColor(c);
            g.drawString(s, x, 60);
        }
        g.dispose();
        return baseComposite;
    }

    // t-shirt:s,m,l:15,20,25 hoodie:17,22,27
    public static void initApparels() throws IOException {
        BufferedImage[] img = new BufferedImage[10];
        for (int i = 0; i < 10; i++) {
            img[i] = ImageIO.read(new File("img/browse9" + i + ".png"));
        }
        apparels[0] = new ApparelType("Supermind T-Shirt", 'S', img[0]);
        apparels[1] = new ApparelType("Mountain T-Shirt", 'S', img[1]);
        apparels[2] = new ApparelType("Jurassic T-Shirt", 'S', img[2]);
        apparels[3] = new ApparelType("Corona T-Shirt", 'S', img[3]);
        apparels[4] = new ApparelType("Green T-Shirt", 'S', img[4]);
        apparels[5] = new ApparelType("Heaven T-Shirt", 'S', img[5]);
        apparels[6] = new ApparelType("Marriage Hoodie", 'H', img[6]);
        apparels[7] = new ApparelType("WayTooDank Hoodie", 'H', img[7]);
        apparels[8] = new ApparelType("FoxNews Hoodie", 'H', img[8]);
        apparels[9] = new ApparelType("Inspirational Hoodie", 'H', img[9]);

    }

    class SizeActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "S") {
                if (shirtType == 'S') {
                    if (shownPrice != 15) {
                        shownPrice = 15;
                    }

                } else if (shownPrice != 17) {
                    shownPrice = 17;
                }
            } else if (e.getActionCommand() == "M") {
                if (shirtType == 'S') {
                    if (shownPrice != 20) {
                        shownPrice = 20;
                    }
                } else if (shownPrice != 22) {
                    shownPrice = 22;
                }
            } else if (shirtType == 'S') {
                if (shownPrice != 25) {
                    shownPrice = 25;
                }
            } else if (shownPrice != 27) {
                shownPrice = 27;
            }
            rightPane.remove(g);
            pane.revalidate();
            pane.repaint();
            JLabel price = new JLabel(String.format("RM %.2f", shownPrice));
            price.setFont(new Font(new JLabel().getFont().toString(), Font.PLAIN, 20));
            price.setAlignmentX(Component.LEFT_ALIGNMENT);
            rightPane.add(price, g);
            rightPane.revalidate();
            rightPane.repaint();
        }
    }
}
