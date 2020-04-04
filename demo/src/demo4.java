public class demo4 {
    public static void main(String[] args) {
Notebook book=new Notebook();
book.run();
book.useUSB(null);
book.useUSB(new useKeyByUSB());
    }
}
interface USB{
     void open();
     void close();
}
 class useMouseByUSB implements USB{
    public void open(){
        System.out.println("mouse open");
    }
    public void close(){
        System.out.println("mouse close");
    }
}
class useKeyByUSB implements USB{
    public void open(){
        System.out.println("key open");
    }
    public void close(){
        System.out.println("key close");
    }
}
class Notebook{
void run(){
    System.out.println("notebook run");
}
public void useUSB(USB usb){//定义接口
    if (usb!=null){
        usb.open();
        usb.close();
    }
}
}