import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 */
public class 二叉搜索树的第k个结点 {


    /**
     * 解题思路:
     *  对二叉搜索树进行中序遍历后，就行一个有序的数组，使用非递归的中序遍历，
     *  并用一个count记录每打印一个节点count++，当count==k时候遍历结束
     */
    static TreeNode KthNode(TreeNode pRoot,int k) {
        if (pRoot == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        stack.push(pRoot);
        while (!stack.isEmpty()) {
            if (pRoot != null) {
                stack.push(pRoot.left);
                pRoot = pRoot.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop == null) continue;
                count++;
                if (count == k) return pop;
                stack.push(pop.right);
                pRoot = pop.right;
            }
        }
        return null;
    }
}
