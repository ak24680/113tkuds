import java.util.Scanner;

public class F02_YouBikeNextFull {

    static int toMinutes(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] times = new String[n];
        int[] minutes = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = sc.next();
            minutes[i] = toMinutes(times[i]);
        }

        String query = sc.next();
        int queryMin = toMinutes(query);

        int left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (minutes[mid] > queryMin) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(times[ans]);
        }
        sc.close();
    }
}

/*
 * 時間複雜度：O(log n)
 * 說明：利用二分搜尋法在已排序的時間陣列中找出首個大於查詢時間的索引。
 *       時間陣列長度為 n，二分搜尋複雜度為 O(log n)。
 *       轉換時間字串為分鐘的複雜度為 O(n)，整體以二分搜尋為主。
 */
