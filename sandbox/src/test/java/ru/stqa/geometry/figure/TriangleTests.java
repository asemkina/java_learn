package ru.stqa.geometry.figure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

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
