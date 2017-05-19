package rii.woc32;

import java.util.Arrays;
import java.util.Scanner;

public class Woc32_Duplication {

	private static boolean[] lookup;

	public static void main(String[] args) {
		fillLookup();
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int x = in.nextInt();
			String result = duplication(x);
			System.out.println(result);
		}
	}

	private static void fillLookup() {
		lookup = new boolean[1024];
		Arrays.fill(lookup, false);
		for (int i = 1; i < 1000; i *= 2) {
			for (int j = 0; j < i; j++) {
				lookup[i + j] = !lookup[j];
			}
		}
	}

	static String duplication(int x) {
		return lookup[x] ? "1" : "0";
	}
}
