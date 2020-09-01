package order_java.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import order_java.classes.Apparel;
import order_java.classes.Customer;
import order_java.classes.Order;
import order_java.classes.ReportData;

public class PageReport {
    final static String Report = "REPORT";
    final static String History = "HISTORY";
    final static int extraWindowWidth = 100;
    public static JPanel historyPane = new JPanel();

    public static void createPageReport() {

        JPanel pane = new JPanel(new BorderLayout());
        MiscFunctions.addDefaultComponentsToPane(pane, "StaffLogin", 2);
        // pane.setPreferredSize(new Dimension(400,400));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(460, 400));

        // Create the "cards".
        JPanel card1 = new JPanel() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            // Make the panel wider than it really needs, so
            // the window's wide enough for the tabs to stay
            // in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };

        String[] header = new String[] { "Products", "Size", "Sold", "Sales" };
        // actual data for the table in a 2d array
        String[][] data = {
                { "T-Shirt", "S", String.valueOf(ReportData.getQuantity_S_Shirt()),
                        String.valueOf(ReportData.getRevenue_S_Shirt()) },
                { "T-Shirt", "M", String.valueOf(ReportData.getQuantity_M_Shirt()),
                        String.valueOf(ReportData.getRevenue_M_Shirt()) },
                { "T-Shirt", "L", String.valueOf(ReportData.getQuantity_L_Shirt()),
                        String.valueOf(ReportData.getRevenue_L_Shirt()) },
                { "Hoodie", "S", String.valueOf(ReportData.getQuantity_S_Hoodie()),
                        String.valueOf(ReportData.getRevenue_S_Hoodie()) },
                { "Hoodie", "M", String.valueOf(ReportData.getQuantity_M_Hoodie()),
                        String.valueOf(ReportData.getRevenue_M_Hoodie()) },
                { "Hoodie", "L", String.valueOf(ReportData.getQuantity_L_Hoodie()),
                        String.valueOf(ReportData.getRevenue_L_Hoodie()) }, };

        // create table with data
        JTable ReportTable = new JTable(data, header);
        ReportTable.setShowHorizontalLines(true);
        ReportTable.setShowVerticalLines(true);
        ReportTable.setGridColor(Color.black);
        ReportTable.setShowGrid(true);
        ReportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportTableMouseClicked(evt);
            }

            private void ReportTableMouseClicked(MouseEvent evt) {
                boolean a = ReportTable.isEditing();
                if (a == false) {
                    JOptionPane.showMessageDialog(null, "You cant edit this table");
                }
            }

        });

        JScrollPane scrollPane = new JScrollPane(ReportTable);
        card1.add(scrollPane, BorderLayout.CENTER);

        JPanel card2 = new JPanel();
        JTextArea HistoryText = new JTextArea(20, 35);
        HistoryText.setEditable(false);
        HistoryText.setText("fasdasdasdasdasd");

        // try {
        // ArrayList<Apparel> shirts = new ArrayList<Apparel>();
        // ArrayList<Order> orderList = new ArrayList<Order>();
        // shirts= user.getOrder().getShirts();

        // for(Order x : orderList)
        // {
        // historyrecord=new String("Order ID :"
        // +user.getOrder().getOrderID()+"\n"+"Date :"+user.getOrder().getDate()+"
        // "+user.getOrder().getNumofShirts());
        // HistoryText.setText(historyrecord);
        // }

        // HistoryText.addMouseListener(new java.awt.event.MouseAdapter() {
        // public void mouseClicked(java.awt.event.MouseEvent evt) {
        // HistoryTextMouseClicked(evt);
        // }

        // private void HistoryTextMouseClicked(MouseEvent evt) {
        // boolean b=HistoryText.isEditable();
        // if(b==true)
        // {
        // JOptionPane.showMessageDialog(null,"You cant edit this text");
        // }
        // }
        // });

        // }
        // catch (Exception exception)
        // {
        // HistoryText.setText(" ");
        // }

        JScrollPane scrollpane = new JScrollPane(historyPane);
        scrollpane.setPreferredSize(new Dimension(350, 350));
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setVisible(true);

        card2.add(scrollpane);
        tabbedPane.addTab(Report, card1);
        tabbedPane.addTab(History, card2);

        pane.add(tabbedPane, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "Reports");

    }

    public static void addToHistory() {

        ArrayList<Order> orders = Customer.getCustomer().getOrder().getOrders();

        for (Order y : orders) {
            historyPane = new JPanel(new BorderLayout());
            historyPane.setLayout(new BoxLayout(historyPane, BoxLayout.Y_AXIS));
            historyPane.add(new JLabel(String.valueOf(Customer.getCustomer().getOrder().getOrderID()) + "  "
                    + String.valueOf(Customer.getCustomer().getOrder().getDate())), BorderLayout.PAGE_START);

            for (Apparel x : y.getShirts()) {
                JLabel imagelabel = new JLabel(x.getShirtImg());

                historyPane.add(imagelabel);
                historyPane.add(new JLabel(String.valueOf("Shirt Name :" + x.getShirtName() + " Type : "
                        + x.getShirtType() + " Size : " + x.getSize() + " Qty : " + x.getQuantity())));

                historyPane.revalidate();
                historyPane.repaint();
            }
        }
    }

}

/**
 * Create the GUI and show it. For thread safety, this method should be invoked
 * from the event dispatch thread.
 */
