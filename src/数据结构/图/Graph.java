package 数据结构.图;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private ArrayList<String> vertexList; //存储顶点集合
    private  int [][] edges; //存储图对应的领接矩阵
    private  int numOfEdges; //表示边的数目
    private  boolean [] isVisited ; //记录节点是否被访问

    //初始化图
    public Graph(int n)
    {
        edges=new int[n][n];
        vertexList=new ArrayList<>(n);
        numOfEdges=0;
        isVisited=new boolean[n];
    }

    //得到第一个邻接节点的下标 w
    /**
     * index 如果存在则返回对应的下标，否则返回-1
     *
     * */
    public int getFirstNeighbor(int index)
    {
        for (int j = 0;j < vertexList.size(); j++) {
            if (edges[index][j]>0)
            {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点

    public int getNextNeighbor(int v1,int v2)
    {
        for (int j = v2+1; j < vertexList.size(); j++) {
            if (edges[v1][j]>0)
            {
                return j;
            }
        }
        return -1;
    }


    //深度优先遍历算法
    public void dfs(boolean [] isVisited,int i)
    {
        //首先，我们访问该节点
        System.out.println(getValueByIndex(i)+"->");

        //将节点设置为已经访问
        isVisited[i]=true;



        int w=getFirstNeighbor(i);
        while(w!=-1)
        {
            if (!isVisited[w])
            {
                dfs(isVisited,w);
            }

            //如果w节点已经被访问过
            w=getNextNeighbor(i,w);

        }


    }

    //深度优先算法的重载

        //对dfs进行一个重载，遍历所有的节点，并进行dfs
        public void dfs()
        {
            //遍历所有的节点，进行dfs回溯
            for (int i = 0; i < getNumOfVertex(); i++) {
                if (!isVisited[i])
                {
                    dfs(isVisited,i);
                }
            }
        }




    //插入节点
    public void insertVertex(String vertex)
    {
        vertexList.add(vertex);
    }

    /**
     *
     * @Param v1、v2 表示下标，即第几个节点
     * @Param weight表示权值
     *
     * */
    //插入邻接矩阵
    public void insertEdge(int v1,int v2,int weight)
    {
        //A-B有关系 ，则B与A有关系
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

    //返回节点的个数
    public int getNumOfVertex()
    {
        return vertexList.size();
    }

    //返回边的个数
    public int getNumOfEdges()
    {
        return  numOfEdges;
    }

    //返回节点i 对应的数值
    public String getValueByIndex(int i)
    {
        return  vertexList.get(i);
    }

    //返回v1和v2的权值
    public  int getWeight(int v1,int v2)
    {
        return  edges[v1][v2];
    }

    //显示图所对应的矩阵
    public  void showGraph()
    {
        for (int []  i :edges) {
            System.err.println(Arrays.toString(i));
        }
    }


    public static void main(String[] args) {
        int n=5;
        String vertexValue []={"A","B","C","D","E"};

        Graph graph=new Graph(n);

        //添加循环的节点
        for (String value: vertexValue) {
            graph.insertVertex(value);
        }

/**
 *    A B C D E (坐标0 1 2 3 4) weight默认1
 *  A
 *  B
 *  C
 *  D
 *  E
 * */

        //添加边A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        //显示
        graph.showGraph();


        //测试深度优先搜索
        System.out.println("深度遍历");
        graph.dfs(); //A->B->C->D->E

    }


}
