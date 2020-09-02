package order_java.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import order_java.classes.Apparel;
import order_java.classes.Log;
import order_java.classes.Order;
import order_java.classes.ReportData;

public class PageReport {
    private final static String Report = "REPORT";
    private final static String History = "HISTORY";
    private final static int extraWindowWidth = 100;
    public static JPanel[] historyPane;
	protected static PageReport pr;

    public PageReport() {

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
        JPanel outter = new JPanel();
        outter.setLayout(new BoxLayout(outter, BoxLayout.Y_AXIS));
    
        for(int x=0;x<Log.log.getOrders().size();x++)
        {
            outter.add(historyPane[x],BorderLayout.CENTER);
            outter.setAlignmentY(Component.LEFT_ALIGNMENT);
            
        }

        JScrollPane scrollpane = new JScrollPane(outter);
        scrollpane.setPreferredSize(new Dimension(400, 350));
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setVisible(true);

        card2.add(scrollpane);
        tabbedPane.addTab(Report, card1);
        tabbedPane.addTab(History, card2);

        pane.add(tabbedPane, BorderLayout.CENTER);
        MiscFunctions.addCardtoMasterCards(pane, "Reports");

    }

    public static void addToLog() {

        ArrayList<Order> orders = Log.log.getOrders();
        historyPane=new JPanel[orders.size()];

        for (Order y : orders) {
            int i =orders.indexOf(y);
            historyPane[i] = new JPanel(new BorderLayout());
            historyPane[i].setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
            JPanel contentPane = new JPanel();
            contentPane.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
            
            historyPane[i].setLayout(new BoxLayout(historyPane[i], BoxLayout.Y_AXIS));
            historyPane[i].add(
                    new JLabel(String.valueOf(" Order ID : " + y.getOrderID())
                            + "  Date : " + String.valueOf(y.getDate())),
                    BorderLayout.PAGE_START);

            for (Apparel x : y.getShirts()) {
                JLabel imagelabel = new JLabel(new ImageIcon(MiscFunctions.rescaleImage(x.getShirtImg(), 30, 40, 4)));

                contentPane.add(imagelabel);
                contentPane.add(new JLabel(String.valueOf("Shirt Name :" + x.getShirtName() + " Type : "
                        + x.getShirtType() + " \nSize : " + x.getSize() + " Qty : " + x.getQuantity())));

                contentPane.revalidate();
                contentPane.repaint();
                historyPane[i].add(contentPane, BorderLayout.CENTER);
                historyPane[i].setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
            }
        }
    }

}

/**
 * Create the GUI and show it. For thread safety, this method should be invoked
 * from the event dispatch thread.
 */
