import java.util.Random;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 3:10 PM
 */
public class ArrayFindElement {
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
        return a > 0 && b > 0 || a < 0 && b < 0;
    }

    static Random random = new Random();

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
}
