package medium;

public class BinarySearchConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'A',b='B';
		int d = c;
		System.out.println(c<b);
	}
	
	
	int binarySearch(int[] arr,int start,int end,int ele) {
		if(start>end)
			return -1;
		if(start==end && arr[start]==ele)
			return start;
		
		int mid = start+(end-start)/2;
		
		if(arr[mid]==ele)
			return mid;
		if(arr[mid]<ele) {
			return binarySearch(arr, mid+1, end, ele);
		} else {
			return binarySearch(arr, start, mid-1, ele);
		}
	}
	
	int binarySearchReverse(int[] arr,int start,int end,int ele) {
		if(start>end)
			return -1;
		if(start==end && arr[start]==ele)
			return start;
		
		int mid = start+(end-start)/2;
		
		if(arr[mid]==ele)
			return mid;
		if(arr[mid]<ele) {
			return binarySearch(arr, start, mid-1, ele);
		} else {
			return binarySearch(arr, mid+1, end, ele);
		}
	}
	
	int firstOccurenceEle(int[] arr,int ele) {
		if(arr.length==0)
			return -1;
		int res = -1;
		int start = 0;
		int end = arr.length-1;
		int mid;
		while(start<=end) {
			mid = start + (end-start)/2;
			if(arr[mid]==ele) {
				res = mid;
				end = mid-1;
			} else if(arr[mid]<ele) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return res;
	}
	
	
	int lastOccurenceEle(int[] arr,int ele) {
		if(arr.length==0)
			return -1;
		int res = -1;
		int start = 0;
		int end = arr.length-1;
		int mid;
		while(start<=end) {
			mid = start + (end-start)/2;
			if(arr[mid]==ele) {
				res = mid;
				start = mid+1;
			} else if(arr[mid]<ele) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return res;
	}
	
	int countOfEleSortedArr(int[] arr,int ele) {
		if(arr.length==0) {
			return 0;
		}
		int firstOcc = firstOccurenceEle(arr, ele);
		int lastOcc = firstOccurenceEle(arr, ele);
		
		return (lastOcc-firstOcc+1);
	}
	
	int findEleInNearlySortedArr(int[] arr,int ele) {
		if(arr.length==0) {
			return -1;
		}
		
		int start = 0,end = arr.length-1,mid;
		while(start<=end) {
			mid = start+(end-start)/2;
			if(arr[mid]==ele)
				return mid;
			if(mid-1>=0 && arr[mid-1]==ele)
				return mid-1;
			if(mid+1<arr.length && arr[mid+1]==ele)
				return mid+1;
			if(arr[mid]>ele) {
				end = mid-2;
			if(arr[mid]<ele)
				start = mid+2;
			}
		}
		return -1;
	}
	
	int findEleInSortedArr(int[] arr,int ele) {
		int minEleIdx = findMinEleIdxInRotatedSprtedArr(arr);
		if(arr[minEleIdx]==ele)
			return minEleIdx;
		int i = binarySearch(arr, 0, minEleIdx-1, ele);
		if(i<0)
			i = binarySearch(arr, minEleIdx+1, arr.length-1, ele);
		return i;
	}
	
	int finNoOfRotations(int[] arr) {
		int minEleIdx = findMinEleIdxInRotatedSprtedArr(arr);
		int n = arr.length;
		return (n-1-minEleIdx+1)%n;
	}
	
	int findMinEleIdxInRotatedSprtedArr(int[] arr) {
		if(arr.length<=1)
			return 0;
		
		int start = 0,end = arr.length-1,mid,n=arr.length;
		int prev,next;
		int minEleIdx = -1;
		while(start<=end) {
			mid = start + (end-start)/2;
			prev = (mid+n-1) % n;
			next = (mid+1) % n;
			if(arr[mid]<arr[prev] && arr[mid]<arr[next]) {
				minEleIdx = mid;
				break;
			} else if(arr[start]<arr[mid]) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return minEleIdx;
	}
	
	int findFloorEle(int[] arr,int ele) {
		if(arr.length==0)
			return -1;
		
		int start=0,end = arr.length-1,mid,floorIdx=-1;
		while(start<=end) {
			mid = start+(end-start)/2;
			if(arr[mid]==ele)
				return mid;
			if(arr[mid]<ele) {
				floorIdx=mid;
				start=mid+1;
			} else {
				end=mid-1;
			}
		}
		return floorIdx;
	}
	
	int findCeilEle(int[] arr,int ele) {
		if(arr.length==0)
			return -1;
		
		int start=0,end = arr.length-1,mid,floorIdx=-1;
		while(start<=end) {
			mid = start+(end-start)/2;
			if(arr[mid]==ele)
				return mid;
			if(arr[mid]<ele) {
				start=mid+1;
			} else {
				floorIdx=mid;
				end=mid-1;
			}
		}
		return floorIdx;
	}
	
	int nextAlphabet(char[] arr,char ele) {
		if(arr.length==0)
			return -1;
		
		int start=0,end=arr.length-1,mid;
		int idx=-1;
		while(start<=end) {
			mid = start+(end-start)/2;
			if(arr[mid]<=ele) {
				start=mid+1;
			} else {
				idx=mid;
				end=mid-1;
			}
		}
		return idx;
	}
	
	int findEleInfiniteSortedArray(int[] arr,int ele) {
		int start=0;
		int end=1;
		boolean found=false;
		while(!(arr[start]<=ele && arr[end]>=ele)) {
			start=end;
			end*=2;
		}
		return binarySearch(arr, start, end, ele);
	}
	
	int firstOccurenceOf1BinarySortedArr(int[] arr,int start,int end) {
		int mid;
		int idx=-1;
		while(start<=end) {
			mid = start + (end-start)/2;
			if(arr[mid]==1) {
				idx=mid;
				end=mid-1;
			} else {
				start=mid+1;
			}
		}
		return idx;
	}
	
	int findFirstOneInInfiniteBinarySortedArray(int[] arr) {
		int start=0,end=1;
		if(arr[start]==1)
			return start;
		if(arr[end]==1)
			return 1;
		while(!(start==0 && end==1)) {
			start=end;
			end=2*end;
		}
		if(arr[start]==0 && arr[end]==1)
			return firstOccurenceOf1BinarySortedArr(arr,start,end);
		return -1;
	}
	
	int minimumDiffEle(int[] arr,int key) {
		if(arr.length==0)
			return -1;
		
		int start=0,end=arr.length-1,mid=-1;
		while(start<=end) {
			mid=start=(end-start)/2;
			if(arr[mid]==key)
				return 0;
			if(arr[mid]<key) {
				start=mid+1;
			} else {
				end=mid-1;
			}
		}
		
		int diff = Math.abs(arr[mid]-key);
		if(mid-1>=0)
			diff = Math.min(diff, Math.abs(arr[mid-1]-key));
		if(mid+1<=arr.length-1)
			diff = Math.min(diff, Math.abs(arr[mid+1]-key));
		return diff;
	}
	
	//Applying Binary search in unsorted array--good question
	//Logic= peak element is the element which is greater than its immediated neighbors
	//if mid is peak return else move towards the greater element i.e move towards increasing slope
	//if we do so, either the slope will keep increasing in that case peak will be last element
	//if slope decrease then there will be peak element
	int peakElement(int[] arr) {
		if(arr.length==0)
			return -1;
		if(arr.length==1)
			return 0;
		
		int start=0,end=arr.length-1,mid;
		while(start<=end) {
			mid=start+(end-start)/2;
			if(mid>start && mid<end) {
				if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
					return mid;
				else {
					if(arr[mid+1]>arr[mid-1])
						start=mid+1;
					else
						end=mid-1;
				}
			} else {
				if(mid==start) {
					if(arr[start]>arr[end])
						return start;
					else
						return end;
				}
				if(mid==arr.length-1) {
					if(arr[arr.length-1]>arr[arr.length-2])
						return arr.length-1;
					else
						return arr.length-2;
				}
			}
		}
		return -1;
	}
	
	public int[] findPeakGrid(int[][] mat) {
        
    }
	
	//Bitonic arr is the array which is monotonically increasing then monotonically decreasing
	int findMaxEleInBitonicArr(int[] arr) {
		return peakElement(arr);
	}
	
	int searchEleInBitonicArr(int[] arr,int key) {
		int peakIdx = peakElement(arr);
		int k = binarySearch(arr, 0, peakIdx, key);
		if(k==-1)
			k = binarySearch(arr, peakIdx,arr.length-1, key);
		return k;
	}
	
	int[] searchInSorted2DArray(int[][] arr,int key) {
		int m = arr.length;
		int n = arr[0].length;
		int i=0,j=n-1;
		while(i<m && j>=0) {
			if(arr[i][j]==key)
			{
				int[] a = new int[2];
				a[0]=i;
				a[1]=j;
				return a;
			} else if(arr[i][j]>key) {
				j--;
			} else {
				i++;
			}
		}
		return null;
	}
	
	/*
	 * https://www.geeksforgeeks.org/allocate-minimum-number-pages/
	 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
	 * */
	/// Verrrrry good question on Binary search
	int allocateMinNumOfPages(int[] arr,int s) {
		if(arr.length<s)
			return -1;
		if(arr.length==1)
			return arr[0];
		int max=-1,sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(max<arr[i])
				max=arr[i];
		}
		
		int start = max;
		int end = sum;
		int mid,res=-1;
		
		while(start<=end) {
			mid=start+(end-start)/2;
			if(isValid(arr,mid,s)) {
				res=mid;
				end=mid-1;
			} else {
				start=mid+1;
			}
		}
		return res;
	}
	
	boolean isValid(int[] arr,int capacity,int students) {
		int s=1, sum=0;
		for(int i=0;i<arr.length;i++) {
			if(sum+arr[i]>capacity) {
				s++;
				sum=arr[i];
				if(s>students)
					return false;
			} else {
				sum+=arr[i];
			}
		}
		return true;
	}

}
