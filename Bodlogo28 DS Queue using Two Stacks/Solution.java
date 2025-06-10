import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        Deque<Integer> stackNewest = new ArrayDeque<>();
        Deque<Integer> stackOldest = new ArrayDeque<>();

        for (int i = 0; i < q; i++) {
            String[] line = br.readLine().trim().split(" ");
            int type = Integer.parseInt(line[0]);

            switch (type) {
                case 1:
                 
                    int x = Integer.parseInt(line[1]);
                    stackNewest.push(x);
                    break;
                case 2:
                  
                    shiftStacks(stackNewest, stackOldest);
                    stackOldest.pop();
                    break;
                case 3:
                   
                    shiftStacks(stackNewest, stackOldest);
                    System.out.println(stackOldest.peek());
                    break;
            }
        }
    }

    private static void shiftStacks(Deque<Integer> stackNewest, Deque<Integer> stackOldest) {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}
