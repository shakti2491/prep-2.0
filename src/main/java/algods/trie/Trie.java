package algods.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class TrieNode{
        char c;
        private Map<Character, TrieNode> children;
        private boolean endOfWord;
        public TrieNode(char c){
            this.c = c;
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;
    public Trie(){
        root = new TrieNode('$');
    }


    public void insert(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            current.children.putIfAbsent(ch, new TrieNode(ch));
            current = current.children.get(ch);
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
            node = new TrieNode(word.charAt(i));
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

    public void delete(String word){
        delete(root,word,0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()){
            // when end of word is reached only delete if endOfWord is True
            if(!current.endOfWord){
                return false;
            }
            current.endOfWord = false;
            // if current has no other mapping then return true;
            return current.children.size()==0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node==null){
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(node,word,index+1);
        if(shouldDeleteCurrentNode){
            current.children.remove(ch);
            return current.children.size() ==0;
        }
        return false;
    }
}
