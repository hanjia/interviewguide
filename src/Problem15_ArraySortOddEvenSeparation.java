import java.util.Arrays;

/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 2:13 PM
 */
public class Problem15_ArraySortOddEvenSeparation {

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
    
    public static void main(String[] args){
    	int[] a = {1,2,3,4,5,6,7,8,9};
    	System.out.println(Arrays.toString(oddLeftEvenRight(a)));
    }
}
