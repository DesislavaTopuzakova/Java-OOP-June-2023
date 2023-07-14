import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers_03 {
    public static void main(String[] args) {
        int start = 1;
        int end = 100;
        Scanner scanner = new Scanner(System.in);List<Integer> numbers = new ArrayList<>();
        //стоп: списъка има 10 числа
        while (numbers.size() < 10) {
            int number = readNumber(start, end, scanner);
            //readNumber
            //-1 => число е невалидно
            //0 => входните данни не са число
            if (number <= 0) {
                continue;
            }

            // > 0 -> входни данни са число, което е валидно
            numbers.add(number);
            start = number;
        }

        System.out.println(numbers.toString().replace("[", "").replace("]",""));

    }
    //метод, който прочита число, валидира го и го връща
    public static int readNumber (int start, int end, Scanner scanner) {
        //интервал: (start; end)
        //валидно: число > start && число < еnd
        //невалидно: число <= start или число >= end

        int number = 0;
        try {
            number = Integer.parseInt(scanner.nextLine());
            //входните данни са число
            if (number <= start || number >= end) {
                //невалидно число
                System.out.printf("Your number is not in range %d - 100!%n", start);
                number = -1;
            }
        } catch (NumberFormatException e) {
            //входните данни не са число
            System.out.println("Invalid Number!");
        }

        return number;
    }
}
