/* 
 Q1: Merge two arrays by satisfying given constraints
Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly n vacant cells,
 merge elements of Y[] in their correct position in array X[], i.e., merge (X, Y) by keeping the sorted order.

For example,

Input: X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0 }
Y[] = { 1, 8, 9, 10, 15 } The vacant cells in X[] is represented by 0
Output: X[] = { 1, 2, 3, 5, 6, 8, 9, 10, 15 }
 */
import java.util.*;

public class Example1 {
    static int[] X;
    static int[] Y;

    public static void main(String[] args)
    {
        takeArrayInputs();
        X = mergeElements(X, Y);
        System.out.println(Arrays.toString(X));
    }

    public static void takeArrayInputs() {
        String input = "";
        String[] arr;
        Scanner sc = new Scanner(System.in);

        //Ask array X[] size
        System.out.println("Enter first array size:");
        int m = sc.nextInt();
        sc.nextLine();

        X = new int[m];
        //Ask for X[] array inputs
        System.out.println("Enter X[] Array inputs in one line separated by spaces:");
        input = sc.nextLine();
        arr = input.split(" ");

        for(int i=0; i< arr.length; i++) {
            X[i] = Integer.parseInt(arr[i]);
        }

        //Ask array Y[] size
        System.out.println("Enter second array size:");
        int n = sc.nextInt();
        sc.nextLine();
        Y = new int[n];
        //Ask for Y[] array inputs
        System.out.println("Enter Y[] Array inputs in one line separated by spaces:");
        input = sc.nextLine();
        arr = input.split(" ");

        for(int i=0; i<arr.length; i++) {
            Y[i] = Integer.parseInt(arr[i]);
        }

        //Print both Arrays:
        //System.out.println(Arrays.toString(X));
        //System.out.println(Arrays.toString(Y));

    }

    public static int[] mergeElements(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;

        // Move non-zero elements of X[] to the beginning
        int j = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (X[i] != 0) {
                X[j--] = X[i];
            }
        }

        // Merge Y[] into X[]
        int k = 0;
        int i = j + 1;
        j = 0;
        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                X[k++] = X[i++];
            } else {
                X[k++] = Y[j++];
            }
        }

        // Copy remaining elements of Y[] if any
        while (j < n) {
            X[k++] = Y[j++];
        }
        return X;
    }
}