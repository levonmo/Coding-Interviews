import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class 按之字形顺序打印二叉树 {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        queue.offer(pRoot);
        int count = 0;
        int nextCount = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        //是否为反过来打印
        boolean ff = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (ff) {
                list.add(0, poll.val);
            } else {
                list.add(poll.val);
            }
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
            count++;
            if (count == nextCount) {
                lists.add(list);
                list = new ArrayList<Integer>();
                nextCount = queue.size();
                count = 0;
                ff = !ff;
            }
        }
        return lists;
    }
}
