package test.exam_demo;

/**
 * Created by kentorvalds on 2017/11/12.
 */
public class Test {
    public static void main(String[] args){
        Quadrilateral quadrilateral = new Quadrilateral(1.1, 1.2, 6.6,2.8,6.2,9.9,2.2,7.4);
        quadrilateral.print();

        Trapezoid trapezoid = new Trapezoid(0.0, 0.0, 10.0,0.0,8.0,5.0,3.3,5.0);
        trapezoid.print();

        Paralelogram paralelogram = new Paralelogram(5.0,5.0,11.0,5.0,12.0,20.0,6.0,20.0);
        paralelogram.print();

        Rectangle rectangle = new Rectangle(17.0,14.0,30.0,14.0,0.0,28.0,17.0,28.0);
        rectangle.print();

        Square square = new Square(4.0,0.0,8.0,0.0,8.0,4.0,4.0,4.0);
        square.print();
    }
}
