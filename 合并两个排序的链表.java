/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序的链表 {

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode one;//确定在那个链表上面进行插入，选择在第一个元素相对较小的链表中进行插入操作
        ListNode two;
        if (list1.val < list2.val) {
            one = list1;
            two = list2;
        } else {
            one = list2;
            two = list1;
        }
        ListNode pre = one;
        ListNode reOne = one;
        one = one.next;
        while (one != null && two != null) {
            if (two.val >= one.val) {
                pre = one;
                one = one.next;
            } else {
                ListNode temp = two.next;//nulll
                pre.next = two;
                two.next = one;
                pre = two;
                two = temp;
            }
        }
        if (two != null) {
            pre.next = two;
        }
        return reOne;
    }
}
