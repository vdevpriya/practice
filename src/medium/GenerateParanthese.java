package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GenerateParanthese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParanthese g = new GenerateParanthese();
		System.out.println(g.generateParenthesis(3));
	}
	
	List<List<int[]>> grandChildren = new LinkedList<>();	
	
	public List<String> generateParenthesis(int n) {
		List<List<int[]>> nodes = new LinkedList<>();
		List<int[]> root = new LinkedList<>();
		int[] rootIndexArr = new int[2];
		rootIndexArr[0]=0;
		rootIndexArr[1]=1;
		root.add(rootIndexArr);
		nodes.add(root);
		while(!nodes.isEmpty()) {
			root = nodes.remove(0);
			List<List<int[]>> children = generateChildren(root, n);
			if(children!=null && !children.isEmpty())
				nodes.addAll(children);
		}
		List<String> strings = convertIndexArrToString(grandChildren);
		Set<String> s = new HashSet<>(strings);
		strings.removeAll(strings);
		strings = s.stream().collect(Collectors.toList());
		
		return strings;
    }
	
	
	private List<String> convertIndexArrToString(List<List<int[]>> grandChildren2) {
		// TODO Auto-generated method stub
		List<String> strList = new LinkedList<>();
		for (List<int[]> list : grandChildren2) {
			String s ="";
			for (int[] is : list) {
				s += getString(is[0], is[1]);
			}
			strList.add(s);
		}
		return strList;
	}

	String getString(int start,int end) {
		int b = end-start+1;
		b = b/2;
		String s1="",s2="";
		while(b>0) {
			s1+="(";
			s2+=")";
			b--;
		}
		return s1+s2;
	}

	List<List<int[]>> generateChildren(List<int[]> parentIndexList, int n) {
		if(n==1) {
			return null;
		}
		int b = getNoOfBrackets(parentIndexList);
		if(b==2*n) {
			grandChildren.add(parentIndexList);
			return null;
		}
		
		List<int[]> child;
		List<List<int[]>> childrenlist = new LinkedList<>();
		for(int i=0;i<parentIndexList.size();i++) {
			child = new LinkedList<int[]>(parentIndexList);
			int[] paranthIndexPair = child.remove(i);
			int start = paranthIndexPair[0];
			int end = paranthIndexPair[1];
			int[] newIndexArr = new int[2];
			newIndexArr[0] = start;
			newIndexArr[1] = end+2;
			child.add(i, newIndexArr);
			for(int x=i+1;x<child.size();x++) {
				paranthIndexPair = child.get(x);
				paranthIndexPair[0] = paranthIndexPair[0]+2;
				paranthIndexPair[1] = paranthIndexPair[1]+2;
			}
			childrenlist.add(child);
			if(i==parentIndexList.size()-1) {
				child = new LinkedList<int[]>(parentIndexList);
				newIndexArr = new int[2];
				newIndexArr[0] = end+1;
				newIndexArr[1] = end+2;
				child.add(i+1, newIndexArr);
				childrenlist.add(child);
			}
		}
		return childrenlist;
	}
	
	int getNoOfBrackets(List<int[]> parentIndexList) {
		int b = 0;
		for (int[] is : parentIndexList) {
			b+= is[1]-is[0] +1;
		}
		return b;
	}
	

}
