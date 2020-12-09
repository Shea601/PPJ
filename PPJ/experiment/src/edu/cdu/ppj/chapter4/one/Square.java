package edu.cdu.ppj.chapter4.one;

public class Square extends Rectangle {

    public double edge;

    public Square(double edge) {
        super(edge, edge);
        setEdge(edge);
        // TODO Auto-generated constructor stub
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }


}
