public class DepthMin {
    public int[] maxDepthAfterSplit(String seq) {
        int len=seq.length();
        int[] item=new int[len];
        int depth=-1;
        for (int i = 0; i <len-1; i++) {
            if (seq.charAt(i)=='(')
                item[i]=++depth%2;
            if (seq.charAt(i)==')')
                item[i]=--depth%2;
        }
        return item;

    }
}
