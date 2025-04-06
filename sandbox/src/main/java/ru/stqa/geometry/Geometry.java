package ru.stqa.geometry;

import ru.stqa.geometry.figure.Rectangle;
import ru.stqa.geometry.figure.Square;
import ru.stqa.geometry.figure.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(51.0));///передаем в функции объект Square с его свойствами
        Square.printSquareArea(new Square(80.));
        Square.printSquareArea(new Square(10.));

        Rectangle.printRectangleArea(5., 9.);
        Rectangle.printRectangleArea(7, 6);
        Rectangle.printRectangleArea(4., 2.);

        Triangle.printTrianglePerimeter(5., 3., 4.);

    }

}