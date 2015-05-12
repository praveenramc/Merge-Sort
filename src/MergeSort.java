import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Praveen
 *
 */
public class MergeSort<T extends Comparable> {

	public static<T extends Comparable<? super T>> void sort(T[] arr, int p, int r) {
		mergesort(arr, 0, arr.length - 1);
	}
	
	private static <T extends Comparable<? super T>> void mergesort (T[] a, int i, int j) { 
		if(j-i < 1) return;
		int midpoint = (i + j) / 2;
		//System.out.println("M: " + midpoint);
		mergesort(a, i, midpoint);
		mergesort(a, midpoint + 1, j);
		merge(a, i, midpoint, j);
	}
	
	private static <T extends Comparable<? super T>> void  merge(T[] a, int p, int midpoint, int q) {
		Object[] tmpArray = new Object[q-p+1]; 
		int i = p;
		int j = midpoint+1;
		int k = 0;
		while (i <= midpoint && j <= q) {
		    if (a[i].compareTo(a[j])<=0) {
		    	tmpArray[k] = a[i++]; 
			} else {
				tmpArray[k] = a[j++]; 
			}
		    k++;
		}
		if (i <= midpoint && j > q) {
		    while (i <= midpoint) 
			tmpArray[k++] = a[i++];
		} else {
		    while (j <= q)
			tmpArray[k++] = a[j++];
		}
		for (k = 0; k < tmpArray.length; k++) {
		    a[k+p] = (T)(tmpArray[k]); 
		}
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Intersection of two list");
		TimerUtil t = new TimerUtil();
		MergeSort<Integer> mergesort = new MergeSort<Integer>();
        if (args.length > 0) {
            File inputFile = new File(args[0]);
            try {
				in = new Scanner(inputFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        } else {
            in = new Scanner(System.in);
        }
        
        int samples = in.nextInt();
       
        Integer[] array = new Integer[samples];
        
        for(int i = 0; i < samples; i++) {
        	array[i] = MergeSort.randInt(1, samples);
        }
     
        
        t.startTimer();
        MergeSort.sort(array, 0, array.length);
        t.endTimer();
        System.out.println("Time taken to sort using merge sort for" + samples + " numbers is " + t.getRunningTime());
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        for(int i = 0; i < samples; i++) {
        	a.add(MergeSort.randInt(1, samples));
        }
        t.startTimer();
        Collections.sort(a);
        t.endTimer();
        System.out.println("Time taken to sort using Java sort is " + t.getRunningTime());
	}

}
