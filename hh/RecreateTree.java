import java.util.HashMap;
import java.util.Stack;

public class RecreateTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root==null)return true;
            return isSame(root.right,root.left);

        }
        public boolean isSame(TreeNode p1, TreeNode p2){
            if (p1==null&&p2!=null||p2==null&&p1!=null)
                return false;
            if (p1==null&&p2==null)
                return true;
            if (p1.val==p2.val)
            return isSame(p1.left,p2.right)&&isSame(p1.right,p2.left);
            return false;
        }
    }
        public void mirror(TreeNode root) {
            if (root==null||root.right==null&&root.left==null)
                return;
            mirror(root.left);
            mirror(root.right);
            TreeNode node3 ;
            node3 = root.left;
            root.left = root.right;
            root.right = node3;
        }

        public boolean Same(TreeNode pRoot1, TreeNode pRoot2) {
            if (pRoot1 == null) return false;
            if (pRoot2 == null || pRoot1.val == pRoot2.val)
                return Same(pRoot1.left, pRoot2.left) && Same(pRoot1.right, pRoot2.right);
            //if (pRoot1 == null)
            return false;
        }

        public boolean hasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
            if (Same(pRoot1, pRoot2))
                return true;


            return hasSubtree(pRoot1.left, pRoot2) || hasSubtree(pRoot1.right, pRoot2);


        }


    String s;
    String p;
    int slength;
    int plength;

    boolean[][] f;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        slength = s.length();
        plength = p.length();
        f = new boolean[slength][plength];
        return dp(0, 0);
    }//正则匹配

    private boolean dp(int i, int j) {
        if (f[i][j] == true) return f[i][j];
        if (j == plength) return f[i][j] = i == slength;//必然是p的先走完然后才能是s
        boolean firstMatch = i < slength && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < plength && p.charAt(j + 1) == '*')
            f[i][j] = dp(i, j + 2) || dp(i + 1, j) && firstMatch;
        else
            f[i][j] = firstMatch && dp(i + 1, j + 1);
        return f[i][j];

    }


    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    class TreeNode1 {
        int val;
        TreeNode1 left;
        TreeNode1 right;
        TreeNode1 father;

        TreeNode1(int x) {
            val = x;
        }
    }

    public TreeNode1 inorderSuccessor(TreeNode1 p) //inorder 的下一个节点
    {
        if (p.right != null) {
            while (p.right.left != null)
                p.right = p.right.left;
            return p.right;
        } else
            while (p.father.right != null && p.father.right != p)
                p.father = p.father.father;
        return p.father;

    }

    public TreeNode1 buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, inorder.length - 1);

    }//重构二叉树

    public TreeNode1 dfs(int ps, int pe, int is, int ie) {
        if (ps > pe) return null;

        TreeNode1 res = new TreeNode1(preorder[ps]);
        int k = map.get(res.val);
        res.left = dfs(ps + 1, ps + k - is, is, k - 1);
        res.right = dfs(ps + k - is + 1, pe, k + 1, ie);
        return res;
    }

}
