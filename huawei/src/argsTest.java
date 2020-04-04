import java.io.*;

public class argsTest{
    public static void main(String[] args) {
        BufferedReader reader=null;
        String line=null;
        long count;
        try {
            reader=new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\Desktop\\da.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (reader != null) {
                while ((line = reader.readLine()) != null){
                    /*int x=reader.read();
                    if (x > 0) {
                        count=+x;*//*
                       reader.skip(1);
                    }*/
                    int x=reader.read();
                    System.out.println(line+x);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}