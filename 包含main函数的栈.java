import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 解题思路: 使用两个栈，一个栈存储数据，一个栈存储数据栈中的最小元素
 */
public class 包含main函数的栈 {

    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int node) {//进栈
        if (min.isEmpty() || min.peek() >= node) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
        data.push(node);
    }

    public void pop() {//出栈
        if (!data.isEmpty() && !min.isEmpty()) {
            data.pop();
            min.pop();
        }
    }

    public int top() {//取得栈顶元素
        if (!data.isEmpty()) {
            return data.peek();
        } else {
            return -1;
        }
    }

    public int min() {//取得最小值
        if (!min.isEmpty()) {
            return min.peek();
        } else {
            return -1;
        }
    }

}

