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
    public long kthLargestLevelSum(TreeNode root, int k) {
        int h = height(root);

        if(h<k){
            return -1;
        }
        long[] levelSum = new long[h];
        findlevelSum(root, 0, levelSum);

        Arrays.sort(levelSum);
        reverse(levelSum);
        return levelSum[k-1];
        
        
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r)+1;
    }
    public void findlevelSum(TreeNode root, int le, long[] levelSum){
        if(root == null){
            return ;
        }
        levelSum[le]+=root.val;
        findlevelSum(root.left, le+1, levelSum);
        findlevelSum(root.right, le+1, levelSum);
    }
    private void reverse(long[] arr){
        int left =0, right = arr.length-1;
        while(left<right){
            long temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}