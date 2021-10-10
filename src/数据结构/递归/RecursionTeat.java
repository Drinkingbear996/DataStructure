package 数据结构.递归;
/**
 * 递归：
 *   自己调用自己
 * */
public class RecursionTeat {
    //打印问题
  public static void test(int n)
  {
      if (n>2)
      {
          test(n-1);
      }

      System.out.println("n="+n);
  }

  //阶层问题
    public static  int factorial(int n)
    {
        if (n==1)
        {
            return  1;
        }
      return  factorial(n-1)*n;
    }


    public static void main(String[] args) {

//      test(10);
        System.out.println(factorial(3));

        for (int i = 0,j=0; i < 100; i++) {

        }



    }
}
