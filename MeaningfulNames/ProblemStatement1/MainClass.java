package ProblemStatement1;

public class MainClass {
    public static void main(String[] args) {
        UtilClass utilObject = new UtilClass();
        utilObject.utilNumber = 10;
        utilObject.utilDecimal = 20.5;
        utilObject.utilString = "hello";

        utilObject.sum(utilObject.utilNumber, 5);
        utilObject.toUpperCase("world");
    }
}