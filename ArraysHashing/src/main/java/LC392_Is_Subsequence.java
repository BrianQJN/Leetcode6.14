/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-20
 */
public class LC392_Is_Subsequence {
    /**
     * @param s the string to be determined
     * @param t the base string
     * @return boolean - if s is a subsequence of t, return true
     * @implSpec Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     * @author Brian Qu
     * @since 2024-05-20 10:59
     */
    public boolean isSubsequence(String s, String t) {
        // initialize the two pointers
        int i = 0, j = 0;
        int m = s.length(), n = t.length();

        // traverse through the string s
        while (j < n) {
            if (i < m && s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == m;
    }
}
