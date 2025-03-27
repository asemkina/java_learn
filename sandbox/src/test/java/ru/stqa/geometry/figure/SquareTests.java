package ru.stqa.geometry.figure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCalculateArea() {

        double result = Square.Area(5.0);
        Assertions.assertEquals(25.0, result);
    }
    @Test
    void canCalculatePerimeter(){
         Assertions.assertEquals(24.0, Square.Perimeter(6.0));

    }

}
