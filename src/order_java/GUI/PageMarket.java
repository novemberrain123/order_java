package order_java.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import order_java.classes.Apparel;
import order_java.classes.ApparelType;

public class PageMarket {
    public static Image rescaleImage(ImageIcon img, int x, int y, int s) {
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(x, y, s);
        return newimg;
    }

    public static void createPageMarket() {
        JPanel pane = new JPanel(new BorderLayout()); // main pane
        MiscFunctions.addDefaultComponentsToPane(pane, "Home", 1);
        JPanel midPane = new JPanel();
        midPane.setLayout(new GridLayout(2, 1));

        JPanel topMidPane = new JPanel();
        JPanel btmMidPane = new JPanel();
        JButton btnCustomShirt = new JButton("Design Your Own");
        btnCustomShirt.setPreferredSize(new Dimension(200, 40));
        btnCustomShirt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards, "Custom");
            }
        });

        JButton btnBrowse = new JButton("Browse Our Selection");
        btnBrowse.setPreferredSize(new Dimension(200, 40));
        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (MiscFunctions.masterCards.getLayout());
                cl.show(MiscFunctions.masterCards, "Browse");
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

        pane.add(midPane, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "Market");
    }

    static String allStr = "All";
    static String hoodieStr = "Hoodie";
    static String tshirtStr = "T-Shirt";
    static JPanel leftPane = new JPanel();
    static JPanel rightPane = new JPanel();
    public static JFrame frame;

    public static void createPageBrowse() throws IOException {
        JPanel pane = new JPanel(new BorderLayout());
        // pass in main JPanel and name of previous page for back btn
        MiscFunctions.addDefaultComponentsToPane(pane, "Market", 1);

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
        for (int i = 0; i < 10; i++) {
            shirtPane[i] = new JPanel();
            shirtPane[i].setLayout(new BoxLayout(shirtPane[i], BoxLayout.Y_AXIS));

            ImageIcon img = new ImageIcon("img/browse" + Integer.toString(i) + ".png");
            img = new ImageIcon(rescaleImage(img, 150, 150, 4));
            JLabel lbl = new JLabel("");
            lbl.setIcon(img);

            shirtPane[i].add(lbl);
        }

        // add shirts to pane
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
        // set buy button for all shirtpanels
        JButton[] btnBuy = new JButton[10];
        ApparelType.initApparels();
        for (int i = 0; i < 10; i++) {
            btnBuy[i] = new JButton("Buy Now");
            shirtPane[i].add(btnBuy[i]);
            final Integer innerI = i;
            btnBuy[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame = new JFrame(ApparelType.apparels[innerI].getShirtName());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(600, 400);
                    frame.add(ApparelType.apparels[innerI].pane);
                    frame.setVisible(true);
                }
            });
        }
        // Define leftpane and rightpane
        leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.Y_AXIS));
        rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));

        // set actionlistener for rbuttons
        btnAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftPane.removeAll();
                rightPane.removeAll();
                for (int i = 0; i < 5; i++) {
                    leftPane.add(shirtPane[i]);
                }
                for (int i = 5; i < 10; i++) {
                    rightPane.add(shirtPane[i]);
                }
                leftPane.revalidate();
                rightPane.revalidate();
            }
        });

        btnTshirt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftPane.removeAll();
                rightPane.removeAll();
                for (int i = 0; i < 3; i++) {
                    leftPane.add(shirtPane[i]);
                }
                for (int i = 3; i < 6; i++) {
                    rightPane.add(shirtPane[i]);
                }
                leftPane.revalidate();
                rightPane.revalidate();

            }
        });

        btnHoodie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leftPane.removeAll();
                rightPane.removeAll();
                for (int i = 6; i < 8; i++) {
                    leftPane.add(shirtPane[i]);
                }
                for (int i = 8; i < 10; i++) {
                    rightPane.add(shirtPane[i]);
                }
                leftPane.revalidate();
                rightPane.revalidate();

            }
        });

        JPanel midPane = new JPanel();
        midPane.add(leftPane);
        midPane.add(rightPane);
        // add cardPane to scrollPane
        JScrollPane scrollPane = new JScrollPane(midPane);
        scrollPane.setPreferredSize(new Dimension(400, 400));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.add(scrollPane, BorderLayout.CENTER);
        btnAll.doClick();
        MiscFunctions.addCardtoMasterCards(pane, "Browse");
    }

    public static char bgColour;
    public static JLabel picLabel;
    public static BufferedImage composite;
    public static JFileChooser fc;
    public static String newline = "\n";
    static File file; // store user input file path
    public static Apparel custom;
    public static Color textColour;
    public static boolean isShirt;
    public static boolean hasGenerated = false;

    public static void createPageCustom() throws IOException {
        JPanel pane = new JPanel(new BorderLayout()); // main pane
        MiscFunctions.addDefaultComponentsToPane(pane, "Market", 1);
        composite = MiscFunctions.resizeImage(ImageIO.read(new File("img/blackshirt.png")), 300, 300);
        picLabel = new JLabel(new ImageIcon(composite));
        pane.add(picLabel, BorderLayout.LINE_START);
        JPanel rightPane = new JPanel();
        rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));
        rightPane.add(new JLabel("Name(Max 20 chars)")); // Name Label
        JTextField tfName = new JTextField(20);
        rightPane.add(tfName);
        tfName.setMaximumSize(new Dimension(380, 20));
        rightPane.add(new JLabel("Style"));
        JRadioButton btnTshirt = new JRadioButton("TShirt");
        JRadioButton btnHoodie = new JRadioButton("Hoodie");

        ButtonGroup styleGroup = new ButtonGroup();
        styleGroup.add(btnTshirt);
        styleGroup.add(btnHoodie);
        btnTshirt.setSelected(true);
        JPanel stylePanel = new JPanel();
        stylePanel.setLayout(new BoxLayout(stylePanel, BoxLayout.Y_AXIS));
        stylePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        stylePanel.add(btnTshirt);
        stylePanel.add(btnHoodie);
        rightPane.add(stylePanel);
        rightPane.add(Box.createRigidArea(new Dimension(0, 10)));

        rightPane.add(new JLabel("Colour"));
        JRadioButton btnBlack = new JRadioButton("Black");
        JRadioButton btnTurquoise = new JRadioButton("Turquoise");
        JRadioButton btnOrange = new JRadioButton("Orange");

        ButtonGroup bgGroup = new ButtonGroup();
        bgGroup.add(btnBlack);
        bgGroup.add(btnTurquoise);
        bgGroup.add(btnOrange);
        btnBlack.setSelected(true);
        JPanel bgPanel = new JPanel();
        bgPanel.setLayout(new BoxLayout(bgPanel, BoxLayout.Y_AXIS));
        bgPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        bgPanel.add(btnBlack);
        bgPanel.add(btnTurquoise);
        bgPanel.add(btnOrange);
        rightPane.add(bgPanel);
        rightPane.add(Box.createRigidArea(new Dimension(0, 10)));

        rightPane.add(new JLabel("Slogan(Max 20 chars)"));
        JTextField tfSlogan = new JTextField("", 40);
        tfSlogan.setMaximumSize(new Dimension(380, 20));
        rightPane.add(tfSlogan);
        rightPane.add(new JLabel("Text Colour"));
        String s[] = { "White", "Black", "Red", "Blue", "Green" };
        JComboBox<String> cbColour = new JComboBox<String>(s);
        cbColour.setMaximumSize(new Dimension(100, 20));
        cbColour.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String s = (String) cbColour.getSelectedItem();
                if (s == "White")
                    textColour = Color.WHITE;
                else if (s == "Black")
                    textColour = Color.BLACK;
                else if (s == "Red")
                    textColour = Color.RED;
                else if (s == "Blue")
                    textColour = Color.BLUE;
                else
                    textColour = Color.GREEN;

            }
        });
        rightPane.add(cbColour);
        JButton btnUpload = new JButton("Upload .png...", new ImageIcon("img/folder.png"));
        btnUpload.setMaximumSize(new Dimension(200, 30));
        btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fc == null) {
                    fc = new JFileChooser();

                    // Add a custom file filter and disable the default
                    // (Accept All) file filter.
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                    fc.setFileFilter(filter);
                    fc.setAcceptAllFileFilterUsed(false);
                }
                // Show it.
                int returnVal = fc.showDialog(null, "Attach");
                // Process the results.
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    file = fc.getSelectedFile();
                }
                // Reset the file chooser for the next time it's shown.
                fc.setSelectedFile(null);
            }
        });
        rightPane.add(new JLabel("Logo"));
        rightPane.add(btnUpload);
        JButton btnGenerate = new JButton("Generate");
        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (file == null) {
                    JOptionPane.showMessageDialog(pane, "Please Upload a png!", "", JOptionPane.WARNING_MESSAGE);
                } else {
                    String slogan = "";
                    BufferedImage back = composite;
                    String type;
                    String colour;
                    if (btnTshirt.isSelected()) {
                        type = "shirt";
                        isShirt = true;
                    } else {
                        type = "hoodie";
                        isShirt = false;
                    }
                    if (btnBlack.isSelected()) {
                        colour = "black";
                        bgColour = 'B';
                    } else if (btnTurquoise.isSelected()) {
                        colour = "turquoise";
                        bgColour = 'T';
                    } else {
                        colour = "orange";
                        bgColour = 'O';
                    }

                    try {
                        back = MiscFunctions.resizeImage(ImageIO.read(new File("img/" + colour + type + ".png")), 300,
                                300);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    custom = new Apparel();
                    try {
                        custom.setImg(MiscFunctions.resizeImage(ImageIO.read(file), 150, 200));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    if (tfSlogan.getText() != null) {
                        slogan = tfSlogan.getText();
                    }
                    composite = custom.generateComposite(back, slogan, textColour);
                    pane.remove(picLabel);
                    pane.revalidate();
                    pane.repaint();
                    picLabel = new JLabel(new ImageIcon(composite));
                    pane.add(picLabel, BorderLayout.LINE_START);
                    pane.revalidate();
                    pane.repaint();
                    hasGenerated = true;
                }
            }
        });
        btnGenerate.setMaximumSize(new Dimension(150, 30));
        rightPane.add(Box.createRigidArea(new Dimension(0, 10)));
        rightPane.add(btnGenerate);
        JPanel btm = (JPanel) pane.getComponent(0); // get btmPane
        btm.add(Box.createHorizontalGlue());
        JButton btnFinal = new JButton("Finish");
        btm.add(btnFinal);
        btnFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfName.getText().equals("")) {
                    JOptionPane.showMessageDialog(pane, "Please enter a name!", "", JOptionPane.WARNING_MESSAGE);
                } else if (!hasGenerated) {
                    JOptionPane.showMessageDialog(pane, "Please generate a design!", "", JOptionPane.WARNING_MESSAGE);

                } else {
                    custom.setShirtName(tfName.getText());
                    if (isShirt) {
                        custom.setBasePrice(20.00);
                        custom.setShirtType('S');
                    } else {
                        custom.setBasePrice(22.00);
                        custom.setShirtType('H');
                    }
                    custom.setBgColor(bgColour);
                    custom.setShirtImg(new ImageIcon(composite));
                    try {

                        custom.generatePane(ApparelType.CUSTOM);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    frame = new JFrame(custom.getShirtName());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(600, 400);
                    frame.add(custom.pane);
                    frame.setVisible(true);
                }
            }
        });
        pane.add(rightPane, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "Custom");
    }

}
