/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 11:54 AM
 */
public class ArraySum {
    public static int sum(int[] a, int n) {
        return n == 0 ? 0 : sum(a, n - 1) + a[n - 1];
    }
}
