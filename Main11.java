
// ADD BINARY

public class Main11{
    public String addBinary(String a, String b){
       StringBuilder result = new StringBuilder();
       
       int i = a.length() - 1;
       int j = b.length() - 1;
       int carry = 0;

       while (i >= 0 || j >= 0) {
        int sum = carry;
        if(i >= 0) sum += a.charAt(i--) - '0'; // Convert char to int
        if(j >= 0) sum += b.charAt(j--) - '0';

        result.append(sum % 2); // Append current digit
        carry = sum / 2; // calculate carry
       }
       if (carry != 0) {
        result.append(carry);
       }
        return result.reverse().toString(); // Reverse to get a final result
    }
    public static void main(String[] args) {
        Main11 sol = new Main11();
        String a = "11";
        String b = "1";
        String result = sol.addBinary(a, b);
        System.out.println(result);
    }
}
