package datastructures;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
    	Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ns = sc.nextInt();// Reading input from STDIN
        int n = ns;
        int[] narr = new int[n];
        for(int i=0;i<n;i++)
        {
        	//narr[i] = Integer.parseInt(br.read());
        	narr[i] = sc.nextInt();
        }
        
        
        int ms = sc.nextInt();// Reading input from STDIN
        int m = ms;
        int[] marr = new int[m];
        for(int i=0;i<m;i++)
        {
        	//marr[i] = Integer.parseInt(br.read());
        	marr[i] = sc.nextInt();
        }
        Set<Integer> s= null;
        if(n>m)
        {
        	s =getMissingNum(marr, narr);
        }
        if(m>n)
        {
        	s =getMissingNum(narr, marr);
        }
        else
        {
        	s =getMissingNum(narr, marr);
        }
        Iterator<Integer> i = s.iterator();
        while(i.hasNext())
        {
        	System.out.println(i.next()+" ");
        }
    }
    
    public static Set<Integer> getMissingNum(int[] small,int[] big)
    {
    	int n = small.length;
    	int m = big.length;
    	Map<Integer,Integer> mbig = new HashMap<Integer,Integer>();
    	Map<Integer,Integer> msmall = new HashMap<Integer,Integer>();
    	Set<Integer> set = new HashSet<>();
    	int num;
    	for(int i=0;i<m;i++)
    	{
    		num = big[i];
    		if(mbig.containsKey(num)){
    			mbig.put(num, mbig.get(num)+1);
    		}
    		else
    		{
    			mbig.put(num, 1);
    		}
    	}
    	
    	for(int i=0;i<n;i++)
    	{
    		num = small[i];

    		if(msmall.containsKey(num)){
    			msmall.put(num, msmall.get(num)+1);
    		}
    		else
    		{
    			msmall.put(num, 1);
    		}
    	}
    	
    	for(Integer k:mbig.keySet())
    	{
    		if((!msmall.containsKey(k)) || (!msmall.get(k).equals(mbig.get(k))))
    		{
    			set.add(k);
    		}
    	}
    	return set;
    }
}
