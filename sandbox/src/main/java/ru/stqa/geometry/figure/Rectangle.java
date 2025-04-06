package ru.stqa.geometry.figure;

public class Rectangle {
    public static void printRectangleArea(double a, double b) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", a, b, Area(a, b));
        System.out.println(text);
    }

    public static double Area(double a, double b) {
        return a * b;
    }

    public static double Perimeter(double a, double b) {
        return 2*a + 2*b;
    }
}
