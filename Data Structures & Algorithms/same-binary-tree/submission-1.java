/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
        {
            return true;
        }
        else if(p==null && q!=null || p!=null &&q==null)
        {
            return false;
        }
        int v1=p.val;
        int v2=q.val;
        if(v1==v2)
        {
          return (isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));
        }
        return false;

    }
}
