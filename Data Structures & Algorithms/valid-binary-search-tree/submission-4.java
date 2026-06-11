/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    //与上面的node进行比较 这样在在运行到null的时候可以很好的面对 在向下进行比较的时候可能会遇到null这样要排除情况不好进行比较
    public boolean isValidBST(TreeNode root) {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean valid(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }

        if (!(node.val > left && node.val < right)) {
            return false;
        }

        return valid(node.left, left, node.val) && valid(node.right, node.val, right);
    }
}
