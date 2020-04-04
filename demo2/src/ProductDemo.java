import java.util.concurrent.locks.*;
public class ProductDemo {
    public static void main(String[] args) {
        Resource1 r=new Resource1();
        Product p1=new Product(r);
        Consume c1=new Consume(r);
        Thread t1=new Thread(p1);
        Thread t2=new Thread(p1);
        Thread t3=new Thread(c1);
        Thread t4=new Thread(c1);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


}
class Resource1{
    private String name;
    private int count=1;
    private boolean flag=false;
    Lock lock=new ReentrantLock();
    Condition con1=lock.newCondition();
    Condition con2=lock.newCondition();
    public void set(String name){
        lock.lock();
        try{
            while(flag)
               // try{lock.wait();}catch (InterruptedException e){}
            try{con1.await();}catch (InterruptedException e){}
            this.name=name+count;
                count++;
            System.out.println(Thread.currentThread().getName()+"" +
                    "shengchang"+this.name);
            flag=true;
            con2.signal ();}
        finally {lock.unlock();
        }
    }
    public void get(){
        lock.lock();
        try{
            while(!flag)
                try{con2.await();}catch (InterruptedException e){}
            System.out.println(Thread.currentThread().getName()+"" +
                    "xiaofei"+this.name);
            flag=false;
            //notifyAll();
            con1.signal();}
        finally {lock.unlock();

    }
}}
class Product implements Runnable {
    private Resource1 r;
    Product(Resource1 r){
        this.r=r;
    }
    public void run(){
        while(true)
            r.set("kaoya");
    }
}
class Consume implements Runnable {
    private Resource1 r;
    Consume(Resource1 r){
        this.r=r;
    }
    public void run(){
        while(true)
            r.get();
    }
}