import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

   
    public static int formingMagicSquare(List<List<Integer>> s) {
        int[][][] magicSquares = {
            {{8,1,6},{3,5,7},{4,9,2}},
            {{6,1,8},{7,5,3},{2,9,4}},
            {{4,9,2},{3,5,7},{8,1,6}},
            {{2,9,4},{7,5,3},{6,1,8}},
            {{8,3,4},{1,5,9},{6,7,2}},
            {{4,3,8},{9,5,1},{2,7,6}},
            {{6,7,2},{1,5,9},{8,3,4}},
            {{2,7,6},{9,5,1},{4,3,8}}
        };

        int minCost = Integer.MAX_VALUE;

        for (int[][] magic : magicSquares) {
            int cost = 0;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    cost += Math.abs(s.get(row).get(col) - magic[row][col]);
                }
            }
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
