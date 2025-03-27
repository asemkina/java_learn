package ru.stqa.geometry.figure;

public class Square {
    public static void printSquareArea(double side) {

        String text = String.format("Площадь квадрата со стороной %f = %f", side, Area(side));
        System.out.println(text);
    }

    public static double Area(double a) {
        return a * a;
    }

    public static double Perimeter(double a) {
    return a+a+a+a; }
}
