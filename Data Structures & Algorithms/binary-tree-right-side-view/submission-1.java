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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        if(root==null)
        {
            return l;
        }
        Deque<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        l.add(root.val);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode n=q.poll();
                if(n.left!=null)
                q.add(n.left);
                if(n.right!=null)
                q.add(n.right);
            }
            if(!q.isEmpty())
            l.add(q.peekLast().val);
        }
        return l;

    }
}
