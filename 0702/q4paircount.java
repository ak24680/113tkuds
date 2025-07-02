import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int pairCount = 0;
            int ops = 0;

            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    ops++;
                    pairCount++;
                }
            }

            System.out.println(pairCount);
            System.out.println(ops);
        }
    }
}
