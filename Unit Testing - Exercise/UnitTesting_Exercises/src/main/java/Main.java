import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 6, 1, 2, 3, 0, 9, 12);
        Collections.sort(numbers); //ascending order (нарастващ ред)
        System.out.println(numbers.toString());

    }
}
