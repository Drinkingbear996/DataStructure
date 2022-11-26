package 算法.排序;


 class Dog {

     private  String name;
     private  int age;
     public String getName()
     {
         return  this.name;
     }// 获取狗狗的名字

     public int getAge()
     {
         return  this.age;
     }// 获取狗狗的年龄
     public Dog(String name, int age)
     {
         this.name=name;
         this.age=age;
     }// 构造方法

     @Override
     public String toString() {
         return "Dog{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }
 }
public class QuickSort {

  static   void Quick_Sort(Dog []dogs, int begin, int end){

      if(begin > end)
          return;
        Dog tmp = dogs[begin];
        int i = begin;
        int j = end;
        while(i != j){
            while(dogs[j].getAge() >= tmp.getAge() && j > i)
                j--;
            while(dogs[i].getAge() <= tmp.getAge() && j > i)
                i++;
            if(j > i){
                Dog t = dogs[i];
                dogs[i] = dogs[j];
                dogs[j] = t;
            }
        }
        dogs[begin] = dogs[i];
        dogs[i] = tmp;
        Quick_Sort(dogs, begin, i-1);
        Quick_Sort(dogs, i+1, end);
    }

    public static void main(String[] args) {

      Dog dog[]=new Dog[10];
        for (int i = 0; i < 10; i++) {
            dog[i]=new Dog("测试"+i,(int)(Math.random()*100+1));
        }
        Quick_Sort(dog,0, dog.length-1);


        for (int i = 0; i < dog.length; i++) {
            System.out.println(dog[i]);
        }
    }
}
