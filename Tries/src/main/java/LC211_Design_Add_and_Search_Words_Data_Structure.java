/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-03
 */
public class LC211_Design_Add_and_Search_Words_Data_Structure {
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public LC211_Design_Add_and_Search_Words_Data_Structure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchPrefix(word, 0, root);
    }

    private boolean searchPrefix(String prefix, int idx, TrieNode node) {
        if (idx == prefix.length()) {
            return node.isEndOfWord;
        }

        char c = prefix.charAt(idx);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && searchPrefix(prefix, idx + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int childIdx = c - 'a';
            TrieNode child = node.children[childIdx];
            if (child == null) {
                return false;
            }
            return searchPrefix(prefix, idx + 1, child);
        }
    }
}
