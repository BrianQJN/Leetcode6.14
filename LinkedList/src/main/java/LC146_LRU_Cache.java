import java.util.HashMap;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-23
 */
public class LC146_LRU_Cache {
    static class Node {
        public int key, val;
        public Node next, prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class DoubleList {
        // head and tail dummy nodes
        private Node head, tail;
        // list size
        private int size;

        public DoubleList() {
            // initialization
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // add node at last, cost O(1)
        public void addLast(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        // remove node from list, cost O(1)
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        // remove the first node and return it
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        // return the list size
        public int size() {return size;}
    }

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LC146_LRU_Cache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node node = cache.removeFirst();
        int deleteKey = node.key;
        map.remove(deleteKey);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }

        if (cap == cache.size()) {
            removeLeastRecently();
        }

        addRecently(key, value);
    }
}
