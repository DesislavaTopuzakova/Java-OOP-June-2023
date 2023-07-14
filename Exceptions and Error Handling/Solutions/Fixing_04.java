import java.util.Scanner;

public class Fixing_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] weekdays = new String[5];

        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";

        for (int i = 0; i <= weekdays.length ; i++) {
            try {
                System.out.println(weekdays[i]);
            } catch (Exception e) {
                System.out.println("Index " + i + " is not valid!");
            }
        }

        scanner.nextLine();
    }
}
