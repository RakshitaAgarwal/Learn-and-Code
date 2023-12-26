/*
Let's consider a problem where we need to create different types of electronic devices 
    (e.g., smartphones and laptops) with varying specifications.

Problem Statement:
Imagine a scenario where you have a program that needs to create electronic devices. 
Each device type (e.g., smartphone, laptop) has different specifications, and based on 
the user's input, the program should create and display the details of the selected device.

Look at the below code, and check if it's following OCP or not. If it's not following rewrite the code to follow OCP. 
 */

// DeviceType enum
enum DeviceType {
    SMARTPHONE,
    LAPTOP
}

// Device interface
interface Device {
    void displayDetails();
}

// Concrete Smartphone class
class Smartphone implements Device {
    @Override
    public void displayDetails() {
        System.out.println("Smartphone: Model X, RAM: 8GB, Storage: 128GB");
    }
}

// Concrete Laptop class
class Laptop implements Device {
    @Override
    public void displayDetails() {
        System.out.println("Laptop: Model Y, RAM: 16GB, Storage: 512GB");
    }
}

// DeviceFactory class with a switch statement
class DeviceFactory {
    public static Device createDevice(DeviceType type) {
        switch (type) {
            case SMARTPHONE:
                return new Smartphone();
            case LAPTOP:
                return new Laptop();
            default:
                throw new IllegalArgumentException("Invalid device type: " + type);
        }
    }
}

// Client code using the switch statement
public class ClientWithSwitch {
    public static void main(String[] args) {
        Device smartphone = DeviceFactory.createDevice(DeviceType.SMARTPHONE);
        Device laptop = DeviceFactory.createDevice(DeviceType.LAPTOP);

        smartphone.displayDetails();
        laptop.displayDetails();
    }
}

