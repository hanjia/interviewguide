/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 2:13 PM
 */
public class ArraySort {

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

    public static boolean isOdd(int a) {
        return (a & 1) == 1;
    }

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
            if (left != right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        return a;
    }
}
