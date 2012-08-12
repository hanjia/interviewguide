/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 1:27 PM
 */
public class ArrayFindMaxSub {
    public static int findMaxSum(int[] a) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum < 0) {
                sum = 0;
            }
            max = sum > max ? sum : max;
        }
        return max;
    }

    public static int findMaxMultiply(int[] a) {
        int max = 1;
        int min = 1;
        int result = 1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                max *= a[i];
                min = Math.min(min * a[i], 1);
            } else if (a[i] == 0) {
                max = 1;
                min = 1;
            } else {
                int temp = max;
                max = Math.max(min * a[i], 1);
                min = temp * a[i];
            }
            result = Math.max(result, max);
        }

        return result;
    }
}
