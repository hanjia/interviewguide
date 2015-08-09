package interviewguide.array;
import java.util.Arrays;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 1:47 PM
 * 
 * 将一个含有n个元素的数组向右循环移动k位，要求时间复杂度是O(n)，且只能使用两个额外的变量。
 * 要求时间复杂度不超过`O(n)`，空间复杂度不超过`O(1)`
 * 例如：数组`1,2,3,4,5` 循环2位后为`4,5,1,2,3`
 * 
 */
public class Problem12_ArrayRotate {
	
	/*
	 * 解法：将数组分为两部分`1,2,3 | 4,5`，
	 * 首先逆序第一部分得到`3,2,1 | 4,5`，然后逆序第二部分得到`3,2,1 | 5,4`，最后逆序整个数组可得结果`4,5,1,2,3`。
	 * 需要注意的是k可能大于n，所以实际需要移动的是`k%n`位。
	 */
    public static int[] rotate(int[] a, int k) {
        int n = a.length;
        k %= n;
        a = reverse(a, 0, n - k - 1);
        a = reverse(a, n - k, n - 1);
        a = reverse(a, 0, n - 1);
        return a;
    }
    
    public static int[] reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
        return a;
    }
    
    public static void main(String[] args){
    	int[] a = {1,2,3,4,5};
    	System.out.println(Arrays.toString(rotate(a,2)));
    }
}
