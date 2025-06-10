import java.io.*;

class Result {

    
    public static String timeInWords(int h, int m) {
     String[] numbers = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
        "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"
    };

    if (m == 0) {
        return numbers[h] + " o' clock";
    } else if (m == 15) {
        return "quarter past " + numbers[h];
    } else if (m == 30) {
        return "half past " + numbers[h];
    } else if (m == 45) {
        int nextHour = h % 12 + 1;
        return "quarter to " + numbers[nextHour];
    } else if (m < 30) {
        String minuteWord = (m == 1) ? "minute" : "minutes";
        return numbers[m] + " " + minuteWord + " past " + numbers[h];
    } else {
        int remainingMinutes = 60 - m;
        int nextHour = h % 12 + 1;
        String minuteWord = (remainingMinutes == 1) ? "minute" : "minutes";
        return numbers[remainingMinutes] + " " + minuteWord + " to " + numbers[nextHour];

    }

}
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
