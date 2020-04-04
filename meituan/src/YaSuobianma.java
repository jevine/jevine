import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class YaSuobianma {
    public static void main(String[] args) {
        new YaSuobianma().minimumLengthEncoding3(new String[]{"time", "me", "bell"});
    }
    //暴力垃圾算法
    public int minimumLengthEncoding(String[] words) {
        StringBuilder sb=new StringBuilder();
        Arrays.sort(words, (x,y)->(y.length()-x.length()));
        for (int i = 0; i <words.length; i++) {
            if (sb.toString().contains(words[i]+"#")){
                continue;
            }
            sb.append(words[i]).append("#");
        }
        return sb.length();

    }
    //进阶版使用 endwith（）
    public int minimumLengthEncoding2(String[] words) {
        Arrays.sort(words, (x, y) -> {
            int n=Math.min(x.length(),y.length());
            for (int i = 0; i <n ; i++) {
                int c=Character.compare(x.charAt(x.length()-1-i),y.charAt(y.length()-1-i));
                if (c!=0)
                    return c;
            }
            return x.length()-y.length();
        });
        int res=0;

        for (int i = 0; i <words.length ; i++) {
            if (i + 1 == words.length || !words[i + 1].endsWith(words[i])) {
                res+=words[i].length()+1;
            }
        }
        return res;
    }
    //一般使用字典树
    public int minimumLengthEncoding3(String[] words){
        HashMap<TrieNode,Integer> map=new HashMap<>();
        TrieNode tn=new TrieNode();
        for (int i = 0; i <words.length ; i++) {
            TrieNode tn1=tn;
            //地址赋值给tn1，tn1上的操作影响到tn；
            for (int j = words[i].length()-1; j >=0 ; j--) {
                //tn1在get中new  了一个新的TrieNode，即
                //tn[c-'a']有了赋值。tn1=new 的TrieNode；
                tn1=tn1.get(words[i].charAt(j));

                map.put(tn1,i);
            }
        }
        int res=0;
        for (TrieNode t:map.keySet()
             ) {
            if (t.count==0)
            res+=words[map.get(t)].length()+1;
        }
        return res;
    }
    class TrieNode{
        int count;
        TrieNode[] tn;
        TrieNode(){
            tn=new TrieNode[26];
            count=0;
        }
        TrieNode get(char c){
            if (tn[c-'a']==null){
                tn[c-'a']=new TrieNode();
                count++;
            }
            return tn[c-'a'];
        }
    }
}
