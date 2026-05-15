package tsp;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Seham Alharbi
 */
public class Main {
	public static void main(String[] args) {
		try {
			// 1) Read berlin52.tsp
			System.out.println("===== berlin52.tsp file =====");
			List<City> berlin = TSPLIBReader.readFile("TSPProject-master/data/berlin52.tsp");

			// Save as .txt
			TSPLIBReader.saveAsTxt(berlin, "TSPProject-master/data/berlin52.txt");
			System.out.println("Number of cities: " + berlin.size());

			for (City city : berlin) {
				System.out.println(city);
			}

			if (berlin.size() >= 2) {
				double d = TSPUtils.distance(berlin.get(0), berlin.get(1));
				System.out.println("Distance between first two cities: " + d);
			}

			double totalBerlin = TSPUtils.totalDistance(berlin);
			System.out.println("Total tour distance: " + totalBerlin);

			// 2) Read eil51.tsp
			System.out.println("\n===== eil51.tsp file =====");
			List<City> eil = TSPLIBReader.readFile("TSPProject-master/data/eil51.tsp");

			// Save as .txt
			TSPLIBReader.saveAsTxt(eil, "TSPProject-master/data/eil51.txt");
			System.out.println("Number of cities: " + eil.size());

			for (City city : eil) {
				System.out.println(city);
			}

			if (eil.size() >= 2) {
				double d = TSPUtils.distance(eil.get(0), eil.get(1));
				System.out.println("Distance between first two cities: " + d);
			}

			double totalEil = TSPUtils.totalDistance(eil);
			System.out.println("Total tour distance: " + totalEil);

			// Hill Climbing output
			runHillClimbing("berlin52", berlin);
			runHillClimbing("eil51", eil);

			// Simulated Annealing output
			runSimulatedAnnealing("berlin52", berlin);
			runSimulatedAnnealing("eil51", eil);

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

	public static void runHillClimbing(String datasetName, List<City> cities) {
		
		// TODO: Write the code that displays your solution output here.
		System.out.println("\n===== Hill Climbing on " + datasetName + " =====");

		List<City> initialTour = new ArrayList<>(cities);

		Collections.shuffle(initialTour);

		double initialDistance =
				TSPUtils.totalDistance(initialTour);

		System.out.println(
				"Initial random tour distance: "
						+ initialDistance);

		HillClimbingSolver solver =
				new HillClimbingSolver(10000);

		List<City> improvedTour =
				solver.solve(initialTour);

		double improvedDistance =
				TSPUtils.totalDistance(improvedTour);

		System.out.println(
				"Improved tour distance: "
						+ improvedDistance);

		System.out.println(
				"Improvement amount: "
						+ (initialDistance - improvedDistance));

		System.out.println(
				"Iterations used: 10000");

		System.out.println(
				"Final tour (city IDs):");

		for (City city : improvedTour) {
			System.out.print(city.getId() + " ");
		}

		System.out.println();
	}

	public static void runSimulatedAnnealing(String datasetName, List<City> cities) {
		
		// TODO: Write the code that displays your solution output here.
	}
}