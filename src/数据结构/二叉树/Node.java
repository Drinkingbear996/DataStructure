package 数据结构.二叉树;

public class Node {
   Node left,right;
   int data;

   //构造节点和左右子节点
   public Node(Node left, Node right, int data) {
      this.left = left;
      this.right = right;
      this.data = data;
   }

   //构造节点
   public Node(int data) {
      this.data = data;
   }

   public boolean isLeaf()
   {
      if (this.left==null&&this.right==null)
      {
         return true;
      }
      else
      {
         return false;
      }

   }

   @Override
   public String toString() {
      return "Node{" +
              "left=" + left +
              ", right=" + right +
              ", data=" + data +
              '}';
   }
}
