public class test {
    public static void main(String[] args) {
        Students s = new Students("xaioming", 21);
        s.students();
        s.setAge(58);
        System.out.println(s.getAge());
    }
}
class Person{
    private  int age;
    private String name;
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
public void setAge(int age){
        this.age=age;
}
public void setName(String name){
        this.name=name;
}
public String getName(){
        return name;
}
public int getAge(){
        return age;
}
}
class Students extends Person {
    Students(String name, int age) {
        super(name, age);
    }

    void students() {
        System.out.println("students");
    }
}

    class Works extends Person{
        Works(String name,int age){
            super(name,age);
        }
        void works(){
            System.out.println("works");
        }
}
