package 数据结构.二叉树;

public class BinaryTree {

    Node root;

    //构造空二叉树
    public BinaryTree(BinaryTree root) {
        this.root = null;
    }

     public boolean isEmpty()
     {
         return  this.root==null;
     }

     //插入x元素作为根节点，如果x!=null,则root节点为x的左节点。
     public void insert(Node x)
     {
         if (x!=null)
         {
             x=new Node(x,this.root,-1);
         }
     }
     public void insert()
     {

     }
}
