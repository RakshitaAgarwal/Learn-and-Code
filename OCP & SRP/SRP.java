// Implement SRP in below codes if it's not implemented

eg. 1

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public void printArea() {
        double area = calculateArea();
        System.out.println("Area: " + area);
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        rectangle.printArea();
    }
}
-----------------------------------------------------------------------------




eg. 2

import java.io.FileWriter;
import java.io.IOException;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        double area = length * width;

        // Save area to a file
        try (FileWriter writer = new FileWriter("area.txt")) {
            writer.write("Area: " + area);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        return area;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        double area = rectangle.calculateArea();
        System.out.println("Calculated Area: " + area);
    }
}

