package interviewguide.array;
/**
 * 
 * @author hajia
 *给定一个整型数组a，求出最大连续子段的乘积，比如`1， 2， -8， 12， 7`则输出`84`
 */
public class Problem11_ArrayFindMaxProduct {
    /*
     * 解法：和最大子段和类似，注意正负符号。
     */
	public static int findMaxProduct(int[] a) {
        int max = 1;
        int min = 1;
        int result = 1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                max *= a[i];
                min = Math.min(min * a[i], 1);
            } else if (a[i] == 0) {
                max = 1;
                min = 1;
            } else {
                int temp = max;
                max = Math.max(min * a[i], 1);
                min = temp * a[i];
            }
            result = Math.max(result, max);
        }
        return result;
    }
    
    public static void main(String[] args){
    	int[] a = {1, 2, -8, 12, 7};
    	System.out.println(findMaxProduct(a));
    }
}
