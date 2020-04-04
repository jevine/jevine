import java.io.IOException;
import java.net.DatagramSocket;

public class chat {
    public static void main(String[] args) throws IOException {
        DatagramSocket send = new DatagramSocket(8888);
        DatagramSocket rece = new DatagramSocket(10005);
        new Thread(new Send(send)).start();
        new Thread(new Rece(rece)).start();
    }
}

