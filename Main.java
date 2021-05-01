import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scnanner = new Scanner(System.in);

        String s = scnanner.nextLine().toLowerCase();    // true
        String t = scnanner.nextLine().toLowerCase();

       boolean result = isAnagram(s,t);
       if(result == true){
           System.out.println("yes");
       } else {
           System.out.println("no");
       }


    }
    public static boolean isAnagram(String s, String t) {
        defaultHashMap<Character, Integer> countS = new defaultHashMap<>(0);
        defaultHashMap<Character, Integer> countT = new defaultHashMap<>(0);
        if (s.length() != t.length()){
            return false;
        }
        // count frequencies of characters
        for (int i=0; i < s.length(); i++){
            countS.put(s.charAt(i), countS.get(s.charAt(i)) + 1);
            countT.put(t.charAt(i), countT.get(t.charAt(i)) + 1);
        }
//        System.out.println(countS.entrySet());
//        System.out.println(countT.entrySet());

        // compare to map
        for (Map.Entry<Character, Integer> entry : countT.entrySet()){
            if (! entry.getValue().equals(countS.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
/*
define a defaultHashMap class extending hashmap
*/
class defaultHashMap <K,V> extends HashMap<K,V> {
    protected V defaultValue;
    public defaultHashMap(V defaultValue) {
        this.defaultValue = defaultValue;
    }
    @Override
    public V get(Object k) {
        return containsKey(k) ? super.get(k) : defaultValue;
    }

}
