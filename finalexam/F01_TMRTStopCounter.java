import java.util.Scanner;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }
        String start = sc.next();
        String end = sc.next();

        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) startIdx = i;
            if (stops[i].equals(end)) endIdx = i;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(endIdx - startIdx) + 1);
        }
        sc.close();
    }
}

/*
 * 時間複雜度：O(n)
 * 說明：透過一次線性掃描陣列找出起站與訖站索引位置。
 *       陣列長度為 n，最多掃描 n 次。
 *       計算站數為兩索引差值絕對值加一，複雜度為常數。
 */

