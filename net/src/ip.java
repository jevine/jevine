import java.io.IOException;
import java.net.InetAddress;

public class ip {
    public static void main(String[] args) throws IOException {
        InetAddress i=InetAddress.getLocalHost();
        System.out.println(i.getHostName()+i.getHostAddress());

    }
}
