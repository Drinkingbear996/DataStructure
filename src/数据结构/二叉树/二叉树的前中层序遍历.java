package 数据结构.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的前中层序遍历 {




    //前序遍历
    List<Integer> l = new LinkedList<>();

    public void PreOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }


        l.add(treeNode.val);
        preorderTraversal(treeNode.left);
        preorderTraversal(treeNode.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        PreOrder(root);
        return l;
    }

    //中序遍历
    public void inorder(TreeNode tree) {
        if (tree == null)
            return;
        inorder(tree.left);
        l.add(tree.val);
        inorder(tree.right);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return l;
    }


    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 先将根节点放入队列
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            // 遍历队列，把当前层的元素从队列取出来，将下一层放入队列
            for (int i = 0; i < size; i++) {
                // 取出队列元素，放入集合
                TreeNode current = queue.poll();
                temp.add(current.val);
                if (current.left != null) {
                    // 将当前节点的左儿子放入队列
                    queue.add(current.left);
                }
                if (current.right != null) {
                    // 将当前节点的右儿子放入队列
                    queue.add(current.right);
                }
            }
            result.add(temp);
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
