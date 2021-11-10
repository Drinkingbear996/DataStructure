package 数据结构.二叉树;

//前序遍历
public class Test {
    public static void main(String[] args) {

        //创建一颗二叉树


        HeroNode root=new HeroNode(1,"a");
        HeroNode b=new HeroNode(2,"b");
        HeroNode c=new HeroNode(3,"c");
        HeroNode d=new HeroNode(4,"d");
        HeroNode e=new HeroNode(5,"e");
        HeroNode f=new HeroNode(6,"f");
        HeroNode g=new HeroNode(7,"g");


/**
 * 手动创建二叉树
 *        a（root）
 *    b       c
 *  d   e   f   g
 * */

        //说明，手动创建二叉树，后面学习递归二叉树

        root.setLeft(b);
        root.setRight(c);

        b.setLeft(d);
        b.setRight(e);

        c.setLeft(f);
        c.setRight(g);


        BinaryTree binaryTree=new BinaryTree();

        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();


        System.out.println("前序遍历查找");
        HeroNode result = binaryTree.PreOrderSearch(5);
        if (result!=null)
        {
            System.out.printf("找到了，信息为no=%d name=%s",result.getNo(),result.getName());
        }

        else
        {
            System.out.printf("没有找到 no=%d的英雄",4);
        }
        System.out.println();
        System.out.println("==========================删除叶子节点==========================================");

        System.out.println("删除前 前序遍历");
        binaryTree.preOrder();
        System.out.println("删除5号节点");
        binaryTree.DeleteNode(5);
        System.out.println("删除后 前序遍历");
        binaryTree.preOrder();


        System.out.println("==========================删除非叶子节点，则删除整个子树==========================================");

        System.out.println("删除前 前序遍历");
        binaryTree.preOrder();
        System.out.println("删除2号节点");
        binaryTree.DeleteNode(2);
        System.out.println("删除后 前序遍历");
        binaryTree.preOrder();

    }

}
