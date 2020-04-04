import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map=new LinkedHashMap<>();
        for (int i = 0; i <5 ; i++) {
            map.put(i+1,"shuai"+i);
        }
        map.put(1,"hhh");
        for (String s : map.values()) System.out.println(s);


        /*for (Map.Entry<Integer, String> en :map.entrySet()) {
            System.out.println(en.getKey()+en.getValue());
        }*/

        //map.forEach((k,v)-> System.out.println(k+v));
    }
}
