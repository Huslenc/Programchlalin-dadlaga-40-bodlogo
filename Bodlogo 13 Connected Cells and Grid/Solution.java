import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

   public static int connectedCell(List<List<Integer>> matrix) {
    int n = matrix.size();
    int m = matrix.get(0).size();
    boolean[][] visited = new boolean[n][m];
    int maxRegion = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) == 1 && !visited[i][j]) {
                int regionSize = dfs(matrix, visited, i, j, n, m);
                maxRegion = Math.max(maxRegion, regionSize);
            }
        }
    }

    return maxRegion;
}

private static int dfs(List<List<Integer>> matrix, boolean[][] visited, int row, int col, int n, int m) {
   
    if (row < 0 || row >= n || col < 0 || col >= m) return 0;
    if (visited[row][col] || matrix.get(row).get(col) == 0) return 0;

    visited[row][col] = true;
    int size = 1; 

    
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    for (int d = 0; d < 8; d++) {
        size += dfs(matrix, visited, row + dx[d], col + dy[d], n, m);
    }

    return size;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
