package interviewguide.stackandqueue;

/**
 * 给定一含有多个元素的栈，用递归颠倒栈內元素。例如栈内元素为{1,2,3,4,5} 1在栈顶，颠倒后成为｛5，4，3，2，1｝ 5在栈顶。
 * @author hajia
 *
 */
public class Problem1_HStackReverse {
	
    public static void reverseStack(HStack stack) {
        if (!stack.isEmpty()) {
            int data = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, data);
        }
    }

    public static void insertAtBottom(HStack stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else{
            int data = stack.pop();
            insertAtBottom(stack, value);
            stack.push(data);
        }
    }
    
    public static void main(String[] args) {
        HStack s1 = new HStack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);

        reverseStack(s1);
    }

}
