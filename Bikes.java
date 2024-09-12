package pack1;

import java.util.ArrayList;

public class Bikes {
	private ArrayList<Bike> Bikes = new ArrayList<>();

	public Bike searchBike(int bikenum) {
		for (Bike b : Bikes) {
			if (b.getNumber() == bikenum) {
				return b;
			}
		}
		return null;
	}

	public void addBike(Bike newBike) {
		if (searchBike(newBike.getNumber()) != null) {
			return;
		}
		Bikes.add(newBike);
	}

	public void removeBike(Bike deleteBike) {
		Bikes.remove(deleteBike);
	}
}