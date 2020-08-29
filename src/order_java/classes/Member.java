package order_java.classes;

import java.io.*;

public class Member extends Customer {
    private int memberID;
    private String password;
    private double points;
    private String email;
    private String dob;
    private int luckyNumber;
    private final static double convertPoints = 0.3;

    public Member() { // Constructor to create new member
        memberID = Member.getNextMemberID();
    }

    public Member(String name, int memberID, String password, Double points){ // Constructor to create regular member
        super(name);
        this.memberID = memberID;
        this.password = password;
        this.points = points;
    }

    public void setNewMemberDetails(String name, String address, String phoneNo, String email, String dob, String password){ // Set new member details
        Customer.setNewMemberDetails(name, address, phoneNo);
        this.email = email;
        this.dob = dob;
        this.password = password;
    }

    public static double getConvertPoints(){
        return convertPoints;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getPoints() {
        return points;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setDob(String dob){
        this.dob = dob;
    }

    public String getDob(){
        return dob;
    }

    public void setLuckyNumber(int luckyNumber){
        this.luckyNumber = luckyNumber;
    }

    public int getLuckyNumber(){
        return luckyNumber;
    }

    public void addPoints(double rawTotal) {
        points += rawTotal * convertPoints;
    }

    public static double getAddPoints(double rawTotal){
        return rawTotal * convertPoints;
    }

    public void redeemPoints(int pointsSelection) { 
        if (pointsSelection == 0) 
            points -= 500;
        else if (pointsSelection == 1) 
            points -= 1000;
        else 
            points -= 1500;
    }

    public static String validatePassword(String password){
        int countLetter = 0;
        int countDigit = 0;
        int countUpperCaseLetter = 0;
        if (password.length() < 8)
            return "Password entered is less than 8 characters.\nPlease try again.";
        for (int i = 0; i < password.length(); i++){
            if (Character.isDigit(password.charAt(i)) == true)
                countDigit++;
            else if (Character.isLetter(password.charAt(i)) == true){
                countLetter++;
                if (Character.isUpperCase(password.charAt(i)) == true)
                    countUpperCaseLetter++;
            }
        } 
        if (countLetter == 0)
            return "Password does not have letter.\nPlease try again.";
        else if (countDigit == 0)
            return "Password does not have digit.\nPlease try again.";
        else if (countUpperCaseLetter == 0)
            return "Password does not have upper case letter.\nPlease try again.";
        else   
            return "Valid";         
    }

    public void writeToFile() {
        try {
            FileWriter writer = new FileWriter("./././ID/members.txt", true);
            writer.write(memberID + " " + password + " " + points + " " + getName() + "\n");
            writer.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Error");
            e.printStackTrace();
        }
    }

    public static int getNextMemberID(){
        File memberFile = new File("./././ID/members.txt");
        RandomAccessFile raf = null; 
        StringBuilder stringMemberID = new StringBuilder();
        try {
            raf = new RandomAccessFile(memberFile, "r");
            long fileLength = raf.length() - 1;
            for (long pointer = fileLength; pointer >= 0; pointer--){
                raf.seek(pointer);
                int readByte = raf.readByte();

                if (readByte == 0xA){
                    if(pointer == fileLength){
                        continue;
                    }
                    break;
                }
                else if (readByte == 0xD){
                    if(pointer == fileLength - 1){
                        continue;
                    }
                    break;
                }
                stringMemberID = stringMemberID.append((char)readByte);
            }
            stringMemberID = stringMemberID.reverse();
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
        return Integer.parseInt(stringMemberID.substring(0, 3)) + 1;
    }

    
}