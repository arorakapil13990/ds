package tree;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/word-search-ii/submissions/966880933/
public class WordSearchII {


   static class TrieNode {
        TrieNode childs[] = new TrieNode[26];
        String str;

        public static void insert(TrieNode node,String word) {
            //TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.childs[idx] == null) {
                    node.childs[idx] = new TrieNode();
                }
                node = node.childs[idx];
            }
            node.str = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int i, j, m, n;
        TrieNode root = new TrieNode();
        for (String str : words) {
            root.insert(root,str);
        }

        ArrayList<String> ans = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                dfs(board, i, j, root, visited, ans);
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, boolean visited[][], ArrayList<String> ans) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == true) return;
        if(root.childs[board[i][j] - 'a'] == null) return;
        TrieNode child = root.childs[board[i][j] - 'a'];
        if (child.str != null) {
            ans.add(child.str);
            child.str=null;
        }

        visited[i][j] = true;
        dfs(board, i + 1, j, child, visited, ans);
        dfs(board, i - 1, j, child, visited, ans);
        dfs(board, i, j + 1, child, visited, ans);
        dfs(board, i, j - 1, child, visited, ans);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        WordSearchII wordSearch = new WordSearchII();
        char[][] board = {{'o','a','b','n'}, {'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] str = {"oa","oaa"};
        wordSearch.findWords(board,str).stream().forEach(System.out::println);

    }
}
