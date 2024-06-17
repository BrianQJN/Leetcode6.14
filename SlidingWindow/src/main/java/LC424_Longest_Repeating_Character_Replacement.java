import java.util.HashSet;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        // initialize an array to store char frequencies in the cur window
        int[] charCount = new int[26];
        int maxLength = 0;
        int maxCount = 0;
        int left = 0;

        // iterate through the string using the right pointer
        for (int right = 0; right < s.length(); right++) {
            // update the frequency of the cur char
            charCount[s.charAt(right) - 'A']++;

            // update the maximum frequency of any char in the cur window
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);

            // check if the cur window size minus the maximum frequency is greater than k
            if (right - left + 1 - maxCount > k) {
                // shrink the window size from the left
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            // update the maximum length of the substring found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
