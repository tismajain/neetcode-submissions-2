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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
        {
            return -1;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode temp=st.pop();
            pq.add(temp.val);
            if(temp.right!=null)
            st.add(temp.right);
            if(temp.left!=null)
            st.add(temp.left);
        }
        for(int i=0;i<k-1;i++)
        {
            pq.poll();
        }
        return pq.peek();
    }
}
