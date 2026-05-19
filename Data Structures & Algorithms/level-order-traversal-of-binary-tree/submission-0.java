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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> l=new ArrayList<>();
        if(root==null)
        {
            return l;
        }
        q.add(root);
        q.add(null);
        List<Integer> curr=new ArrayList<>();
        while(q.size()>1)
        {
            TreeNode temp=q.poll();
            if(temp==null)
            {
                l.add(curr);
                curr=new ArrayList<>();
                q.add(null);
                continue;
            }
            
            curr.add(temp.val);
            if(temp.left!=null)
            q.add(temp.left);
            if(temp.right!=null)
            q.add(temp.right);
            

        }
        l.add(curr);
        return l;
        
    }
}
