package ru.stqa.geometry.figure;

public record Rectangle(double a, double b) {

    public Rectangle {
        if (a < 0 || b < 0){
            throw new IllegalArgumentException("Rectangle side should not be negative");
        }
    }

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
