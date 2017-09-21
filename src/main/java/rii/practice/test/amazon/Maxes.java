package rii.practice.test.amazon;

import java.util.Arrays;

public class Maxes {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 3, 3, 4, 5 };
		int[] maxes = { 1, 2, 3 };
		int[] res = counts(nums, maxes);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	static int[] counts(int[] nums, int[] maxes) {
		int[] res = new int[maxes.length];
		Arrays.sort(nums);
		for (int i = 0; i < maxes.length; i++) {
			res[i] = find(nums, maxes[i]);
		}
		return res;
	}

	// use binary search of key in array to find the position of any max
	private static int find(int[] nums, int key) {
		int low = 0;
		int high = nums.length - 1;
		boolean found = false;
		int res = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == key && (mid == nums.length - 1 || nums[mid + 1] != key)) {
				res = mid;
				found = true;
				break;
			}

			if (nums[mid] <= key)
				low = mid + 1;
			else
				high = mid - 1;
		}
		// if element present in array - add itself to result and plus num of elements before
		if (found) {
			res++;
		} else {
			// if element not found, the position to be inserted is the number of elements less then given key
			res = high + 1;
		}
		return res;
	}

}
