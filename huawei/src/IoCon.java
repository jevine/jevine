import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoCon {
    public static void main(String[] args) {
        new IoCon().loadFile("C:\\Users\\Administrator\\Desktop\\huawei\\data\\test_data.txt",false);

    }
    public double[][] loadFile(String fileName, boolean skipTitle) {
       /* BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException exception) {
            System.err.println(fileName + " File Not Found");
            return null;
        }
        List<List<Double>> listArr = new ArrayList<>();
        String line = "";
        try {
            if (skipTitle) {
                reader.readLine();
            }
            while ((line = reader.readLine()) != null) {
                List<Double> list = new ArrayList<>();
                String item[] = line.split(",");
                for (int i = 0; i < item.length; i++) {
                    list.add(Double.parseDouble(item[i]));
                }
                listArr.add(list);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }*/

        readCon rc=new readCon(fileName,skipTitle);
        Thread t1=new Thread(rc);
        Thread t2=new Thread(rc);
        Thread t3=new Thread(rc);
        Thread t4=new Thread(rc);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<List<Double>> listArr =rc.getListArr();
        System.out.println(listArr.size()+"    "+listArr.get(0).size());
        double[][] matrix = new double[listArr.size()][listArr.get(0).size()];
         for (int i = 0; i < listArr.size(); i++) {
                for (int j = 0; j < listArr.get(i).size(); j++) {
                    matrix[i][j] = listArr.get(i).get(j);
                }
            }
         return matrix;
    }
     class readCon implements Runnable{
        String fileName;
        boolean skipTitle;
        long count=0;
        List<List<Double>> listArr = new ArrayList<>();
        readCon(String filename,boolean skipTitle){
            this.fileName=filename;
            this.skipTitle=skipTitle;
        }
        public List<List<Double>> getListArr(){
            return listArr;
        }
        @Override
        public void run() {
                BufferedReader reader = null;
            try
                {
                    reader = new BufferedReader(new FileReader(fileName));
                } catch(
                FileNotFoundException exception)

                {
                    System.err.println(fileName + " File Not Found");
                    return;
                }

                String line = "";
            try
                {
                    if (skipTitle) {
                        reader.readLine();
                    }

                    while ((line = reader.readLine()) != null) {
                        int x=reader.read();
                        if (x > 0) {
                            count=+x;
                            reader.skip(count-1);
                        }
                        List<Double> list = new ArrayList<>();
                        String[] item = line.split(",");
                        for (String s : item) {
                            list.add(Double.parseDouble(s));
                        }
                        listArr.add(list);
                    }
                } catch(
                IOException exception)

                {
                    System.err.println(exception.getMessage());
                }

        }
    }
}

