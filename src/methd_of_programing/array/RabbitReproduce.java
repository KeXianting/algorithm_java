package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/10/26.
 * 如果有一对小兔，每一个月都生下一对小兔，
 * 而所生下的每一对小兔在出生后的第三个月也都生下一对小兔。
 * 那么，由一对兔子开始，满一年时一共可以繁殖成多少对兔子？(兔子没有死亡)
 *
 * Fibonacci数列问题
  用列举的方法可以很快找出本题的答案：
 第一个月，这对兔子生了一对小兔，于是这个月共有2对（1+1=2）兔子。
 第二个月，第一对兔子又生了一对兔子。因此共有3对（1+2=3）兔子。
 到第三个月，第一对兔子又生了一对小兔而在第一个月出生的小兔也生下了一对小兔。所以，这个月共有5对（2+3=5）兔子。
 到第四个月，第一对兔子以及第一、二两个月生下的兔子也都各生下了一对小兔。因此，这个月连原先的5对兔子共有8对（3+5=8）兔子。
 */
public class RabbitReproduce {

    public static void main(String[] args){
        int n = 13;

        System.out.println("递归法: " + Fibonacci.fibonacciMethod1(n));

        System.out.println("递推法: " + Fibonacci.fibonacciMethod2(n));
    }

}
