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
        Boolean expected = true;
        assertTrue(expected);
    }

    void checkPasswordLength_ifPasswordLengthIsSmaller8_thenReturnFalse() {
        // GIVEN
        String password  = "pass12";
        //WHEN
        boolean actual = Main.checkPasswordLength(password);
        //THEN
        Boolean expected = false;
        assertEquals(expected, actual);
    }

}