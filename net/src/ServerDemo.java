import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10007);
        Socket s = serverSocket.accept();//阻塞式
        String ip = s.getInetAddress().getHostAddress();
        BufferedReader bufin=
                new BufferedReader(new InputStreamReader(s.getInputStream()));
         String line=null;
         PrintWriter out=new PrintWriter(s.getOutputStream(),true);
       /* byte[] buf = new byte[1024];
        int len = in.read(buf);
        String str = new String(buf, 0, len);*/
       while((line=bufin.readLine())!=null){
           System.out.println(line);
           //OutputStream outputStream=s.getOutputStream();
           out.println(line.toUpperCase());
       }


        s.close();
        serverSocket.close();

    }
}
