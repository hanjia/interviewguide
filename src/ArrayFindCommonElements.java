/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 12:48 PM
 */
public class ArrayFindCommonElements {
    public static void findCommon(int[] a, int[] b) {
        for (int i = 0, j = 0; i < a.length && j < b.length; ) {
            if (a[i] == b[j]) {
                System.out.println("Found common: " + a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
    }

}
