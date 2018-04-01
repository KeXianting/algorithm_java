package test.string;

/**
 * Created by kentorvalds on 2018/3/17.
 */
public class StringDemo {

    public static void main(String[] args){
//        System.out.println("=================1=====================");
//        String str2 = "SEUCalvin";//新加的一行代码，其余不变
//        String str1 = new String("SEU")+ new String("Calvin");
//        System.out.println(str1.intern() == str1);
//        System.out.println(str1 == "SEUCalvin");
//        System.out.println("=================2=====================");
//
//        String str3 = new String("SEU")+ new String("Calvin");
//        System.out.println(str3.intern() == str3);
//        System.out.println(str3 == "SEUCalvin");
//        System.out.println("===============3=======================");


        //why???????
//        String s1 = new StringBuilder("go")
//                .append("od").toString();
//        System.out.println(s1.intern() == s1);
//        System.out.println("==============4========================");
//        String s2 = new StringBuilder("ja")
//                .append("va").toString();
//        System.out.println(s2.intern() == s2);
//
//        System.out.println("===============5=======================");

        //String s = new String("1"):生成了两个对象, 一个是堆中的"1"对象,另外一个常量池中的对象;
        //s.intern创建常量池对象,发现常量池中已经有"1"了,就不在创建;
        //s2发现常量池中有"1",直接指向"1";
        //由于s是堆中对象, s2是常量池中对象,所以为false
        //JDK6:false,因为s为堆中对象,而s2位常量池对象,二者地址不同
//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);
//
//        //JDK1.7以上, 常量池移入Java堆中, s3创建对象后, 首先在常量池中创建"1", 并且创建"11"对象,s3指向"11"的引用,此时常量池中没有"11";
//        //s3.intern()后, 由于JDK7以后常量池移入堆中,此时因为堆中存有"11",所以此时常量池"11"直接指向s3的地址引用;
//        //s4指向常量池中的"11",所以此时s3和s4都指向同一个引用.
        //JDK6:false;因为s3位堆中对象,而s4为常量池中对象, JDK6以前常量池存放在方法区中的永久区(Perm 区)中, 所以二者指向不同的地址
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);

        //JDK1.7以上,String s = new String("1"):此处创建两个对象, 一个堆里的对象,s指向; 另外一个在常量池中的对象;
        //s2="1"指向常量池中的"1";
        //s.intern()把s指向常量池,此时由于new String("1")已经在常量池中创建对象"1",所以此条语句没有实际作用;
        //最终s指向堆中的"1",而s2指向常量池,因此是false
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        //String s3 = new String("1") + new String("1");在常量池中创建"1",在堆中创建"11"对象;
        //String s4 = "11"在常量池中创建;
        //因为此时常量池中已经有"11"了,因此s3.intern不起作用
        //s3位堆中对象, s4指向常量池, 所以为false
        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);



        System.out.println(new StringDemo().find(6));

    }

    int find(int n){
        if (n <= 0){
            return 0;
        }else if(n > 0 && n <= 2){
            return 1;
        }
        return find(n-1)+find(n-2);
    }
}
