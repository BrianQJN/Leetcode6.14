/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-23
 */
public class LC141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        // initialize two pointers
        ListNode slow = head;
        ListNode fast = head;

        // iterate the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // cycle detected
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
