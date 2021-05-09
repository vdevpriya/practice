package algorithm;

public class teamSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numTeams(int[] rating) {
		int[] numLessDP = new int[rating.length];
		int[] numMoreDP = new int[rating.length];
		int numOfTeams = 0;
		
		for(int i=1;i<rating.length;i++) {
			for(int j=0;j<i;j++) {
				if(rating[j]<rating[i]) {
					numOfTeams+=numLessDP[j];
					numLessDP[i]++;
				} 
				if(rating[j]>rating[i]) {
					numOfTeams+=numMoreDP[j];
					numMoreDP[i]++;
				} 
			}
		}
		
		return numOfTeams;
	}

}
