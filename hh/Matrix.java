
import javafx.util.Pair;
import jdk.internal.dynalink.beans.StaticClass;

import java.util.*;

//将一个树序列化成一个字符串的形式。并将该字符串反序列化为原本的树的结构
public class Matrix {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(8);
        TreeNode t2=new TreeNode(12);
        TreeNode t3=new TreeNode(2);
        TreeNode t4=new TreeNode(6);
        TreeNode t5=new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        Matrix m = new Matrix();
        System.out.println(m.serializeQ(t1));
        System.out.println(m.serializeQ(m.deserialize(m.serializeQ(t1))));

    }
    ArrayList<Integer> al = new ArrayList<>();
    ArrayList<Integer> all = new ArrayList<>();
    ArrayList<Integer> alll = new ArrayList<>();
    StringBuffer sb = new StringBuffer();

    // Encodes a tree to a single string.
    // 前序遍历 递归的方法和非递归的方法；
    public String serializeQ(TreeNode root) {
        /*if (root==null)
            return null;
        al.add(root.val);
        serializeQ(root.left);
        serializeQ(root.right);
        return al.toString();*/
        String res="";
        Stack<TreeNode> sta = new Stack();
        while (!sta.isEmpty() || root != null) {
            if (root != null) {
                res += root.val + " ";
                sta.push(root);
                root = root.left;
            } else {
                root = sta.pop();
                res += "null ";
                root = root.right;
            }
        }res += "null ";
        return res;
    }
    public int[] printMatrix(int[][] matrix) {
        if (matrix.length == 0)
            return null;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] in = new int[n * m];
        boolean[][] booleans = new boolean[n][m];
        int count = 0;
        in[0] = matrix[0][0];
        for (int i = 1; i < n * m; i++) {

            int x = 0;
            int y = 0;
            x = x + dx[count];
            y = y + dy[count];
            if (x == 0 || x == n - 1 || y == m - 1 || booleans[x][y])
                if (count == 3)
                    count = 1;
                else
                    count++;

            in[i] = matrix[x][y];
            booleans[x][y] = true;


        }
        return in;
    }
    Stack<Integer> stemp = new Stack<>();
//反序列化 将String转化为Tree的节点样式
    TreeNode deserialize(String data) {
        int u = 0;
        return ds(data, u);
    }
    TreeNode ds(String data, int u) {
        if (!stemp.isEmpty())
            u = stemp.peek();
        if (u == data.length())
            return null;
        int k = u;
        while (data.charAt(k) != ' ') k++;
        if (data.charAt(u) == 'n') {
            u = 1 + k;
            stemp.push(u);
            return null;
        }
        int sum = 0;
        for (int i = u; i < k; i++) {
            if (data.charAt(i)!='-')
            sum = data.charAt(i) + sum * 10 - '0';
        }
        if (data.charAt(u)=='-')
            sum=-sum;
        u = k + 1;
        stemp.push(u);
        TreeNode node = new TreeNode(sum);
        node.left = ds(data, u);
        node.right = ds(data, u);
        return node;
    }
}
//获得栈中的最小值
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> temp;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (temp.isEmpty() || stack.peek() <= temp.peek())
            temp.push(x);


    }

    public void pop() {

        if (stack.peek().equals(temp.peek()))
            temp.pop();
        stack.pop();

    }

    public int top() {
        return stack.peek();


    }

    public int getMin() {
        return temp.peek();

    }
}
//队列出栈是否可能按照给出的方式
class Solution {
    public boolean isPopOrder(int[] pushV, int[] popV) {
        if (pushV.length != popV.length)
            return false;
        Stack h = new Stack();
        int count = 0;
        int j = 0;
        int[] temp = new int[popV.length];
        for (int i = 0; i < pushV.length; i++) {
            if (pushV[i] != popV[count]) {
                int x = i;
                while (count + 1 < popV.length && x > 0 && pushV[x - 1] == popV[count + 1]) {
                    temp[j] = pushV[x];
                    j++;
                    count++;
                    x--;
                }
                h.push(pushV[i]);
            } else {
                temp[j] = pushV[i];
                j++;
                count++;
            }
        }
        for (int i = j; i < popV.length; i++) {
            temp[i] = (Integer) h.pop();
        }
        for (int i = 0; i < popV.length; i++) {
            if (temp[i] != popV[i])
                return false;
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//判断二叉树中的某一路径val的和是否可能与给定的一个数相同，如果存在 则输出所有符合条件的路径
class Solution1 {
    int sum;
    LinkedList<Integer> in = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int sum) {
        this.sum = sum;
        dfs(root, sum);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null)
            return;
        sum -= root.val;
        in.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            LinkedList<Integer> linkedList = new LinkedList<>(in);
            ans.add(linkedList);
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        in.pollLast();
    }
}

class ListNode {
    int val;
    ListNode next, random;

