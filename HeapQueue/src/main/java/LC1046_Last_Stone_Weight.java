import java.util.PriorityQueue;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-30
 */
public class LC1046_Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        // initialization
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // put the original stone to the heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // smash the stones
        while (maxHeap.size() >= 2) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if (x < y) {
                maxHeap.offer(y - x);
            }
        }

        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }
}
