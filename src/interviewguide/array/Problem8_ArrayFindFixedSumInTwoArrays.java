package interviewguide.array;
/**
 * Author: haozhou
 * Date: 8/11/12
 * Time: 1:04 PM
 * 
 * 给定两个有序整型数组a和b，各有n个元素，求两个数组中满足给定和的数对，即对a中元素i和b中元素j，满足i + j = s(s已知)
 */
public class Problem8_ArrayFindFixedSumInTwoArrays {
   /*
    * 解法：利用数组有序特性，设置2个指针i，j分别指向数组a，b的头部。然后从两端向中间遍历，直到交叉。
    */
	public static void findInTwoArray(int[] a, int[] b, int s) {
        for (int i = 0, j = b.length - 1; i < a.length && j > 0; ) {
            if (a[i] + b[j] == s) {
                System.out.println("Found fixed sum with " + a[i] + " " + b[j]);
                i++;
                j--;
            } else if (a[i] + b[j] > s) {
                j--;
            } else {
                i++;
            }
        }
    }
    
    public static void main(String[] args){
    	int[] a = {1,2,3,4,5,6,7};
    	int[] b = {1,3,5,7,9,11};
    	findInTwoArray(a,b,11);
    }
    

}
