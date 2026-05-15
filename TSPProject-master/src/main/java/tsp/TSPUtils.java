package tsp;

import java.util.List;

/**
 * a class that compute distance between two cities using helper methods
 * {@code distance} and {@code totalDistance}
 * 
 * @author Seham Alharbi
 */

public class TSPUtils {

	/**
	 * 
	 * @param a
	 * @param b
	 * @return computed distance between two cities a and b using Euclidean distance
	 *         formula, check the Euclidean-Distance-Calculation-Example.pdf file
	 *         found in this project for more details.
	 */
	public static double distance(City a, City b) {
		double dx = a.getX() - b.getX();
		double dy = a.getY() - b.getY();
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * 
	 * @param tour
	 * @return total tour distance by calling the distance method, it is simply the
	 *         sum of distances between consecutive cities + return to the start If
	 *         your tour is: A → B → C → D, Then total distance is: d(A,B) + d(B,C)
	 *         + d(C,D) + d(D,A)
	 */
	public static double totalDistance(List<City> tour) {
		double total = 0.0;

		for (int i = 0; i < tour.size() - 1; i++) {
			total += distance(tour.get(i), tour.get(i + 1));
		}

		total += distance(tour.get(tour.size() - 1), tour.get(0));
		return total;
	}
}
