package ru.stqa.geometry.figure;

import java.util.Objects;

public record Rectangle(double a, double b) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;///приведение типов
        return (Double.compare(this.a, rectangle.a) == 0 && Double.compare(this.b, rectangle.b) == 0)
                || (Double.compare(this.b, rectangle.a) == 0 && Double.compare(this.a, rectangle.b) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

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
