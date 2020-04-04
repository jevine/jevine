public class demo5 {
    public static void main(String[] args){
        Person1 p1=new Person1(22,"lisi");
        Person1 p2=new Person1(22,"lisi");
        System.out.println(p1.equals(p2));
        System.out.println(p1==p2);
        Person1 p3=new Person1(32,"shuaijian");
     /*Outer o=new Outer();
     o.method();*/
    }
}
class Person1 extends Object{
    private int age;
private String name;
Person1 (int age, String name){
    this.age=age;
    this.name=name;
}
    public boolean equals(Object obj){
        if(!(obj instanceof Person1)){
            return false;
        }
            if(this==obj){
                return true;
            }
        Person1 p=(Person1)obj;
return this.name.equals(p.name)&&this.age==p.age;
//obj.age;是错误的 object没有age 需要向下转型
    }

}
/*
abstract class Demo{
 abstract void show();
}
class Outer{
    private int num=4;
    public void method(){
        new Demo(){
            public void show(){
                System.out.println("num="+num);
            }
        }.show();
    }
}*/
