package 数据结构.排序;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

    public static  void BubblingSort(int  a[])
    {

        //中间容器，用于交换值
        int temp=0;
        //排序
        int m=a.length-1;
        //判断是否有交换
        boolean flag=false;

        while(m>0)
        {
            for (int i = 0; i <m; i++) {

                //第一趟排序
                if (a[i]>a[i+1])
                {
                    temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    flag=true;
                }

            }
            m--;
            //一次都没有交换过
            if (flag==false)
            {
                break;
            }
            //重置
            else
            {
                flag=false;
            }

        }


    }

    public static void main(String[] args) {
        int a[] = new int[]{3, 9, 5, 8, 1, 4, 6, 2};

        //测试冒泡排序的时间，给8w个数据

        int arr[]=new int[80000];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*80000); //[0,800000)

        }

        //格式化
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        Date date = new Date();

        String StartTime=simpleDateFormat.format(date);
        System.out.println(StartTime);

        //测试
        BubbleSort.BubblingSort(arr);

        Date date1 =new Date();
        String EndTime=simpleDateFormat.format(date1);
        System.out.println(EndTime);



    }
}
