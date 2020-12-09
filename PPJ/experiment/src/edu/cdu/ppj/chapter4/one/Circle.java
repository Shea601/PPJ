package edu.cdu.ppj.chapter4.one;

import edu.cdu.ppj.chapter4.one.Shape;

class Circle extends Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double length() {
        return 3.1415 * 2 * r;
    }

    public double area() {
        return 3.1415 * r * r;
    }
}