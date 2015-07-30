
/**
 * 
 * @author hajia
 *给定含有1001个元素的数组，其中存放了1-1000之内的整数，只有一个整数是重复的，请找出这个数
 */
public class Problem6_ArrayFindDuplicateElement {

	/*
	 * 求出整个数组的和，再减去1-1000的和
	 */
	public static int findADuplicateElement(int[] a){
		int sumForOneThoudsand = (1 + 1000) * 1000 / 2;
		int sum = 0;
		for(int i : a){
			sum += i;
		}		
		return sum - sumForOneThoudsand;
	}
	
	public static void main(String[] args){
		int[] a = new int[1001];
		for(int i = 0; i < 1000; i++){
			a[i] = i + 1;
		}
		a[1000] = 23;
		
		int duplicate = findADuplicateElement(a);
		System.out.println(duplicate);
	}
}
