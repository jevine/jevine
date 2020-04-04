
public class Person{
    private int age;
    private String name;
    Person(){}

    public Person(String name, int age){
    this.age=age;
    this.name=name;
}
public  void show() {
        System.out.println(name+"running"+age);
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("rrr"+name);
    }

    public int getAge() {
        return age;
    }
}
class Student extends Person{


    public Student(String name, int age){
        super(name, age);
    }
}
class Work extends Person{
    public Work(String name, int age){
        super(name, age);
    }
}
