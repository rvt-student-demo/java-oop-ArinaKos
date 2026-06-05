package rvt;

import java.util.Scanner;

public class Connecticut {
    
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {

            while(true) {
                System.out.println("Enter the numerator:");
                String inputNumerator = scan.nextLine(). trim();
                if (!inputNumerator.isEmpty() && (inputNumerator.charAt(0) == 'q' || inputNumerator. charAt(0)=='Q')) {
                    break;
                }
                try {
                    int numerator = Integer.parseInt(inputNumerator);
                    System.out.println("Enter the divisor: ");
                    String inputDivisor = scan.nextLine().trim();
                    int divisor = Integer.parseInt(inputDivisor);
                    if (divisor ==0) {
                    System.out.println("You cant divide" + numerator + " by 0");
                    } else {
                    int result = numerator / divisor;
                    System.out.println(numerator + "/" + divisor + " is" + result);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You entered bad data");
                    System.out.println("Please try again");
                }
                System.out.println();
            }
        }
    }
}