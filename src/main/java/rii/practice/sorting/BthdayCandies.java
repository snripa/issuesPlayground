package rii.practice.sorting;

import java.util.Scanner;

/**
 * Created by sergeyr on 22.04.17.
 */
public class BthdayCandies {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int height[] = new int[n];
		for (int height_i = 0; height_i < n; height_i++) {
			height[height_i] = in.nextInt();
		}

		int max = -1;
		int count = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
				count = 1;
			} else if (height[i] == max) {
				count++;
			}
		}
		System.out.println(count);
	}
}