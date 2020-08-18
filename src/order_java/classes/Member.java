package order_java.classes;

import java.io.*;
import java.lang.*;

public class Member extends Customer {
    private int memberID;
    private String password;
    private double points;
    private final double convertPoints = 0.3;
    private final double discountRate500 = 0.03;
    private final double discountRate1000 = 0.07;
    private final double discountRate1500 = 0.12;

    public Member() {

    }

    public Member(String password, String name, String address, String phoneNo) {
        super(name, address, phoneNo);
        memberID = Member.getNextMemberID();
        this.password = password;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getPoints() {
        return points;
    }

    public double redeemPoints(double rawTotal) {
        if (points >= 500) {
            points -= 500;
            return rawTotal * discountRate500;
        } else if (points >= 1000) {
            points -= 1000;
            return rawTotal * discountRate1000;
        } else {
            points -= 1500;
            return rawTotal * discountRate1500;
        }
    }

    public void addPoints(double rawTotal) {
        points += rawTotal * convertPoints;
    }

    public void writeToFile() {
        try {
            FileWriter writer = new FileWriter("../../../ID/members.txt");
            writer.write(memberID + "-" + password + "-" + points);
            writer.close();
        } catch (IOException e) {
            System.out.println("IO Error");
            e.printStackTrace();
        }
    }

    public static int getNextMemberID(){
        File memberFile = new File("../../../ID/members.txt");
        StringBuilder memberID = new StringBuilder();
        RandomAccessFile raf = null; 
        try {
            raf = new RandomAccessFile(memberFile, "r");
            long fileLength = memberFile.length() - 1;
            raf.seek(fileLength);
            for (long pointer = fileLength; pointer >= 0; pointer--){
                raf.seek(pointer);
                char character;
                character = (char)raf.read();
                if (character == '\n'){
                    break;
                }
                memberID.append(character);
            }
            memberID.reverse();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Integer.parseInt(memberID.substring(0, 3)) + 1;
    }
}