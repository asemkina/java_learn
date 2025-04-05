package ru.stqa.geometry.figure;

public class Triangle {


    public static void printTrianglePerimeter(double a, double b, double c) {
        String text = String.format("Периметр треугольника со сторонами %f, %f, %f = %f", a, b, c, Perimeter(a, b, c));
        System.out.println(text);
    }

    public static double Perimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static double Area (double a, double b) {
        return a * b;
    }
}
