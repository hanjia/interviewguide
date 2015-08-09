package interviewguide.array;
/**
 * Author: haozhou
 * Date: 8/11/12
 * Time: 11:54 AM
 * 
 * 给定一个含有n个元素的整型数组a，求a中所有元素的和。要求使用递归实现。
 */
public class Problem1_ArraySum {
    public static int sum(int[] a, int n) {
        return (n == 0) ? 0 : sum(a, n - 1) + a[n - 1];
    }
    
    public static void main(String[] args){
    	int[] a = {1,2,3,4,5,6,7,8,9,10};
    	int n = 10;
    	System.out.println(sum(a,n));
    }
}
