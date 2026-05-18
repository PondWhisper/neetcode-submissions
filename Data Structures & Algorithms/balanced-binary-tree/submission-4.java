class Solution {
    public boolean isBalanced(TreeNode root) {
        // 如果最终算出来的高度不是 -1，说明整棵树都是平衡的
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0; // 空节点高度为 0

        // 1. 探查左子树
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1; // 左子树已经不平衡了，直接一票否决（剪枝）

        // 2. 探查右子树
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1; // 右子树已经不平衡了，直接一票否决（剪枝）

        // 3. 检查当前节点是否平衡
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // 左右高度差大于 1，当前节点沦陷，向上传递 -1
        }

        // 4. 如果走到这里，说明当前节点也平衡，返回它真正的树高
        return Math.max(leftHeight, rightHeight) + 1;
    }
}