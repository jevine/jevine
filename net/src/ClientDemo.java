import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.31.78", 10007);
        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(System.in));
       // OutputStream outputStream = socket.getOutputStream();
        BufferedReader bufin=
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
        String line =null;
        while ((line=bufr.readLine())!=null){
            if ("over".equals(line))
                break;
            out.println(line);
            String upperCase=bufin.readLine();
            System.out.println(upperCase);
        }
        socket.close();
        /*outputStream.write("tcpyanshi".getBytes());
        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(str);*/

      /*  InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostName() + ip.getHostAddress());
        socket.close();*/


    }
}
