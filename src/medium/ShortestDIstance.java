package medium;

public class ShortestDIstance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int wordDistance(String[] words,String word1,String word2) {
		if(words.length<2)
			return -1;
		
		int w1=-1,w2=-1,minDist=1000000000;
		String word;
		for(int i=0;i<words.length;i++) {
			word = words[i];
			if(word.equals(word1)) {
				if(w1==-1) {
					w1=i;
				}
				if(w2!=-1) {
					if(w1-w2<minDist)
						minDist = w1-w2;
				}
			} else if(word.equals(word2)) {
				if(w2==-1) {
					w2=i;
				}
				if(w1!=-1) {
					if(w2-w1<minDist)
						minDist = w2-w1;
				}
			}
		}
		return minDist;
	}

}
