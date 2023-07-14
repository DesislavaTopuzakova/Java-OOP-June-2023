package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Class<RichSoilLand> clazz = RichSoilLand.class;
		//всички полета, без значение от техния access modifier
		Field[] fields = clazz.getDeclaredFields();

		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();

		//Consumer<тип> -> void -> accept
		//"{access modifier} {field type} {field name}"
		Consumer<Field> fieldPrinter = field -> System.out.printf("%s %s %s%n",
				Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());

		while (!command.equals("HARVEST")) {
			switch (command) {
				case "private":
					//print all private fields
					Arrays.stream(fields)
							.filter(field -> Modifier.isPrivate(field.getModifiers()))
							.forEach(fieldPrinter);
					break;
				case "protected":
					//print all protected fields
					Arrays.stream(fields)
							.filter(field -> Modifier.isProtected(field.getModifiers()))
							.forEach(fieldPrinter);
					break;
				case "public":
					//print all public fields
					Arrays.stream(fields)
							.filter(field -> Modifier.isPublic(field.getModifiers()))
							.forEach(fieldPrinter);
					break;
				case "all":
					//print ALL declared fields
					Arrays.stream(fields).forEach(fieldPrinter);
					break;
			}

			command = scanner.nextLine();
		}

	}
}
