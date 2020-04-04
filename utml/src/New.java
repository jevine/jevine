import java.util.Arrays;
import java.util.HashSet;

public class New {
    public int duplicateInArray(int[] nums) {
        int start=1;
        int end=nums.length-1;
        while(start<end){
            int mid=(start+end)/2;
            int loop=0;
            for (int x:nums
                 ) {
                if (x<mid)loop++;
            }
            if (loop>mid-start+1)
                end=mid;
            else start=mid;
        }
        return end;
/*
                int len=nums.length;
                HashSet<Integer> hs=new HashSet<Integer>();
                if(len==0)
                    return -1;
                else
                    Arrays.sort(nums);
                if(nums[0]<0||nums[len-1]>len)
                    return -1;
                for (int i = 0; i <len ; i++) {
                    if (!hs.add(nums[i])){
                        return nums[i];
                    }
                }
                return -1;*/
            }
        }

