package order_java.classes;

import java.lang.*;
import java.util.*;

public class CardInfo{
    private char cardType;
    private String cardNo;
    private String expiryDate;
    private int cvCode;

    public CardInfo(){
        
    }

    public CardInfo(char cardType, String cardNo, String expiryDate, int cvCode){
        this.cardType = cardType;
        this.cardNo = cardNo;
        this.expiryDate = expiryDate;
        this.cvCode = cvCode;
    }

    public char getCardType(){
        return cardType;
    }

    public String getCardNo(){
        return cardNo;
    }

    public boolean validateCard(){
        int totalCardOddNo = 0;
        int totalCardEvenNo = 0;
        if (String.valueOf(cvCode).matches("[\\d]{3}") == false)
            return false;
        if (cardNo.length() != 16)
            return false;
        for (int i = 0; i < cardNo.length(); i++){
            if (Character.isDigit(cardNo.charAt(i)) == false)
                return false;
        }
        for (int i = 0; i < cardNo.length(); i += 2){
            totalCardOddNo += cardNo.charAt(i) - '0';
        }
        if (totalCardOddNo < 35 || totalCardOddNo > 45)
            return false;
        for (int i = 1; i < cardNo.length(); i += 2){
            totalCardEvenNo += cardNo.charAt(i) - '0';
        }
        if (totalCardEvenNo % 2 == 0)
            return false;
        if ((totalCardOddNo + totalCardEvenNo) % 2 != 0)
            return false;
        return true;
    }
}