import java.util.Scanner;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 吃掉換行

        int[] times = new int[n];
        String[] rawTimes = new String[n];
        for (int i = 0; i < n; i++) {
            rawTimes[i] = sc.nextLine();
            times[i] = toMinutes(rawTimes[i]);
        }
        String queryStr = sc.nextLine();
        int query = toMinutes(queryStr);

        int idx = binarySearch(times, query);

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(rawTimes[idx]);
        }
    }

    static int toMinutes(String hhmm) {
        String[] parts = hhmm.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        return hour * 60 + min;
    }

    static int binarySearch(int[] times, int query) {
        int left = 0, right = times.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (times[mid] > query) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // 若找不到就是 n
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：輸入轉換 O(n)，但查詢使用二分搜尋 O(log n)，主要時間取決於搜尋。
 */
