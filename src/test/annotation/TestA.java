package test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by kentorvalds on 2017/10/12.
 * //@Interface: 自定义注解类
 * 注释中的每一个方法定义了这个注释类型的一个元素，注释中方法的声明中一定不能包含参数，
 * 也不能抛出异 常；方法的返回值被限制为简单类型、String、Class、emnus、注释，和这些类型的数组。方法可以有一个缺省值。
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestA {
    String name();
    int id() default 0;
    Class<Long> gid();
}
