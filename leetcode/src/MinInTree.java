
import java.util.Collections;
import java.util.Stack;

public class MinInTree //在二叉搜索树中取出第k小的数
{
    public int kthSmallest(TreeNode root, int k) {
        if (root==null)
            return -1;
        Stack<Integer> stack=new Stack<>();
        midorder(root,stack);
        Collections.reverse(stack);
        while (--k>0){
            stack.pop();
        }
        return stack.pop();

    }
    public void midorder(TreeNode root,Stack<Integer> stack){
        if (root==null)
            return;
        midorder(root.left,stack);
        stack.push(root.val);
        midorder(root.right,stack);
    }
}
 class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }