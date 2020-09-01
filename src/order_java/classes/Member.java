package order_java.classes;

import java.io.*;

public class Member extends Customer {
    private int memberID;
    private String password;
    private double points;
    private String email;
    private String dob;
    private int luckyNumber; // Lucky number chosen by new member for raffle purpose
    private final static double convertPoints = 0.3; // Rate to convert raw total of purchase to member points

    public Member(){ // Constructor to create new member when new member signed up
        memberID = Member.getNextMemberID();
    }

    public Member(String name, int memberID, String password, double points){ // Constructor to create regular member
        super(name, new Order());
        this.memberID = memberID;
        this.password = password;
        this.points = points;
    }

    public static void createNewMember(){ // Method to create new member when new member signed up
        pointsToNewMem();
    }

    // Method to create regular member when member login
    public static void createRegMember(String name, int memberID, String password, double points){ 
        pointsToRegMem(name, memberID, password, points);
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

    public void addPoints(double rawTotal) { // Add new member points to accumulated member points
        points += rawTotal * convertPoints;
    }

    public static double getAddPoints(double rawTotal){ // Get new added member points
        return rawTotal * convertPoints;
    }

    public void redeemPoints(int pointsSelection) { // Deduct member points when member redeem for discount
        if (pointsSelection == 0) 
            points -= 500;
        else if (pointsSelection == 1) 
            points -= 1000;
        else 
            points -= 1500;
    }

    public static String validatePassword(String password) { // Validate member login password
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

    public void writeToFile() { // Write new signed up member to text file
        try {
            FileWriter writer = new FileWriter("./././ID/members.txt", true);
            String[] split = getName().split(" ");
            String name = "";
            for (int i = 0; i < split.length; i++){
                name += split[i];
            }
            writer.write(memberID + " " + password + " " + points + " " + name + "\n");
            writer.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getNextMemberID(){ // Get the next member id from text file and assign it to new member
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

    public void updatePoints() throws FileNotFoundException, IOException { // Update member points in text file
        File memberFile = new File("./././ID/members.txt");
        String oldContent = ""; // To store initial text file content
        String lineToEdit = ""; // The line needed to update member points
        String[] memberDetails = new String[4];

        BufferedReader myReader = new BufferedReader(new FileReader(memberFile));
        String eachLine = myReader.readLine(); // Read first line
        while (eachLine != null){
            oldContent += eachLine + System.lineSeparator(); 
            memberDetails = eachLine.split(" ");
            if (String.valueOf(memberID).equals(memberDetails[0])) // Check if this is the line needed to update
                lineToEdit = eachLine;
            eachLine = myReader.readLine(); // Read line by line
        }

        String[] arrayLineToEdit = lineToEdit.split(" ");
        String editedLine = arrayLineToEdit[0] + " " + arrayLineToEdit[1] + " " + String.format("%-7.2f", points) + " " + arrayLineToEdit[3];
        String newContent = oldContent.replace(lineToEdit, editedLine);

        FileWriter writer = new FileWriter(memberFile);
        writer.write(newContent);
        myReader.close();
        writer.close();
    }
}