import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ie_server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9090);
        Socket socket=serverSocket.accept();
        System.out.println(socket.getInetAddress().getHostAddress()+"connected");
        InputStream in=socket.getInputStream();
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
        byte[] buf=new byte[1024];
        int len=in.read(buf);
        String str=new String(buf,0,len);
        System.out.println(str);
        out.println("<font color='red',font size='7'>welcome</font>");
        socket.close();
        serverSocket.close();
    }
}
