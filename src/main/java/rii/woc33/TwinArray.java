package rii.woc33;

import apple.laf.JRSUIUtils;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.*;
/**
 * Created by sergeyr on 6/13/17.
 */
public class TwinArray {
    static int twinArrays(int[] ar1, int[] ar2){
        int min1_pos = ar1.length -1;
        int min2_pos = ar2.length -1;

        for (int i = 0; i < ar1.length; i++){
            if(ar1[i] < ar1[min1_pos]) min1_pos = i;
            if(ar2[i] < ar2[min2_pos]) min2_pos = i;
        }
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        if(min1_pos == min2_pos){
            if(ar1[0] +  ar2[1] > ar1[1] + ar2[0]) return ar1[1] + ar2[0];
            else return ar1[0] +  ar2[1];
        }
        return ar1[0] + ar2[0];
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] ar1 = new int[n];
//        for(int ar1_i = 0; ar1_i < n; ar1_i++){
//            ar1[ar1_i] = in.nextInt();
//        }
//        int[] ar2 = new int[n];
//        for(int ar2_i = 0; ar2_i < n; ar2_i++){
//            ar2[ar2_i] = in.nextInt();
//        }
//        int result = twinArrays(ar1, ar2);
//        System.out.println(result);
//    }

    public static void main(String[] args) {
        int[] arr1 = new int[10_0000];
        int[] arr2 = new int[10_0000];
        Arrays.fill(arr1, 1);
        Arrays.fill(arr1, 3);

        long s = System.currentTimeMillis();
        System.out.println(twinArrays(arr1, arr2));
        System.out.println("took:" + (System.currentTimeMillis() - s));
    }
}
