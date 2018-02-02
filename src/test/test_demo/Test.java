package test.test_demo;

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

class Quadrilateral {
    public double x1;
    public double y1;
    public double x2;
    public double y2;
    public double x3;
    public double y3;
    public double x4;
    public double y4;

    public Quadrilateral(double x1, double y1, double x2, double y2,double x3, double y3,double x4, double y4){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
    }
    public Quadrilateral(){

    }

    public void print(){
        System.out.println("Coordinates of Quadrilateral are " + "(" + this.x1 + ", " + this.y1 + ")" + ", "
                + "(" + this.x2 + ", " + this.y2 + ")" + ", "
                + "(" + this.x3 + ", " + this.y3 + ")" + ", "
                + "(" + this.x4 + ", " + this.y4 + ")" + ", ");
    }

}

class Trapezoid extends Quadrilateral {

    public Trapezoid(double x1, double y1, double x2, double y2,double x3, double y3,double x4, double y4){
        super(x1,y1,x2,y2,x3,y3,x4,y4);
    }
    public Trapezoid(){

    }

    public void print(){

        System.out.println("Coordinates of Trapezoid are" + "(" + this.x1 + ", " + this.y1 + ")" + ", "
                + "(" + this.x2 + ", " + this.y2 + ")" + ", "
                + "(" + this.x3 + ", " + this.y3 + ")" + ", "
                + "(" + this.x4 + ", " + this.y4 + ")" + ", "
                + "Height is : " + (this.y3-this.y1) + "Area is : " + (this.x3-this.x4 + this.x2-this.x1)*(this.y3-this.y1)/2);
    }
}
class Paralelogram extends Trapezoid {

    public Paralelogram(double x1, double y1, double x2, double y2,double x3, double y3,double x4, double y4){
        super(x1,y1,x2,y2,x3,y3,x4,y4);
    }
    public Paralelogram(){

    }
    public void print(){

        System.out.println("Coordinates of Paralelogram are" + "(" + this.x1 + ", " + this.y1 + ")" + ", "
                + "(" + this.x2 + ", " + this.y2 + ")" + ", "
                + "(" + this.x3 + ", " + this.y3 + ")" + ", "
                + "(" + this.x4 + ", " + this.y4 + ")" + ","
                + "Width is : " + (this.x2-this.x1) + "Height is :" + (this.y3-this.y1)
                + "Area is : " + (this.x2-this.x1)*(this.y3-this.y1));
    }
}

class Rectangle extends Paralelogram {

    public Rectangle(double x1, double y1, double x2, double y2,double x3, double y3,double x4, double y4){
        super(x1,y1,x2,y2,x3,y3,x4,y4);
    }
    public void print(){

        System.out.println("Coordinates of Rectangle are" + "(" + this.x1 + ", " + this.y1 + ")" + ", "
                + "(" + this.x2 + ", " + this.y2 + ")" + ", "
                + "(" + this.x3 + ", " + this.y3 + ")" + ", "
                + "(" + this.x4 + ", " + this.y4 + ")" + ","
                + "Width is : " + (this.x2-this.x1) + "Height is :" + (this.y3-this.y1)
                + "Area is : " + (this.x2-this.x1)*(this.y3-this.y1));
    }
}

class Square extends Paralelogram {
    public Square(double x1, double y1, double x2, double y2,double x3, double y3,double x4, double y4){
        super(x1,y1,x2,y2,x3,y3,x4,y4);
    }
    public void print(){

        System.out.println("Coordinates of Square are" + "(" + this.x1 + ", " + this.y1 + ")" + ", "
                + "(" + this.x2 + ", " + this.y2 + ")" + ", "
                + "(" + this.x3 + ", " + this.y3 + ")" + ", "
                + "(" + this.x4 + ", " + this.y4 + ")" + ","
                + "Side is : " + (this.x2-this.x1) + "Area is : " + (this.x2-this.x1)*(this.y3-this.y1));
    }
}