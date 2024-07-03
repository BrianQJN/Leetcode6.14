import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-03
 */
public class LC212_Word_SearchII {
    private int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private Set<String> res;
    private char[][] board;
    private int m, n;

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.res = new HashSet<>();

        // build trie
        TrieNode root = buildTrie(words);

        // perform DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, root);
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(int i, int j, TrieNode node) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
        }

        // mark cur cell as visited to avoid double use
        board[i][j] = '#';

        // spread to adjacent directions
        for (int[] dir : DIRECTIONS) {
            int iNew = i + dir[0], jNew = j + dir[1];
            if (iNew >= 0 && iNew < m && jNew >= 0 && jNew < n) {
                dfs(iNew, jNew, node);
            }
        }

        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }

        return root;
    }
}
