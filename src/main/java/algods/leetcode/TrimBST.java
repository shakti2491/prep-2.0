package algods.leetcode;

import java.util.Stack;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        // find root
        while(root != null && root.val < L || root.val > R) {
            if(root.val < L)
                root = root.right;
            if(root.val > R)
                root = root.left;
        }
        if(root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode left = cur.left;
            // trim lower value
            while(left != null && left.val < L)
                left = left.right;
            TreeNode right = cur.right;
            // trim higher value
            while(right != null && right.val > R)
                right = right.left;
            cur.left = left;
            cur.right = right;
            if(cur.left != null)
                stack.push(cur.left);
            if(cur.right != null)
                stack.push(cur.right);
        }
        return root;
    }
}



   class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

