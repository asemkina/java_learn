package ru.stqa.geometry.figure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerimeterTests {

    @Test /// аннотацтия для теста
        void canCalculatePerimeter(){ /// функция ничего не выводит?
        var result = Triangle.Perimeter(2,3,4); ///задание переменной result
        Assertions.assertEquals(9, result); ///задание ожидаемого результата и расчет
    }

    @Test
        void canCalculateArea(){
        Assertions.assertEquals(20,Triangle.Area(4,5));
    }
}
