public class demo4 {
    public static void main(String[] args) {
        Demo d1=new Demo("xiao");
        Demo d2=new Demo("da");
        Runnable r=new Demo("shuu");
        Thread t1=new Thread(d1);
        Thread t2=new Thread(d2);
        t1.start();
        t2.start();
    }


}
class Fu{
    void show(){}
}
class Demo extends Fu implements Runnable{
    private String name;//super name时this.name自然就为空
    Demo(String name){
        //super(name);
        this.name=name;
    }
    public void run(){
        show();
    }
    public void show(){
        for (int x=0;x<10;x++){
            System.out.println(name+"..x="+x+Thread.currentThread().getName());
        }
    }
}