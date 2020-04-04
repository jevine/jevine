import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class randomAccessFileDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="联通";
        byte[] buf=str.getBytes("GBK");
        printBytes(buf);
        String s1=new String(buf,"GBk");
        System.out.println(s1);


    }
    private static void printBytes(byte[] buf){
        for (byte b:buf)
            System.out.println(Integer.toBinaryString(b&255));
    }
}
