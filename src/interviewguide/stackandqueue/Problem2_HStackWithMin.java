package interviewguide.stackandqueue;
/**
 * Author: haozhou
 * Date: 8/11/12
 * Time: 11:46 PM
 * 
 * 定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。要求函数min、push以及pop的时间复杂度都是O(1)。
 */
public class Problem2_HStackWithMin extends HStack{
    
	HStack minStack;

    @Override
    public void push(int value) {
        if (value < min()) {
            minStack.push(value);
        }
        super.push(value);
    }

    @Override
    public int pop() {
        int value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        return value;
    }

    /*
     * 解法：在栈內另存一个栈来保存最小值。
     */
    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }
}
