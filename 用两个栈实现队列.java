import java.util.Stack;

public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.empty()) {
            Integer pop = stack2.pop();
            return pop;
        } else {
            while (!stack1.empty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
            if (!stack2.empty()) {
                return stack2.pop();
            } else {
                return -1;
            }
        }
    }
}
