public class demo3 {
    public static void main(String[] args){
        circle c=new circle();System.out.println(c.area(7,3));
       /* try{  ;}
        catch(ShuxiaoException e){
            System.out.println(e.toString());}*/



    }

}
class ShuxiaoException extends RuntimeException{
    ShuxiaoException(String mes){
        super(mes);
    }
}
interface Area{
double area(double a,double b);
}
class circle implements Area{
    double s;

    public double area(double a, double b) //当继承RuntimeException时，
    // 不需要throws ShuxiaoException
     {
        if (a > 0 && b > 0) {
            if (a == b) {
                s = a * b * 3.14;
                System.out.println("circle");
            } else{ s = a * b;
                System.out.println("rectangle");}

            return s;
        }
        else{
            throw new ShuxiaoException("shuzhiyouwenti");
        }

    }

}