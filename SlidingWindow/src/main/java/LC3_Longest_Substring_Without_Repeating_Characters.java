import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        // initialize the sliding window and a HashSet to record appearance
        int left = 0, right = 0;
        int maxLength = 0;
        Set<Character> seen = new HashSet<>();

        // move the window to find the max length
        while (right < s.length()) {
            char curChar = s.charAt(right);

            // if cur char exists in the set, move the window to remove it
            while (seen.contains(curChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            // after moving, the substring is a new one, update max length
            seen.add(curChar);
            maxLength = Math.max(maxLength, seen.size());
            right++;
        }

        return maxLength;
    }
}
