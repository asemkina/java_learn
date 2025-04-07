package ru.stqa.geometry.figure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle (-5.0, 3., 4.);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            /// OK
        }
    }
    @Test
    void cannotCreateTriangleWithWrongSides() {
        try {
            new Triangle (1.0, 3.0, 10.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            /// OK
        }
    }
    @Test /// аннотация для теста
        void canCalculatePerimeter(){
        var t = new Triangle(2.0, 3.0, 4.0);
        double result = t.Perimeter();
        Assertions.assertEquals(9, result);
        }
    @Test
        void canCalculateArea(){
            Assertions.assertEquals(6,new Triangle(5.,3.,4.).Area());
    }
}
