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
    
    int i=0;
    public TreeNode b(int[] preorder,int[] inorder, int instart, int inend)
    {
         if(instart>inend)
        {
            return null;
        }
        TreeNode root=new TreeNode();
        if(i<preorder.length)
        root=new TreeNode(preorder[i++]);
        
        
        int index=1;
        for(int j=instart;j<=inend;j++)
        {
            if(inorder[j]==root.val)
            {
                index=j;
            }
        }
        root.left=b(preorder,inorder,instart, index-1);
        root.right=b(preorder,inorder,index+1,inend);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       TreeNode root=b(preorder,inorder,0,inorder.length-1);
       return root;

    }
}
