package datastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		//int[] height = {4,2,0,3,2,5};
		//test.trap(height);
		//int[] price = {100,180,260,310,40,535,695}; 
		//System.out.println(test.maxProfit(price));
		//int[] a1 = {};
		//int[] a2 = {2};
		//System.out.println(test.findMedianSortedArrays(a1, a2));
		//System.out.print(test.longestValidParentheses("(()))())("));
		//String s = "ADOBECODEBANC";
		//String t = "ABC";
		//System.out.println(test.minWindow2(s, t));
		//int[] pushed = {1,2,3,4,5};
		//int[] popped = {4,3,5,1,2};
		//System.out.println(test.validateStackSequences(pushed, popped));
		//int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		//System.out.println(test.maxProfit(arr));
		//int[] arr = {1,1,4,5,7,7,7,7,11,11,11};
		//int[] range = test.searchRange(arr, 11);
		//System.out.println(range[0]+","+range[1]);
		int[] houses = {1,2,3};
		int[] heaters = {2};
		System.out.println(test.findRadius(houses, heaters));
	}
	
	public int maxSubArray(int[] nums) {
        if(nums.length==1) {
        		return nums[0]; 
        }
        int l=0,r=0;
        int lmax=0,rmax=0;
        int max = nums[0];
        int i=1;
        int s = nums[0];
        
        while(l<=r && i<nums.length) {
	      if(s<0 && nums[i]>=0) {
	    	  	l=i;
	    	  	r=i;
	    	  	s=nums[i];
	    	  	if(s>max) {
	    	  		lmax=l;
	    	  		rmax=r;
	    	  		max=s;
	    	  	}
	    	  	i++;
	    	  	continue;
	      }
	      else if(s>=0 && s+nums[i]<0) {
	    	  	i++;
	    	  	l=i;
	    	  	r=i;
	    	  	s=r<nums.length?nums[i]:0;
	    	  	continue;
	      }
	      else {
	    	  	if(s+nums[i]>=0) {
	    	  		r=i;
	    	  		if(s>max) {
		    	  		lmax=l;
		    	  		rmax=r;
		    	  		max=s;
		    	  	}
	    	  		i++;
		    	  	continue;
	    	  	}
	      }
        }
        return max;
    }

	public int trap(int[] height) {
		int len = height.length;
		if(len==0)
			return 0;
		int[] tallestBldgLeft = new int[len];
		int[] tallestBldgRight = new int[len];
		tallestBldgLeft[0] = -1;
		tallestBldgRight[len - 1] = -1;
		int tallestStart = height[0],tallestEnd = height[len-1];
		int idx = 1,currStart, currEnd;
		
		while (idx < len) {
			currStart = height[idx];
			
			if(currStart < tallestStart) {
				tallestBldgLeft[idx] = tallestStart;
			} else {
				tallestBldgLeft[idx] = -1;
				tallestStart = currStart;
			}
		
			idx++;
		}
		
		idx = 1;
		while(idx < len) {
			currEnd = height[len-1-idx];
			
			if(currEnd < tallestEnd) {
				tallestBldgRight[len-1-idx] = tallestEnd;
			} else {
				tallestBldgRight[len-1-idx] = -1;
				tallestEnd = currEnd;
			}
			idx++;
		}
		
		int[] water = new int[len];
		int min;
		for(int i=0;i<len;i++) {
			min = Math.min(tallestBldgLeft[i], tallestBldgRight[i]);
			if(tallestBldgLeft[i]==-1 || tallestBldgRight[i]==-1 || height[i]>min) {
				continue;
			} else {
				water[i] = min - height[i];
			}
		}
//		System.out.println(Arrays.stream(water).reduce((a,b) -> a+b).getAsInt());
//		System.out.println(Arrays.stream(tallestBldgLeft).mapToObj(String::valueOf).reduce((a,b) -> a+","+b).get());
//		System.out.println(Arrays.stream(tallestBldgRight).mapToObj(String::valueOf).reduce((a,b) -> a+","+b).get());
		
		return Arrays.stream(water).reduce((a,b) -> a+b).getAsInt();
	}
		
	int maxProfit(int price[]) {
		int buyingPrice = price[0], profit = 0;
		int i =1 , a, b, c;
		while(i<price.length-1){
			a = price[i-1];
			b = price[i];
			c = price[i+1];
			
			if(a<b && b<c) {
			} else if(a>b && b>c) {
				buyingPrice = b;
			} else if(a<b && b>c) {
				profit += b-buyingPrice;
			} else if(a>b && b<c) {
				buyingPrice = b;
			}
			i++;
		}
		
		if(price[price.length-1]>buyingPrice) {
			profit += price[price.length-1]-buyingPrice;
		}
		
		return profit;	
	}
	
	double findMedianSortedArrays(int[] a1,int[] a2) {
		int m = a1.length;
		int n = a2.length;
		double median;
		
		if(m+n==0)
			return -1;
		int mid1,mid2 = -1;
		double s = m+n;
		mid1 = (int) (Math.ceil(s/2) - 1);
		if(s%2==0) {
			mid2 = (int) Math.ceil(s/2);
		}
		if(m==0) {
			median = mid2 == -1 ? a2[mid1]: ((double)(a2[mid1]+a2[mid2]))/2;
			return median;
		}
		if(n==0) {
			median = mid2 == -1 ? a1[mid1]: ((double)(a1[mid1]+a1[mid2]))/2;
			return median;
		}
		
		int i=0,l=0,k=0,min1,min2;

		while(i<=mid1) {
			if(k>=m) {
				min1 = a2[mid1-m];
				if(mid2!=-1){
					min2 = a2[mid1-m+1];
					return ((double)(min1+min2))/2;
				}
				return min1;
			}
			if(l>=n) {
				min1 = a1[mid1-n];
				if(mid2!=-1){
					min2 = a1[mid1-n+1];
					return ((double)(min1+min2))/2;
				}
				return min1;
			}
			if(a1[k]<a2[l]) {
				min1 = a1[k];
				if(i==mid1) {
					if(mid2!=-1) {
						min2 = k+1>=m ? a2[l]: Math.min(a1[k+1], a2[l]);
						return ((double)(min1+min2))/2;
					}
					return min1;
				} else {
					i++;
					k++;
				}
			} else {
				min1 = a2[l];
				if(i==mid1) {
					if(mid2!=-1) {
						min2 = l+1>=n ? a1[k]: Math.min(a1[k], a2[l+1]);
						return ((double)(min1+min2))/2;
					}
					return min1;
				} else {
					i++;
					l++;
				}
			}
		}
		return -1;
		
	}
	
	public int longestValidParentheses(String s) {
		char[] arr = s.toCharArray();
		int l = arr.length;
		if(l<2)
			return 0;
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		int y;
		for(int i=0;i<l;i++) {
			char x = arr[i];
			if(x=='(') {
				s1.push(1);
				continue;
			} else {
				boolean matchFound = false;
				while(!s1.isEmpty()) {
					y = s1.peek();
					if(y==1) {
						s1.pop();
						Optional<Integer> sm = s2.stream().reduce((a,b) -> a+b);
						int sum = sm.isPresent() ? sm.get(): 0;
						while(!s1.isEmpty() && s1.peek()>1) {
							sum+=s1.pop();
						}
						s1.push(sum+2);
						s2.removeAllElements();
						matchFound = true;
						break;
					} else if(y==-1) {
						s1.addAll(s2);
						s1.push(-1);
						s2.removeAllElements();
						matchFound = true;
						break;
					} else {
						s2.push(s1.pop());
					}
				}
				if(s1.isEmpty() && !s2.isEmpty()) {
					s1.addAll(s2);
					s2.removeAllElements();
				}
				if(!matchFound) {
					s1.push(-1);
				}
			}
		}
		
		//s1.iterator().forEachRemaining(System.out::print);
		return s1.stream().filter(i -> i>1).max((a,b) -> a-b).isPresent() ? s1.stream().filter(i -> i>1).max((a,b) -> a-b).get() : 0;
    }

	public String minWindow(String s, String t) {
		char[] sarr = s.toCharArray();
		char[] tarr = t.toCharArray();
		int sl = sarr.length;
		int tl = tarr.length;
		if(tl>sl)
			return "";
		int start=-1,end=-1, tCharFound=0,i=0,minWindowSize=1000000000;
		int startMin = -1,endMin = -1;
		char currentChar;
		Map<Character,Integer> tFreq = new HashMap<>();
		Map<Character,Integer> tFreqTrack = new HashMap<>();
		for(int j=0;j<tl;j++) {
			char x = tarr[j];
			tFreq.put(x, tFreq.getOrDefault(x, 0)+1);
		}
		while(i<sl) {
			currentChar = sarr[i];
			int currentFreq = tFreqTrack.getOrDefault(currentChar, 0);
			if(tFreq.containsKey(currentChar)) {
				start = start==-1? i : start;
				end = i;
				tFreqTrack.put(currentChar, currentFreq +1);
				if(currentFreq < tFreq.get(currentChar))
					tCharFound++;
			}
			if(tCharFound < tl) {
				i++;
				continue;
			} else {
				int windowSize = end-start +1;
				if(windowSize < minWindowSize) {
					endMin = end;
					startMin = start;
					minWindowSize = windowSize;
					if(minWindowSize == tl)
						break;
				}
				
				while(start<=end) {
					currentChar = sarr[start];
					start++;
					if(tFreq.containsKey(currentChar) && tFreqTrack.get(currentChar)>=tFreq.get(currentChar)) {
						tFreqTrack.put(currentChar, tFreqTrack.get(currentChar)-1);
						if(tFreqTrack.get(currentChar) < tFreq.get(currentChar)) {
							tCharFound--;
							break;
						}
					}
				}
				while(start<sl && !tFreq.containsKey(sarr[start])) {
					start++;
				}
				
				int j = end+1;
				while(j<=sl-1) {
					currentChar = sarr[j];
					if(tFreq.containsKey(currentChar)) {
						end = j;
						if(tFreqTrack.get(currentChar) < tFreq.get(currentChar)) {
							tFreqTrack.put(currentChar, tFreqTrack.get(currentChar) +1);
							tCharFound++;
							break;
						}
						tFreqTrack.put(currentChar, tFreqTrack.get(currentChar) +1);
					}
					j++;
				}
				i=end+1;
			}
		}
		if(startMin!=-1 && endMin!=-1) {
			return s.substring(startMin,endMin+1);
		}
		return "";
	}
	
	public String minWindow2(String s, String t) { 
		char[] sarr = s.toCharArray();
		char[] tarr = t.toCharArray();
		int sl = sarr.length;
		int tl = tarr.length;
		
		if(tl>sl)
			return "";
		
		Map<Character,Integer> tFreq = new HashMap<>();
		Map<Character,Integer> tFreqTrack = new HashMap<>();
		for(int j=0;j<tl;j++) {
			char x = tarr[j];
			tFreq.put(x, tFreq.getOrDefault(x, 0)+1);
		}
		
		int start=0,end=0, tCharFound=0,i=0,minWindowSize=1000000000;
		int sMin=-1,eMin=-1;
		while(i<sl && !tFreq.containsKey(sarr[i])) {
			i++;
		}
		start = i;
		end = i;
		int j=i;
		while(start<=end && j < sl) {
			if(tFreq.containsKey(sarr[j])) {
				end = j;
				if(tFreqTrack.getOrDefault(sarr[j],0) < tFreq.get(sarr[j])) {
					tCharFound++;
				}
				tFreqTrack.put(sarr[j], tFreqTrack.getOrDefault(sarr[j], 0)+1);
				if(tCharFound==tl) {
					if(end-start+1 == tl) {
						return s.substring(start,end+1);
					} else {
						if(end-start+1 < minWindowSize) {
							sMin = start;
							eMin = end;
							minWindowSize = end-start+1;
						}
					}
					int k = start;
					while(tCharFound==tl && k<=end) {
						while(!tFreq.containsKey(sarr[k])) {
							k++;
						}
						if(end-k+1 < minWindowSize) {
							sMin = k;
							eMin = end;
							minWindowSize = end-k+1;
						}
						if(tFreq.containsKey(sarr[k]) && tFreqTrack.get(sarr[k]) >= tFreq.get(sarr[k])) {
							tFreqTrack.put(sarr[k], tFreqTrack.get(sarr[k])-1);
							if(tFreqTrack.get(sarr[k]) < tFreq.get(sarr[k])) {
								tCharFound--;
								start=k+1;
								while(!tFreq.containsKey(sarr[start])) {
									start++;
								}
							}
						}
						k++;
					}
				}
			}
			j++;
		}
		
		
		if(sMin<=eMin && eMin!=-1) {
			return s.substring(sMin, eMin+1);
		}
		return "";
		
	}
	
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed.length == 0 && popped.length == 0)
			return true;
		if((pushed.length == 0 && popped.length != 0) || (pushed.length != 0 && popped.length == 0))
			return false;
		
		Stack<Integer> stack = new Stack<>();
		int pushedIndex = 1;
		int poppedIndex = 0;
		stack.push(pushed[0]);
		while(true) {
			while(!stack.isEmpty() && stack.peek()==popped[poppedIndex]) {
				stack.pop();
				poppedIndex++;
			}
			if(pushedIndex<pushed.length)
				stack.push(pushed[pushedIndex++]);
			if(pushedIndex>=pushed.length && poppedIndex>=popped.length && stack.isEmpty()) {
				return true;
			}
			if(pushedIndex>=pushed.length && !stack.isEmpty() && poppedIndex<popped.length && stack.peek()!=popped[poppedIndex]) {
				return false;
			}
		}
	  }

	public int[] searchRange(int[] nums, int target) {
        	int start =0, end = 0;
        	int targetIndex = bsearch(0, nums.length-1, target, nums);
        	int[] range = {-1,-1};
        	
        	if(targetIndex!=-1) {
        		range[0]= targetIndex;
        		range[1]= targetIndex;
        		start = 0;
        		end = targetIndex -1;
        		while(start<=end) {
        			if(start==end) {
        				if(nums[start]==target) {
        					range[0] = start;
        				}
        				break;
        			} else {
        				int mid = (start+end)/2;
        				if(nums[mid]<target) {
        					start = mid+1;
        					continue;
        				} else {
        					range[0] = mid;
        					end = mid -1;
        					continue;
        				}
        			}
        		}
        		start = targetIndex + 1;
        		end = nums.length -1;
        		while(start<=end) {
        			if(start==end) {
        				if(nums[start]==target) {
        					range[1] = start;
        				}
        				break;
        			} else {
        				int mid = (start+end)/2;
        				if(nums[mid]>target) {
        					end = mid -1;
        					continue;
        				} else {
        					range[1] = mid;
        					start = mid +1;
        					continue;
        				}
        			}
        		}
        	} else {
        		return range;
        	}
     return range;
    }
	
	public int bsearch(int start,int end,int target,int[] nums) {
		if(start<=end && target>=nums[start] && target<=nums[end]) {
			int mid = (start+end)/2;
			if(nums[mid]>target) {
				return bsearch(start, mid-1, target, nums);
			} else if(nums[mid]<target) {
				return bsearch(mid+1, end, target, nums);
			} else {
				return mid;
			}
		} else {
			return -1;
		}
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
