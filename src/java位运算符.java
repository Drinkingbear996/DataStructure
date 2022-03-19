public class java位运算符 {
    /**

     java中有三种移位运算符

>>>是无符号右移，忽略符号位，空位都以0补齐
>>>：无符号右移，忽略符号位，空位都以0补齐

<<：左移运算符，num << 1,相当于num乘以2
>>：右移运算符，num >> 1,相当于num除以2


    */

        static int num = 0;
        public static void main(String[] args) {
            int number = -100;
            System.out.println("原始:    "+Integer.toBinaryString(number));
            System.out.println("左移:    "+Integer.toBinaryString(number << 4));
            System.out.println("右移:    "+Integer.toBinaryString(number >> 4));
            System.out.println("无符号右移:"+Integer.toBinaryString(number >>> 4));

//            原始:    11111111111111111111111110011100
//            左移:    11111111111111111111100111000000
//            右移:    11111111111111111111111111111001
//            无符号右移:1111111111111111111111111001

    }
}
