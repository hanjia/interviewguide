package interviewguide.array;
import java.util.Random;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 3:10 PM
 * 
 * 给定一无序整型数组a，在不排序的情况下，查找第k小的元素
 */
public class Problem17_ArrayFindKSmallestElement {
    
    public static Random random = new Random();

    /*
     * 解法：查找元素优先考虑二分搜索，因为数组无序，所以需要对二分搜索作出修改。参考QuickSort的partition过程。
     * 首选在数组中任选一个元素做参考值，将比参考值小的元素都移动到参考值的左边，比参考值大的元素都移动到右边。
     * 判断左边数组的长度若大于k，则第k小的值一定在左边，只需要在左边部分重复在这一过程。
     * 若左边数组长度小于k，则在右边数组重复这一过程，只不过查找的是k减去左边数组的长度。
     */
    public static int findKSmallestElement(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int pivotIndex = left + random.nextInt(right - left + 1);
            int idx = partition(a, left, right, pivotIndex);
            int length = idx - left +1;
            if (k < length) {
                right = idx - 1;
            } else if (k > length) {
                left = idx + 1;
                k = k - length;
            } else {
                return a[idx];
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int partition(int[] a, int left, int right, int pivotIndex) {
        int pivotValue = a[pivotIndex];
        swap(a, pivotIndex, right);
        int storedIndex = left;
        for (int i = left; i < right; i++) {
            if (a[i] < pivotValue) {
                swap(a, i, storedIndex);
                storedIndex++;
            }
        }
        swap(a, storedIndex, right);
        return storedIndex;
    }

    private static void swap(int[] a, int src, int target) {
        int temp = a[src];
        a[src] = a[target];
        a[target] = temp;
    }
    
    public static void main(String[] args){
    	int[] a = {1,3,7,4,9,6,2,0};
    	System.out.println(findKSmallestElement(a,2));
    }
}
