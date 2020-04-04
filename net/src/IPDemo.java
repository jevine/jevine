import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class IPDemo {
    public static void main(String[] args)
            throws IOException {
        InetAddress ip = InetAddress.getLocalHost();
        //ip=InetAddress.getByName("68.142.93.254");
        System.out.println(ip.getHostAddress() + ip.getHostName());
        DatagramSocket ds = new DatagramSocket(8888);
        //String str = "udpchuanshu wozhenshuai";
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bufr.readLine()) != null) {
            byte[] buf = line.getBytes();
            DatagramPacket dp =
                    new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.31.78"), 10006);
            ds.send(dp);
            if ("over".equals(line))
                break;
        }


        ds.close();
    }
}
