package interviewguide.string;

/**
 * 给定一个含有n个元素的字符数组a，将其原地逆序。
 * @author hanjia
 *
 */
public class Problem1_StringReverse {

	/*
	 * 解法：设置2个指针分别指向头尾，交换两指针所指向的字符，逐渐向中间靠拢直到指针交叉。
	 */
	public static char[] reverseString(char[] a) {
	    int left = 0;
	    int right = a.length -1;
	    while (left < right) {
	        char temp = a[left];
	        a[left++] = a[right];
	        a[right--] = temp;
	    }
	    return a;
	}
	
	public static void main(String[] args){
		char[] charArray = {'h','e','l','l','o'};
		System.out.println(reverseString(charArray));
	}
}
