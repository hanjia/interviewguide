package interviewguide.array;

import java.util.Arrays;

/**
 * 给定三个含有n个元素的整型数组a,b和c，求他们最小的共同元素
 * @author hanjia
 *
 */
public class Problem5_ArrayFindCommonElementAmongThree {

	/*
	 * 解法： 如果三个数组都无序，可以对数组a，b排序，然后遍历数组c，对于c中的每一个元素在数组a，b中做二分搜索。
	 */
	public static void findMinCommonElement(int[] a, int[] b, int[] c){
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		for(int i = 0; i < c.length; i++){
			if(binarySearch(a, c[i]) && binarySearch(b, c[i]))
				System.out.println(c[i]);
		}
	}
	
	public static boolean binarySearch(int[] array, int data){
		if(array.length < 1)
			return false;
		int low = 0;
		int high = array.length - 1;
		while (low <= high){
			int mid = low + (high - low) / 2;
			if(array[mid] == data) return true;
			else if(array[mid] < data) low = mid + 1;
			else high = mid - 1;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5};
		int[] b = {1,3,5,7,9};
		int[] c = {3,7,11,13,17};
		
		findMinCommonElement(a,b,c);
	}
}
