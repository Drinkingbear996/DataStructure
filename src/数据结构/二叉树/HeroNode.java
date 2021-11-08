package 数据结构.二叉树;

public class HeroNode {

    private int no;
    private String name;
    private HeroNode left; //默认为空
    private HeroNode right; //默认为空

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void PreOrder( )
    {
        //输出父节点
        System.out.println(this);

        //递归左子树前序遍历
        if (this.left!=null)
        {
            this.left.PreOrder();
        }
        //递归右子树前序遍历
        if (this.right!=null)
        {
            this.right.PreOrder();
        }

    }

    public void infixOrder()
    {
        //递归向左子树中序遍历
        if (this.left!=null)
        {
            this.left.infixOrder();
        }

        System.out.println(this);

        //递归向右子树中序遍历
            if (this.right.right!=null)
            {
                this.right.infixOrder();
            }





    }

    public void postOrder()
    {
        //递归向左子树遍历
         if (this.left!=null)
         {
             this.left.postOrder();
         }

         //递归向右子树遍历
        if (this.right!=null)
        {
            this.right.postOrder();
        }

        System.out.println(this);

    }


}

//二叉树
class BinaryTree
{
    private HeroNode root;

    public BinaryTree() {

    }

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder()
    {
        if (this.root!=null)
        {
            this.root.PreOrder();
        }
        else
        {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder()
    {
        if (this.root!=null)
        {
            this.root.infixOrder();
        }

        else
        {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder()
    {
        if (this.root!=null)
        {
            this.root.postOrder();
        }
        else
        {
            System.out.println("二叉树为空，无法遍历");
        }
    }

}