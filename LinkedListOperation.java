/*Name: Vaishakhi Kulkarni
 * Net Id: vpk140230
 */

//package DAY1;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.ListIterator;

public class LinkedListOperation {
	
	private static int phase = 0;
    private static long startTime, endTime, elapsedTime;
    
	//Function for intersection
	public static <T extends Comparable<? super T>> LinkedList<T> Intersection(
			LinkedList<T> L1, LinkedList<T> L2) {
		LinkedList<T> I = new LinkedList<T>();
		ListIterator<T> itr1 = L1.listIterator();
		ListIterator<T> itr2 = L2.listIterator();
		T X1 = null, X2 = null;

		X1 = next(itr1);
		X2 = next(itr2);

		while (X1 != null && X2 != null) {
			int cmp = X1.compareTo(X2);
			if (cmp < 0) {
				X1 = next(itr1);
			} else if (cmp > 0) {
				X2 = next(itr2);
			} else if (cmp == 0) {
				I.add(X1);

				X1 = next(itr1);
				X2 = next(itr2);
			}
		}
		return I;
	}
	//Function to override ListIterator hasNext function
	public static <T extends Comparable<? super T>> T next(ListIterator<T> itr) {
		T temp = null;
		if (itr.hasNext())
			temp = itr.next();
		return temp;
	}
	//Function for Union operation
	public static <T extends Comparable<? super T>> LinkedList<T> Union(
			LinkedList<T> L1, LinkedList<T> L2) {
		LinkedList<T> U = new LinkedList<T>();
		ListIterator<T> itr3 = L1.listIterator();
		ListIterator<T> itr4 = L2.listIterator();

		T X3 = null, X4 = null;

		X3 = next(itr3);
		X4 = next(itr4);

		while (X3 != null && X4 != null) {
			int cmp = X3.compareTo(X4);
			if (cmp < 0) {
				U.add(X3);
				X3 = next(itr3);
			} else if (cmp > 0) {
				U.add(X4);
				X4 = next(itr4);
			} else if (cmp == 0) {
				U.add(X3);
				X3 = next(itr3);
				X4 = next(itr4);
			}
			//When list L2 is empty but list L1 is not empty
			while (X3 != null && X4 == null) {
				U.add(X3);
				X3 = next(itr3);
			}
			//When list L1 is empty but list L2 is not empty
			while (X4 != null && X3 == null) {
				U.add(X4);
				X4 = next(itr4);
			}

		}
		return U;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> L1 = new LinkedList<Integer>();
		LinkedList<Integer> L2 = new LinkedList<Integer>();

		//Enter the elements
		Scanner in = new Scanner(System.in);

		System.out.println("Enter number of elements in list L1");
		int n = in.nextInt();

		System.out.println("Enter number of elements in list L2");
		int m = in.nextInt();

		System.out.println("Enter L1 elements");
		for (int i = 0; i < n; i++) {
			L1.add(in.nextInt());
		}

		System.out.println("Enter L2 elements");
		for (int i = 0; i < m; i++) {
			L2.add(in.nextInt());
		}

		in.close();

		timer();
		LinkedList<Integer> L = Intersection(L1, L2);

		System.out.println("INTERSECTION" + L);

		LinkedList<Integer> U = Union(L1, L2);

		System.out.println("UNION" + U);
		timer();
	}

	public static void timer()
    {
        if(phase == 0) {
	    startTime = System.currentTimeMillis();
	    phase = 1;
	    } else {
	    endTime = System.currentTimeMillis();
            elapsedTime = endTime-startTime;
            System.out.println("Time: " + elapsedTime + " msec.");
            phase = 0;
        }
    }
}

