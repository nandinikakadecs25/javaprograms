
abstract class Shape {
   int dim1;
   int dim2;
   Shape(int d1, int d2){
      dim1=1;
      dim2=2;
   }
   abstract void printArea();
}

class rectangle extends Shape{
    rectangle (int length,int breadth){
        super(length,breadth);
    }
    void printArea(){
        double area=dim1*dim2;
        System.out.println("area of rectangle:"+area);
    }
}

class triangle extends rectangle{
    triangle(int base,int height){
        super(base,height);
    }
    void printArea(){
        double area=0.5*dim1*dim2;
        System.out.println("area of triangle:"+area);
    }
}

class circle extends triangle{
    circle(int radius){
        super(radius,0);
    }
     void printArea(){
        double area=3.147159*dim1*dim2;
        System.out.println("area of circle:"+area);
    }
}
public class demo{
    public static void main(String args[] ){
        rectangle r =new rectangle(10, 5);
        triangle t =new triangle(10, 8);
       circle c=new circle(7);
       r.printArea();
       t.printArea();
       c.printArea();
    }
} 


