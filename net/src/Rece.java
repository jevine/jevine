import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Rece implements Runnable{
    private DatagramSocket ds;

    public Rece(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            while(true){
                byte [] buf=new byte[1024];
                DatagramPacket dp=new DatagramPacket(buf,1024);
                ds.receive(dp);

                //通过数据包对象方法解析其中的数据，比如地址 端口 数据内容等
                String ip=dp.getAddress().getHostAddress();
                int port=dp.getPort();
                String text=new String(dp.getData(),0,dp.getLength());
                System.out.println(ip+port+text);
                if (text.equals("886")){
                    System.out.println(ip+"退出聊天室");
                }
            }

        }catch(Exception e){}

    }
}
