package interviewguide.stackandqueue;

/**
 * 
 * @author hajia
 * 编写程序将一给定栈的元素以升序排列，栈类上只有4个方法可用，pop,push,peek,isEmpty。
 * 例如给定栈s1 = {4, 3, 1, 5, 2} 2为栈顶，排序后得到 s2 = {1, 2, 3, 4, 5} 5为栈顶。
 */
public class Problem4_HStackSort {
	
    public static HStack sort(HStack stack) {
        HStack r = new HStack();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                stack.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }
    
    public static void main(String[] args) {
        HStack s2 = new HStack();
        s2.push(4);
        s2.push(3);
        s2.push(1);
        s2.push(5);
        s2.push(2);

        HStack s3 = sort(s2);
        System.out.println(s3.pop());
        System.out.println(s3.pop());
        System.out.println(s3.pop());
        System.out.println(s3.pop());
        System.out.println(s3.pop());
    }
}
