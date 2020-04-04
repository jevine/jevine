public class Demo {
    public static void main(String[] args) {
        Demo2 d=new Demo2();
        Thread t2=new Thread(d);
        t2.start();
        /*new Thread(d::test,"t1").start();*/
    }

}
class Demo2 implements Runnable{
    public void run(){
        System.out.println("hh");
    }
}
