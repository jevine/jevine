public class ResourceDemo {
    public static void main(String[] args) {
        Resource r=new Resource();
        Input in=new Input(r);
        Output out=new Output(r);
        Thread t1=new Thread(in) ;
        Thread t2=new Thread(out);
        t1.start();
        t2.start();

    }
}
class Resource {
    private String name;
     private String sex;
     boolean flag=false;
     synchronized void set(String name,String sex){
         if (flag)
             try{this.wait();} catch (InterruptedException e){}
         this.name=name;
         this.sex=sex;
         flag=true;
         this.notify();
     }
     synchronized void get(){
         if (!flag)
             try{this.wait();} catch (InterruptedException e){}
         System.out.println(name+"....."+sex);
         flag=false;
         this.notify();
     }
}
class Input implements Runnable{
    private Resource r;
    Input(Resource r){
        this.r=r;
    }
   public void run(){
       int x=0;int n=100;
       while(n-->0){
         synchronized (r){
           if (x==0){
               r.set("小坤","男");
           }
           else{
               r.set("july","female");
           }
    } x=(x+1)%2;
       }
    }

}
class Output implements Runnable{
    private Resource r;
    int n=100;
    Output(Resource r){
        this.r=r;
    }
    public void run(){
        while(n-->0)
            r.get();
    }
}
