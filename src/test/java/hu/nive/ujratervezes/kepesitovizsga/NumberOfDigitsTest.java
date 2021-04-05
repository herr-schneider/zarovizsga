package hu.nive.ujratervezes.kepesitovizsga;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfDigitsTest {

    @Test
    void getNumberOfDigits() {
        NumberOfDigits num = new NumberOfDigits();
        assertEquals(4,num.getNumberOfDigits(4));
        assertEquals(11,num.getNumberOfDigits(10));
    }
}