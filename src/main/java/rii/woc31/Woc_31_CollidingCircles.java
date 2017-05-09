package rii.woc31;

import java.util.Scanner;

public class Woc_31_CollidingCircles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] r = new int[n];
        for (int r_i = 0; r_i < n; r_i++) {
            r[r_i] = in.nextInt();
        }
        // Write Your Code Here
        System.out.println(getResult(r, k));
    }

    public static float getResult(int[] elements, int k) {
        long sumProd = 0;
        long sumSquares = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                sumProd += elements[i] * elements[j];
            }
            sumSquares += Math.pow(elements[i], 2);
        }
        sumSquares += Math.pow(elements[elements.length - 1], 2);
        int k_prod = 2;
        int k_squares = 3;
        double result = ((k_prod * sumProd + k_squares * sumSquares) * Math.PI) / k_squares;
        return (float) result;
    }
}
