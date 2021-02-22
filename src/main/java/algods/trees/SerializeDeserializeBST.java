package algods.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class SerializeDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postOrder(root,sb);
        if(sb.length()>0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void postOrder(TreeNode node, StringBuilder sb){
        if(node==null)
            return ;
        postOrder(node.left,sb);
        postOrder(node.right,sb);
        sb.append(node.val);
        sb.append('#');
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;

        Deque<Integer> nums = new ArrayDeque<>();
        for(String s : data.split("#")){
            nums.add(Integer.valueOf(s));
        }
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE,nums);
    }

    private TreeNode helper(Integer lower, Integer higher, Deque<Integer> nums){
        if(nums.isEmpty())
            return null;

        int val  = nums.getLast();

        TreeNode root = new TreeNode(val);
        root.right = helper(val,higher,nums);
        root.left = helper(lower,val,nums);
        return root;
    }
}
