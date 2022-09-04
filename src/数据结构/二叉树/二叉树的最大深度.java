package 数据结构.二叉树;

/**
 * 自顶向下
 */

public class 二叉树的最大深度 {

    //定义初始长度
    int maxlen = 1;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //如果不为空则+1
        maxlen=1;

        //递归调用
        MaxDepth(root, maxlen);
        return maxlen;
    }

    void MaxDepth(TreeNode root, int depth) {

        //递归的终止条件
        if (root == null)
            return;

        //如果该节点两边都为空则返回
        if (root.left == null && root.right == null) {
            maxlen = Math.max(maxlen, depth);
        }

        //如果左或右至少有一个节点，depth+1;
        MaxDepth(root.left, depth + 1);
        MaxDepth(root.right, depth + 1);
    }

    public static void main(String[] args) {

    }
}
