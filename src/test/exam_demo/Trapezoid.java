package test.exam_demo;

/**
 * Created by kentorvalds on 2017/11/12.
 */
public class Trapezoid extends Quadrilateral {

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
