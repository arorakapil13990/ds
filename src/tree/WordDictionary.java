package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDictionary {
    class TrieNode {
        boolean flag;

        TrieNode links[] = new TrieNode[26];
        public TrieNode() {

        }

        boolean contains(char ch){
            return links[ch - 'a'] != null;
        }

        TrieNode get(char ch){
            return links[ch - 'a'];
        }

        void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }

        void setEnd(){
            flag = true;
        }

        boolean isEnd(){
            return flag;
        }

    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    /*public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isWord = true;
    }*/
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void addWord(String word) {
        TrieNode node = root;
        int i;
        for(i =0;i< word.length(); i++){
            if(!node.contains(word.charAt(i))){
                node.put(word.charAt(i), new TrieNode());
            }
            // moves to the reference trie
            node = node.get(word.charAt(i));
        }

        node.setEnd();
    }


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean searching(String word, TrieNode node, int index) {
        if (node == null) return false;
        /**
         * Time Complexity: O(n)
         *   - word length
         */
        for (int i = index; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            // ('.' - 'a') = -51
            if (idx == (-51)) {
                /**
                 * Time Complexity: O(1)
                 *   - Always 26 lower-case English letters
                 */
                for (int j = 0; j < node.links.length; j++) {
                    /**
                     * Space Complexity: O(n)
                     *   - stack: if search '.' for whole letters.
                     */
                    if (searching(word, node.links[j], i + 1)) {
                        return true;
                    }
                }
                return false;
            }
            if (node.links[idx] == null) return false;
            node = node.links[idx];
        }
        return node.flag;
    }

    public boolean search(String word) {
        return searching(word, root, 0);
    }


    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("bar");
        System.out.println(obj.search("bap"));
    }
}
/*public class WordDictionary {


    // time limit exceeded
    *//*Map<Integer, List<String>> map = new HashMap<>();
    public WordDictionary() {

    }

    public void addWord(String word) {
        List<String> list = map.get(word.length());
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(word);
        map.put(word.length(), list);
    }

    public boolean search(String word) {
-----------
List<String> list = map.get(word.length());
        if(list == null) return false;
        for(String str : list){
            if(isEqual(str,word)) return true;
        }
        return false;
        -------------


        List<String> list = map.get(word.length());
        if(list == null) return false;
        for(String str : list){
            boolean isPresent = true;
            for(int i =0;i<str.length();i++){

                if(word.charAt(i) == '.') continue;
                if(str.charAt(i) != word.charAt(i)){
                    isPresent = false;
                }

            }
            if(isPresent){
                return isPresent;
            }
        }

        return false;
    }

    private boolean isEqual(String a, String b){
        for(int i = 0;i< a.length();i++){
            if(b.charAt(i) == '.') continue;
            if(a.charAt(i) != b.charAt(i)) return false;
        }
            return true;

    }

    *//*
}*/

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */