/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 12:59 PM
 */
public class ArrayFindElementOccurOdd {
    public static int find(int[] a) {
        int k = a[0];
        for (int i : a) {
            k^=a[i];
        }
        return k;
    }
}