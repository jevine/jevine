public class Demo3 {
    public static void main(String[] args) {
        System.out.println("hjgf");
        new Demo4();
        new Demo4();
        System.gc();
        new Demo4();
        System.out.println("hello world");
    }
}
