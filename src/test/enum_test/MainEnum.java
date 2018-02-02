package test.enum_test;

import java.util.EnumSet;

/**
 * Created by kentorvalds on 2017/6/22.
 */
public class MainEnum {

    public static void main(String[] arg){
        EnumTest color = EnumTest.BLANK;
        switch (color){
            case RED:
                System.out.println("red");
                break;
            case BLANK:
                System.out.println("blank");
                break;
            case GREEN:
                System.out.println("green");
                break;
            case YELLOW:
                System.out.println("yellow");
                break;
            default:
                break;
        }


        //枚举类的鼓噪函数
        EnumTest test = EnumTest.GREEN;
        System.out.println("========构造函数:");
        test.testConstructor();



        for (EnumTest t:EnumTest.values()){
            //t.name()调用枚举类的方法, t.getName()方法得到枚举类实例的属性值
            System.out.println("name:" + t.name() + "序号: " + t.ordinal() + "对应值下标" + t.getIndex() + "对应值:" + t.getName());
        }

        EnumSet<EnumTest> enumTests = EnumSet.allOf(EnumTest.class);
        for (EnumTest t1:enumTests){
            //调用toString()方法
            System.out.println("当前的enumTests的数据为: " + t1);
        }

        //自定义的static方法, 可以用枚举类直接调用
        System.out.println(EnumTest.getName(3));


        //自定义toString()方法
        System.out.println(EnumTest.BLANK.toString());

        //自定义getSpeColor()方法
        System.out.println(EnumTest.BLANK.getSpeColor());
        System.out.println(EnumTest.GREEN.getSpeColor());


        //实例中自定义abstract方法
        System.out.println(EnumTest.RED.getColorName());
        System.out.println(EnumTest.GREEN.getColorName());
        System.out.println(EnumTest.BLANK.getColorName());
        System.out.println(EnumTest.YELLOW.getColorName());


        //实例中自定义非abstract方法
        System.out.println("kkkk: ");
        System.out.println(EnumTest.RED.colorTest());
        System.out.println(EnumTest.GREEN.colorTest());
    }

}
