
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MyTEst {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public void deleteNode(ListNode node) {
    ListNode p=new ListNode(0);
        p=node.next;
        node.val=p.val;
        node.next=p.next;
    }//删除链表中的节点
    public ListNode deleteDuplication(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode node=new ListNode(-1);
        node.next=head;
        ListNode p=node;
        ListNode q=p.next;

        while(p.next!=null){
            while(q!=null&&p.next.val==q.val)q=q.next;
            if(p.next.next==q)
                p=p.next;
            else
                p.next=q;

        }

        return node.next;

    }//删除链表中所有重复的节点
    public double Power(double base, int exponent) {
        double x=1;
        if (exponent<0){
            base=base/10;
            for (int i = 0; i <-exponent ; i++) {
                x=x*base;
        }}

        else
            for (int i = 0; i <exponent ; i++) {
            x=x*base;
        }
        return x;

    }//整数幂函数
    public int maxProductAfterCutting(int length)//cut length
    {int max=0;
    int[] ma=new int[length];
        for (int i = 1; i <= length/2; i++) {
            int temp=length/i;
            int count=length%i;
            for (int j = 0; j < i; j++) {
                ma[j]=temp;
            }
            for (int j = 0; j <count ; j++) {
                ma[j]++;
            }
            temp=1;
            for (int j = 0; j < i; j++) {
                temp=ma[j]*temp;
            }
            max=Math.max(max,temp);
        }
        return max;
    }
    public int NumberOf1(int n) {
        int count=0;
        //String s=Integer.toBinaryString(n);
        //int x=Integer.valueOf(s);
        for (int i = 0; i <32 ; i++) {
            if ((n&1)==1)
                count++;
            n=n>>>1;
        }
        return count;
    }//found numbers of 1 in a number

    private class Node//构造函数
    {
        int first;
        int second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int sum(int a, int b) {
        return a / 10 + b / 10 + a % 10 + b % 10;
    }

    public int movingCount1(int threshold, int rows, int cols) {
        Queue<Node> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean[][] booleans = new boolean[rows][cols];
        booleans[0][0] = true;
        queue.offer(new Node(0, 0));
        int res = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (sum(node.first + dx[i], node.second + dy[i]) > threshold || node.second + dy[i] < 0 ||
                        node.first + dx[i] < 0 || node.first + dx[i] >= rows ||
                        node.second + dy[i] >= cols || booleans[node.first + dx[i]][node.second + dy[i]])
                    continue;
                res++;
                queue.offer(new Node(node.first + dx[i], node.second + dy[i]));
                booleans[node.first + dx[i]][node.second + dy[i]] = true;
            }
        }
        return res;


    }//robert move bfs


    public int movingCount(int threshold, int rows, int cols) {
        //int count = 0;
        boolean[][] bl = new boolean[rows - 1][cols - 1];
        return deepsf(threshold, bl, 0, 0);

        //return count;
    }//robert move dfs深度优先一般都需要用到递归

    public int deepsf(int threshold, boolean[][] bl, int i, int j) {
        if (i < 0 || j < 0 || i / 10 + i % 10 + j / 10 + j % 10 > threshold || i > bl.length || j > bl[0].length || bl[i][j])
            return 0;
        bl[i][j] = true;
        return deepsf(threshold, bl, i + 1, j) + deepsf(threshold, bl, i, j + 1) +
                deepsf(threshold, bl, i - 1, j) + deepsf(threshold, bl, i, j - 1);
    }


    public boolean hasPath(char[][] matrix, String str) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dsf(matrix, str, 0, i, j))
                    return true;

            }
        }
        return false;


    }//矩阵中的路径问题

    boolean dsf(char[][] matrix, String str, int u, int i, int j) {
        if (matrix[i][j] != str.charAt(u)) return false;
        if (u == str.length() - 1) return true;
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, -1, 0, 1};
        char t = matrix[i][j];
        matrix[i][j] = 'a';
        for (int k = 0; k < 4; k++) {
            int dx = x[k] + i;
            int dy = y[k] + j;
            if (dx >= 0 && dx < matrix.length && dy >= 0 && dy < matrix[0].length)
                if (dsf(matrix, str, u + 1, dx, dy))
                    return true;
        }
        matrix[i][j] = t;
        return false;
    }

    public boolean searchArray(int[][] array, int target)//二维数组查找问题
    {
        if (array.length == 0 || array[0].length == 0)
            return false;
        int x = 0;
        int y = array.length - 1;
        while (x < array[0].length && y >= 0) {
            if (target == array[x][y])
                return true;
            if (target > array[x][y])
                x++;
            else y--;
        }
        return false;
    }
}




