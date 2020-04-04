import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteNio{
    public static void main(String[] args) {
        new ReadWriteNio().loadFile("C:\\Users\\Administrator\\Desktop\\huawei\\data\\test_data.txt",false);

    }

public double[][] loadFile(String fileName, boolean skipTitle) {
    long start=System.currentTimeMillis();
    File file = new File(fileName);
    BufferedInputStream fis = null;
    try {
        fis = new BufferedInputStream(new FileInputStream(file));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),1024*1024/2);
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
        /*BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException exception) {
            System.err.println(fileName + " File Not Found");
            return null;
        }*/
        List<List<Double>> listArr = new ArrayList<>();
        String line = "";
        try {
            if (skipTitle) {
                reader.readLine();
            }
            while ((line = reader.readLine()) != null) {
                long x=reader.read();
                System.out.println(x);
                if (x > 0) {
                    reader.skip(x-1);
                }
                List<Double> list = new ArrayList<>();
                String[] item = line.split(",");
                for (int i = 0; i < item.length; i++) {
                    list.add(Double.parseDouble(item[i]));
                }
                listArr.add(list);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

    //System.out.println(System.currentTimeMillis()-start);
    System.out.println(listArr.size()+"  "+listArr.get(0).size());
    double[][] matrix = new double[listArr.size()][listArr.get(0).size()];
    for (int i = 0; i < listArr.size(); i++) {
        for (int j = 0; j < listArr.get(i).size(); j++) {
            matrix[i][j] = listArr.get(i).get(j);
        }
    }
    System.out.println(System.currentTimeMillis()-start);
    return matrix;

}}