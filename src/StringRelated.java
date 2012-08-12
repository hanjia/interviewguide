/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 4:52 PM
 */
public class StringRelated {

    public static char[] reverseString(char[] a) {
        return reverseString(a, 0, a.length - 1);
    }


    public static char[] reverseString(char[] a, int left, int right) {
        while (left < right) {
            char temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
        return a;
    }

    public static char[] reverseSentence(char[] s) {
        reverseString(s, 0, s.length - 1);

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverseString(s, left, right - 1);
                left = i + 1;
                right = left;
            } else {
                right++;
            }
        }
        reverseString(s, left, right - 1);
        return s;
    }

    public static boolean isCharAllUnique(String s) {
        boolean[] map = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]) {
                return false;
            } else {
                map[s.charAt(i)] = true;
            }
        }
        return true;
    }
}
