package interviewguide.array;
/**
 * Author: haozhou
 * Date: 8/11/12
 * Time: 1:27 PM
 * 
 * 给定一个整型数组a，求出最大连续子段之和，如果和为负数，则按0计算，比如`1， 2， -5， 6， 8`则输出`14`
 */
public class Problem10_ArrayFindMaxSum {
    public static int findMaxSum(int[] a) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum < 0) {
                sum = 0;
            }
            max = (sum > max) ? sum : max;
        }
        return max;
    }

    public static void main(String[] args){
    	int[] a = {1, 2, -5, 6, 8};
    	System.out.println(findMaxSum(a));
    }
}
