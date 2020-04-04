
import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.*;
import javax.swing.Timer;

import static com.sun.xml.internal.ws.util.VersionUtil.compare;
import static java.util.Collections.reverseOrder;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

        employee[] staff = new employee[3];
        staff[0] = new employee("hee", 20);
        staff[1] = new employee("jw", 2);
        staff[2] = new employee("a", 10);
        String[] strings = new String[3];
        Timer t = new Timer(1000, e ->
                System.out.println(new Date()));
        t.start();
        for (int i = 0; i < 3; i++) {
            strings[i] = staff[i].getName();
        }
        employee copy = staff[0].clone();
        copy.getAge(2);
        System.out.println(copy.age() + copy.getName());
        Comparator com=Comparator.comparing(employee::getName);
        Arrays.sort(staff,com);
       /* Arrays.sort(staff,Comparator.comparing(employee::getName,
                Comparator.comparingInt(String::length)).thenComparing(employee::age));*/
        for (employee s : staff
        ) {
            System.out.println(s.getName());
        }
    }

    public static void raiseAge(employee x) {
        x.getAge(4);
        System.out.println(x.age());
    }
}

class LengthComparator implements Comparator<employee> {
    @Override
    public int compare(employee o1, employee o2) {
        return o1.getName().length() - o2.getName().length();
    }
}

class StringComparator implements Comparator<employee> {
    @Override
    public int compare(employee o1, employee o2) {
        return o1.getName().compareTo(o2.getName());
    }

}

class employee implements Comparable<employee>, Cloneable {
    private String name;
    private int age;
    private int x;
    public employee clone() throws CloneNotSupportedException {
        return (employee) super.clone();
    }

    public employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getAge(int a) {
        age = age + a;
        return age;
    }

    public int age() {
        return age;
    }

    @Override
    public int compareTo(employee o) {
        return this.getName().compareTo(o.getName());
    }
}

class manager extends employee {
    public manager(String name, int age) {
        super(name, age);
    }
}

enum Size {
    Small("s"), Medium("m"), Lager("l");
    private String abbreviation;

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
