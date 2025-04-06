package ru.stqa.geometry.figure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test /// аннотацтия для теста
        void canCalculatePerimeter(){ /// функция ничего не выводит?
        var result = Triangle.Perimeter(2,3,4); ///задание переменной result
        Assertions.assertEquals(9, result); ///задание ожидаемого результата и расчет
    }
}
