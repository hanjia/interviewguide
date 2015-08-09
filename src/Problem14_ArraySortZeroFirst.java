import java.util.Arrays;

/**
 * 
 * 给定含有n个元素的整型数组a，其中包括0元素和非0元素，对数组进行排序，要求： 
 * 1. 排序后所有0元素在前，所有非零元素在后，且非零元素排序前后相对位置不变 
 * 2. 不能使用额外存储空间 
 * 例如： 输入 0, 3, 0, 2, 1, 0, 0 输出 0, 0, 0, 0, 3, 2, 1
 * @author hajia
 *
 */
public class Problem14_ArraySortZeroFirst {

	/*
	 * 解法：从后向前遍历整个数组，遇到某个位置i上的元素是非0元素时，如果a[k]为0，则将a[i]赋值给a[k]，a[k]赋值为0。
	 * 实际上i是非0元素的下标，而k是0元素的下标
	 */
    public static int[] zeroFirst(int[] a) {
        for (int i = a.length - 1, k = a.length - 1; i >= 0; i--) {
            if (a[i] != 0) {
                if (a[k] == 0) {
                    a[k] = a[i];
                    a[i] = 0;
                }
                k--;
            }
        }
        return a;
    }
    
    public static void main(String[] args){
    	int[] a = {1,0,0,2,0,3,0,0,4};
    	System.out.println(Arrays.toString(zeroFirst(a)));
    }
}
