package interviewguide.string;

/**
 * 给定一含有n元素的字符串（假定都是ASCII字符），判断该字符串中的各个字符是否唯一。要求时间复杂度为O(n)
 * @author hanjia
 *
 */
public class Problem3_CharArrayUniqueElement {
	
	/*
	 * 解法：新建一布尔数组，遍历字符串中每个字符，判断其在布尔数组中是否重复出现。相似的解法可用于LeetCode Problem3
	 */
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
	
	public static void main(String[] args){
		String s= "hello world";
		System.out.println(isCharAllUnique(s));
	}
}
