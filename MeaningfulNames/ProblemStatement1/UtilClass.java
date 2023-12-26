package ProblemStatement1;

public class UtilClass {
    int utilNumber;
    double utilDecimal;
    String utilString;

    public void sum(int operand1, int operand2) {
        int sumResult = operand1 + operand2;
        System.out.println("Result: " + sumResult);
    }

    public void toUpperCase(String inputString) {
        utilString = inputString.toUpperCase();
        System.out.println("Updated String: " + utilString);
    }
}