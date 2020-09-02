package order_java;

import java.io.IOException;

import javax.swing.JFrame;

import order_java.GUI.Home;
import order_java.GUI.MiscFunctions;
import order_java.GUI.PageCart;
import order_java.GUI.PageMarket;
import order_java.GUI.PageMemberLogin;
import order_java.GUI.PagePayMethod;
import order_java.GUI.PageStaffLogin;
import order_java.classes.ApparelType;
import order_java.classes.Customer;
import order_java.classes.Log;
import order_java.classes.Order;

public class Main {
    public static void main(String args[]) throws IOException {
        JFrame frame = new JFrame("Custom T-Shirt Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        Log.log = new Log();
        ApparelType.initApparels();
        Home.home = new Home(); // "home"
        PageMemberLogin.pml = new PageMemberLogin();// "MemberLogin", pass=12345oop , name=limjunshen,ganyihwee,johnwick
        PageMarket.pm = new PageMarket();// "Market"
        PageCart.pg = new PageCart();
        PageStaffLogin.psl = new PageStaffLogin();// "StaffLogin", pass=12345fat
        PagePayMethod.ppm = new PagePayMethod(); //"Pay Method"
        frame.getContentPane().add(MiscFunctions.masterCards);
        frame.setVisible(true);
        Customer.createCustomer(new Order());

    }
}