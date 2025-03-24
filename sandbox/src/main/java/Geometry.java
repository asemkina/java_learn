public class Geometry {
    public static void main(String[] args) {
        printSquareArea (5.);
        printSquareArea (8.);
        printSquareArea (100.);

        printRectangleArea(5.,9.);
        printRectangleArea(7,6);
        printRectangleArea(4,2);

        }

    private static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + RectangleArea(a, b));
    }

    private static double RectangleArea(double a, double b) {
        return a * b;
    }


    static void printSquareArea(double side) {
    System.out.println("Площадь квадрата со стороной " + side + " = " + SquareArea(side));
    }

    private static double SquareArea(double a) {
        return a * a;
    }
}