    ListNode(int x) {
        this.val = x;
    }
}
//复制存在两个指针链表
class Solution2 {
    public ListNode copyRandomList(ListNode head) {
        ListNode p;
        for (p = head; p != null; p = p.next.next) {
            ListNode ln = new ListNode(p.val);
            ln.next = p.next;
            p.next = ln;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        for (p = head; p != null; p = p.next.next) {
            if (p.random != null)
                p.next.random = p.random.next;
        }
        for (p = head; p != null; p = p.next) {
            cur.next = p.next;
            p.next = cur.next.next;
            cur = cur.next;

        }
        return dummy.next;

    }
}
//将二叉树 改写成双向列表的数据结构方式
class Solution3 {
    public TreeNode convert(TreeNode root) {
        if (root == null || root.right == null && root.left == null)
            return root;
        TreeNode tr = null;
        TreeNode temp = null;
        TreeNode root1 = root;
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root.left != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                temp = root;
                root.left = tr;
                if (tr != null)
                    tr.right = temp;
                tr = temp;
                root = root.right;
            }
        }
        while (root1.left != null)
            root1 = root1.left;
        return root1;
    }

}
//前中后三种 的遍历方式
class Solution4 {
    ArrayList<Integer> al = new ArrayList<>();
    ArrayList<Integer> all = new ArrayList<>();
    ArrayList<Integer> alll = new ArrayList<>();
    Stack<TreeNode> sta = new Stack<>();
    String res;
    StringBuffer sb = new StringBuffer();

    // Encodes a tree to a single string.
     String serializeQ(TreeNode root) {
        /*if (root==null)
            return null;
        al.add(root.val);
        serializeQ(root.left);
        serializeQ(root.right);
        return al.toString();*/
        while (!sta.isEmpty() || root != null) {
            if (root != null) {
                res += root.val + ' ';
                sta.push(root);
                root = root.left;
            } else {
                res += "null" + ' ';
                root = sta.pop();
                root = root.right;
            }
        }
        return res;
    }//前序遍历

    String serializeZ(TreeNode root) {
        if (root == null)
            return null;

        serializeZ(root.left);
        all.add(root.val);
        serializeZ(root.right);
        return all.toString();

    }//中序遍历

    String serializeH(TreeNode root) {//后序遍历
        if (root == null)
            return null;
        serializeH(root.left);
        serializeH(root.right);
        alll.add(root.val);
        return alll.toString();
    }//后序遍历

     int max=0;
    public int treeDepth(TreeNode root) {

         return searchDepth(root,0);

    }
    public int searchDepth(TreeNode root,int depth){
         if (root==null){
             return depth-=1;
         }
         max=Math.max(max,depth);
         searchDepth(root.left,depth+1);
         searchDepth(root.right,depth+1);
         return max;

    }
    public int[] findNumsAppearOnce(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int x:nums
             ) {
            if (!set.add(x))
                set.remove(x);
        }
        Iterator<Integer> it=set.iterator();
        int[] x=new int[2];
        for (int i=0;i<2;i++)
            x[i]=it.next();
        return x;


    }

}