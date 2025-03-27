package ru.stqa.geometry.figure;

public class Rectangle {
    public static void printRectangleArea(double a, double b) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", a, b, RectangleArea(a, b));
        System.out.println(text);
    }

    private static double RectangleArea(double a, double b)
    {
        return a * b;
    }
}
