package com.example.leedstrinity.myroute;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordChecker {
    private String checker = "123457";


    @Test public void testNullPasswordReturnsFalse() {
        assertFalse(checker.isEmpty());
    }

    @Test public void testLongPasswordReturnsFalse() {
        assertFalse(checker.length()>15);
        //"ThisPasswordIsWayTooLongSoTrySomethingElse"
    }

    @Test public void testShortPasswordReturnsFalse() {
        assertFalse(checker.length()<6);
        //"ThisPasswordIsWayTooLongSoTrySomethingElse"
    }


}
