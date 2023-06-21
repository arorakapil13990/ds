package tree;
        // https://www.youtube.com/watch?v=dBGUmUQhjaM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp
class TrieNode {
    TrieNode links[] = new TrieNode[26];
    boolean flag = false;
    public TrieNode(){}

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

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        TrieNode node = root;
        boolean isPresent = true;
        int i;
        for (i =0;i < word.length();i++){
            if(node.contains(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                isPresent = false;
                break;
            }

        }

        if(isPresent && node.isEnd()){
            return true;
        }
        return false;
    }

    public boolean startsWith(String word) {
        TrieNode node = root;
        boolean isPresent = true;
        int i;
        for (i =0;i < word.length();i++){
            if(node.contains(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                isPresent = false;
            }
        }
        if(isPresent && node.isEnd())
        {
            return true;
        }
        return isPresent;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
