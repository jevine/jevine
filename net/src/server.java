import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(10010);
        Socket s=serverSocket.accept();
        BufferedReader bufin=
                new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufw=
                new BufferedWriter(new FileWriter("server.txt"));
        String line =null;
        while((line=bufin.readLine())!=null){
            /*if ("over".equals(line))
                break;*/
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }
        PrintWriter out=new PrintWriter(s.getOutputStream(),true);
        out.println("success");
        serverSocket.close();
        s.close();
        bufw.close();

    }
}
