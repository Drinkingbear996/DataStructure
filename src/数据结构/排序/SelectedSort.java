package 数据结构.排序;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectedSort {
    public static void SelectSort( int a [])
    {

        //只用找a.length-1个元素
        for (int k = 0; k < a.length-1; k++) {

            //当前循环的首位最小
            int minIndex=k;
            int min=a[k];



            for (int i = k+1; i < a.length; i++) {
                //找最小值，求出对应的下标
                if (min>a[i])
                {
                    min=a[i];
                    minIndex=i;
                }

            }

            //最小值放前面 交换
            //如果当前位置不等于k，(因为每次都是和第k位交换,如果当前位置就是最小，就不用交换了）
            if (minIndex!=k)
            {
                a[minIndex]=a[k];
                a[k]=min;
            }

        }

    }

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Date date=new Date();

        String start=simpleDateFormat.format(date);
        System.out.println(start);

        int a[]=new int[80000];
        for (int i = 0; i < args.length; i++) {
            a[i]=(int)(Math.random()*80000);
        }

        SelectSort(a);

        Date date1=new Date();

        String end=simpleDateFormat.format(date1);
        System.out.println(end);

    }
}
