package test.compare_compareTo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by kentorvalds on 2017/6/28.
 */
/*
1.compareTo(Object o)方法是java.lang.Comparable<T>接口中的方法，当需要对某个类的对象进行排序时，
  该类需要实现Comparable<T>接口的，必须重写public int compareTo(T o)方法，
  比如MapReduce中Map函数和Reduce函数处理的 <key,value>,其中需要根据key对键值对进行排序，
  所以，key实现了WritableComparable<T>接口，实现这个接口可同时用于序列化和反序列化。
  WritableComparable<T>接口(用于序列化和反序列化)是Writable接口和Comparable<T>接口的组合；
2.compare(Object o1,Object o2)方法是java.util.Comparator<T>接口的方法，它实际上用的是待比较对象的compareTo(Object o)方法。
 */
public class CompareTest {
    //编写Comparator,根据User的id对User进行排序
    private static final Comparator<User> COMPARATOR = new Comparator<User>() {
        public int compare(User o1, User o2) {
            return o1.compareTo(o2);//运用User类的compareTo方法比较两个对象
        }
    };

    public static void main(String[] args) {
        ArrayList<User> student = new ArrayList<User>();
        User user1 = new User(3,"yueliming");
        User user2 = new User(2,"yueliming");
        student.add(user1);
        student.add(user2);
        Collections.sort(student, COMPARATOR);//用我们写好的Comparator对student进行排序
        for(int i=0;i<student.size();i++){
            System.out.println(student.get(i).getId());
        }

        ArrayList<User> student1 = new ArrayList<User>();
        User user3 = new User(4,"ke");
        User user4 = new User(3,"nan");
        User user5 = new User(5,"ko");
        student1.add(user3);
        student1.add(user4);
        student1.add(user5);

        student1.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o2.getId()>= o1.getId()){
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        System.out.println("=======================");
        for(int i=0;i<student1.size();i++){
            System.out.println(student1.get(i).getId());
        }
    }
}
