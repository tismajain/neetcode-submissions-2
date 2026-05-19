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
    int sum=Integer.MIN_VALUE;
    int gain(TreeNode node)
    {
        if (node == null) return 0;

        int leftGain = Math.max(gain(node.left), 0);
        int rightGain = Math.max(gain(node.right), 0);

        int localMax = node.val + leftGain + rightGain;
        sum = Math.max(sum, localMax);

        return node.val + Math.max(leftGain, rightGain);
    }
    public int maxPathSum(TreeNode root) {
        gain(root);
        return sum;
        
    }
}
