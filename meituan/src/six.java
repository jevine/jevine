import java.util.Arrays;

public class six {
    public static void main(String[] args) {
        new six().hasGroupsSizeX(new int[]{1,1,3,2,4,5});
    }
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length<2)
            return false;
        int[] temp=new int[10000];
        for (int x:deck
             ) {
            System.out.println(++temp[x]);
        }
        int res=0;
        for (int i = 0; i <10000; i++) {
            if(res==0&&temp[i]>1)
                res=temp[i];
            else if (res!=0&&temp[i]>1){
                res=gbs(res,temp[i]);
            }

        }
        return res>=2;
    }

    private int gbs(int res, int i) {
        return res==0?i:(gbs(i%res,res));
    }
}
