package com.sinyak.ordercake.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilMyTest {
    @Test
    public void testMyTest() {
        // Arrange
        UtilMy util = new UtilMy();
        int a = 5;
        int b = 3;

        // Act
        int result = util.my(a, b);

        // Assert
        assertEquals(8, result, "The method myTest should return the sum of a and b");
    }

}