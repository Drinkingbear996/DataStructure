package 算法.搜索;

/**
 * 参考文章:https://blog.csdn.net/qq_37482202/article/details/89513877
 *      BFS
 *      特点：它并不考虑结果的可能位置，彻底地搜索整张图，直到找到结果为止（一层层的遍历）
 *
 *

 *
 *      可以解决：
 *              第一类问题：从节点A出发，有前往节点B的路径吗？（在你的人际关系网中，有芒果销售商吗？）
 *              第二类问题：从节点A出发，前往节点B的哪条路径最短？（哪个芒果销售商与你的关系最近？）
 *
 *
 *              编写国际跳棋AI，计算最少走多少步就可获胜；
 *              编写拼写检查器，计算最少编辑多少个地方就可将错拼的单词改成正确的单词，如将READED改为READER需要编辑一个地方；
 *              根据你的人际关系网络找到关系最近的医生。
 *
 *
 *
 *
 *
 *      思路：先搜索你，如果不是目标，搜索你的朋友，在搜索你朋友的朋友，
 *
 *      BFS中存在一度关系，2度关系，----> N度关系
 *      因为BFS有层序遍历的思想，一层层的搜索，所以我们用队列存储每一个节点
 *       `1
 *
 *       \\
 *
 *      如果队列为空则表明无此元素。
 *      那如果你是A，B是你的朋友，C是A的朋友也是B的朋友，就会陷入无限循环，因此用一个列表记录访问过的节点
 *
 *      实际代码：
 *
 *      HashMap<String,String[]> hashMap=new HashMap<>();  运用散列表hashmap来记录你映射到所有节点。形成图。
 *
 *      List<String> hasSearchList = new ArrayList<>();
 *      利用hasSearchList.contains()，查看每次寻找的节点是否被访问过，防止死循环
 *
 *      node表示每一个节点，id:节点名  parent：他的上一级
 *
 *      Queue:先将1度关系放入队列中查找。
 *
 *
 *
 *
 *
 *
**/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class BFS {


    public static void main(String[] args) {
        //添加每一个人以及他的朋友 构造图;

        HashMap<String,String[]> hashMap=new HashMap<>();
        hashMap.put("YOU",new String[]{"CLAIRE","ALICE","BOB"});
        hashMap.put("CLAIRE",new String[]{"YOU","JONNY","THON"});
        hashMap.put("JONNY",new String[]{"CLAIRE"});
        hashMap.put("THOH",new String[]{"CLAIRE"});
        hashMap.put("ALICE",new String[]{"YOU","PEGGY"});
        hashMap.put("BOB",new String[]{"YOU","PEGGY","ANUJ"});
        hashMap.put("PEGGY",new String[]{"BOB","ALICE"});
        hashMap.put("ANUJ",new String[]{"BOB"});
        Node target = findTarget("YOU","ANUJ",hashMap);
        //打印出最短路径的各个节点信息
        printSearPath(target);
    }

    /**
     * 打印出到达节点target所经过的各个节点信息
     * @param target
     */
    static void printSearPath(Node target) {
        if (target != null) {
            System.out.print("找到了目标节点:" + target.id + "\n");

            List<Node> searchPath = new ArrayList<Node>();
            searchPath.add(target);
            Node node = target.parent;
            while(node!=null) {
                searchPath.add(node);
                node = node.parent;
            }
            String path = "";
            for(int i=searchPath.size()-1;i>=0;i--) {
                path += searchPath.get(i).id;
                if(i!=0) {
                    path += "-->";
                }
            }
            System.out.print("步数最短："+path);
        } else {
            System.out.print("未找到了目标节点");
        }
    }

    static Node findTarget(String startId,String targetId,HashMap<String,String[]> map) {

        List<String> hasSearchList = new ArrayList<>();

        LinkedBlockingQueue<Node> queue=new LinkedBlockingQueue<>();

        queue.offer(new Node(startId,null));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(hasSearchList.contains(node.id)) {
                continue;
            }
            System.out.print("判断节点:" + node.id +"\n");
            if (targetId.equals(node.id)) {
                return node;
            }
            hasSearchList.add(node.id);
            //添加某一个节点的所有朋友
            String friendCount[]=map.get(node.id);

            if (friendCount != null && friendCount.length > 0) {
                for (String childId : friendCount) {
                    queue.offer(new Node(childId,node));
                }
            }
        }
        return null;
    }

    static class Node{
        public String id;
        public Node parent;
        public Node(String id,Node parent) {
            this.id = id;
            this.parent = parent;
        }
    }
}