import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-30
 */
public class LC621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        // initialization
        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char task : tasks) {
            taskCounts.put(task, taskCounts.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(taskCounts.values());

        // calculate the units used
        int unitsUsed = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> freqs = new ArrayList<>();

            // we need n + 1 units to form one interval
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    freqs.add(maxHeap.poll());
                }
            }

            // once we retrieve these tasks, we minus their frequency by one, means we have done this task once
            for (int freq : freqs) {
                if (--freq > 0) {
                    // means we still have this task to execute, add it back to heap
                    maxHeap.add(freq);
                }
            }

            // update units used
            unitsUsed += maxHeap.isEmpty() ? freqs.size() : n + 1;
        }

        return unitsUsed;
    }
}
