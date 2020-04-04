/*public class demo {
    public static void main(String[] args) {
       for (int i=1;i<=5;i++){
           for (int y=i;y<=5;y++){
               System.out.print("*");//easy
           }
           System.out.println();
       }
    }
}*/



public class demo {
    public static String reverse(String s){

        return new StringBuffer(s).reverse().toString();//jdk自带的方法 自己加写一行代码
    }
    public static String Hex(int num10){
        String str=" ";
        for (int y=1;y<9;y++){
            int x=num10 & 15;
            if (x>9) {
                //System.out.println("x="+(char)(x-10+'a'));
                str=str+(char)(x-10+'a');
            }
            else {
                //System.out.println((char) (x + '0'));
                str = str + (char) (x + '0');
            }
            num10=num10>>>4;
            }
        str=reverse(str);
        int n=0;
        outloop:for (int x=0;x<8;x++){
                String s=str.substring(x,x+1);
                if (s.equals("0")) {
                    n=x;
                }
                else{break outloop;
                }

            }
        str=str.substring(n+1,8);
        return str;
    }//以字符串的方式进行10转16
    public static void main(String[] args){
        String str=Hex(256);
        System.out.println("0x"+str);
    }}
/*public class demo {
    public static void main(String[] args) {
        String s="hiuhf";
        s = s.substring(2, 5);
        //if (s.equals("c"))
        System.out.println(s);


    }
}*/
