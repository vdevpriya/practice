package datastructures;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

class TestClass2 {
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
    	int v= sc.nextInt();
    	List<Vendor> vlist = new LinkedList<Vendor>();
    	Collections.sort(vlist,new Vendor());
    	for(int i=0;i<v;i++)
    	{
    		int s = sc.nextInt();
    		int e = sc.nextInt();
    		int p = sc.nextInt();
    		Vendor ve = new Vendor(s,e,p);
    		vlist.add(ve);
    	}
    	List<Vendor> vlist2 = new LinkedList<Vendor>();
    	Vendor curr = vlist.get(0);
    	for(int i=0;i<vlist.size()-1;i++)
    	{
    		Vendor next = vlist.get(i+1);
    		if(next.st==curr.st && next.p<curr.p)
    		{
    			vlist2.add((Vendor) next.clone());
    		}
    		if(next.st>curr.st && next.st<=curr.et && next.p<curr.p)
    		{
    			vlist2.add(new Vendor(curr.st,next.st-1,curr.p));
    		}
    	}

    }
    
   
}