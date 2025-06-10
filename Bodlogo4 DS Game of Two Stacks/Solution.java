import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;



class Result {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
       
        List<Integer> prefixA = new ArrayList<>();
        List<Integer> prefixB = new ArrayList<>();
        
        int sum = 0;
        for (int num : a) {
            sum += num;
            if (sum > maxSum) break;
            prefixA.add(sum);
        }
        
        sum = 0;
        for (int num : b) {
            sum += num;
            if (sum > maxSum) break;
            prefixB.add(sum);
        }
        
        int maxCount = 0;
     
        for (int i = 0; i <= prefixA.size(); i++) {
            int sumA = (i == 0) ? 0 : prefixA.get(i-1);
            if (sumA > maxSum) break;
            
            int remaining = maxSum - sumA;
            
            
            int left = 0, right = prefixB.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefixB.get(mid) <= remaining) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            maxCount = Math.max(maxCount, i + left);
        }
        
        return maxCount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int maxSum = Integer.parseInt(firstMultipleInput[2]);

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                int result = Result.twoStacks(maxSum, a, b);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
