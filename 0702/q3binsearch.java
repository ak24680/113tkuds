import java.util.Scanner;

public class q3binsearch {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int key = scanner.nextInt();

            int left = 0, right = n - 1;
            int ops = 0;
            int index = -1;

            while (left <= right) {
                ops++;
                int mid = left + (right - left) / 2;
                if (arr[mid] == key) {
                    index = mid;
                    break;
                } else if (arr[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(index);
            System.out.println(ops);
        }
    }
}
