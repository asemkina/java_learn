package ru.stqa.geometry;

import ru.stqa.geometry.figure.Rectangle;
import ru.stqa.geometry.figure.Square;
import ru.stqa.geometry.figure.Triangle;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {
        var squares = List.of(new Square(7), new Square(3), new Square(5));
//        for (Square square : squares) {
//            Square.printSquareArea(square);
//        }
        Consumer<Square> print = square -> {
            Square.printSquareArea(square);
            Square.printPerimeter(square);
        };
        squares.forEach(print);
//        Square.printSquareArea(new Square(51.0));///передаем в функции объект Square с его свойствами
//        Square.printSquareArea(new Square(80.));
//        Square.printSquareArea(new Square(10.));
//
//        Rectangle.printRectangleArea(5., 9.);
//        Rectangle.printRectangleArea(7, 6);
//        Rectangle.printRectangleArea(4., 2.);
//
//        Triangle.printTrianglePerimeter(new Triangle(5.0,3.0,4.0));
//        Triangle.printTrianglePerimeter(new Triangle(7.0,9.0,10.0));
//
//
//        Triangle.printTriangleArea(new Triangle(5.,3.,4.));
//        Triangle.printTriangleArea(new Triangle(3.,3.,4.));
//
//    }

    }}