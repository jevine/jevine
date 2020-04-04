public class demo2 {
    public static void main(String[] args)
    {
   Teacher t=new Teacher("zhang");
    try{t.prelect();}
    catch(NoPlanException e){
        System.out.println(e.toString());
        System.out.println("change one");
    }
    }
}
class LanpingException extends Exception{
    LanpingException(){
        super();
    }
    LanpingException(String messages){
        super(messages);
    }
}
class MaoyanException extends Exception{
    MaoyanException(){
        super();
    }
    MaoyanException(String messages){
        super(messages);
    }
}
class NoPlanException extends Exception{
    NoPlanException(String messages){
        super(messages);
    }
}
class Computer{
    private int n=2;
    public void run()throws LanpingException,MaoyanException{
        System.out.println("computer run");
        if(n==1)
            throw new LanpingException("lanping");
            if (n==2)
                throw new MaoyanException("maoyan");
        }


    public void reset(){
        System.out.println("reset");
        n=0;
    }
}
class Teacher{
    private Computer com;
    private String name;
    Teacher(String name){
        com=new Computer();
        this.name=name;
    }
    public void prelect() throws NoPlanException
    {
        try{com.run();
            System.out.println("jiangke");
            }
        catch(LanpingException e){
            System.out.println(e.toString());
            com.reset();
            prelect();
        }
        catch(MaoyanException e){
            System.out.println(e.toString());
            test();
            throw new NoPlanException("wufanwancheng because"+e.getMessage());

        }

    }
    void test(){
        System.out.println("study by yourself");
    }

}

