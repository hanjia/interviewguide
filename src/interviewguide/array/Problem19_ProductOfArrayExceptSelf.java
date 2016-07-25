package interviewguide.array;

import java.util.Arrays;

public class Problem19_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
	    int[] result = new int[nums.length];
	 
		result[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] = result[i + 1] * nums[i + 1];
		}
	 
		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] = result[i] * left;
			left = left * nums[i];
		}	 
	    return result;
	}
	
	public static void main(String[] args) {
		Problem19_ProductOfArrayExceptSelf product = new Problem19_ProductOfArrayExceptSelf();
		int[] nums = {1,2,3,4,5};
		int[] result = product.productExceptSelf(nums);
		System.out.println(Arrays.toString(result));
	}
}
