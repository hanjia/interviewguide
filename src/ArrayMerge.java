import java.util.Arrays;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 1:59 PM
 */
public class ArrayMerge {
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                c[k++] = b[j++];
            } else if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = a[i++];
                j++;
            }
        }
        // if array a and array b are not the same length
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return Arrays.copyOfRange(c, 0, k);
    }
}
