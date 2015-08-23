package interviewguide.string;

/**
 * 给定一个字符串，反转其中单词出现的顺序，单词本身不反转。 
 * 例如字符串s1 = "This is a sentence" 反转后得到"sentence a is This"
 * @author hanjia
 *
 */
public class Problem2_StringReverseWords {

	/*
	 * 解法：先反转整个字符串，再单独反转每一个单词即可。与Array问题中Problem12解法相似。
	 */
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
	
	public static void main(String[] args){
		char[] charArray = {'T','h','i','s',' ','i','s',' ','a',' ','s','e','n','t','e','n','c','e'};
		System.out.println(reverseSentence(charArray));
	}
}
