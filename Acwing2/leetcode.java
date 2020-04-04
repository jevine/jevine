import java.util.*;

public class leetcode {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            if (!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }
            else return new int[]{map.get(target-nums[i]),i};
        }
        return null;

    }
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list=new LinkedList<>();
        Arrays.sort(num);
        int n=num.length;
        for (int i = 0; i <n; i++) {
            int left=n-1,right=i+1;
            if (num[i]==num[i-1])
                continue;
            while (left<=right){

                if (num[i]+num[left]+num[right]==0){
                    List<Integer> l=new LinkedList<>();
                    l.add(num[left]);
                    l.add(num[right]);
                    l.add(num[i]);
                    list.add(l);
                    left--;
                    right++;
                    while (left<=right&&num[left+1]==num[left])
                        left--;
                    while (left<=right&&num[right-1]==num[right])
                        right++;
                }
                else if (num[i]+num[left]+num[right]>0)
                    left--;
                else
                    right++;
            }
        }
        return list;
    }

    public int lastRemaining(int n, int m) {
        int count=0;
        for (int i=2;i<n;i++) {
            count=(count+m)%i;
        }
        return count;
    }

}
