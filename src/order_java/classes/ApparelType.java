package order_java.classes;

import order_java.GUI.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.*;
import java.io.*;

public class ApparelType implements ActionListener {
    private String shirtName;
    private double basePrice;
    private char shirtType;
    public JPanel pane;
    BufferedImage img;
    public ApparelType() {
    }

    public ApparelType(String shirtName, double basePrice, char shirtType, BufferedImage img) {
        this.shirtName = shirtName;
        this.basePrice = basePrice;
        this.shirtType = shirtType;
        this.img = img;
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

    public void setPane(JPanel pane) {
        this.pane = pane;
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

    public void generatePane() throws IOException {
        pane = new JPanel(new BorderLayout());
        BufferedImage back;
        // set background bufferedimage; either hoodie or shirt;
        if (shirtType == 'S') {
            back = ImageIO.read(new File("img/blackshirt.png"));
        } else {
            back = ImageIO.read(new File("img/blackhoodie.png"));
        }
        back = MiscFunctions.resizeImage(back, 300, 300);
        img = MiscFunctions.resizeImage(img, 150, 200);
        // create combined img
        BufferedImage composite = generateComposite(back);
        // give label to combined image and cast as ImageIcon and add to main JPanel
        picLabel = new JLabel(new ImageIcon(composite));
        pane.add(picLabel, BorderLayout.LINE_START);
        // create right side of pane with shirtname, choices for bgColor, for size, show
        // price and quantity
        JPanel rightPane = new JPanel();
        rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));
        JLabel name = new JLabel(shirtName);
        name.setFont(new Font(new JLabel().getFont().toString(), Font.PLAIN, 30));
        name.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPane.add(Box.createRigidArea(new Dimension(0, 50)));
        rightPane.add(name);
        // bgcolor radio buttons
        JRadioButton btnBlack = new JRadioButton("Black");
        JRadioButton btnTurquoise = new JRadioButton("Turquoise");
        JRadioButton btnOrange = new JRadioButton("Orange");
        btnBlack.setActionCommand("black");
        btnTurquoise.setActionCommand("turquoise");
        btnOrange.setActionCommand("orange");
        btnBlack.addActionListener(this);
        btnTurquoise.addActionListener(this);
        btnOrange.addActionListener(this);

        ButtonGroup bgGroup = new ButtonGroup();
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
        // size radio buttons
        JRadioButton btnS = new JRadioButton("S");
        JRadioButton btnM = new JRadioButton("M");
        JRadioButton btnL = new JRadioButton("L");
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(btnS);
        sizeGroup.add(btnM);
        sizeGroup.add(btnL);
        btnS.setSelected(true);
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.X_AXIS));
        sizePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        sizePanel.add(btnS);
        sizePanel.add(btnM);
        sizePanel.add(btnL);
        rightPane.add(sizePanel);
        // price
        JLabel price = new JLabel(String.format("RM %.2f", basePrice));
        price.setFont(new Font(new JLabel().getFont().toString(), Font.PLAIN, 20));
        price.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPane.add(Box.createRigidArea(new Dimension(0, 50)));
        rightPane.add(price);
        // quantity
        SpinnerModel value = new SpinnerNumberModel(1, 0, 99, 1);
        JSpinner quantity = new JSpinner(value);
        quantity.setAlignmentX(Component.LEFT_ALIGNMENT);
        quantity.setMaximumSize(new Dimension(100, 40));
        rightPane.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPane.add(quantity);
        // add to cart button
        JButton btnAddtoCart = new JButton("Add to Cart");
        btnAddtoCart.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPane.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPane.add(btnAddtoCart);
        // add rightpane to main panel
        pane.add(rightPane, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        BufferedImage composite;
        if (shirtType == 'S') {
            try {
                composite = generateComposite(MiscFunctions.resizeImage(ImageIO.read(new File("img/" + e.getActionCommand() + "shirt.png")),300,300));
            } catch (IOException io) {
                throw new RuntimeException(io);
            }
        } else {
            try {
                composite = generateComposite(MiscFunctions.resizeImage(ImageIO.read(new File("img/" + e.getActionCommand() + "hoodie.png")),300,300));
            } catch (IOException io) {
                throw new RuntimeException(io);
            }
        }
        pane.remove(picLabel);
        pane.revalidate();
        pane.repaint();
        picLabel = new JLabel(new ImageIcon(composite));
        pane.add(picLabel,BorderLayout.LINE_START);
        pane.revalidate();
        pane.repaint();
    }

    public BufferedImage generateComposite(BufferedImage back) {
        int w = back.getWidth();
        int h = back.getHeight();
        BufferedImage composite = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics g = composite.getGraphics();
        g.drawImage(back, 0, 0, null);
        g.drawImage(img, 75, 70, null);

        g.dispose();
        return composite;
    }

}