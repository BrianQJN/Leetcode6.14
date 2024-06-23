/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-21
 */
public class LC2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // initialize dummy node and a carry digit
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;

        // iterate through each digit
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        return dummy.next;
    }
}
