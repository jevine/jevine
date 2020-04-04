import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException{
        String s="ab你好ef扉";
        int len=s.getBytes("gbk").length;
        for (int i = 0; i <len; i++) {
            System.out.println(cutString(s,i+1));
        }


    }
    public static String cutString(String s,int len) throws IOException {
        int count=0;
        byte[] b=s.getBytes("gbk");
        for (int i =len-1; i >=0; i--) {
            if (b[i]<0)
                count++;
            else
                break;

        }
        if (count%2==0){
            return new String(b,0,len,"gbk");
        }
        else
            return new String(b,0,len-1,"gbk");

    }
}
