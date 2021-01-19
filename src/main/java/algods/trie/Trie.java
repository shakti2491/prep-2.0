package algods.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class TrieNode{
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;
    public Trie(){
        root = new TrieNode();
    }


    public void insert(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public void insertRecursive(String word){
        insertRecursive(root,word,0);
    }

    private void insertRecursive(TrieNode current, String word, int i) {
        if(i==word.length()){
            current.endOfWord =true;
            return;
        }

        char ch = word.charAt(i);
        TrieNode node = current.children.get(ch);
        if(node == null){
            node = new TrieNode();
            current.children.put(ch,node);
        }
        insertRecursive(node,word,i+1);
    }

    public boolean search(String word){
        TrieNode current = root;
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node==null){
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }
}
