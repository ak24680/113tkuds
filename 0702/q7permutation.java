import java.util.Scanner;

public class q7permutation {
    static int ops = 0;

    static void permute(int[] arr, int start, int n) {
        if (start == n) {
            ops++;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
                if (i < n - 1) System.out.print(" ");
            }
            System.out.println();
        } else {
            for (int i = start; i < n; i++) {
                swap(arr, start, i);
                permute(arr, start + 1, n);
                swap(arr, start, i); 
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
            permute(arr, 0, n);
            System.out.println(ops);
        }
    }
}
