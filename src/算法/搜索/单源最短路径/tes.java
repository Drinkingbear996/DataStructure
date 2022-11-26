package 算法.搜索.单源最短路径;
import java.util.*;
public class tes {

    public int findCheapestPrice(int n, Flight[] flights, String src, String dst) {
        int ans = -1;

        // 请补充完整程序代码
        // TODO ...
        int[][] G = new int[n][n];
        int[] dist = new int[n];
        boolean flag[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j){
                    G[i][j]=0;
                }else{
                    G[i][j]=100000;
                }
            }
        }
        Set<String> pointSet = new HashSet<>();
        Map<String,Integer> pointMap = new HashMap<>();
        int m = 0;
        for (Flight flight : flights) {
            pointSet.add(flight.getStart());
            pointSet.add(flight.getEnd());
        }

        for (String s : pointSet) {
            pointMap.put(s,m++);
        }

        for (Flight flight : flights) {
            String start = flight.getStart();
            String end = flight.getEnd();
            int price = flight.getPrice();
            G[pointMap.get(start)][pointMap.get(end)]=price;
        }


        for(int i=0;i<dist.length;i++){
            dist[i]=G[pointMap.get(src)][i];
        }
        flag[pointMap.get(src)]=true;
        dist[pointMap.get(src)]=0;


        for(int i=0;i<n;i++){
            int temp = 100000;
            int small = pointMap.get(src);

            for (int j = 0; j < n; j++) {
                if(!flag[j]&&dist[j]<temp){

                    small=j;
                    temp=dist[j];
                }
            }

            flag[small]=true;


            for (int j = 0; j < n; j++) {
                if(!flag[j] && dist[j]>dist[small]+G[small][j]){
                    dist[j]=dist[small]+G[small][j];
                }
            }
        }
        return dist[pointMap.get(dst)];


    }
    }