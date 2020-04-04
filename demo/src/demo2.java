/*
public class demo2 {
    private int age=8;
    {cry();}
    {
        System.out.println("conscodedemo");
    }
    demo2(){
        System.out.println("shuai");
    }
    demo2(int age){
        this.age=age;
        System.out.println("zeishuai"+age);
    }
    public void cry(){
        System.out.println("shuai222");
    }
    public static void main(String[] args){
        demo2 d1=new demo2();
        demo2 d2=new demo2(9);

    }
}
*/

class single{
   private static single s=new single();
    private single(){
    }
    public static single getInstance(){
        return s;
    }
}
class demo2{
    public static void main(String[] args){
        //new single();
        single s1=single.getInstance();
        single s2=single.getInstance();
        System.out.println(s1==s2);
         Superman s=Superman.getInstance();
         s.setName("shuai");


        System.out.println(s.getname());
    }
}
class Superman{
    private String name;
    private static Superman man=new Superman("shuaijian");
    private Superman(String name){
        /*this.name=name;*/
    }
    public static Superman getInstance(){
        return man;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getname(){
        return this.name;
    }
}