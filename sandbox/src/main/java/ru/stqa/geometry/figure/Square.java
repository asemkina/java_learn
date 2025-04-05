package ru.stqa.geometry.figure;

public class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public static void printSquareArea(Square s) {

        String text = String.format("Площадь квадрата со стороной %f = %f", s.side, s.side);
        System.out.println(text);
    }

    public double Area() {
        return this.side * this.side;
    }

    public double Perimeter() {
        return 4 * this.side;
    }
}
