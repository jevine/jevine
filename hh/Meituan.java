import java.util.*;

public class Meituan {
    public static void main(String[] args) {
        List<Integer> A=new ArrayList<>();
        A.add(0);
        A.add(1);
        A.add(2);
        List<Integer> B=new ArrayList<>();
        List<Integer> C=new ArrayList<>();
        new Meituan().hanota(A,B,C);

        /*int[] d=new int[13];
        d[1]=1;
        for (int i = 2; i <13; i++) {
            d[i]=d[i-1]*2+1;
        }
        int[] f=new int[13];
        for(int i=1;i<13;i++)
            f[i]=Integer.MAX_VALUE;

        for (int i = 1; i <13 ; i++) {
            for (int j = 0; j <=i; j++) {
                f[i]=Math.min(f[i],(f[j]*2+d[i-j]));
            }
        }
        for(int i=1;i<13;i++)
            System.out.println(f[i]);*/


    }
    public int getSum(int n,int k,int l,int r){
        int len=n*r;
        int[][] dp=new int[n+1][len+1];
        dp[0][0]=1;
        for (int i = 1; i < n+1; i++) {
            for (int j = l; j <n*r+1 ; j++) {
                for (int m = l; m <Math.min(j,r)+1; m++) {
                    dp[i][j]+=dp[i-1][j-m]; } } }
        int sum=0;
        for (int i = l*n; i <r*n+1; i++) {
            if (i%k==0)
                sum+=dp[n][i]; }
        return sum;

    }
    public boolean isContinuous(int [] numbers) {
        Arrays.sort(numbers);
        int count=0;
            for (int i = 0; i <numbers.length-1; i++) {
                if (numbers[i]==0)
                    count=i;
                if (numbers[i]!=0&&numbers[i]==numbers[i+1])
                    return false;
            }
            return numbers[4]-numbers[count]<5;

    }
    public int[] multiply(int[] A) {
        int[] res=new int[A.length];
        for (int i = 0,p=1; i <A.length; i++) {
            res[i]*=p;
            p*=A[i];
        }
        for (int i = A.length-1,p=1; i >0 ; i++) {
            res[i]*=p;
            p*=A[i];
        }
        return res;

    }
    //归并排序
    public int inversePairs(int[] nums) {

        return mergeSort(nums,0,nums.length-1);

    }
    int mergeSort(int[] nums,int l,int r){
        if (l>=r)
            return 0;
        int mid=(l+r)>>1;
        int res=mergeSort(nums,l,mid)+mergeSort(nums, mid+1, r);
        int x=mid+1;
        int index=l;
        LinkedList<Integer> list=new LinkedList<>();
        while (index<=mid&&x<=r){
            if (nums[x]<nums[index]){
                res+=mid-index+1;
                list.add(nums[x++]);
            }
            else list.add(nums[index++]);
        }
        while (index<=mid)list.add(nums[index++]);
        while (x<=r)list.add(nums[x++]);

        Iterator it=list.listIterator();
        index=l;
        while (it.hasNext())
            nums[index++]=(int)it.next();
        System.out.println(Arrays.toString(nums));
        list.clear();
        return res;

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null||root==p||root==q)
            return root;
         TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        return left==null?right:(right==null?left:root);

    }

    public int strToInt(String str) {
        int k=0;
        while (str.charAt(k)==' ')k++;
        StringBuilder s= new StringBuilder();
        boolean f=true;
        while (str.charAt(k)=='-'){
            k++;
            f=false;
        }
        while (str.charAt(k)=='+')
            k++;

        while (k<str.length()&&str.charAt(k)-'0'>=0&&str.charAt(k)-'0'<9){
            s.append(str.charAt(k));
            k++;
        }
        long res=0L;
        if (s.length()!=0)
         res=Long.parseLong(s.toString());
        if (!f)
            res*=-1;
        return res>Integer.MAX_VALUE?Integer.MAX_VALUE:(res<Integer.MIN_VALUE?Integer.MIN_VALUE:(int)res);

    }


    public void hanota(List<Integer> a, List<Integer> b, List<Integer> c) {
        move(a.size(),a,b,c);
        }

    private void move(int size, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (size==1)
        {
            c.add(a.remove(a.size()-1));
            return;
        }
        move(size-1,a,c,b);
        c.add(a.remove(a.size()-1));
        move(size-1,b,a,c);

    }

    public int minIncrementForUnique(int[] A) {
        int count=0;
        Arrays.sort(A);
        for (int i = 1; i <A.length; i++) {
            if (A[i]<=A[i-1]){

                count+=A[i-1]-A[i]+1;
                A[i]=A[i-1]+1;
            }
        }
        return count;

    }




}
