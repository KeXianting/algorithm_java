package test;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by kentorvalds on 2017/7/13.
 */
public class DeepOrShallowCopy implements Cloneable {

    private int id;
    private String name;
    private Vector courses;

    public DeepOrShallowCopy(){
        try{
            Thread.sleep(1000);
            System.out.println("DeepOrShallowCopy Construnctor called");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public Vector getCourses(){
        return courses;
    }
    public void setCourses(Vector courses){
        this.courses=courses;
    }

    public DeepOrShallowCopy newInstance(){   //使用clone()创建对象，浅拷贝
        try{
            return (DeepOrShallowCopy)this.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }

    public DeepOrShallowCopy deepClone(){     //使用clone()创建对象，深拷贝
        try{
            DeepOrShallowCopy cloning = (DeepOrShallowCopy) super.clone();
//              Student cloning = (Strdent) this.clone();   //和上一句话效果等价
            cloning.courses = new Vector();     //关键点：非基本数据类型的空间需要自己新开辟一块儿
            return cloning;
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] arg){
        int[] a = {1,2,3,4,5,8};
//        arrayCopyTest(a); //数组的深拷贝
//        for (int i = 0; i < a.length; i++){
//            System.out.print(" " + a[i]);
//        }



        DeepOrShallowCopy stu1 = null;

        shallowCopyDemo(stu1);
        System.out.println("----- ----- -----I'm cut-off rule----- ----- -----");
        deepCopyDemo(stu1);
    }

    public static void arrayCopyTest(int[] a){
        //利用Arrays.copyOf进行深拷贝
        int[] b = Arrays.copyOf(a, a.length + 3);
        b[2] = 100;
        for (int i = 0; i < b.length; i ++){

            System.out.println(b[i]);
        }
    }


    public static void shallowCopyDemo(DeepOrShallowCopy stu1) {
        stu1=new DeepOrShallowCopy();
        Vector cs=new Vector();
        cs.add("Java");
        stu1.setId(1);
        stu1.setName("Tom");
        stu1.setCourses(cs);

        DeepOrShallowCopy stu2=stu1.newInstance();
        stu2.setId(2);
        stu2.setName("Mary");
        stu2.getCourses().add("C#");

        System.out.println("stu1'name:"+stu1.getName());
        System.out.println("stu2'name:"+stu2.getName());
        System.out.println(stu1.getCourses()==stu2.getCourses());
        System.out.println(stu1.getName() + "'s course: " + stu1.getCourses());
        System.out.println(stu2.getName() + "'s course: " + stu2.getCourses());
    }

    public static void deepCopyDemo(DeepOrShallowCopy stu1) {
        stu1=new DeepOrShallowCopy();
        Vector cs=new Vector();
        cs.add("Java");
        stu1.setId(1);
        stu1.setName("Tom");
        stu1.setCourses(cs);

        DeepOrShallowCopy stu2=stu1.deepClone();
        stu2.setId(2);
        stu2.setName("Mary");
        stu2.getCourses().add("C#");

        System.out.println("stu1'name:"+stu1.getName());
        System.out.println("stu2'name:"+stu2.getName());
        System.out.println(stu1.getCourses()==stu2.getCourses());
        System.out.println(stu1.getName() + "'s course: " + stu1.getCourses());
        System.out.println(stu2.getName() + "'s course: " + stu2.getCourses());
    }
}
