package interviewguide.array;
import java.util.Arrays;

/**
 * 给定一无序整型数组a，求数组a中是否有任意3个元素之和等于给定数s
 * @author hajia
 *
 */
public class Problem9_ArrayFindFixedSumByThreeElements {

	/*
	 * 对数组排序，然后设置3个指针i，j，k。i指向头部，j指向i+1个元素，k指向尾部。
	 * 遍历数组，求a[i],a[j],a[k]之和，如果等于s则输出，反之根据比较值决定i向后移动或k向前移动，直到i，k交叉。
	 */
    public static void findThreeTupleSumEqFixedNum(int[] a, int s) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            int k = a.length - 1;
            while (j < k) {
                if (a[i] + a[j] + a[k] == s) {
                    System.out.println("Found fixed sum "+ s +" with " + a[i] + " " + a[j] + " " + a[k]);
                    return;
                } else if (a[i] + a[j] + a[k] > s) {
                    k--;
                } else {
                    j++;
                }
            }
        }
    }
    
    public static void main(String[] args){
    	int[] a = {1,2,3,4,5,6,7,8,9,10,11};
    	findThreeTupleSumEqFixedNum(a,18);
    	findThreeTupleSumEqFixedNum(a,30);

    }
}
