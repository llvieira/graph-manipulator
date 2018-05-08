package manipulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Util {
	public static Map<Integer, Integer> getValuesFromFile(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scanner = new Scanner(file);

		Map<Integer, Integer> mapOfConnections = new HashMap<>();

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] values = line.trim().split(" ");

			if (values.length > 1)
				mapOfConnections.put(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
		}

		scanner.close();

		return mapOfConnections;
	}

}
