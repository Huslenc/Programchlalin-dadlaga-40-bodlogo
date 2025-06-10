import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

   
    public static void countSort(List<List<String>> arr) {
        int n = arr.size();
        int half = n / 2;
        
       
        int max = 0;
        for (List<String> pair : arr) {
            int num = Integer.parseInt(pair.get(0));
            if (num > max) {
                max = num;
            }
        }
        
       
        List<List<String>> count = new ArrayList<List<String>>();
        for (int i = 0; i <= max; i++) {
            count.add(new ArrayList<String>());
        }
        
   
        for (int i = 0; i < n; i++) {
            List<String> pair = arr.get(i);
            int num = Integer.parseInt(pair.get(0));
            String s = pair.get(1);
            
            
            if (i < half) {
                s = "-";
            }
            
            count.get(num).add(s);
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (List<String> list : count) {
            for (String s : list) {
                sb.append(s).append(" ");
            }
        }
        
        
        System.out.println(sb.toString().trim());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        Result.countSort(arr);

        bufferedReader.close();
    }
}