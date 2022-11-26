package 算法.搜索.单源最短路径;

import java.util.*;

class Node  implements Comparator<Node>{
    // 名称
    String name;

    // 所有从当前节点出发的航班信息
    ArrayList<Flight> trips = new ArrayList<>();

    // 最终算出从开始节点到该节点的总路径长度（总票价）
    int cost = Integer.MAX_VALUE; // 一开始为无穷大

    // 构造方法
    Node(String name) {
        this.name = name;
    }
    Node() {}
    //实现comparator升序排列，优先规则：从左到右，从小到大
    //小的返回-1
    @Override
    public int compare(Node o1, Node o2) {
        return o1.cost <= o2.cost ? -1 : 1;
    }
}

public class CheapestPriceSolution  {

    /**
     * 计算最便宜的机票总价钱
     * @param n 表示最多总共有n个城市
     * @param flights 所有航班信息，以对象数组给出，每个Flight对象表示一个航班数据（起点-终点-价格）
     * @param src 起点的名称
     * @param dst 终点的名称
     * @return 搜索一条路径可以从起点转乘一直飞到终点，并且机票总价格最小，输出最小机票价格
     */
    public int findCheapestPrice(int n, Flight[] flights, String src, String dst) {
        int ans = -1;

        // 首先对数据进行初始化的创建
        HashMap<String, Node> nodeMap = new HashMap<>(n);

        // 将数据初始化到nodeMap
        for (Flight fi : flights) {
            String name_start = fi.getStart(), name_end = fi.getEnd();
            if (!nodeMap.containsKey(name_start)) {
                Node node = new Node(name_start);
                nodeMap.put(name_start, node);
            }

            // 将flight添加到node里面
            nodeMap.get(name_start).trips.add(fi);

            if (!nodeMap.containsKey(name_end)) {
                Node node = new Node(name_end);
                nodeMap.put(name_end, node);
            }
        }

        //优先队列
        PriorityQueue<Node> pq=new PriorityQueue<>(new Node());

        //查看节点是否被访问
        Set<String> seen=new HashSet<>();


        //存储开始节点到某个节点的最短路径中，前一个节点是什么
        HashMap<String,String>  parent=new HashMap<>();

        // 初始化，将起点放入数组
        Node start_node = nodeMap.get(src);

        //首个节点无前置节点
        parent.put(src,null);


        // 存储某个节点到初始点的距离 cost默认Integer_MAX.开始节点为0
        start_node.cost = 0;

        //入队
        pq.add(start_node);

        while(pq.size() > 0){

              //当前顶点
            Node pair=pq.poll();
              //当前节点到开始节点的距离
            int dist=pair.cost;

            //当前节点
            String vertex=pair.name;
            //设置为已访问
            seen.add(vertex);

            //所有邻接节点
            ArrayList<Flight> trips = pair.trips;

            for(Flight i:trips){

                //遍历由vertex出发的所有邻接节点
                Node neighbor=nodeMap.get(i.getEnd());

                //查看是否被访问过
                if (!seen.contains(neighbor.name)){
                    //当前价格
                    int newPrice=dist+i.getPrice();
                    //计算价格
                    int oldPrice=neighbor.cost;

                     if(newPrice < oldPrice){
                         //入队
                         pq.add(neighbor);
                         //更新parent
                         parent.put(neighbor.name,vertex);
                         //更新价格
                         neighbor.cost=newPrice;
                     }
                }
            }

        }

        return nodeMap.get(dst).cost;
    }

    // 运行测试用例并输出结果
    void test(int n, String s, Object a, Object b) {
        String src, dst;
        Flight[] flights = Flight.readInput(s);
        if (a instanceof String) {
            src = (String)a;
            dst = (String)b;
        } else {
            src = FlightEX.convertToTitle((int)a);
            dst = FlightEX.convertToTitle((int)b);
        }

        // 计算最便宜票价
        int r = findCheapestPrice(n, flights, src, dst);
        
        // 输出计算结果
        System.out.printf("\n测试用例#%d:\n从起点【%s】飞往终点【%s】的最便宜价格为：%d\n", number++, src, dst, r);       
    }
    private static int number = 0;

    public static void main(String[] args) {
        CheapestPriceSolution sln = new CheapestPriceSolution();
        String s;

        // 测试用例0: (答案应该为2000)
        s = "[[广州,上海,1000],[上海,北京,1000],[广州,北京,5000]]";
        sln.test(3, s, "广州", "北京");

        // 测试用例1: (答案应该为56)
        s = "[[1,2,6],[2,3,43],[1,4,1],[2,4,11],[2,5,6],[4,5,12],[5,3,38],[1,6,50],[6,5,1],[5,7,24],[6,7,12],[3,8,8],[7,8,20]]";
        sln.test(8, s, 1, 8);

        // 测试用例2: (答案应该为125)
        s = "[[11,12,74],[1,8,91],[4,6,13],[7,6,39],[5,12,8],[0,12,54],[8,4,32],[0,11,4],[4,0,91],[11,7,64],[6,3,88],[8,5,80],[11,10,91],[10,0,60],[8,7,92],[12,6,78],[6,2,8],[4,3,54],[3,11,76],[3,12,23],[11,6,79],[6,12,36],[2,11,100],[2,5,49],[7,0,17],[5,8,95],[3,9,98],[8,10,61],[2,12,38],[5,7,58],[9,4,37],[8,6,79],[9,0,1],[2,3,12],[7,10,7],[12,10,52],[7,2,68],[12,2,100],[6,9,53],[7,4,90],[0,5,43],[11,2,52],[11,8,50],[12,4,38],[7,9,94],[2,7,38],[3,7,88],[9,12,20],[12,0,26],[10,5,38],[12,8,50],[0,2,77],[11,0,13],[9,10,76],[2,6,67],[5,6,34],[9,7,62],[5,3,67]]";
        sln.test(13, s, 10, 9);
    }
}
