import java.util.*;

public class Test3{
    public static void main(String[] args) {
        int x=90;
        System.out.println(Integer.toString(x).length());
    }
    //求一个数组中有重复数字的排列组合，list<list> add list，会随着list的更新 之前add的list也会被更新
    //需要 new list(list)
    private List<List<Integer>> li=new ArrayList<>();

    public List<List<Integer>> permutation(int[] nums){
      List<Integer> l=new ArrayList<>();
       for (int i = 0; i <nums.length ; i++) {
           l.add(0);
       }
       Arrays.sort(nums);
       dps(nums,0,0,0,l);
       return li;
   }

    private void dps(int[] nums, int u, int start, int state,List<Integer> l) {
       if (u==nums.length){
           li.add(new ArrayList<>(l));
           return;
       }
       if (u==0||nums[u]!=nums[u-1])start=0;
        for (int i = start; i <nums.length ; i++) {
            if ((state>>i&1)!=1){
                l.set(i,nums[u]);
                //System.out.println(l.size());
            dps(nums, u+1, start+1, state+(1<<i),l);}
        }
    }
    //求一个数组中出现的 次数超过一半的数
    public int moreThanHalfNum_Solution(int[] nums) {
       int count=1;
       int val=0;
        for (int i = 0; i <nums.length; i++)
        {
            if (val!=nums[i])
                count--;
            else count++;
            if (count<0)
            {
                count=1;
                val=nums[i];
            }
        }
        return val;

    }
    //把数字翻译成字符串(类似于走楼梯的升级版，动态规划，斐波那契额数列)

    public int getTranslationCount(String s) {
       String[] str=s.split("");
       int[] tem=new int[str.length];
       int i=0;
        for (String s1:str
             ) {
            tem[i++]=Integer.parseInt(s1);
        }
        int[] val=new int[str.length+1];
        val[0]=1;
        val[1]=1;
        for (int j = 2; j <tem.length+1; j++) {
            int x=tem[j-2]*10+tem[j-1];
            if (tem[j-2]!=0&&x!=0&&x<26)
            val[j]=val[j-1]+val[j-2];
            else
                val[j]=val[j-1];

        }
       return val[str.length];
    }
    public List<Integer> getLeastNumbers_Solution(int [] input, int k) {
           boolean x=input.length-k<0;
           if (!x)
               throw new RuntimeException("hhhhhhh");

       Arrays.sort(input);
       List<Integer> list=new ArrayList<>();
        for (int i = 0; i <k ; i++) {
            list.add(input[i]);
        }
        return list;

    }

    //中位数,用于判断奇偶性用位运算比较合适&1
    private PriorityQueue<Integer> max=new PriorityQueue<>();
    private PriorityQueue<Integer> min=new PriorityQueue<>((o1, o2) -> o2-o1);
    public void insert(Integer num) {
        min.offer(num);
        if (max.peek()!=null&&max.peek()<min.peek()){
            Integer x=max.poll(),y=min.poll();
            max.offer(y);min.offer(x);
        }
        if (min.size()-max.size()>1)
        max.offer(min.poll());
    }
    public Double getMedian(){
        if (((max.size()+min.size())&1)==1)
        {
            return (double) min.peek();
        } else
            return (min.peek()+max.peek())/2.0;
    }


}
