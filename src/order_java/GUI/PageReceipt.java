package order_java.GUI;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class PageReceipt {
    public static void addComponentsToReceiptPane(Container pane){
        JPanel[] paneReceiptLabels = new JPanel[8]; // To store every receipt labels
        for (int i = 0; i < 8; i++){
            paneReceiptLabels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        }

        // Store receipt labels into panel
        paneReceiptLabels[0].add(new JLabel("Status : "));
        paneReceiptLabels[1].add(new JLabel("Receipt No. : "));
        paneReceiptLabels[2].add(new JLabel("Customer Name : "));
        paneReceiptLabels[3].add(new JLabel("Transaction Date : "));
        paneReceiptLabels[4].add(new JLabel("Transaction Time : "));
        paneReceiptLabels[5].add(new JLabel("Method : "));
        paneReceiptLabels[6].add(new JLabel("Amount : "));
        paneReceiptLabels[7].add(new JLabel("Payment Reference : "));

        // Create panel to include all panels of receipt labels
        JPanel midLeftPane = new JPanel(new GridLayout(8,1));
        for (int i = 0; i < 8; i++){
            midLeftPane.add(paneReceiptLabels[i]);
        }

        JPanel[] paneReceiptInfo = new JPanel[8]; // To store every receipt information
        for (int i = 0; i < 8; i++){
            paneReceiptInfo[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        }

        paneReceiptInfo[0].add(new JLabel("Successful"));
        paneReceiptInfo[1].add(new JLabel("SM1001"));
        paneReceiptInfo[2].add(new JLabel("Lim Jun Shen"));
        paneReceiptInfo[3].add(new JLabel("23-JUL-2020"));
        paneReceiptInfo[4].add(new JLabel("20:08:22"));
        paneReceiptInfo[5].add(new JLabel("Credit Card"));
        paneReceiptInfo[6].add(new JLabel("RM 192.70"));
        paneReceiptInfo[7].add(new JLabel("29384_34895"));

        // Create panel to include all panels of receipt information
        JPanel midRightPane = new JPanel(new GridLayout(8,1));
        for (int i = 0; i < 8; i++){
            midRightPane.add(paneReceiptInfo[i]);
        }

        // Create top panel
        JPanel midTopPane = new JPanel();
        midTopPane.add(new JLabel("Customer Receipt"));

        // Create bottom panel
        JPanel midBtmPane = new JPanel();
        midBtmPane.add(new JButton("Continue with shopping"));

        // Create middle panel
        JPanel midPane = new JPanel(new BorderLayout());
        midPane.add(midTopPane, BorderLayout.PAGE_START);
        midPane.add(midBtmPane, BorderLayout.PAGE_END);
        midPane.add(midLeftPane, BorderLayout.LINE_START);
        midPane.add(midRightPane, BorderLayout.CENTER);
        pane.add(midPane, BorderLayout.CENTER);
    }
}