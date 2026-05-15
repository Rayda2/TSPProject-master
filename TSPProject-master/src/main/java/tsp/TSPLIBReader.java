package tsp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * a class to parse the .tsp files and store cities' IDs and coordinates in a
 * List and a .txt file for simpler reading
 * 
 * @author Seham Alharbi
 */
public class TSPLIBReader {
	public static List<City> readFile(String fileName) throws IOException {
		List<City> cities = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line;
		boolean readingCoordinates = false;

		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty()) {
				continue;
			}
			if (line.equals("NODE_COORD_SECTION")) {
				readingCoordinates = true;
				continue;
			}
			if (line.equals("EOF")) {
				break;
			}
			if (readingCoordinates) {
				String[] parts = line.split("\\s+");
				int id = Integer.parseInt(parts[0]);
				double x = Double.parseDouble(parts[1]);
				double y = Double.parseDouble(parts[2]);
				cities.add(new City(id, x, y));
			}
		}
		reader.close();
		return cities;
	}

	/**
	 * Save cities to simplified .txt file
	 * 
	 * @param cities
	 * @param outputFile
	 * @throws IOException
	 */
	public static void saveAsTxt(List<City> cities, String outputFile) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		for (City c : cities) {
			writer.write(c.getId() + " " + c.getX() + " " + c.getY());
			writer.newLine();
		}
		writer.close();
	}
}