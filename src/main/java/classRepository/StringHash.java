package classRepository;

import java.util.Arrays;
import java.util.List;

public class StringHash {

    public static void main(String[] args) {
        String a = "";
        String b = "";
        List<Character> letters = Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L');
        for(int i = 0 ; i < letters.size() -1 ; ++i){
            a = letters.get(i) + "a";
            b = letters.get(i+1) + "B";
            System.out.println(a.hashCode() == b.hashCode());
        }
    }
}
