/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 12:13 PM
 */
public class ArrayFindOccurMoreThanHalf {
    public static int find(int[] a, int n) {
        int current = a[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] == current) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    current = a[i];
                    count = 1;
                }
            }

        }
        return current;
    }
}
