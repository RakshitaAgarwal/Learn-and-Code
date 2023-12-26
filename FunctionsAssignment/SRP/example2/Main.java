package FunctionsAssignment.SRP.example2;

import FunctionsAssignment.SRP.example2.Model.Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        RectangleAreaManager areaManager = new RectangleAreaManager(rectangle);
        areaManager.calculateArea();
        areaManager.saveAreaToFile();
        areaManager.printArea();
    }
}