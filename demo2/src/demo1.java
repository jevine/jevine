public class demo1 {
    public static void main(String[] args ){
        demo d=new demo();
        try{d.div(4,-1);}
        catch(Exception e){
            System.out.println(e.toString());
    }
}
}
class FushuException extends RuntimeException{
    FushuException(String message){
     super(message);
    }
}
class demo{
    int div (int a,int b){
        if(b<0){
            throw new FushuException("cuowu");
        }
        return a/b;
    }


}