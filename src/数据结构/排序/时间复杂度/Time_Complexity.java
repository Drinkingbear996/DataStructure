package 数据结构.排序.时间复杂度;

public class Time_Complexity {

    public void O_log2N()
    {
        int i=1;
        int n=1024;
        while(i<=n)
        {
            i=i*2;
        }
    }

    //线性对数阶
    public void O_Nlog2N()
    {
        int m=1024;
        int n=1;

        for (int i = 0; i < m; i++) {

            while(n<m)
            {
                n=n*2;
            }

        }
    }

    public static void main(String[] args) {

    }
}
