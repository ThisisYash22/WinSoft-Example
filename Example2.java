/*Q2:Find maximum sum path involving elements of given arrays
Given two sorted arrays of integers, find a maximum sum path involving elements of both arrays whose sum is maximum.
We can start from either array, but we can switch between arrays only through its common elements.

For example,

Input: X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 }
Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 }
The maximum sum path is: 1 —> 2 —> 3 —> 6 —> 7 —> 9 —> 10 —> 12 —> 15 —> 16 —> 18 —> 100
The maximum sum is 199*/

import java.util.Arrays;
import java.util.Scanner;

public class Example2 {
    static int X[];
    static int Y[];
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
        System.out.println(Arrays.toString(X));
        System.out.println(Arrays.toString(Y));

    }
    public static int maxSumPath(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        int i = 0, j = 0;
        int sumX = 0, sumY = 0, result = 0;

        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                sumX += X[i++];
            } else if (X[i] > Y[j]) {
                sumY += Y[j++];
            } else {
                // Common element found, take maximum sum till now and update result
                result += Math.max(sumX, sumY) + X[i];
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements of X[]
        while (i < m) {
            sumX += X[i++];
        }

        // Add remaining elements of Y[]
        while (j < n) {
            sumY += Y[j++];
        }

        // Add the maximum of remaining sums
        result += Math.max(sumX, sumY);

        return result;
    }

    public static void main(String[] args) {
        takeArrayInputs();

        int maxSum = maxSumPath(X, Y);

        System.out.println("Maximum sum path is: " + maxSum);
    }
}
