import java.util.Scanner;

public class SquareRoot_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //входни данни
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 0) {
                throw new ArithmeticException("SQRT is invalid for negative numbers");
            }
            System.out.printf("%.2f%n", Math.sqrt(number));
        } catch (NumberFormatException | ArithmeticException e) {
            //NumberFormatException: входните данни не са ми число
            //или
            //ArithmeticException: числото е отрицателно
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }

    }
}
