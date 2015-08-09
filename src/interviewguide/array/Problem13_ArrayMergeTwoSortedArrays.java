package interviewguide.array;
import java.util.Arrays;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 1:59 PM
 * 
 * 给定含有n个元素的有序（非降序）整型数组a和含有m个元素的有序（非降序）整型数组b。合并两个数组中的元素到整型数组c，要求去除重复元素并保持c有序（非降序）
 * a = 1, 2, 4, 8
 * b = 1, 3, 5, 8
 * c = 1, 2, 3, 4, 5, 8
 */
public class Problem13_ArrayMergeTwoSortedArrays {
	
	/*
	 * 利用数组有序特性，设置指针i，j分别指向数组a，b头部。比较是a[i], b[j]
	 *	a[i] > b[j] 则c[k] = b[j] 向后移动j
	 *	a[i] == b[k] 则 c[k] = a[i] 向后移动i，j
	 *	a[i] < b[j] 则c[k] = a[i] 向后移动i
	 *	最后将数组a或数组b中剩余的元素填入数组c即可
	 */
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                c[k++] = b[j++];
            } else if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = a[i++];
                j++;
            }
        }
        // if array a and array b are not the same length
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return Arrays.copyOfRange(c, 0, k);
    }
    
    public static void main(String[] args){
    	int[] a = {1,2,4,8};
    	int[] b = {1,3,5,8};
    	System.out.println(Arrays.toString(merge(a,b)));
    }
}
