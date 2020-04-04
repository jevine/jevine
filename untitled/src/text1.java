/*
public class text1 {
    public static String ToString(char[] arr,int index){
    String str="";
    for (int x=index;x<arr.length;x++){
        if (x!=arr.length-1)
            str=str+arr[x];
        else
            str=str+arr[x];
    }
    return str;
}//数组变为字符
    public static String trans(int num10,int base,int offset){
        char[] cha={'0','1','2','3','4','5','6',
                '7','8','9','a','b','c','d','e','f'};
        char[] arr=new char[32];
        int index=arr.length;
        while(num10!=0) {
            int a=num10&base;

            arr[--index]=cha[a];
            num10 = num10 >>> offset;
        }
        String str=ToString(arr,index);
        return str;
    }//数组中以查表的方式从10进制转为16进制
    public static void main(String[] args){
        String str1=trans(7685,15,4);
        System.out.println("0x"+str1);
        String str2=trans(7685,1,1);
        System.out.println("binary:"+str2);
        String str4=trans(7685,3,2);
        System.out.println("si:"+str4);
        String str3=trans(7685,7,3);
        System.out.println("octal:"+str3);
    }
}
*/


public class text1 {
    /*public static int[] compare(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
                    int temp = arr[y];
                    arr[y] = arr[x];
                    arr[x] = temp;
                }
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {88, 99, 90, 65, 87, 54};
        compare(arr);
        for (int x = 0; x < arr.length; x++) {
            System.out.println(arr[x]);
        }
    }*/
    int y=9;
    public static void main(String[] args){
        text1 x=new text1();
        x.y=6;
        show(new text1());
        System.out.println(x.y);
    }
    public static void show(text1 x){
        x.y=5;
    }
}