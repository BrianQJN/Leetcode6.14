import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-03
 */
public class LC295_Find_Median_from_Data_Stream {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public LC295_Find_Median_from_Data_Stream() {
        // initialization
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        // add to max heap first
        maxHeap.offer(num);

        // balance the heaps
        minHeap.offer(maxHeap.poll());

        // ensure max heap has equal or one more element than min heap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
