
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//输出一组数据所有的排列方式
public class Permutation {
    public static void main(String[] args) {
        int[] nums={1,2,4};
        System.out.println(new Permutation().permutation(nums).toString());
    }
    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> listIn1=new ArrayList<>();
        //Arrays.sort(nums);
        for (int n:nums
        ) {
            listIn1.add(n);
        }
        list.add(listIn1);
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length; j++) {
                int[] nums1=nums.clone();
                List<Integer> listIn=new ArrayList<>();
                int temp=nums1[i];
                nums1[i]=nums1[j];
                nums1[j]=temp;
                for (int n:nums1
                     ) {
                    listIn.add(n);
                }
                list.add(listIn);
            }

        }
        return list;

    }
}
