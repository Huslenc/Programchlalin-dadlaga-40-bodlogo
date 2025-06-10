import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int solve(List<List<Integer>> shots, List<List<Integer>> players) {
        List<Integer> shotStarts = new ArrayList<>();
        List<Integer> shotEnds = new ArrayList<>();
        
        for (List<Integer> shot : shots) {
            shotStarts.add(shot.get(0));
            shotEnds.add(shot.get(1));
        }
        
        Collections.sort(shotStarts);
        Collections.sort(shotEnds);
        
        int total = 0;
        
        for (List<Integer> player : players) {
            int a = player.get(0);
            int b = player.get(1);
            
            
            int startsBeforeB = upperBound(shotStarts, b);
            
            
            int endsBeforeA = lowerBound(shotEnds, a);
            
            total += startsBeforeB - endsBeforeA;
        }
        
        return total;
    }
    
    private static int upperBound(List<Integer> list, int value) {
        int left = 0;
        int right = list.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private static int lowerBound(List<Integer> list, int value) {
        int left = 0;
        int right = list.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> shots = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                shots.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> players = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                players.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.solve(shots, players);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}