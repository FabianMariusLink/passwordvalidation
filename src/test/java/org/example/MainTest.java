package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void checkPasswordLength_ifPasswordLengthIsBigger8_thenReturnTrue() {
        // GIVEN
        String password  = "pass1234";
        //WHEN
        boolean actual = Main.checkPasswordLength(password);
        //THEN
        assertTrue(actual);
    }

    @Test
    void checkPasswordLength_ifPasswordLengthIsSmaller8_thenReturnFalse() {
        // GIVEN
        String password  = "pass12";
        //WHEN
        boolean actual = Main.checkPasswordLength(password);
        //THEN
        assertFalse(actual);
    }

    @Test
    void checkPasswordForNumbers_ifPasswordContainsNumbers_thenReturnFalse(){
        //GIVEN
        String password = "pass";
        //WHEN
        boolean actual = Main.checkPasswordForNumbers(password);
        //THEN
        assertFalse(actual);
    }

    @Test
    void checkPasswordForNumbers_ifPasswordContainsNumbers_thenReturnTrue(){
        //GIVEN
        String password = "pass12";
        //WHEN
        boolean actual = Main.checkPasswordForNumbers(password);
        //THEN
        assertTrue(actual);
    }

    @Test
    void checkPasswordForCapitalLetters_ifPasswordContainsCapitalLetter_thenReturnTrue(){
        //GIVEN
        String password = "Pass12";
        //WHEN
        boolean actual = Main.checkPasswordForUpperCaseAndLowerCase(password);
        //THEN
        assertTrue(actual);
    }

    @Test
    void checkPasswordForCapitalLetters_ifPasswordContainsCapitalLetter_thenReturnFalse(){
        //GIVEN
        String password = "pass12";
        //WHEN
        boolean actual = Main.checkPasswordForUpperCaseAndLowerCase(password);
        //THEN
        assertFalse(actual);
    }

    @Test
    void checkBadPassword_ifPasswordInArray_thenReturnFalse(){
        //GIVEN
        String password = "Password1";
        //WHEN
        boolean actual = Main.checkBadPassword(password);
        //THEN
        assertFalse(actual);
    }

    @Test
    void checkBadPassword_ifPasswordInArray_thenReturnTrue(){
        //GIVEN
        String password = "csde!21cdQ?";
        //WHEN
        boolean actual = Main.checkBadPassword(password);
        //THEN
        assertTrue(actual);
    }

    @Test
    void checkPasswordForSpecialCharacter_ifPasswordContainsSpecialCharacter_thenReturnTrue(){
        //GIVEN
        String password = "csde!21cdQ";
        //WHEN
        boolean actual = Main.checkPasswordForSpecialCharacter(password);
        //THEN
        assertTrue(actual);
    }

    @Test
    void checkPasswordForSpecialCharacter_ifPasswordContainsSpecialCharacter_thenReturnFalse(){
        //GIVEN
        String password = "csde21cdQ";
        //WHEN
        boolean actual = Main.checkPasswordForSpecialCharacter(password);
        //THEN
        assertFalse(actual);
    }
    /*@Test
    void generateSecurePassword_ifAppliedGeneratePasswordWithLowerAndUpperCasesNumbersAndSpecialCharacters(){
        //GIVEN
        int passwordLength = 8;
        //WHEN
        String actual = MainPasswordGenerator.generateSecurePassword(passwordLength);
        //THEN
        String expected = "";
        assertEquals(expected, actual);
    }*/
}