import java.util.Arrays;
import java.util.Random;

public class Paixu {
    public static void main(String[] args) {
        int[] num=new int[]{234,100,8,3,44,99,1,4,5,33,230};

        new Paixu().heapify(num);
        System.out.println(Arrays.toString(num));
    }
    //插入排序模板
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        for (int i = 1; i <n; i++) {
            int  temp=nums[i];
            int j=i;
            while(j>0&&nums[j-1]>temp){
                nums[j]=nums[j-1];
                j--;
            }
           nums[j]=temp;
        }
        return nums;
    }
    //快速排序模板
    /**
     * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
     */
    private static final Random RANDOM = new Random();
    public int[] sortArray1(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right) {
        if (right<=left)
            return;
        int pIndex = partition(nums, left, right);
        System.out.println(Arrays.toString(nums));
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }
    private int partition(int[] nums, int left, int right) {
        int location = left;
        for (int i = left ; i < right; i++) {
            if (nums[i] < nums[right]) {
                swap1(nums, i, location);
                location++;
            }
        }
        swap1(nums, left, location);
        return location;
    }

    private void swap1(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    //堆排序模板
    public int[] sortArray2(int[] nums) {
        int len = nums.length;
        // 将数组整理成堆，
        heapify(nums);

        // 循环不变量：区间 [0, i] 堆有序
        for (int i = len - 1; i >= 1; ) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, 0, i);
            // 逐步减少堆有序的部分
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            siftDown(nums, 0, --i);
        }
        return nums;
    }

    /**
     * 将数组整理成堆（堆有序）
     *
     * @param nums
     */
    private void heapify(int[] nums) {
        int len = nums.length;
        // 只需要从 i = (len - 1) / 2 这个位置开始逐层下移
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    /**
     * @param nums
     * @param k    当前下沉元素的下标
     * @param end  [0, end] 是 nums 的有效部分,模拟大根堆
     */
    private void siftDown(int[] nums, int k, int end) {
        while (k*2+1<=end){
            int j=2*k+1;
            if (j+1<=end&&nums[j+1]>nums[j])
                j++;
            if (nums[j]>nums[k])
                swap(nums,j,k);
            else break;
            k=j;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    //归并排序模板
    public int[] sortArray3(int[] nums) {
        int len=nums.length;
        int[] item=new int[len];
        mergeSort(nums,0,len-1,item);
        return nums;

    }

    private void mergeSort(int[] nums, int left, int right, int[] item) {

        int INSERTION_SORT_THRESHOLD = 7;
        if (right-left< INSERTION_SORT_THRESHOLD){
            insertSort(nums,left,right);
            return;
        }

        int mid=left+right>>1;
        mergeSort(nums,left,mid,item);
        mergeSort(nums,mid+1,right,item);
        if (nums[mid+1]>nums[mid])
            return;
        mergeOfTwoArray(nums,left,mid,right,item);

    }

    private void mergeOfTwoArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right + 1 - left);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1)
                nums[k] = temp[j++];
             else if (j == right + 1)
                nums[k] = temp[i++];
            else if (temp[i] <= temp[j])
                // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                nums[k] = temp[i++];
             else
                // temp[i] > temp[j]
                nums[k] = temp[j++];
        }
    }
//较小长度的插入排序
    private void insertSort(int[] nums, int left, int right) {

        for (int i = left+1; i <=right ; i++) {
            int temp=nums[i];
            int j=i;
            while (j>left&&temp<nums[j-1]){
                nums[j]=nums[j-1];
                j--;
            }
            nums[j]=temp;
        }

    }


}
