
// 1310. XOR Queries of a Subarray
import java.util.Arrays;

public class Main12 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        // create the prefix XOR query
        int n = arr.length;
        int[] prefixXOR = new int[n];

        //  fill the prefixXOR query
        prefixXOR[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }
        // process each query to store the result
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            if (L == 0) {
                result[i] = prefixXOR[R];
            } else {
                result[i] = prefixXOR[R] ^ prefixXOR[L - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Main12 sol = new Main12();
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] result = sol.xorQueries(arr, queries);
        System.out.println(Arrays.toString(result));
    }

}
