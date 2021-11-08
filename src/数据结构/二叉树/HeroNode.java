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
        if (this.right !=null)
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
            if (this.right!=null)
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

    //二叉树  查找元素

    /** 前序查找
     * 1. 先判断当前节点是否为目标元素，如果是，则递归 如果相等，则返回当前节点
     * 2.
     *
     * */


    /**
     * @param
     * @param no
     * */

    public HeroNode PreOrderSearch(int no)
    {
        //结果节点 初始化为null

        HeroNode resultNode=null;

        //判断当前节点是不是空 (当前节点是root)
        if (this.no==no)
        {
            return this;
        }

            //判断当前节点的左子点是否为空，如果不为空，则递归前序查找
            //如果找到，则返回节点
            if (this.left!=null)
            {
              resultNode=this.left.PreOrderSearch(no);
            }

            if (resultNode!=null) //说明我们左子树找到了
            {
                return resultNode;
            }

            //左子点遍历完还没找到，则进行右子节点的遍历
            if (this.right!=null)
            {
               resultNode= this.right.PreOrderSearch(no);
            }

            //不管有没有找到都要返回
           return resultNode;


    }
    public HeroNode InfixOrderSearch(int no)
    {

        HeroNode resultNode=null;

        //判断当前节点的左子点是否为空，如果不为空，则递归前序查找
        //如果找到，则返回节点

        if (this.left!=null)
        {
            resultNode=this.left.InfixOrderSearch(no);
        }


        if (resultNode!=null)  //说明我们左子树找到了
        {
            return resultNode;
        }

        //判断当前节点是不是空 (当前节点是root)
        if (this.no==no)
        {
            return  this;
        }

        //左子点遍历完还没找到，则进行右子节点的遍历
        if (this.right!=null)
        {
            resultNode=this.right.InfixOrderSearch(no);
        }

        //不管有没有找到都要返回
        return  resultNode;
    }

    public HeroNode PostOrderSearch(int no)
    {
        //这个用于接收结果节点
        HeroNode resultNode=null;

        //遍历左子树，后序遍历
        if (this.left!=null)
        {
            resultNode=this.left.PostOrderSearch(no);
        }
        //如果左子树不为null，则证明找到了结果，返回该值

        if (resultNode!=null)
        {
            return resultNode;
        }

        //左子树没有找到，则遍历右子树
        if (this.right!=null)
        {
            resultNode=this.right.PostOrderSearch(no);
        }

        //找到了，就返回该节点
        if (resultNode!=null)
        {
            return resultNode;
        }

        //如果左右节点都没有找到，就比较当前节点（root）是不是目标节点
        if (this.no==no)
        {
            return this;
        }
        //否则仍然返回为空的结节点
        return resultNode;


    }



}

//二叉树
class BinaryTree
{


    public void setRoot(HeroNode root) {
        this.root = root;
    }

    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

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

    //前序遍历查找
    public HeroNode PreOrderSearch(int no)
    {
        if (root!=null)
        {
            return root.PreOrderSearch(no);
        }
        else
        {
            return  null;
        }

    }

    //中序遍历查找
    public HeroNode InfixOrderSearch(int no)
    {
        if (root!=null)
        {
            return  root.InfixOrderSearch(no);
        }
        else
        {
            return null;
        }
    }


    //后序遍历查找
    public HeroNode PostOrderSearch(int no)
    {
        if (root!=null)
        {
            return  root.PreOrderSearch(no);
        }
        else
        {
            return null;
        }
    }




}