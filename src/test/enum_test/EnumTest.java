package test.enum_test;

/**
 * Created by kentorvalds on 2017/6/22.
 */
//可以实现接口
public enum EnumTest {
    //自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。而且 Java 要求必须先定义 enum 实例
    RED("红色", 1){
        //abstract方法必须在每个实例中实现
        public String getSpecName(){
            return "这是红色";
        }

        public String colorTest(){
            return "red非abstract方法";
        }
    },
    GREEN("绿色", 2){
        public String getSpecName(){
            return "这是绿色";
        }
        public String colorTest(){
            return "green非abstract方法";
        }
    },
    BLANK("白色", 3){
        public String getSpecName(){
            return "这是白色";
        }
    },
    YELLOW("黄色", 4){
        public String getSpecName(){
            return "这是黄色";
        }
    };

    // 成员变量: 四种颜色对应的四个实例, name="红色, index=1;
    private String name;
    private int index;


    // 构造方法
     EnumTest(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (EnumTest c : EnumTest.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }



    //覆盖方法
    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }


    //自定义方法
    public String getSpeColor(){
        return "hello world";
    }

   // public String getSpecName(){throw new AbstractMethodError();};
    abstract String getSpecName();
    //自定义方法调用实例中的方法
    public String getColorName(){

        return getSpecName();
    }

    //实例中的非abstract方法
    public String colorTest(){throw new AbstractMethodError();};


    public void testConstructor(){
        System.out.println("构造函数的name: " + this.name);
    }


    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }


}
