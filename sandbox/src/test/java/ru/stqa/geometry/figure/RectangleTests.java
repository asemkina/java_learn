package ru.stqa.geometry.figure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/// тесты с функциями
public class RectangleTests {

    @Test
    void canCalculateArea(){
        var result = Rectangle.Area(4.,5.);
        Assertions.assertEquals(20,result);
    }

    @Test
    void canCalculatePerimeter(){
        Assertions.assertEquals(20, Rectangle.Perimeter(4.,6.));
    }


}

