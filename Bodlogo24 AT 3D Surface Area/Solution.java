import java.io.*;
import java.util.*;

class Result {

   

    public static int surfaceArea(List<List<Integer>> A) {
        int H = A.size();
        int W = A.get(0).size();
        int area = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int height = A.get(i).get(j);
                if (height > 0) {
                   
                    area += 2;

                    
                    int north = (i == 0) ? 0 : A.get(i - 1).get(j);
                    area += Math.max(height - north, 0);

                   
                    int south = (i == H - 1) ? 0 : A.get(i + 1).get(j);
                    area += Math.max(height - south, 0);

                   
                    int east = (j == W - 1) ? 0 : A.get(i).get(j + 1);
                    area += Math.max(height - east, 0);

                    int west = (j == 0) ? 0 : A.get(i).get(j - 1);
                    area += Math.max(height - west, 0);
                }
            }
        }
        return area;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);
        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String[] rowItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < W; j++) {
                row.add(Integer.parseInt(rowItems[j]));
            }
            A.add(row);
        }

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
