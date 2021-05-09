package datastructures;

import java.util.ArrayList;
import java.util.List;

public class MinPositive {
	public int firstMissingPositive(int[] nums) {
		int l = nums.length;
		if (l == 0)
			return 1;
		int n1 = 0;
		for (int i = 0; i < l; i++) {
			if (nums[i] == l + 1) {
				if (n1 != 0) {
					nums[i] = 0;
					continue;
				}
				n1 = l + 1;
				nums[i] = 0;
				continue;
			} else if (nums[i] <= 0 || nums[i] > l + 1) {
				nums[i] = 0;
				continue;
			} else if (nums[i] == i + 1) {
				continue;
			} else if (nums[i] != i + 1) {
				if (nums[nums[i] - 1] == nums[i]) {
					nums[i] = 0;
					continue;
				}
				swap(nums[i] - 1, i, nums);
				i = i - 1;
			}
		}

		for (int i = 0; i < l; i++) {
			if (nums[i] == 0)
				return i + 1;
		}
		return n1 == 0 ? l + 1 : n1;
	}

	public void swap(int i, int j, int[] nums) {
		int k = nums[i];
		nums[i] = nums[j];
		nums[j] = k;
	}
	
	public static void main(String[] args) {
		List<Object> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		l1 = l2;
	}
}