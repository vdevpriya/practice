package medium;

import java.util.Arrays;

public class MinimumRadius {
	public static void main(String[] args) {
		MinimumRadius test = new MinimumRadius();
		int[] houses = {2,3,7,8,10,12};
		int[] heaters = {3,4,10};
		System.out.println(test.findRadius(houses, heaters));
	}
	
	public int findRadius(int[] houses, int[] heaters) {
		 Arrays.sort(houses);
		 Arrays.sort(heaters);
		 int maxHeaterHouseDistance = -1;
		 for (int houseLoc : houses) {
			int nearestHeater = findNearestHeater(houseLoc, heaters);
			if(Math.abs(nearestHeater-houseLoc)>maxHeaterHouseDistance) {
				maxHeaterHouseDistance = Math.abs(nearestHeater-houseLoc);
			}
		}
		 return maxHeaterHouseDistance;
	 } 
	
	 int findNearestHeater(int houseLoc,int[] heaters) {
		 int distanceToHeater = 1000000000;
		 int heaterLoc = -1;
		 for (int h : heaters) {
			 if(Math.abs(h-houseLoc)<distanceToHeater) {
				 distanceToHeater = Math.abs(h-houseLoc);
				 heaterLoc = h;
		}
	 }
		 return heaterLoc;
	 }
}
