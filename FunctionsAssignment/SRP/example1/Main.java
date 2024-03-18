package FunctionsAssignment.SRP.example1;

import FunctionsAssignment.SRP.example1.Model.Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        RectangleAreaCalculator areaCalculator = new RectangleAreaCalculator(rectangle);
        areaCalculator.calculateArea();
        areaCalculator.printArea();
    }
}