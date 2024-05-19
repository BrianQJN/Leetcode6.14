import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-19
 */
public class LC49_Group_Anagrams {
    /**
     * @param strs an array of strings
     * @return List<List<String>> - the grouped anagrams
     * @implSpec Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     * @author Brian Qu
     * @since 2024-05-19 00:13
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // initialize the HashMap to store the grouped anagrams
        Map<String, List<String>> anagrams = new HashMap<>();

        // traverse the strs array
        for (String str : strs) {
            // sort the str to form key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }

            anagrams.get(key).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }
}
