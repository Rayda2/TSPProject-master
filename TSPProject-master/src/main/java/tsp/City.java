package tsp;

/**
 *  a city model class
 * @author Seham Alharbi
 */
public class City {
	private int id;
	private double x;
	private double y;

	public City(int id, double x, double y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return id + " (" + x + ", " + y + ")";
	}
}
