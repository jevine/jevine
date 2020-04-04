import org.w3c.dom.NodeList;
import sun.reflect.generics.tree.Tree;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(new UglyNumber().findContinuousSequence(15));
    }

    public int getUglyNumber(int n) {
        if (n < 2)
            return n;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int x = 0, y = 0, z = 0;
        int temp = 0;
        while (n-- > 0) {
            temp = Math.min(list.get(x) * 2, Math.min(list.get(y) * 3, list.get(z) * 5));
            if (temp == list.get(x) * 2)
                x++;
            if (temp == list.get(y) * 3)
                y++;
            if (temp == list.get(z) * 5)
                z++;
            list.add(temp);
        }
        return temp;
    }

    //0到n之间，1出现得次数
    public int numberOf1Between1AndN_Solution(int n) {
        String s = "" + n;
        String[] item = s.split("");
        int count = 0;
        for (int i = 0; i < item.length; i++) {
            if (i != 0)
                count = count + Integer.valueOf(s.substring(0, i)) * (int) Math.pow(10, item.length - i - 1);
            if (Integer.valueOf(item[i]) != 0) {
                if (i == item.length - 1)
                    count++;
                else {
                    if (Integer.valueOf(item[i]) == 1) {
                        StringBuilder sb2 = new StringBuilder(s.substring(i));
                        sb2.deleteCharAt(0);
                        count = count + Integer.valueOf(sb2.toString()) + 1;
                    } else
                        count = count + (int) Math.pow(10, item.length - i - 1);

                }
            }

        }
        return count;
    }

    public int getNumberOfK(int[] nums, int k) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                temp++;
            }
            if (nums[i] != k && temp > 0)
                break;
        }
        return temp;

    }

    public int[] numberOfDice(int n) {
        int[][] dp = new int[n][6 * n + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 6 * n; j++) {
                for (int k = 1; k < Math.min(j, 6); k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        int[] res = new int[6 * n - n + 1];
        if (6 * n - n + 1 >= 0)
            System.arraycopy(dp[n - 1], n, res, 0, 6 * n - n + 1);
        return res;

    }

    public int getMissingNumber(int[] nums) {
        int end = nums.length - 1;
        int start = 0;
        while (end != start) {
            int mid = (end + start) >> 1;
            if (nums[mid] == mid)
                start = mid + 1;
            if (nums[mid] > mid)
                end = mid;
        }
        return end;
    }

    Map<Character, Integer> map = new HashMap<>();
    Deque<Character> deque = new ArrayDeque<>();

    public void insert(char ch) {
        if (map.containsKey(ch))
            if (deque.contains(ch))
                deque.remove(ch);
            else {
                map.put(ch, 1);
                deque.add(ch);
            }

    }

    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        if (deque.isEmpty())
            return '#';
        return deque.peek();

    }

    /*public int inversePairs(int[] nums) {


    }*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    Stack<TreeNode> stack = new Stack<>();


    public TreeNode kthNode(TreeNode root, int k) {
        if (root == null)
            return null;
        if (stack.size() == k)
            return stack.peek();
        kthNode(root.left, k);
        stack.push(root);
        kthNode(root.right, k);
        return null;
    }


    public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA.next != null) {
            headA = headA.next;
            set.add(headA);
        }
        while (set.add(headB))
            headB = headB.next;
        if (headB.next == null)
            return null;
        return headB;
    }


    public int findNumberAppearingOnce(int[] nums) {
        int[] res = new int[32];
        for (int x : nums
        ) {
            for (int i = 0; i < 32; i++) {
                res[i] += (x >> 1 & 1);
            }

        }
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result = result << 1;
            result += res[i] % 3;

        }
        return result;
    }

    public int[] findNumbersWithSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums
        ) {
            int num = target - x;
            if (set.contains(num)) {
                return new int[]{x, num};
            } else set.add(num);
        }
        return null;
    }

    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int j = 1, i = 0; j <= 1+sum>>1; j++) {
            count += j;
            while (count > sum) {
                count = count - i;
                i++;
            }
            if (count == sum) {
                List<Integer> list = new ArrayList<>();
                for (int k = i; k < j + 1; k++) {
                    list.add(k);
                }
                res.add(new ArrayList<>(list));
            }
        }
        return res;
    }
    public String reverseWords(String s) {
        String[] item=s.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = item.length-1; i >0; i--) {
            sBuilder.append(item[i]).append(" ");
        }
        s = sBuilder.toString();
        return s+item[0];
    }
    public String leftRotateString(String str,int n) {
        String s=str.substring(0,n);
        String s1=str.substring(n);
        return s1+s;

    }
    public int[] maxInWindows(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        Deque<Integer> queue=new ArrayDeque<>();
        for (int i = 0; i <nums.length; i++) {
            while (!queue.isEmpty()&&i-queue.peekLast()==k){
                queue.pollLast();
            }
            while (!queue.isEmpty()&&nums[queue.peek()]<nums[i])
                queue.poll();
            queue.push(i);
            if (i>=k-1)
                res[i-k+1]=nums[queue.peekLast()];
        }
        return res;

    }
    private boolean balance=true;
    public boolean isBalanced(TreeNode root) {
        dsp(root);
        return balance;
    }
    private int dsp(TreeNode root) {
        if (root==null)
            return 0;
        int left=dsp(root.left);
        int right=dsp(root.right);
        if (Math.abs(left-right)>1)
            balance=false;
        return left>right?left+1:right+1;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}