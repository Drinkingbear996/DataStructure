package 数据结构.稀疏数组;

public class SparseArray {
    public static void main(String[] args) {


        //创建一个含有3个有效数字的二维数组
        int array[] []=new int[10][10];

        array[8][2]=1;
        array[7][5]=2;
        array[6][8]=3;

        //得出有效个数
        int sum=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
               if (array[i][j]!=0)
               {
                   sum++;
               }
            }
        }

        //存入有效元素
        int Sparearray[] []=new int[sum+1][3];
        Sparearray[0][0]=10;
        Sparearray[0][1]=10;
        Sparearray[0][2]=sum;

        //计数器，存入有效元素的行和列进稀疏数组
        int count=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (array[i][j]!=0)
                {
                   count++;
                    Sparearray[count][0]=i;
                    Sparearray[count][1]=j;
                    Sparearray[count][2]=array[i][j];
                }
            }
        }

        //输出稀疏数组
        for (int i = 0; i < Sparearray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",Sparearray[i][0],Sparearray[i][1],Sparearray[i][2]);
        }



//-------------------------------------------------------------------

   //读取稀疏数组的第一行，根据第一行，创建最原始的数组
    int recoverArray[][]=new int[Sparearray[0][0]][Sparearray[0][1]];

        for (int i = 1; i < Sparearray.length; i++) {
            recoverArray[Sparearray[i][0]][Sparearray[i][1]]=Sparearray[i][2];

        }
        System.out.println("=======================================");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }




    }

}
