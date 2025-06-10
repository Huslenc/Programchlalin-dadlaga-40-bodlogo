import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {
    public static int downToZero(int n) {
        if (n == 0) return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        int[] steps = new int[n + 1];
        Arrays.fill(steps, -1);
        
        queue.add(n);
        steps[n] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == 0) {
                return steps[current];
            }
            
            
            if (current - 1 >= 0 && steps[current - 1] == -1) {
                steps[current - 1] = steps[current] + 1;
                queue.add(current - 1);
            }
            
           
            for (int i = 2; i * i <= current; i++) {
                if (current % i == 0) {
                    int factor = Math.max(i, current / i);
                    if (steps[factor] == -1) {
                        steps[factor] = steps[current] + 1;
                        queue.add(factor);
                    }
                }
            }
        }
        
        return steps[0];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.downToZero(n);

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
