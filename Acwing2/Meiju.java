import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//递归实现组合型枚举,从 1~n 这 n 个整数中随机选出 m 个，输出所有可能的选择方案。
//递归的做法 和 非递归的做法
public class Meiju {
    static int n;
    static int m;
    List<Integer> list=new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         n=Integer.parseInt(sc.next());
         m=Integer.parseInt(sc.next());
        //new Meiju().dsp(0);
        Stack<temp> stack=new Stack<>();
        stack.add(new temp(0,0,0,0));
        while (stack.size()!=0){
            temp t=stack.pop();
            if (t.pos==0){
                if (t.sum-t.u+n<m)
                    continue;
                if (t.sum==m){
                    for (int i = 0; i <n; i++) {
                        if ((t.state>>i&1)==1)
                        System.out.print(i+1+" ");
                    }
                    System.out.println();
                    continue;
                }
                t.pos=1;
                stack.add(t);
                stack.push(new temp(0,t.u+1,t.sum+1,t.state|1<<t.u));
            }
            else if (t.pos==1){
                stack.push(new temp(0,t.u+1,t.sum,t.state));
            }
        }
    }
    private void dsp(int u) {
        if (list.size()==m){
            for (int x:list
                 ) {
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }
        for (int i = u; i <n; i++) {
                list.add(i+1);
                dsp(i+1);
                list.remove(list.size()-1);
        }
    }
}
class temp{
    int pos,u,sum,state;

    public temp(int pos, int u, int sum, int state) {
        this.pos = pos;
        this.u = u;
        this.sum = sum;
        this.state = state;
    }
}
