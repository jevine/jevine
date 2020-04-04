import java.util.*;

public class Tdifferent{
    static <T> void show(List<T> t){
        for (T l:t
        ) {
            System.out.println(l.toString());
        }
    }
    static void show2(List<? extends Person> t){

        for (Object l:t
             ) {
            System.out.println(l.toString());
        }

    }

    public Tdifferent() {
    }

    public static void main(String[] args) {
        TreeSet<Person> l1= new TreeSet<>(new com());
        l1.add(new Person("hh",2));
        l1.add(new Student("name",5));
        l1.add(new Work("jj",9));
        l1.add(new Work("jj3",1));
        TreeSet<Work> l2= new TreeSet<>(new com());
        l2.add(new Work("jj",9));
        l2.add(new Work("jj3",2));
        l2.add(new Work("jj",4));
        l2.add(new Work("jj3",1));

        Iterator<Work> it=l2.iterator();
        while(it.hasNext())
            System.out.println(it.next().getAge());


    }
}
class com implements Comparator<Person>{
    @Override
    public int compare(Person l, Person j) {
        return l.getAge()-j.getAge();
    }
}
