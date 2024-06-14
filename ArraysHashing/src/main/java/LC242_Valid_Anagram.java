import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-14
 */
public class LC242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        // base case
        if (s.length() != t.length()) return false;

        // initialize a HashMap to store letter count
        Map<Character, Integer> letterCount = new HashMap<>();

        // iterate through s to record the letter appearance
        for (char c : s.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }

        // iterate through t to check the anagram
        for (char c : t.toCharArray()) {
            // if current char not exists in the s
            if (!letterCount.containsKey(c)) {
                return false;
            }

            // minus the appearance count
            letterCount.put(c, letterCount.get(c) - 1);
            // remove the letter once it appears all
            if (letterCount.get(c) <= 0) {
                letterCount.remove(c);
            }
        }

        // if the map still has keys, means not anagram
        return letterCount.isEmpty();
    }
}
