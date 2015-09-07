package interviewguide.array;
/**
 * Author: haozhou
 * Date: 8/11/12
 * Time: 12:48 PM
 * 
 * 给定两个含有n个元素的有序（非降序）整型数组a和b，求出其共同元素，比如
 * a = 0, 1, 2, 3, 4
 * b = 1, 3, 5, 7, 9
 * 输出 1, 3
 */
public class Problem4_ArrayFindCommonElements {
	
	/**
	 * 利用数组有序的性质，设置两个指针i，j分别指向数组a，b的头部。 
	 * 判断a[i], b[j]的大小，如果相等则输出共同元素并且共同向后移动。如果a[i]大则指针j向后移动，如果b[j]大则指针i向后移动
	 */
    public static void findCommon(int[] a, int[] b) {
        for (int i = 0, j = 0; i < a.length && j < b.length; ) {
            if (a[i] == b[j]) {
                System.out.println("Found common: " + a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
    }
    
    public static void findCommonAlt(int[] a, int[] b) {
    	int i = 0;
    	int j = 0;
    	while(a[i] < b[j]){
    		i++;
    	}
    	while(a[i] > b[j]){
    		j++;
    	}
    	if(a[i] == b[j])
            System.out.println("Found common: " + a[i]);    	
    }
    
    public static void main(String[] args){
    	int[] a = {0, 1, 2, 3, 4};
    	int[] b = {1, 3, 5, 7, 9};
    	findCommon(a,b);
    	findCommonAlt(a, b);
    }

}
