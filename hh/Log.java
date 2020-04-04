import java.util.*;

public class Log {
    public static void main(String[] args) {
        System.out.println(new Log().digitAtIndex(Integer.MAX_VALUE));

       /* int x=1000000000;long y= 11000000000L;
        System.out.println(x-y);*/
    }
        public int digitAtIndex(int n) {
            long i=1L;
            int x;
            long count=1L;
            while (n > i * 9*count) {
                n = (int) (n - i * 9*count);
               /* if (i * 9*count==720000000){
                    i = i * 10;
                    count++;
                    break;
                }*/
                //System.out.println(n);
                i = i * 10;
                count++;
            }
            String s="";
            x= (int) (i+((n+count-1)/count)-1);
            s=s+x;
            //System.out.println(n);
            //System.out.println(count);
            i=n%count==0?count:n%count;
            //System.out.println(i);
                return Integer.parseInt(String.valueOf(s.charAt((int) (i-1))));
        }
        //返回字符串中第一个没有重复的字符
       public char firstNotRepeatingChar(String s) {
        String str="#";
        if (s.length()==0)
            return str.charAt(0);
        String[] item = s.split("");
        Map<String,Integer> ma= new HashMap<>();
        for (String element : item) {
            if (ma.containsKey(element))
                ma.replace(element, 0);
            else ma.put(element, 1);
        }
        for (String value : item) {
            if (ma.get(value) == 1) {
                str = value;
                break;
            }
        }
        return str.charAt(0);

    }
    }


