import java.util.Random;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 3:42 PM
 */
public class QuickSort {
    Random random = new Random();

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int left, int right) {
        if (left < right) {
            int pivotIndex = left + random.nextInt(right - left + 1);
            int newPivotIndex = partition(a, left, right, pivotIndex);
            sort(a, left, newPivotIndex - 1);
            sort(a, newPivotIndex + 1, right);
        }
    }

    private int partition(int[] a, int left, int right, int pivotIndex) {
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

    private void swap(int[] a, int src, int target) {
        int temp = a[src];
        a[src] = a[target];
        a[target] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, -56, 12, 74, 21, 23, -12, 5, -46, 0};
        new QuickSort().sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
