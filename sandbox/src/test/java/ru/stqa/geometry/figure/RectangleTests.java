package ru.stqa.geometry.figure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/// тесты с функциями
public class RectangleTests {

    @Test
    void cannotCreateRectangleWithNegativeSide() {
        try {
            new Rectangle (-5.0, 3.);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            /// OK
        }
    }

    @Test
    void testEquality() {
        var r1 = new Rectangle(5.0, 6.0);
        var r2 = new Rectangle(6.0, 5.0);
        Assertions.assertEquals(r1, r2);
    }

    @Test
    void testTrueEquality() {
        var r1 = new Rectangle(6.0, 5.0);
        var r2 = new Rectangle(6.0, 5.0);
        Assertions.assertEquals(r1, r2);
    }

    @Test
    void canCalculateArea(){/// задание функции для расчета площади
        var result = Rectangle.Area(4.,5.);///задание переменной result
        Assertions.assertEquals(20,result); ///задание ожидаемого результата и расчет
    }

    @Test
    void canCalculatePerimeter(){
        Assertions.assertEquals(20, Rectangle.Perimeter(4.,6.));
    }


}

