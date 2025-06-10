import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> A = new Stack<>();
        A.addAll(number);
        
        List<Integer> primes = generatePrimes(q);
        
        for (int i = 0; i < q; i++) {
            int prime = primes.get(i);
            Stack<Integer> A1 = new Stack<>();
            Stack<Integer> B = new Stack<>();
            
            while (!A.isEmpty()) {
                int num = A.pop();
                if (num % prime == 0) {
                    B.push(num);
                } else {
                    A1.push(num);
                }
            }
            
            while (!B.isEmpty()) {
                result.add(B.pop());
            }
            
            A = A1;
        }
        
        while (!A.isEmpty()) {
            result.add(A.pop());
        }
        
        return result;
    }
    
    private static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n == 0) return primes;
        
        primes.add(2);
        int num = 3;
        while (primes.size() < n) {
            boolean isPrime = true;
            for (int p : primes) {
                if (p * p > num) break;
                if (num % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
            num += 2;
        }
        return primes;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
