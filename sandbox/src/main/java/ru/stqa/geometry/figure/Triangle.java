package ru.stqa.geometry.figure;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    public Triangle (double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        {
            if (side1 < 0 || side2 < 0 || side3 < 0){
                throw new IllegalArgumentException("Rectangle side should not be negative");
            }
        }
        {
            if ((side1 + side2) < side3 || (side1 + side3) < side2 || (side3 + side2) < side1){
                throw new IllegalArgumentException("Rectangle sides should be wright");
            }
        }

    }

    public static void printTrianglePerimeter(Triangle t) {
        String text = String.format("Периметр треугольника со сторонами %f, %f, %f = %f", t.side1, t.side2, t.side3, t.Perimeter());
        System.out.println(text);
    }
    public static void printTriangleArea(Triangle t){
        String text = String.format("Площадь треугольника со сторонами %f, %f, %f = %f", t.side1, t.side2, t.side3, t.Area());
        System.out.println(text);
    }

    public double Perimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public double Area() {
        double p = (this.side1 + this.side2 + this.side3)/2;
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));


    }
}
