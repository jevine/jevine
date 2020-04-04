public class countDemo {
    public static void main(String[] args) {
        String str="abjljlkabkdjababab";
        String key="ab";
        String s1="abjljlkabkdjababab";
        String s2="pabjp";
        int count=count2(str,key);
        System.out.println(count);
        String s3=compare(s1,s2);
        System.out.println(s3.length()+"  "+s3);
    }
    public static int count2(String str,String key){
        int index=0;
        int count=0;
        while((index=str.indexOf(key,index))!=-1){
            index=index+key.length();
            count++;
        }
        return count;
    }
    public static String compare(String s1,String s2){
        int len;
        String len1;
        String min;
        min=s1.length()<s2.length()?s1:s2;
            len=min.length();

        t:for (int i=0;i<len;i++){
            for (int y=0;y<=i;y++){
                len1=s2.substring(y,len-i);
                System.out.println(len+1-i+"   "+i);
                if (s1.contains(len1)==true)
                    return len1;
            }
        }return null;
    }
}
