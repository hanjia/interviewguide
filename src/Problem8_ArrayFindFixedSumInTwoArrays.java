import java.util.Arrays;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 1:04 PM
 */
public class ArrayFindFixedSum {
    public static void findInTwoArray(int[] a, int[] b, int s) {
        for (int i = 0, j = b.length - 1; i < a.length && j > 0; ) {
            if (a[i] + b[j] == s) {
                System.out.println("Found fixed sum with " + a[i] + " " + b[j]);
                i++;
                j--;
            } else if (a[i] + b[j] > s) {
                j--;
            } else {
                i++;
            }
        }
    }

    public static void findThreeTupleSumEqFixedNum(int[] a, int s) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            int k = a.length - 1;
            while (j < k) {
                if (a[i] + a[j] + a[k] == s) {
                    System.out.println("Found fixed sum with " + a[i] + " " + a[j] + " " + a[k]);
                    return;
                } else if (a[i] + a[j] + a[k] > s) {
                    k--;
                } else {
                    j++;
                }
            }
        }
    }

}
