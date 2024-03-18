package FunctionsAssignment.SRP.example2;

import java.io.FileWriter;
import java.io.IOException;

import FunctionsAssignment.SRP.example2.Model.Rectangle;

public class RectangleAreaManager {

    private Rectangle rectangle;
    private double area;

    public RectangleAreaManager(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public double calculateArea() {
        return this.area = this.rectangle.getLength() * this.rectangle.getWidth();
    }

    public void saveAreaToFile() {
        try (FileWriter writer = new FileWriter("area.txt")) {
            writer.write("Area: " + this.area);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void printArea() {
        System.out.println("Area: " + this.area);
    }
}