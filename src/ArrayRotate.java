/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 1:47 PM
 */
public class ArrayRotate {
    public static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
    }

    public static void rotate(int[] a, int k) {
        int n = a.length;
        k %= n;
        reverse(a, 0, n - k - 1);
        reverse(a, n - k, n - 1);
        reverse(a, 0, n - 1);
    }
}
