package datastructures;

public class KConcatenationMaxSum {
	
public int kConcatenationMaxSum(int[] arr, int k) {
        
        /*
        If k = 1, the problem is not hard to solve in O(N) time O(1) space with Kadane Algorithm
       
        Considering the cases for k > 1:
        
        1) If the sum of arr < 0:
        1.1) If all the elements are negative, return 0;
        1.2) Kadane algorithm result for k=1
        1.3) max(max_prefix_sum, 0) + max(max_suffix_sum, 0)
        
        2) If the sum of arr >= 0:
        2.1) And the first and last elem > 0, the result is sum(arr) * k
        2.2) But eitehr the first or last elem is negative, 
        thus we have to exclude those margin elements, e.g. [-1,4,-2] k=3, 
        we should remove -1 from the begininng and -2 from the end of [-1,4,-2,-1,4,-2,-1,4,-2]. 
        So it is (k-2) * sum(arr) + max_prefix_sum + max_suffix_sum
        */
        
        int mod = (int) 1e9 + 7;
        
        int n = arr.length;
		long maxsub = arr[0], cursub = arr[0]; // subarray sum
        long maxpre = arr[0], curpre = arr[0]; // prefix sum
        long maxsuf = arr[n-1], cursuf = arr[n-1]; // suffix sum
        
        for (int i = 1; i < n; i++) {
            if (cursub > 0) cursub = arr[i] + cursub;
            else cursub = arr[i]; 
            maxsub = Math.max(cursub, maxsub); // Kadane algorithm with O(1) space
			curpre += arr[i];
            maxpre = Math.max(maxpre, curpre);
        }
        
        for (int i = n-2; i >= 0; i--) {
            cursuf += arr[i];
            maxsuf = Math.max(maxsuf, cursuf);
        }
        
        if (k == 1) return (int) (maxsub % mod);
        else if (maxsub < 0) return 0;  // all elements are negative
        
        else {
            long sums = curpre;
            long res1 = sums * k;
            long res2 = Math.max(0, sums * (k-2)) + Math.max(0, maxpre) + Math.max(0, maxsuf); // combine case 1.3) and 2.2)
            long res3 = maxsub;
            
            return (int) (Math.max(res1, Math.max(res2, res3)) % mod);
        } 
    }
}
