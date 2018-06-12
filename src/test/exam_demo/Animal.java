package test.exam_demo;

import java.time.Instant;

/**
 * Created by kentorvalds on 2018/4/1.
 */
public class Animal {
    public void eat(){
        System.out.println("animal eatting...");
    }





    public static void main(String[] args) {
        System.out.println(Instant.now());

//        Animal animal = new Cat(); //向上转型
//        animal.eat();
//
//        animal = new Dog();
//        animal.eat();



        //还是上面的animal和cat dog
//        Animal a = new Cat();
//        Cat c = ((Cat) a);
//        c.eat();
//输出  我吃鱼
       // Dog d = ((Dog) a);
       // d.eat();
// 报错 ： java.lang.ClassCastException：com.chengfan.animal.Cat cannot be cast to com.chengfan.animal.Dog
//        Animal a1 = new Animal();
//        Cat c1 = ((Cat) a1);
//        c1.eat();
    }

}
