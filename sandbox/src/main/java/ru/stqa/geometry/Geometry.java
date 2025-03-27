package ru.stqa.geometry;

import ru.stqa.geometry.figure.Rectangle;
import ru.stqa.geometry.figure.Square;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea (51.);
        Square.printSquareArea (80.);
        Square.printSquareArea (10.);

        Rectangle.printRectangleArea(5.,9.);
        Rectangle.printRectangleArea(7,6);
        Rectangle.printRectangleArea(4.,2.);

        }


}