package org.example;

public class Main {
    public static void main(String[] args) {
        //String password = "";
        //checkPasswordLength("pass12");
        //checkForNumbersInPassword
        //checkForUpperAndLowercase
        //checkForUserPasswords

    }
    public static boolean checkPasswordLength(String password) {
        boolean rightPasswordLength = false;
        if (password.length() > 7){
            rightPasswordLength = true;
        }
        return rightPasswordLength;
    }
}