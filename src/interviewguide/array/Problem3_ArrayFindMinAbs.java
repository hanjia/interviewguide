package interviewguide.array;
import java.util.Arrays;

/**
 * Author: haozhou
 * Date: 8/11/12
 * Time: 12:40 PM
 * 
 * 给定一个含有n个元素的整型数组，找出数组中的两个元素x和y使得|x - y|最小
 */
public class Problem3_ArrayFindMinAbs {
    /**
     * 对数组排序，然后遍历一遍求前后两元素差值即可求出
     */
    public static int findMinAbs(int[] a, int n) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i] - a[i - 1]) < min) {
                min = Math.abs(a[i] - a[i - 1]);
            }
        }
        return min;
    }
    
    public static void main(String[] args){
    	int[] a = {3,9,7,4,6,12,19,1};
    	int n = 8;
    	System.out.println(findMinAbs(a,n));
    }
}
