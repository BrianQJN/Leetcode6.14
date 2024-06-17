import java.util.Arrays;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-17
 */
public class LC567_Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {
        // edge case
        if (s1.length() > s2.length()) return false;

        // initialize two arrays to store char frequencies in s1 and sliding window in s2
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // count the char frequencies in s1 and corresponding in s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // check if the starting is the same
        if (Arrays.equals(s1Count, s2Count)) return true;

        // otherwise, move the window
        for (int j = s1.length(); j < s2.length(); j++) {
            // add the cur char's frequency
            s2Count[s2.charAt(j) - 'a']++;
            // minus the left side char's frequency
            s2Count[s2.charAt(j - s1.length()) - 'a']--;

            // compare the two frequencies
            if (Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }
}
