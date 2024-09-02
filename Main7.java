
//LONGEST LENGTH SUB STRING...

import java.util.HashMap;

public class Main7 {
    public static int longLenOfSubString(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap <Character, Integer> map =  new HashMap<>();

        int maxLength = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left);
            }

            map.put(currentChar, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }  
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longLenOfSubString(s));
    }  
}