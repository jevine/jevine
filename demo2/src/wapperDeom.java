

import java.util.Arrays;
public class wapperDeom {
    public static void main(String[] args) {
        String num="20 78 9 -7 88 36 29";
        System.out.println(num);
        num=sortStringNumber(num);
        System.out.println(num);
    }
    public static String sortStringNumber(String num){
        String[] s=StringToArray(num);
        int[] arr=toIntArray(s);
        mySortArray(arr);
        String temp=arrayToString(arr);
        return temp;

    }
    public static String[] StringToArray(String num){
        String[] s=num.split(" ");
        return s;
    }
    public static int[] toIntArray(String[] str){
        int[] arr=new int[str.length];
        for (int i=0;i<str.length;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        return arr;
    }
    public static void mySortArray(int[] i){
        Arrays.sort(i);

    }
    public static String arrayToString(int[] i){
        StringBuilder sb=new StringBuilder();
        for (int x=0;x<i.length;x++){
            if (x!=i.length-1){
                sb.append(i[x]+" ");
            }
            else
                sb.append(i[x]);
        }
        return sb.toString();
    }


}
