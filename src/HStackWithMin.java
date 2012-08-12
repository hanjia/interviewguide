/**
 * User: haozhou
 * Date: 8/11/12
 * Time: 11:46 PM
 */
public class HStackWithMin extends HStack{
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

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }
}
