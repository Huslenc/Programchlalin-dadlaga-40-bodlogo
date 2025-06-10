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
    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();
        if (startX == goalX && startY == goalY) return 0;
        
       
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        
        boolean[][] visited = new boolean[n][n];
        int[][] distance = new int[n][n];
        for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        distance[startX][startY] = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            
            for (int[] dir : directions) {
                int dx = dir[0];
                int dy = dir[1];
                int steps = 1;
                
                
                while (true) {
                    int newX = x + dx * steps;
                    int newY = y + dy * steps;
                    
                   
                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || 
                        grid.get(newX).charAt(newY) == 'X') {
                        break;
                    }
                    
                   
                    if (distance[x][y] + 1 < distance[newX][newY]) {
                        distance[newX][newY] = distance[x][y] + 1;
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                        
                        
                        if (newX == goalX && newY == goalY) {
                            return distance[newX][newY];
                        }
                    }
                    
                    steps++;
                }
            }
        }
        
        return distance[goalX][goalY] == Integer.MAX_VALUE ? -1 : distance[goalX][goalY];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
