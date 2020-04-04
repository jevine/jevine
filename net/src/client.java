import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.31.78",10010);
        BufferedReader bufr =
                new BufferedReader(new FileReader("client.txt"));
        String line = null;
        BufferedReader bufin =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
        while ((line = bufr.readLine()) != null) {
           /* if ("over".equals(line))
                break;*/
            pr.println(line);
            System.out.println(line);

        }
        socket.shutdownOutput();
        pr.println("over");

        String upperCase = bufin.readLine();
        System.out.println(upperCase);
        bufr.close();
        socket.close();
    }
}
