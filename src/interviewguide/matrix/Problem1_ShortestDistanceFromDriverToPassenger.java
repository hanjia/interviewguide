package interviewguide.matrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * 000000100D
 * 0D00000000
 * 000010P000
 * 00D010010D
 * 0000100100
 * 
 * @author hajia
 *
 */
public class Problem1_ShortestDistanceFromDriverToPassenger {
	
	int minDistance;
	
	public int getShortestDistanceFromDriversToPassenger(int[][] city, Pair passenger, List<Pair> drivers) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(drivers.size(), new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2)
					return -1;
				else if (o1 == o2)
					return 0;
				else
					return 1;
			}
		}); 

		boolean[][] visited = new boolean[city.length][city[0].length];
		for (Pair driver: drivers) {
			minDistance = Integer.MAX_VALUE;
			getDistanceFromDriverToPassenger(city, passenger.x, passenger.y, driver.x, driver.y, 0, visited);
			queue.add(minDistance);
		}
		
		return queue.poll();
	}
	
	public void getDistanceFromDriverToPassenger(int[][] city, int passengerX, int passengerY, int driverX, int driverY, int distance, boolean[][] visited) {
		if ((passengerX == driverX) && (passengerY == driverY)) {
			if (distance < minDistance) {
				minDistance = distance;
				System.out.println(distance);
			}
			return;
		}
		
		if (driverX < 0 || driverY < 0 || driverX >= city[0].length || driverY >= city.length || visited[driverY][driverX])
			return;
		
		visited[driverY][driverX] = true;
		getDistanceFromDriverToPassenger(city, passengerX, passengerY, driverX - 1, driverY, distance + 1, visited);
		getDistanceFromDriverToPassenger(city, passengerX, passengerY, driverX + 1, driverY, distance + 1, visited);
		getDistanceFromDriverToPassenger(city, passengerX, passengerY, driverX, driverY - 1, distance + 1, visited);
		getDistanceFromDriverToPassenger(city, passengerX, passengerY, driverX, driverY + 1, distance + 1, visited);
	}
	
	public static void main(String[] args) {
		int[][] city = new int[3][3];
		Pair passenger = new Pair(0, 0);
		List<Pair> drivers = new ArrayList<Pair>();
		Pair driver = new Pair(2, 0);
		drivers.add(driver);
		
		Problem1_ShortestDistanceFromDriverToPassenger problem1 = new Problem1_ShortestDistanceFromDriverToPassenger();
		int result = problem1.getShortestDistanceFromDriversToPassenger(city, passenger, drivers);
		System.out.println(result);
	}
}

class Pair{
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
