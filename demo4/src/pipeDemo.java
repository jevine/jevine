import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class pipeDemo {
    public static void main(String[] args) throws IOException {
        PipedInputStream in=new PipedInputStream();
        PipedOutputStream out =new PipedOutputStream();
        in.connect(out);
         new Thread(new input(in)).start();
         new Thread(new output(out)).start();

    }

}
class input implements Runnable{
    private PipedInputStream in;
    input(PipedInputStream in){
        this.in=in;
    }

    @Override
    public void run() {
        try {byte[] buf=new byte[1024];
            int len =in.read(buf);
            String s=new String(buf,0,len);
            System.out.println(s);
            in.close();


        }catch (Exception e){}
    }
}
class output implements Runnable{
    private PipedOutputStream out;
    output(PipedOutputStream in){
        this.out=in;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(6000);
             out.write("hi,guandaolaile".getBytes());
            out.close();


        }catch (Exception e){}
    }
}