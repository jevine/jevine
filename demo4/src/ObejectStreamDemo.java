import java.io.*;

public class ObejectStreamDemo {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        writeobj();
        readobj();
    }
public  static void readobj() throws IOException,ClassNotFoundException{
    ObjectInputStream ois=new ObjectInputStream(new FileInputStream("obj.object"));
    Person p=(Person) ois.readObject();
    System.out.println(p.getAge()+p.getName());
    ois.close();
    }
    public static void writeobj() throws IOException {
        ObjectOutputStream oos=
                new ObjectOutputStream(new FileOutputStream("obj.object"));
        oos.writeObject(new Person("lulu",17));
        oos.close();
    }
}
