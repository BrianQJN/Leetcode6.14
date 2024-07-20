import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-19
 */
public class LC763_Partition_Labels {
    public List<Integer> partitionLabels(String s) {
        // initialization
        List<Integer> res = new ArrayList<>();
        int[] lastIdx = new int[26];

        // record the last index of each char
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        // determine the partition points
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIdx[s.charAt(i) - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }
}
