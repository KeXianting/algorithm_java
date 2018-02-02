package test.exam_demo;

/**
 * Created by kentorvalds on 2017/11/12.
 */
public  class Quadrilateral {
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
