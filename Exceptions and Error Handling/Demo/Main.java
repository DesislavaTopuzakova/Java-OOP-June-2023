import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SoftuniUserException {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("Softuni")) {
            throw new SoftuniUserException("invalid input");
        }

    }



}