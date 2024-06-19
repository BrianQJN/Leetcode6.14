/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-19
 */
public class LC21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // create a dummy node to act as the head of the merged list
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // iterate through both lists until one of them is exhausted
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // append the remaining nodes of the non-exhausted list
        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }

        return dummy.next;
    }
}
