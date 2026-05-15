package tsp;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Please complete this class with your solution to the TSP using the Hill
 * Climbing algorithm.
 *
 * @author Seham Alharbi
 */

public class HillClimbingSolver {

	private int maxIterations;
	private int iterationsUsed;

	public HillClimbingSolver(int maxIterations) {
		this.maxIterations = maxIterations;
		this.iterationsUsed = 0;
	}

	public List<City> solve(List<City> initialTour) {

		Random random = new Random();

		List<City> currentTour =
				new ArrayList<>(initialTour);

		double bestDistance =
				TSPUtils.totalDistance(currentTour);

		List<City> bestTour =
				new ArrayList<>(currentTour);

		for (int i = 0; i < maxIterations; i++) {

			iterationsUsed++;

			List<City> newTour =
					new ArrayList<>(currentTour);

			int index1 =
					random.nextInt(newTour.size());

			int index2 =
					random.nextInt(newTour.size());

			Collections.swap(newTour, index1, index2);

			double newDistance =
					TSPUtils.totalDistance(newTour);

			if (newDistance < bestDistance) {

				bestDistance = newDistance;

				bestTour =
						new ArrayList<>(newTour);

				currentTour =
						new ArrayList<>(newTour);
			}
		}

		return bestTour;
	}}