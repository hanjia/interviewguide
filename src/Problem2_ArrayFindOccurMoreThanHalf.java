import java.util.Arrays;

/**
 * Author: haozhou
 * Date: 8/11/12
 * Time: 12:13 PM
 * 
 * 给定一个n个整型元素的数组a，其中有一个元素出现次数超过n / 2，求这个元素。
 */
public class Problem2_ArrayFindOccurMoreThanHalf {
	
	
	/**
	 * 设置一个当前值和当前值出现次数的计数器，初始化为第一个元素，计数器值为1.然后从第二个元素开始遍历数组。
	 * 如果第i个元素值等于当前值则计数器加1，不等则计数器减1，如果计数器值小于1则更新当前值并重置计数器值为1。
	 * 遍历完成后的当前值即为出现超过一半的元素。
	 *
	 */
    public static int find(int[] a) {
        int current = a[0];
        int count = 1;
        for (int i = 1; i < a.length; ++i) {
            if (a[i] == current) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    current = a[i];
                    count = 1;
                }
            }

        }
        return current;
    }

    /**
     * 排序，然后找中间的元素。如果该元素出现超过次数超过一半则一定位于排序后的数组中间。
     */
    public static int findByAnAlternativeWay(int[] a){
    	Arrays.sort(a);
    	return a[a.length/2];
    }
    
    public static void main(String[] args) {
        System.out.println(find(new int[]{3, 2, 3, 2, 3, 1, 5, 4, 4, 3, 3, 3, 3}));
        System.out.println(findByAnAlternativeWay(new int[]{3, 2, 3, 2, 3, 1, 5, 4, 4, 3, 3, 3, 3}));
    }
}
