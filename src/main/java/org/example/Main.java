package org.example;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int passwordLength = 12;
        String securePassword = PasswordGenerator.generateSecurePassword(passwordLength);
        System.out.println("Generiertes sicheres Passwort: " + securePassword);

        //String securePassword = PasswordGenerator.generateSecurePassword(passwordLength);
        //System.out.println("Generiertes sicheres Passwort: " + securePassword);
        //System.out.println(checkBadPassword("Password1"));

    }
    //Schreibt einen Test für die Methode mit der Passwortlänge. Implementiert die Funktionalität zur Überprüfung der Passwortlänge.vDefiniert weitere Testmethoden für verschiedene Passwörter. Wählt eine aus Eurer Sicht optimale Anzahl von Tests.
    public static boolean checkPasswordLength(String password) {
        boolean correctPasswordLength = false;
        if (password.length() > 7) {
            correctPasswordLength = true;
        }
        return correctPasswordLength;
    }

    //Auch hier definiert zuerst eine Testmethode. Sie soll die Methode nutzen, die prüft, ob ein Passwort Ziffern erhält. Implementiert die Funktionalität. Definiert weitere Testmethoden für verschiedene Passwörter.
    public static boolean checkPasswordForNumbers(String password) {
        if (password.matches((".*[0-9].*"))) {
            return true;
        }
        return false;
    }

    //Schreibt nun testdriven die Funktion um sicherzustellen, dass im Passwort sowohl Groß- als auch Kleinbuchstaben zu finden sind.
    public static boolean checkPasswordForUpperCaseAndLowerCase(String password) {
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;

        for (char charCheck : password.toCharArray()) {
            if (Character.isLowerCase(charCheck)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(charCheck)) {
                hasUpperCase = true;
            }

            if (hasLowerCase && hasUpperCase) {
                return true;
            }
        }
        return false;
    }

    //Schreibt nun testdriven die Funktion für die Überprüfung, ob das Passwort schlechte Passwörter wie 'Password1' oder 'Aa345678' enthält.
    public static boolean checkBadPassword(String stringBadPassword) {
        String[] arrayBadPasswords = {"Password1", "Aa345678"};
        for (int i = 0; i<arrayBadPasswords.length; i++) {
            if(stringBadPassword.equals(arrayBadPasswords[i])){
                return false;
            }
        }
        return true;
    }

    //Erweitere die Passwortvalidierung um die Überprüfung, ob das Passwort Sonderzeichen enthält.
    public static boolean checkPasswordForSpecialCharacter(String password) {
        String regex = "[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    //Implementiere eine Funktion, die ein zufälliges sicheres Passwort generiert - das jedesmal die Kriterien aus Euren zuvor definierten Methoden erfüllt.
    /*public static String generateSecurePassword(int passwordLength) {

        return securePassword;
    }*/

    public class PasswordGenerator {
        private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
        private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String NUMBERS = "0123456789";
        private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+-=[]{};:'\"\\|,.<>?/";

        public static String generateSecurePassword(int length) {
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder();

            // Füge mindestens ein Zeichen jeder Kategorie hinzu
            password.append(LOWERCASE_CHARACTERS.charAt(random.nextInt(LOWERCASE_CHARACTERS.length())));
            password.append(UPPERCASE_CHARACTERS.charAt(random.nextInt(UPPERCASE_CHARACTERS.length())));
            password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
            password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

            // Füge den Rest des Passworts hinzu
            String allCharacters = LOWERCASE_CHARACTERS + UPPERCASE_CHARACTERS + NUMBERS + SPECIAL_CHARACTERS;
            for (int i = 4; i < length; i++) {
                password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
            }

            // Mische die Zeichen im Passwort
            String shuffledPassword = shuffleString(password.toString());

            return shuffledPassword;
        }

        // Hilfsmethode zum Mischen der Zeichen im Passwort
        private static String shuffleString(String input) {
            char[] characters = input.toCharArray();
            SecureRandom random = new SecureRandom();
            for (int i = 0; i < characters.length; i++) {
                int randomIndex = random.nextInt(characters.length);
                char temp = characters[i];
                characters[i] = characters[randomIndex];
                characters[randomIndex] = temp;
            }
            return new String(characters);
        }

        }
    }