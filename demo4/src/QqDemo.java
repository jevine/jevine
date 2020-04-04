public class QqDemo {
    public static void main(String[] args) {
        String qq="7938793r";
        String regex="[1-9][0-9]{4,14}";
        boolean b=qq.matches(regex);
        System.out.println(qq+b);
        int len=qq.length();
        if (len>4&&len<16){
            if (qq.startsWith("0")){
                System.out.println(qq+"startWith wrong");
            }else{
                try {
                    Long l=Long.parseLong(qq);
                    System.out.println(l);
                } catch (NumberFormatException e) {
                    System.out.println(qq+"format wrong");
                }
            }
        }else
            System.out.println(qq+"length wrong");

    }
}
