
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    public static void main(String[] args) {
        ResourceTemp r = new ResourceTemp();
        r.setName("duck");
        In x = new In(r);
        Out y = new Out(r);
        ThreadGroup tg=new ThreadGroup("k");
        Thread t1 = new Thread(tg,x);
        Thread t2 = new Thread(tg,x);
        Thread t3 = new Thread(tg,y);
        Thread t4 = new Thread(tg,y);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class ResourceTemp {
    private String name;
    private Lock lock = new ReentrantLock();
    private Condition in_con = lock.newCondition();
    private Condition out_con = lock.newCondition();
    private ConcurrentLinkedQueue<String> list = new ConcurrentLinkedQueue<>();
    private int countin = 0;


    public void setName(String name) {
        this.name = name;
    }

    public void in() throws InterruptedException{
        while (true) {
            lock.lock();
            try {
                while (list.size() == 100)
                    in_con.await();
                if (countin == 100) countin = 0;
                list.add(name + (++countin));
                System.out.println(name + countin + "      product " + Thread.currentThread().getName());
                out_con.signal();
            }
           finally {
                lock.unlock();
            }
        }

    }

    public void out() {
        while (true) {
            lock.lock();
            try {
                while (list.isEmpty())
                    out_con.await();
                System.out.println(list.poll() + "consumer " + Thread.currentThread().getName());
                in_con.signal();
            } catch (InterruptedException e) {
            } finally {
                lock.unlock();
            }
        }
    }

}

class In implements Runnable {
    private ResourceTemp r;

    In(ResourceTemp r) {
        this.r = r;
    }
    @Override
    public void run() {
        try {
            r.in();
        } catch (InterruptedException e) {
        }
    }
}

class Out implements Runnable {
    private ResourceTemp r;

    Out(ResourceTemp r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.out();
    }
}
