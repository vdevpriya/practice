package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsPhoneNumber t = new LetterCombinationsPhoneNumber();
		System.out.println(t.letterCombinations("2"));
	}
	
	static Map<String,List<String>> map = new HashMap<>();
	
	static {
		map.put("2",Arrays.asList("a","b","c"));
		map.put("3",Arrays.asList("d","e","f"));
		map.put("4",Arrays.asList("g","h","i"));
		map.put("5",Arrays.asList("j","k","l"));
		map.put("6",Arrays.asList("m","n","o"));
		map.put("7",Arrays.asList("p","q","r","s"));
		map.put("8",Arrays.asList("t","u","v"));
		map.put("9",Arrays.asList("w","x","y","z"));
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> answer = new ArrayList<>();
        for(int i=0;i<digits.length();i++) {
        		String d = digits.substring(i, i+1);
        		List<String> l = map.get(d);
        		answer = getCrossProduct(l,answer);
        }
        return answer;
    }
	List<String> getCrossProduct(List<String> l1,List<String>l2) {
		if(l1==null || l1.isEmpty()) {
			return l2;
		}
		if(l2==null || l2.isEmpty()) {
			return l1;
		}
		List<String> l3 = new ArrayList<String>();
		for (String i2 : l2) {
			for (String i1 : l1) {
				l3.add(i2+i1);
			}
		}
		return l3;
	}

}
