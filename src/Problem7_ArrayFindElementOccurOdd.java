/**
 * Author: haozhou
 * Date: 8/11/12
 * Time: 12:59 PM
 * 给定一个含有n个元素的整型数组a，其中只有一个元素出现奇数次，找出这个元素。
 */
public class Problem7_ArrayFindElementOccurOdd {
	
    public static int find(int[] a) {
        int k = 0;
        for (int i : a) {
            k ^= i;
        }
        return k;
    }
    
    public static void main(String[] args){
    	int[] a = {2,1,3,4,4,5,2,1,3};
    	System.out.println(find(a));
    }
}