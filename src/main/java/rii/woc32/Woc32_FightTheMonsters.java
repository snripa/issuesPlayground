package rii.woc32;

import java.util.Arrays;
import java.util.Scanner;

public class Woc32_FightTheMonsters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int hit = in.nextInt();
		int t = in.nextInt();
		int[] h = new int[n];
		for (int h_i = 0; h_i < n; h_i++) {
			h[h_i] = in.nextInt();
		}
		int result = getMaxMonsters(n, hit, t, h);
		System.out.println(result);
	}

	static int getMaxMonsters(int n, int hit, int t, int[] h) {

		int monstersKilled = 0;
		Arrays.sort(h);
		for (int i = 0; i < h.length; i++) {
			int hitsCurr = Math.floorDiv(h[i], hit);
			if (h[i] % hit > 0)
				hitsCurr++;
			if (t >= hitsCurr) {
				t -= hitsCurr;
				monstersKilled++;
			} else
				break;
		}
		return monstersKilled;
	}
}
