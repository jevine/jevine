import java.util.Scanner;

public class jk {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j,k,l;
        int[] in=new int[m-1];
        for (int x:in
             ) {
            in[x]=nums1[x];
        }
        for (j=0,k=0,l=0;j<m&&k<n;l++){
            if (in[j]<nums2[k]){
                nums1[l]=in[j];
                j++;
            }
            else{
                nums1[l]=nums2[k];
                k++;
            }
        }
            while(j<m){
                ++l;
                nums1[l]=in[j];
                j++;

            }
        while(k<n){
            ++l;
            nums1[l+1]=in[k];
            j++;
        }

    }
        }