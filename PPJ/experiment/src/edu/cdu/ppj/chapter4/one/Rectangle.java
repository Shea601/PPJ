package edu.cdu.ppj.chapter4.one;

import edu.cdu.ppj.chapter4.one.Shape;

public class Rectangle extends Shape {

    private double width;
    private double height;


    public Rectangle(double height, double width) {
        super();
        // TODO Auto-generated constructor stub
        setHeight(height);
        setWidth(width);
    }

    @Override
    public double length() {
        // TODO Auto-generated method stub
        return 2 * (width + height);
    }

    @Override
    public double area() {
        // TODO Auto-generated method stub
        return width * height;
    }

    public double differ() {
        return Math.abs(height - width);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
