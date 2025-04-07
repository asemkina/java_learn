package ru.stqa.geometry.figure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/// тесты с объектами
public class SquareTests {

    @Test
    void canCalculateArea() {/// тестовая функция ничего не возвращает, поэтому класс void
        var s = new Square(5.0);///вызываем конструктор объекта Square
        double result = s.Area();///вызываем метод Area в этом объекте
        Assertions.assertEquals(25.0, result);

    }

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(16, new Square(4.0).Perimeter());
    }

    @Test
    void cannotCreateSquareWithNegativeSide() {
        try {
            new Square(-5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            /// OK
        }
    }
}