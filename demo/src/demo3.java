public class demo3  {
    public static void main(String[] args){
      animals a=new Dog();
      a.eat();
      Dog d=(Dog)a;
      d.lookhome();
    }
}
 class animals{
    void eat(){
        System.out.println("chifan");
    };
}
class Dog extends animals{
    void eat(){
        System.out.println("gutou");
    }
    void lookhome(){
        System.out.println("look");
    }
}