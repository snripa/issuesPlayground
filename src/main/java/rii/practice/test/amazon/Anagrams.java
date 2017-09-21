package rii.practice.test.amazon;

import java.util.Arrays;

public class Anagrams {

	public static void main(String[] args) {

		String[] a = { "tooo" };
		String[] b = { "toe" };
		int[] res = getMinimumDifference(a, b);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}

	}

	static int[] getMinimumDifference(String[] a, String[] b) {
		int letter_a_ascii = 97;
		int[] res = new int[a.length];
		int[][] matches = new int[2][];
		matches[0] = new int[26];
		matches[1] = new int[26];

		Arrays.fill(matches[0], 0);
		Arrays.fill(matches[1], 0);
		for (int i = 0; i < a.length; i++) {
			char[] str1 = a[i].toCharArray();
			char[] str2 = b[i].toCharArray();

			// here we'll filter cases of different str length-s
			if (str1.length != str2.length) {
				res[i] = -1;
				continue;
			}

			// lets count the num of matched letters instead, and then just count res=length-matched
			// for that we'll traverese both s1 and s2 and fill the table with counted letters occurrences
			Arrays.fill(matches[0], 0);
			Arrays.fill(matches[1], 0);

			// get letters matrix of both words
			for (int j = 0; j < str1.length; j++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (str1[j] == c)
						matches[0][(int) c - letter_a_ascii]++;
					if (str2[j] == c)
						matches[1][(int) c - letter_a_ascii]++;
				}
			}
			int numOfMatches = 0;
			// find the num of matches and calc result
			for (int k = 0; k < 26; k++) {
				// if any word didn't contain matches for single sign - skip
				int letterHit1 = matches[0][k];
				int letterHit2 = matches[1][k];
				if (letterHit1 == 0 || letterHit2 == 0)
					continue;
				numOfMatches += Math.min(letterHit1, letterHit2);
			}

			int minDiff = str1.length - numOfMatches;
			res[i] = minDiff;
		}

		return res;
	}
}
