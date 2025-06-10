import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        long result = 0;
        Stack<Pair> stack = new Stack<>();

        for (int num : arr) {
            while (!stack.isEmpty() && stack.peek().value < num) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek().value == num) {
                result += stack.peek().count;
                stack.peek().count++;
            } else {
                stack.push(new Pair(num, 1));
            }
        }

        System.out.println(result * 2);
    }

    static class Pair {
        int value;
        int count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}