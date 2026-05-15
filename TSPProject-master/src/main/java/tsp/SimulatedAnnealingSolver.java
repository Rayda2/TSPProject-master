package tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Please complete this class with your solution to the TSP using the Simulated
 * Annealing algorithm.
 * 
 * @author Seham Alharbi
 */
public class SimulatedAnnealingSolver {
	private double initialTemperature;
	private double coolingRate;
	private int maxIterations;
	private int iterationsUsed;

	public SimulatedAnnealingSolver(double initialTemperature, double coolingRate, int maxIterations) {
		this.initialTemperature = initialTemperature;
		this.coolingRate = coolingRate;
		this.maxIterations = maxIterations;
		this.iterationsUsed = 0;
	}

	public List<City> solve(List<City> initialTour) {

		List<City> currentTour = new ArrayList<>(initialTour);
		List<City> bestTour = new ArrayList<>(currentTour);
		
		
		// TODO: Implement Simulated Annealing algorithm solution here.
		

		return bestTour;
	}

}