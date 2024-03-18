package FunctionsAssignment.SRP.example1;

import FunctionsAssignment.SRP.example1.Model.Rectangle;

public class RectangleAreaCalculator {

    private Rectangle rectangle;
    private double area;

    public RectangleAreaCalculator(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void printArea() {
        System.out.println("Area: " + this.area);
    }

    public double calculateArea() {
        return this.area = this.rectangle.getLength() * this.rectangle.getWidth();
    }
}