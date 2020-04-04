public class ZhengDemo {
    public static void main(String[] args) {
        function1();
       // function2();
    }

    public static void function2() {

        String str="zhangsantttttxiaoqiangmmmmmzhaoliu";
        String s1="16789879877";
        String s = str.replaceAll("(.)\\1+","$1");
        String s2=s1.replaceAll
                ("(\\d{3})(\\d{4})(\\d{4})","$1****$3");
        System.out.println(s2);
        System.out.println(s);

    }

    public static void function1() {
        String str = "hua...shuai+++kile";
        String[] s = str.split("(.)\\1+");
        for (String j : s
        ) {
            System.out.println(j);
        }
    }
}
