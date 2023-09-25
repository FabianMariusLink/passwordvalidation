package org.example;

public class Main {
    public static void main(String[] args) {
        //String password = "";
        //checkPasswordLength("pass12");
        //checkForNumbersInPassword
        //checkForUpperAndLowercase
        //checkForUserPasswords
        System.out.println(checkPasswordForNumbers("pass"));

    }

    public static boolean checkPasswordLength(String password) {
        boolean correctPasswordLength = false;
        if (password.length() > 7) {
            correctPasswordLength = true;
        }
        return correctPasswordLength;
    }

    public static boolean checkPasswordForNumbers(String password) {
        boolean checkPasswordForNumbers = false;
        if (password.matches((".*[0-9].*"))) {
            return true;
        }
        return checkPasswordForNumbers;
    }
}