import java.util.Scanner;

public class NumberInRange_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //входни данни
        String ranges = scanner.nextLine(); //"10 20"
        int startOfRange = Integer.parseInt(ranges.split(" ")[0]); //10
        int endOfRange = Integer.parseInt(ranges.split(" ")[1]); //20

        //интервал: [startOfRange; endOfRange]
        System.out.printf("Range: [%d...%d]%n", startOfRange, endOfRange);

        //повтарям: въвеждам входни данни
        //стоп: число е валидно (число >= startOfRange и  число <= endOfRange)
        //продължаваме: число не е валидно

        while (true) {
            String input = scanner.nextLine(); //текст
            try {
                int number = Integer.parseInt(input); //число
                if (number >= startOfRange && number <= endOfRange) {
                    //валидно
                    System.out.println("Valid number: " + number);
                    break;
                } else {
                    //невалидно
                    System.out.println("Invalid number: " + number);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + input);
            }
        }
    }
}
