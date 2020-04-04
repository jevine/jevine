import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class received {
    public static void main(String[] args) throws IOException {
        //建立udp socket服务
        //创建数据包 用于存储接受到的数据，方便用数据包对象的方法解析这些数据
        //使用socket服务中的receive方法接受的数据存储与数据报中
        System.out.println("jieshou");

            DatagramSocket ds=new DatagramSocket(10006);

            while(true){ byte [] buf=new byte[1024];
                DatagramPacket dp=new DatagramPacket(buf,1024);
                ds.receive(dp);
            //通过数据包对象方法解析其中的数据，比如地址 端口 数据内容等
            String ip=dp.getAddress().getHostAddress();
            int port=dp.getPort();
            String text=new String(dp.getData(),0,dp.getLength());
            System.out.println(ip+port+text);
        }
        //ds.close();
    }
}
