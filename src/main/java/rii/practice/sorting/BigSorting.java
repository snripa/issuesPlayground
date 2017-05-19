package rii.practice.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BigSorting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] unsorted = new String[n];
		for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
			unsorted[unsorted_i] = in.next();
		}
		Arrays.sort(unsorted, (o1, o2) -> {
			Integer len1 = o1.length();
			Integer len2 = o2.length();
			if (len1.equals(len2)) {
				return o1.compareTo(o2);
			}
			return len1.compareTo(len2);
		});

		for (String s : unsorted) {
			System.out.println(s);
		}
	}

}