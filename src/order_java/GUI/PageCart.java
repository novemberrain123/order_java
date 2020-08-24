package order_java.GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.event.*;

public class PageCart extends JFrame{

    public static Image rescaleImage(ImageIcon img, int x, int y, int s) {
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(x, y, s);
        return newimg;
    }

    public static void createPageCart() {

        JFrame cartFrame = new JFrame("Cart");
        cartFrame.setSize(500, 500);
        cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cartFrame.setVisible(true);
        JPanel midPane1 = new JPanel(new BorderLayout());
        //MiscFunctions.addDefaultComponentsToPane(midPane1, "Home",3);
        //for logo
        JPanel topPane = new JPanel();
        topPane.setLayout(new BoxLayout(topPane, BoxLayout.X_AXIS));
        ImageIcon logo = new ImageIcon("img/mindnew.png");
        Image image = logo.getImage(); // Resize Image
        Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        logo = new ImageIcon(newimg); // transform it back
        JLabel logoLabel = new JLabel("");
        logoLabel.setFont(new Font("", Font.PLAIN, 20)); // Set font style and size
        logoLabel.setIcon(logo);
        topPane.add(logoLabel);
        topPane.add(Box.createHorizontalGlue());


        JPanel[] shirtPane = new JPanel[10];

        for (int i = 0; i < 10; i++) {
            shirtPane[i] = new JPanel();

            shirtPane[i].add(new JLabel(String.valueOf(i + 1 + ")  ")));
            shirtPane[i].setLayout(new BoxLayout(shirtPane[i], BoxLayout.Y_AXIS));
            shirtPane[i].setAlignmentX(Component.LEFT_ALIGNMENT);

            ImageIcon img = new ImageIcon("img/browse" + Integer.toString(i) + ".png");
            img = new ImageIcon(rescaleImage(img, 110, 110, 4));
            JLabel lbl = new JLabel("");
            lbl.setIcon(img);
            shirtPane[i].add(lbl);
            shirtPane[i].setAlignmentX(Component.LEFT_ALIGNMENT);
        }

        shirtPane[0].add(new JLabel("Supermind T-Shirt"));
        shirtPane[1].add(new JLabel("  Mountain T-Shirt"));
        shirtPane[2].add(new JLabel("  Jurassic T-Shirt"));
        shirtPane[3].add(new JLabel(
                "<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Leonardo Da <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Corona T-Shirt<html>"));
        shirtPane[4].add(new JLabel("     Green T-Shirt"));
        shirtPane[5].add(new JLabel("    Heaven T-Shirt"));
        shirtPane[6].add(new JLabel("   Marriage T-Shirt"));
        shirtPane[7].add(new JLabel(
                "<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WayTooDank<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;T-Shirt<html>"));
        shirtPane[8].add(new JLabel("   FoxNews T-Shirt"));
        shirtPane[9].add(new JLabel(
                "<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Inspirational<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;T-Shirt<html>"));

        JPanel[] nested1 = new JPanel[10];
        JSpinner[] spinner = new JSpinner[10];

        for (int j = 0; j < 10; j++) {
            SpinnerModel value = new SpinnerNumberModel(0, 0, 50, 1);
            nested1[j] = new JPanel();
            spinner[j] = new JSpinner(value);
            nested1[j].add(shirtPane[j]);
            nested1[j].add(new JLabel("      "));
            nested1[j].add(spinner[j]);
        }
        JPanel midPane = new JPanel();
        midPane.setLayout(new BoxLayout(midPane, BoxLayout.Y_AXIS));
        JLabel cart1 = new JLabel("Your Cart");
        cart1.setFont(new Font("SansSerif", Font.BOLD, 18));
        midPane.add(cart1, BorderLayout.PAGE_START);

        JPanel newpanel = new JPanel();

         newpanel.setLayout(new BoxLayout(newpanel, BoxLayout.Y_AXIS));
//        newpanel.setSize(20,20);

        for(int k=0;k<10;k++){
           newpanel.add(nested1[k],BorderLayout.CENTER);

        for (int k = 0; k < 10; k++) {
            newpanel.add(nested1[k], BorderLayout.CENTER);

        }
        JButton proceed = new JButton("Proceed to Payment");
        proceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Once proceed to payment section,\nyou can never navigate backward to previous page.\nAre you sure to continue ?", "Proceed to payment", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION){
                    CardLayout cl = (CardLayout)(MiscFunctions.masterCards.getLayout());
                    cl.show(MiscFunctions.masterCards,"Pay Method");
                }
            }
        });
        newpanel.add(proceed,BorderLayout.CENTER);
        JScrollPane scrollpane = new JScrollPane(newpanel);
        scrollpane.setPreferredSize(new Dimension(350,350));
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setVisible(true);



        midPane.add(scrollpane,BorderLayout.CENTER);
        midPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        //midPane.setMaximumSize(new Dimension(100, 700));

        
        midPane1.setVisible(true);
        midPane1.add(midPane,BorderLayout.CENTER);
        midPane1.add(topPane,BorderLayout.PAGE_START);
        //MiscFunctions.addCardtoMasterCards(midPane1, "Cart");
        cartFrame.add(midPane1,BorderLayout.CENTER);
       






    }

    }

