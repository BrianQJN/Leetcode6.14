import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-06-14
 */
public class LC49_Group_Anagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create a hashmap to store anagram groups
        Map<String, List<String>> anagramMap = new HashMap<>();

        // iterate through the array strs
        for (String str : strs) {
            // convert the str to array and sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            // convert the sorted str array to string
            String sortedStr = new String(charArray);

            // add the original string to the corresponding anagram group
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }

            anagramMap.get(sortedStr).add(str);
        }

        // return the result
        return new ArrayList<>(anagramMap.values());
    }
}
