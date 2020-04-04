
import java.util.*;

public class MapAnalyse {
    public static void main(String[] args) {
        new MapAnalyse().maxDistance(new int[][]{{1,0,0},{0,0,0},{0,0,0}});
    }
    public int maxDistance(int[][] grid) {
        int res=-1;
        for (int i = 0; i <grid.length; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]==0){
                    System.out.println(gsf(i,j,grid));
                    res=Math.max(res,gsf(i,j,grid));
                    //System.out.println(res);
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    private int gsf(int x1, int y1, int[][] grid){
        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};
        int[][] state=new int[grid.length][grid.length];
        state[x1][y1]=1;
        LinkedList<Integer[]> stack=new LinkedList<>();
        stack.add(new Integer[]{x1,y1});
        while (!stack.isEmpty()){
            Integer[] item=stack.removeFirst();
        for (int i = 0; i <4; i++) {
            int temp = Math.abs(item[0] - x1)+Math.abs(item[1]-y1);
            int x=item[0]+dx[i%4];
            int y=item[1]+dy[i%4];
            if (x<0||y<0||x>=grid.length||y>=grid.length||state[x][y]==1)
                continue;
            if (grid[x][y]==1)
                return temp +1;
            else state[x][y]=1;
                stack.add(new Integer[]{x,y});
        }
        }
        return -1;

    }
    public int reverse(int x) {
        if (x==0)
            return x;
        int temp;
        long res=0L;
        int count=x;
        while (x!=0){
            temp=x%10;
            if (temp!=0)
                res=res*10+temp;
            x/=10;
        }
        if (count<0)
            res/=-1;
        return res>Integer.MAX_VALUE||res<Integer.MIN_VALUE?0:(int)res;

    }



    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l3=new ListNode(0);
            ListNode res=l3;
            ListNode temp=new ListNode(0);
            while(l1!=null&&l2!=null){
                int x=(l1.val+l2.val)/10;
                int y=(l1.val+l2.val)%10;
                l3.val+=y;
                l3.next=new ListNode(x);
                temp=l3;
                l3=l3.next;
                l1=l1.next;
                l2=l2.next;
            }
            while (l1!=null){
                l3.next=new ListNode((l3.val+l1.val)/10);
                l3.val=(l3.val+l1.val)%10;
                temp=l3;

                l3=l3.next;
                l1=l1.next;
            }

            while (l2!=null){
                l3.next=new ListNode((l3.val+l2.val)/10);
                l3.val=(l3.val+l2.val)%10;

                temp=l3;
                l3=l3.next;
                l2=l2.next;
            }
            if (temp.next.val==0)
                temp.next=null;
            return res;
        }
  }
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] temp=new int[n+3][m+3];
        int[][] item=new int[n+3][m+3];
        for (int i = 0; i <n ; i++) {
            System.arraycopy(board[i], 0, item[i + 2], 2, m);
        }
        for (int i = 1; i <n+3; i++) {
            for (int j = 1; j <m+3; j++) {
                temp[i][j]=temp[i-1][j]+temp[i][j-1]-temp[i-1][j-1]+item[i][j];
            }
        }
        for (int i = 3; i <n+3 ; i++) {
            for (int j = 3; j <m+3; j++) {
                int num=temp[i][j]-item[i-1][j-1]-temp[i-3][j]-temp[i][j-3]+temp[i-3][j-3];
                if (item[i-1][j-1]==0){
                    if (num==3)
                        board[i-3][j-3]=1;}
                else if (num<2||num>3)
                    board[i-3][j-3]=0;
            }
        }
    }
    public int myAtoi(String str) {
        str=str.trim();
        long res=0L;
        if (str.length()==0)
            return 0;
        int ch=str.charAt(0);
        int count =0;
        boolean flag=true;
        if (ch=='-'){
            flag=false;
            count++;
        }
        else if (ch=='+')
            count++;
        else if (ch-'0'>-1&&ch-'0'<10)
            count=0;
        else
            return 0;

        while (count<str.length()){
            int temp=str.charAt(count)-'0';
            if (temp>9||temp<0)
                break;
            res=res*10+temp;
            count++;
            if (res>Integer.MAX_VALUE){
                if (!flag)
                return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }

        }
        if (!flag)
            res*=-1;
        return (int)res;



    }
}
