/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-21
 */
public class LC138_Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        // step 1: create new nodes and interweave them with the original nodes
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        // step 2: set the random pointers for the new nodes
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // step 3: separate the original and new nodes
        Node dummy = new Node(0);
        Node newCur = dummy;
        cur = head;
        while (cur != null) {
            newCur.next = cur.next;
            newCur = newCur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
