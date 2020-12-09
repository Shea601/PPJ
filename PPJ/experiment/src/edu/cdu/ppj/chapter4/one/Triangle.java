package edu.cdu.ppj.chapter4.one;


import edu.cdu.ppj.chapter4.one.Shape;

public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        super();
        // TODO Auto-generated constructor stub
        setA(a);
        setB(b);
        setC(c);
    }

    @Override
    public double length() {
        // TODO Auto-generated method stub
        return a + b + c;
    }

    @Override
    public double area() {
        double p = (a + b + c) / 2;
        // TODO Auto-generated method stub
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}