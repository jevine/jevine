//递归实现指数型枚举
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static int x;
    public static void main(String[] args) {
        new Main().dsf(0,0);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        x=n;
        LinkedList<LinkedList<Integer>> l = new LinkedList<>();
        LinkedList<Integer> ls = new LinkedList<>();
        /*for (int i = n; i > 0; i--) {
            ls.addFirst(i);
            l.add(new LinkedList<>(ls));
            for (int j = 0; j < l.size(); j++) {
                if (l.get(j).peek() == i)
                    break;
                LinkedList<Integer> t = new LinkedList<>(l.get(j));
                t.addFirst(i);
                l.add(t);
            }
            for (LinkedList<Integer> li : l
            ) {
                if (li.peek() == i) {

                    for (int y : li
                    ) {
                        System.out.print(y + " ");
                    }
                    System.out.println();
                }
            }
            ls.clear();
        }*/
    }

    private void dsf(int u, int state) {
        if (u==x){
            for (int i = 0; i <x; i++) {
                if ((state>>i&1)==1){
                    System.out.print(i+1);
                    System.out.println();
                }
            }
            dsf(u+1,state);
            dsf(u+1,state|1<<u);
        }
    }
}
