package rii.practice.sorting;

public class BiggerSum {
	public static int sum(int[] arr) {
		int first = -1, second = 0, maxSum = 0;
		int nFirst = -1, nSecond = 0;
		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			if ((curr > first) || ((curr == first) && (Math.abs(nFirst - nSecond) < Math.abs(i - nSecond)))) {
				first = curr;
				nFirst = i;
			}
			else if (curr > second || ((curr == second) && (Math.abs(nFirst - nSecond) < Math.abs(nFirst - i)))) {
				second = curr;
				nSecond = i;
			}

			if (i > 0) {
				int currSum = first + second + (Math.abs(nFirst - nSecond));
				if (currSum > maxSum)
					maxSum = currSum;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, 3, 5, 1, 2, 3, 3};
		int res = sum(arr);
		System.out.println(res);
	}
}
