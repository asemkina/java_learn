package ru.stqa.geometry.figure;

public record Square (double side){

    ///private double side;    ///описание структуры объекта Square, находится обязательно внутри класса/
                            /// каждый объект структуры Square будет иметь свойство side

    public Square(double side) {/// конструктор для объекта Square (alt+enter в тесте для автоматич создания метода)
    this.side = side;///присвоение свойства внутри текущего объекта
        /// розовый side - структура объекта, белый side - свойство функции
          {
            if (side < 0) {
                throw new IllegalArgumentException("Square side should not be negative");
            }
        }
    }
    public static void printSquareArea(Square s) {

        String text = String.format("Площадь квадрата со стороной %f = %f", s.side, s.Area());
        System.out.println(text);
    }

    public double Area() {/// нет слова statiс, значит функция вызывается в объекте, данные она берет из объекта, а не из указанных параметров
        return this.side * this.side;
    }

    public double Perimeter() {

        return 4 * this.side;
    }
}
