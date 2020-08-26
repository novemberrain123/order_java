package order_java.GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent.*;
import java.lang.Object;
import java.util.EventObject;
import java.awt.AWTEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageReport {
    final static String Report = "REPORT";
    final static String History = "HISTORY";
    final static int extraWindowWidth = 100;


    public static void createPageReport() {
        JPanel pane = new JPanel(new BorderLayout());
        MiscFunctions.addDefaultComponentsToPane(pane, "StaffLogin",2);
        //pane.setPreferredSize(new Dimension(400,400));
  
        
        double sold_S_T=0,sold_M_T=0,sold_L_T=0;
        double sales_S_T=0,sales_M_T=0,sales_L_T=0;
        double sold_S_H=0,sold_M_H=0,sold_L_H=0;
        double sales_S_H=0,sales_M_H=0,sales_L_H=0;



        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(460,400));

        //Create the "cards".
        JPanel card1 = new JPanel() {
            /**
			 *
			 */
			private static final long serialVersionUID = 1L;

			//Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        String[] header = new String[]{
                "Products", "Size", "Sold","Sales"
        };
        //actual data for the table in a 2d array
        Object[][] data = new Object[][]{
                {"T-Shirt", "S", order_java.classes.ReportData.getQuantity_S_Shirt(), order_java.classes.ReportData.getRevenue_S_Shirt()},
                {"T-Shirt", "M", order_java.classes.ReportData.getQuantity_M_Shirt(), order_java.classes.ReportData.getRevenue_M_Shirt()},
                {"T-Shirt", "L", order_java.classes.ReportData.getQuantity_L_Shirt(), order_java.classes.ReportData.getRevenue_L_Shirt()},
                {"Hoodie", "S", order_java.classes.ReportData.getQuantity_S_Hoodie(), order_java.classes.ReportData.getRevenue_S_Hoodie()},
                {"Hoodie", "M",  order_java.classes.ReportData.getQuantity_M_Hoodie(), order_java.classes.ReportData.getRevenue_M_Hoodie()},
                {"Hoodie", "L", order_java.classes.ReportData.getQuantity_L_Hoodie(), order_java.classes.ReportData.getRevenue_L_Hoodie()},
        };





        //create table with data
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
                if(a==false)
                {
                    JOptionPane.showMessageDialog(null,"You cant edit this table");
                }
            }

        });





        //card1.add(new JScrollPane(ReportTable));
        JScrollPane scrollPane= new JScrollPane(ReportTable);
        card1.add(scrollPane,BorderLayout.CENTER);

        JPanel card2 = new JPanel();
        JTextArea HistoryText = new JTextArea(20, 40);


        HistoryText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HistoryTextMouseClicked(evt);
            }

            private void HistoryTextMouseClicked(MouseEvent evt) {
                boolean b=HistoryText.isEditable();
                if(b==true)
                {
                    JOptionPane.showMessageDialog(null,"You cant edit this text");
                }
            }
        });


        JScrollPane scrollpane = new JScrollPane(HistoryText);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setVisible(true);

        card2.add(scrollpane);

        tabbedPane.addTab(Report, card1);
        tabbedPane.addTab(History, card2);

        

        
        
        
        
        pane.add(tabbedPane, BorderLayout.CENTER);
        

        MiscFunctions.addCardtoMasterCards(pane, "Reports");

    }




}


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */


