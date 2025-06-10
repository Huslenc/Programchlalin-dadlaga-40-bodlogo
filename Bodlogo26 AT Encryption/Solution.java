import java.io.*;

class Result {

    

    public static String encryption(String s) {
        
        String str = s.replaceAll("\\s+", "");
        int length = str.length();
        
      
        int r = (int) Math.floor(Math.sqrt(length));
        int c = (int) Math.ceil(Math.sqrt(length));
        
        
        if (r * c < length) {
            r++;
        }
        
      
        char[][] grid = new char[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (index < length) {
                    grid[i][j] = str.charAt(index++);
                } else {
                    grid[i][j] = ' '; 
                }
            }
        }
        
       
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                if (grid[i][j] != ' ') {
                    result.append(grid[i][j]);
                }
            }
            if (j < c - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}