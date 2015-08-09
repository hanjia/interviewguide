package interviewguide.array;
/**
 * 给定一个有序整数序列（非递减序），可能包含负数，找出其中绝对值最小的元素，比如给定序列`-5, -3, -1, 2, 8` 则返回1。
 * @author hajia
 *
 */
public class Problem16_ArrayMinAbs {
	/*
	 * 解法：有序数组查找首先考虑二分搜索:如果给定数组中均为负数，则绝对值最小的是最后一个元素;
	 * 如果给定数组中均为正数，则绝对值最小的是第一个元素; 如果既有正数又有负数，则绝对值最小的元素一定在正负数连接处。
	 */
	public static int findMinAbsElement(int[] a) {
        int n = a.length;
        if (n == 1) {
            return a[0];
        }
        if (isSameSign(a[0], a[n - 1])) {
            return a[0] > 0 ? a[0] : a[n - 1];
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (left + 1 == right) {
                return Math.min(Math.abs(a[left]), Math.abs(a[right]));
            }
            int m = left + ((right - left) >> 1);
            if (isSameSign(a[left], a[m])) {
                left = m;
                continue;
            }
            if (isSameSign(a[m], a[right])) {
                right = m;
                continue;
            }
        }
        return -1;
    }

    public static boolean isSameSign(int a, int b) {
        return (a > 0 && b > 0) || (a < 0 && b < 0);
    }
    
    public static void main(String[] args){
    	int[] a = {-5, -3, -1, 2, 8};
    	System.out.println(findMinAbsElement(a));
    }
}
