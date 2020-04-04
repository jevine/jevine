import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo
{
    public static void main(String[] args) {
        TreeSet ts=new TreeSet();
        ts.add(new person("wan",1));
        ts.add(new person("xan",2));
        ts.add(new person("qan",3));
        ts.add(new person("wean",1));

        for (Iterator it=ts.iterator();it.hasNext();){
            person p=(person)it.next();
            System.out.println(p.getName()+"   "+p.getAge());
        }
    }

}
