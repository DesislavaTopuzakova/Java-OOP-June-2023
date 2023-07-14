package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class; //клас
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor(); //private конструктор без аргументи
        constructor.setAccessible(true); //правим конструктора достъпен - мога да го изпозлвам
        BlackBoxInt blackBoxInt = constructor.newInstance(); //създаваме обект

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while(!command.equals("END")) {
            //command = "{command name}_{value}"
            String methodName = command.split("_")[0]; //метода, който трябва да изпълня
            int argument = Integer.parseInt(command.split("_")[1]); //стойността, с която изпълняваме метода

            Method method = clazz.getDeclaredMethod(methodName, int.class); //достъпваме метод с въведеното име
            method.setAccessible(true); //мога да изпълня метода
            //blackBoxInt.add(argument);
            method.invoke(blackBoxInt, argument); //изпълняваме метода с дадения аргумент


            Field innerValueField = clazz.getDeclaredField("innerValue"); //взимаме числото в кутията
            innerValueField.setAccessible(true);
            System.out.println(innerValueField.get(blackBoxInt)); //стойността на полето

            command = scanner.nextLine();
        }
    }
}
