public class test {
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
    public static String n10to16(int num10){
        char[] cha=new char[8];
       int index=8;
       while(num10!=0) {
           int a=num10&15;

               if (a > 9)
                   cha[--index]= (char) (a - 9 + 'a');
               else
                   cha[--index]= (char) (a  + '0');
           num10 = num10 >>> 4;
       }
       String str=ToString(cha,index);
       return str;
    }//数组方式从10进制转为16进制
    public static void main(String[] args){
       String str=n10to16(7898);
        System.out.println("0x"+str);
    }
}
    /*public static void main(String[] args){
       int[] arr={2,6,7,44,89};
       String str=ToString(arr);
        System.out.println(str);
    }
}
public class test{
    public static String week(int num){
        if(num>7||num<0)
            return num+" no exist";
        String[] arr={"","mon","tues","wed","thur","fri","sat","sun"};
        return arr[num];

    }//输入一个数字得到对应的周
    public static void main(String[] args){
        String x=week(8);
        System.out.println("x="+x);*//*


    }*/
