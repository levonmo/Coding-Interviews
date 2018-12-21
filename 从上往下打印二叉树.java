import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class 从上往下打印二叉树 {

    public static void main(String[] args) {
        ArrayList<Integer> list = PrintFromTopToBottom(null);
        System.out.println(list.size());
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                break;
            }
            list.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return list;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
