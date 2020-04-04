import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class linkedlist {
    public static void main(String[] args) {
        ArrayList al=new ArrayList();
        al.add(new person("lisi",20));
        al.add(new person("lisi2",22));
        al.add(new person("lisi3",204));
        for (Iterator it=al.iterator(); it.hasNext(); ) {
            person p=(person)it.next();
            System.out.println(p.getName()+p.getAge());
        }
   duilie dl=new duilie();
        dl.myAdd("a");
        dl.myAdd("b");
        dl.myAdd("c");
        dl.myAdd("d");
        while (!dl.isNull()){
            System.out.println(dl.myGet());
        }
    }
}
class person implements Comparable{
    public int compareTo(Object o){
        person p=(person)o;
        int temp =this.age-p.age;
        System.out.println(this.age+this.name);
        return temp==0?this.name.compareTo(p.name):temp;
    }
    public person(String name,int age) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;
    private String name;


}
 class duilie{
    private LinkedList link;
    duilie(){
        link=new LinkedList();}
    public void myAdd(Object obj){
        link.addFirst(obj);
    }
    public Object myGet(){
        return link.removeLast();
    }
    public boolean isNull(){
        return link.isEmpty();
    }
}
