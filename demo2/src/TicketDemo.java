public class TicketDemo {
    public static void main(String[] args)//static biaoshigongxiang
    {
        Ticket d=new Ticket();
        //Ticket g=new Ticket();
      /*  Ticket t3=new Ticket();
        Ticket t2=new Ticket();
        Ticket t4=new Ticket();*/
        //Thread t1=new Thread(g);
        //Thread t2=new Thread(g);
        Thread t3=new Thread(d);
        Thread t4=new Thread(d);
        //t1.start();
        t3.start();
       // t2.start();
        t4.start();

    }
}
class Ticket implements Runnable//extends Thread
{
   // Object obj=new Object();
     int num=100;
    public void run(){
        //System.out.println(this.getClass());
        while(num>0) {
            synchronized(this) {
                if (num > 0) {
                    System.out.println("last" + --num + Thread.currentThread().getName());
                }
            }
        }
    }
}