import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        stack.push(sb.toString());

        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");
            int op = Integer.parseInt(input[0]);

            switch (op) {
                case 1: // Append
                    stack.push(sb.toString());
                    sb.append(input[1]);
                    break;
                case 2: // Delete
                    stack.push(sb.toString());
                    int k = Integer.parseInt(input[1]);
                    sb.delete(sb.length() - k, sb.length());
                    break;
                case 3: // Print
                    int pos = Integer.parseInt(input[1]) - 1;
                    bw.write(sb.charAt(pos) + "\n");
                    break;
                case 4: // Undo
                    sb = new StringBuilder(stack.pop());
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}