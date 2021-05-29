package datastructures;

public class MedianOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		int[] nums1 = {3};
		int[] nums2 = {-2,-1};
		MedianOfSortedArray o = new MedianOfSortedArray();
		System.out.println(o.findMedianSortedArrays(nums1, nums2));
		//System.out.println(Math.ceil(4.5));
	}
	
//	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        	double m = nums1.length;
//        	double n = nums2.length;
//        	if(m==0) {
//        		int md;
//        		if(n%2==0) {
//        			md = (int) (n/2);
//        			return ((double)nums2[md]+nums2[md-1])/2;
//        		} else {
//        			md = (int) (n/2);
//        			return nums2[md];
//        		}
//        	}
//        	if(n==0) {
//        		int nd;
//        		if(m%2==0) {
//        			nd = (int) (m/2);
//        			return ((double)nums1[nd]+nums1[nd-1])/2;
//        		} else {
//        			nd = (int) (m/2);
//        			return nums1[nd];
//        		}
//        	}
//        	double k;
//        	boolean mnodd = false;
//        	if((m+n)%2==0) {
//        		k = (m+n)/2 +1;
//        	} else {
//        		k = (int) (Math.ceil((m+n)/2));
//        		mnodd = true;
//        	}
//        	int mid = k==2?1:(int) (Math.ceil((1+k)/2));
//        	int sa =0,ea=mid-1,sb=0,eb=(int)(k-mid-1);
//        	int a,aa,b,bb;
//        	double median;
//        	while(true) {
//        		if(ea==m-1 || eb==n-1) {
//        			if(mnodd) {
//        				return Math.max(nums1[ea], nums2[eb]);
//        			} else {
//        				return (double)((double)nums1[ea]+nums2[eb])/2;
//        			}
//        		}
//        		a = nums1[ea];
//        		aa = nums1[ea+1];
//        		b = nums2[eb];
//        		bb = nums2[eb+1];
//        		
//        		if(a>=b && a<=bb) {
//        			if(!mnodd) {
//        				int secondLast = Math.max(nums1[ea-1], nums2[eb]);
//        				median = (a+secondLast)/2;
//        				break;
//        			} else {
//        				median = a;
//        				break;
//        			}
//        		}
//        		if(b>=a && b<=aa) {
//        			if(!mnodd) {
//        				int secondLast = Math.max(nums1[ea], nums2[eb-1]);
//        				median = (b+secondLast)/2;
//        				break;
//        			} else {
//        				median = b;
//        				break;
//        			}
//        		}
//        		if(a>=b && a>=bb) {
//        			ea = (int) Math.ceil((sa+ea)/2);
//        			eb = (int)k - (ea-sa+1) +sb -1;
//        		}
//        		if(b>=a && b>=aa) {
//        			ea = (int) Math.ceil((ea+k)/2);
//        			eb = (int)k - (ea-sa+1) +sb -1;
//        		}
//        	}
//        	return median;
//    }
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int total = m+n;
		
		if(total==0)
			return -1;
		if(total==1) {
			return m==0?nums2[0]:nums1[0];
		}
		if(total==2) {
			if(m==n) {
				return ((double)(nums1[0]+nums2[0]))/2;
			} else if(m>n) {
				return ((double)nums1[0]+nums1[1])/2;
			} else {
				return ((double)nums2[0]+nums2[1])/2;
			}
		}
		if(m==0) {
			if(total%2==0) {
				return ((double)nums2[n/2]+nums2[n/2-1])/2;
			} else {
				return nums2[n/2];
			}
		} else if(n==0) {
			if(total%2==0) {
				return ((double)nums1[m/2]+nums1[m/2-1])/2;
			} else {
				return nums1[m/2];
			}
		} else {
			int ea,eb,sa=0,sb=0; 
			double ml;
			if(total%2==0) {
				ml = total/2;
				if(ml%2==0) {
					ea = (int) (ml/2-1);
					eb = (int) (ml/2-1);
				} else {
					ea = (int) Math.floor(ml/2);
					eb = ea-1;
				}
				int a,aa,b,bb,seclastEl,lastEl;
				if(m>n) {
					a = nums1[ea];
					aa = nums1[ea+1];
					b = nums2[eb];
					if(eb==n-1) {
						if(b>a && b>=aa) {
							seclastEl = aa;
							lastEl = ea+2<=m-1? Math.min(nums1[ea+2], b): b;
						} else if(b<=a && b<aa) {
							seclastEl = a;
							lastEl = aa;
						} else {
							seclastEl = b;
							lastEl = aa;
						}
					} else {
						bb = nums2[eb+1];
					}
				} else if(n>m) {
					a = nums2[ea];
					aa = nums2[ea+1];
					b = nums1[eb];
				} else {
					a = nums1[ea];
					aa = nums1[ea+1];
					b = nums2[eb];
					bb = nums2[eb+1];
				}
			} else {
				
			}
		}
		return 0;
	}

}
