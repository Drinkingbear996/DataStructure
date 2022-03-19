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
    //走台阶

   static int f(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return f(n-1) + f(n-2);
    }


    public static void main(String[] args) {

        System.out.println(f(6));



    }
}
