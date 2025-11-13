import java.util.Scanner;
class quadratic{
    public static void main(String args[]){
        Scanner obj =new Scanner(System.in);
        double a,b,c,disc;
        double r1 ,r2;
        System.out.println("enter value of a:");
        a=obj.nextDouble();
        System.out.println("enter value of b:");
        b=obj.nextDouble();
        System.out.println("enter value of c:");
        c=obj.nextDouble();
        disc=b*b-4*a*c;
        if(disc>0){
            r1=(-b+ Math.sqrt(disc))/(2*a);
            r2=(-b- Math.sqrt(disc))/(2*a);
            System.out.println("roots are real and different");
            System.out.println("root1"+r1);
            System.out.println("root2"+r2);


        }
        else if (disc==0) {
            r1=-b/(2*a);
           System.out.println("roots are real and equal"); 
           System.out.println("root1"+r1);
        }else{
            System.out.println(" no roots are discriminant is negative"); 
        }



    }
}
