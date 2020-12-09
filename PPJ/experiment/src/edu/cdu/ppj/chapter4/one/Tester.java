package edu.cdu.ppj.chapter4.one;

import edu.cdu.ppj.chapter4.one.Circle;

public class Tester {

    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(5, 10),
                new Circle(5),
                new Square(3),
                new Triangle(3, 4, 5)
        };

        for (int i = 0; i < shapes.length; i++) {
            double length = shapes[i].length();
            double area = shapes[i].area();
            if (shapes[i] instanceof Circle) {
                System.out.println("Shape(" + (i + 1) + ")" +
                        "length" + String.format("%.2f", length) + ",area"
                        + String.format("%.2f", area));
            } else {
                System.out.println("Shape(" + (i + 1) + ")" +
                        "length" + length + ",area" + area);
                if (shapes[i] instanceof Rectangle) {
                    Rectangle r = (Rectangle) shapes[i];
                    System.out.println("长宽差是" + r.differ());
                }
            }
        }
    }
}

