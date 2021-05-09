package datastructures;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 test = new Solution2();
		int[] houses = {1,2,3};
		int[] heaters = {2};
		System.out.println(test.findRadius(houses, heaters));
	}
	
	public int findRadius(int[] houses, int[] heaters) {
		 Arrays.sort(houses);
		 Arrays.sort(heaters);
		 int maxHeaterHouseDistance = -1;
		 for (int houseLoc : houses) {
			int nearestHeater = findNearestHeater(houseLoc, heaters);
			if(nearestHeater>maxHeaterHouseDistance) {
				maxHeaterHouseDistance = nearestHeater;
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
