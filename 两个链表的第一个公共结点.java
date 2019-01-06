import java.util.ArrayList;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class 两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ListNode cur = pHead1;
        while (cur != null) {
            list1.add(cur.val);
            cur = cur.next;
        }
        cur = pHead2;
        while (cur != null) {
            list2.add(cur.val);
            cur = cur.next;
        }
        //当存在相同的节点的时候，后面一部分肯定是相同的，所以从后面依次迭代回来，截取后面相同的部分就行了
        for (int i1 = list1.size() - 1, i2 = list2.size() - 1; i1 >= 0 && i2 >= 0; i1--,i2--) {
            if (!list1.get(i1).equals(list2.get(i2))) {
                //当最后一个元素都不相同，那么就不存在相同的节点
                if (i1 == list1.size() - 1 || i2 == list2.size() - 1) return null;
                for (int i = 0; i <= i1; i++) {
                    pHead1 = pHead1.next;
                }
                return pHead1;
            }
        }
        //当通过上面的for循环，则证明两个链表存在包含的关系，即是例如(1-3-4-5-6-7和3-4-5-6-7) (1-2-3-4-5和1-2-3-4-5)这种类型的
        return list1.size() <= list2.size() ? pHead1 : pHead2;
    }
}
