
// ROMAN TO INTEGER

import java.util.HashMap;

public class Main9 {
public static int RomantoInt(String s){
    HashMap<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int total = 0;
    int preValue = 0;

    for(int i = s.length()-1; i >= 0; i--){
        char curChar = s.charAt(i);
        int curValue = map.get(curChar);

        if (curValue < preValue) {
            total = total - curValue;
        }else{
            total = total + curValue;
        }
        preValue = curValue;
    }
    return total;
}
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int result = RomantoInt(s);
        System.out.println(result);
    }
}
