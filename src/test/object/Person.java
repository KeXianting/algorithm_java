package test.object;

import java.io.Serializable;

/**
 * Created by kentorvalds on 2017/6/19.
 */
public class Person implements Serializable {
    /**
          * 序列化ID: 凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量
     *     如果没有ID, 修改Person的内容,都会导致序列化失败,由于没有显指定 serialVersionUID，
     *     编译器又为我们生成了一个UID，当然和前面保存在文件中的那个不会一样了，于是就出现了2个序列化版本号不一致的错误。
     *     因此，只要我们自己指定了serialVersionUID，就可以在序列化后，去添加一个字段，或者方法，
     *     而不会影响到后期的还原，还原后的对象照样可以使用，而且还多了方法或者属性可以用。
     *
     *
     *
     *     serialVersionUID的取值是Java运行时环境根据类的内部细节自动生成的。如果对类的源代码作了修改，再重新编译，
     *     新生成的类文件的serialVersionUID的取值有可能也会发生变化。
     　　类的serialVersionUID的默认值完全依赖于Java编译器的实现，对于同一个类，
     用不同的Java编译器编译，有可能会导致不同的 serialVersionUID，也有可能相同。
     为了提高serialVersionUID的独立性和确定性，强烈建议在一个可序列化类中显示的定义serialVersionUID，为它赋予明确的值。
          */
        private static final long serialVersionUID = -5809782578272943999L;
        private int age;
        private String name;
        private String sex;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
