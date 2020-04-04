

    public class stringEquals {
        public static void main(String[] args) {
            stringEquals d=new stringEquals();
            System.out.println(d.toHex(60));
            /*
            * String s="a";
            * String s1="ab";
            * String s2="b"+s;
            * s1.equals(s2) this is true
            * but s1==s2 this is false
            * s2 is new String
            * s1 is from String buffer
            * ==比较引用的地址是否相同
            * equals比较的是字符串内的内容是否一致*/
        }
        public String toHex(int x){
            char[] temp=new char[8];
            int[]  te=new int[8];
            for (int i = 0; i <8 ; i++) {
                te[i]=x&15;
                switch(te[i]){
                    default:
                        temp[i]=(char)(te[i]+48);
                        break;
                    case 10:
                        temp[i]='A';
                        break;
                    case 11:
                        temp[i]='B';
                        break;
                    case 12:
                        temp[i]='C';
                        break;
                    case 13:
                        temp[i]='D';
                        break;
                    case 14:
                        temp[i]='E';
                        break;
                    case 15:
                        temp[i]='F';
                        break;
                }
                x=x>>>4;
            }
            String str="";
            for (int i = 7; i>=0; i--) {
                if (temp[i]!='0'||!str.equals(""))
                    str=str+temp[i];
            }
            return str;
        }
    }


