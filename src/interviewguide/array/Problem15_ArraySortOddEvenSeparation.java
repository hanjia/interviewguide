package interviewguide.array;
import java.util.Arrays;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 2:13 PM
 * 
 * 给定含有n个元素的整型数组a，将奇数都归到数组的左边，偶数归到数组的右边，不考虑元素的相对顺序。要求时间复杂度为O(n)
 */
public class Problem15_ArraySortOddEvenSeparation {

    public static boolean isOdd(int a) {
        return (a & 1) == 1;
    }

    /*
     * 解法：类似于QuickSort的partition，设置left，right两个指针分别指向数组的头尾向中间移动。
     */
    public static int[] oddLeftEvenRight(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            while (left < right && isOdd(a[left])) {
                left++;
            }
            while (left < right && !isOdd(a[right])) {
                right--;
            }
            if (left != right) { //SWAP
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        return a;
    }
    
    public static void main(String[] args){
    	int[] a = {1,2,3,4,5,6,7,8,9};
    	System.out.println(Arrays.toString(oddLeftEvenRight(a)));
    }
}
