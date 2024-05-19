import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-18
 */
public class LC242_Valid_Anagram {
    /**
     * @param s the base string
     * @param t the comparing string
     * @return boolean - return true if t is an anagram of s
     * @implSpec Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     * @author Brian Qu
     * @since 2024-05-18 22:30
     */
    public boolean isAnagram(String s, String t) {
        // base case
        if (s.length() != t.length()) return false;

        // initialize a HashMap to record letters' appearances
        Map<Character, Integer> count = new HashMap<>();

        // traverse string s to count letter appearance
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // traverse string t to check anagram
        for (char c : t.toCharArray()) {
            if (!count.containsKey(c)) {
                return false;
            }

            count.put(c, count.get(c) - 1);
            if (count.get(c) == 0) {
                count.remove(c);
            }
        }

        return count.isEmpty();
    }
}
