package rii.practice.test;

import java.io.IOException;
import java.util.Arrays;

public class TaskOne {

	public static void main(String[] args) throws IOException {
		int[] lengths = new int[] { 10000 };
		int cutCost = 100;
		int price = 1;
		int res = maxProfit(cutCost, price, lengths);
		System.out.println(res);
	}

	static int maxProfit(int cost_per_cut, int metal_price, int[] lengths) {
		Arrays.sort(lengths);
		int maxLen = lengths[lengths.length - 1];
		int maxProfit = Integer.MIN_VALUE;
		for (int len = 1; len <= maxLen; len++) {
			int currProfit = 0;
			for (int i = 0; i < lengths.length; i++) {
				int rodLen = lengths[i];
				int rodsToSell = rodLen/len;
				// calc cuts;
				int cuts = 0;
				if (rodsToSell == 0)
					cuts = 0;
				else if (rodLen % len == 0)
					cuts = rodsToSell - 1;
				else
					cuts = rodsToSell;
				currProfit += (rodsToSell * len * metal_price - cuts * cost_per_cut);
            }
            if(currProfit > maxProfit) maxProfit = currProfit;
		}
		return maxProfit;
	}
}
