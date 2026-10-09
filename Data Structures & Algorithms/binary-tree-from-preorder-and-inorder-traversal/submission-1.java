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
    HashMap<Integer,Integer>map=new HashMap<>();
    int ind=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       for(int i=0;i<inorder.length;i++){
        map.put(inorder[i],i);
       } 
     return build(preorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int left,int right){
        if(left>right)return null;
        int cur=preorder[ind++];
        TreeNode root=new TreeNode(cur);
        int x=map.get(cur);
        root.left=build(preorder,left,x-1);
        root.right=build(preorder,x+1,right);
        return root;
    }
}
