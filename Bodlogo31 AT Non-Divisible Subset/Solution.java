import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Result {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    
        int[] remainderCounts = new int[k];
        
        for (int num : s) {
        remainderCounts[num % k]++;
    }

        int result = 0;   
        result += Math.min(remainderCounts[0], 1);
        
        for (int i = 1; i <= k / 2; i++) {
        if (i != k - i) {
            result += Math.max(remainderCounts[i], remainderCounts[k - i]);
        } else {
            
            result += 1;
        }
    }
    return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}