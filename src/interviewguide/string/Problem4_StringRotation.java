package interviewguide.string;

/**
 * 给定两个字符串s1，s2.判断s2是否由s1旋转得来。
 * 例如s1 = "waterbottle", s2 = "terbottlewa"，则判断为true。
 * 若s1 = "dog", s2 = "god" 则返回false
 * @author hanjia
 *
 */
public class Problem4_StringRotation {

	/*
	 * 解法：将s2 加上（concat）其本身得到新字符串s3，如果s1是s3的子串（substring）则判断为true
	 */
	public static boolean isRotatedString(String s1, String s2){
		return (s2+s2).contains(s1);	
	}
	
	public static void main(String[] args){
		String s1 = "waterbottle";
		String s2 = "terbottlewa";
		String s3 = "dog";
		String s4 = "god";
		System.out.println(isRotatedString(s1, s2));
		System.out.println(isRotatedString(s3, s4));

	}
	
}
