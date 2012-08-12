import java.util.Arrays;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 12:40 PM
 */
public class ArrayFindMinAbs {
    public static int findMinAbs(int[] a, int n) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i] - a[i - 1]) < min) {
                min = Math.abs(a[i] - a[i - 1]);
            }
        }
        return min;
    }
}
