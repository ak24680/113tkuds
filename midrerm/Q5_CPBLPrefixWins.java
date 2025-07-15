import java.util.Scanner;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            results[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int[] prefixSum = new int[n + 1]; // prefixSum[0] = 0
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + results[i - 1];
        }

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + prefixSum[i]);
        }
        System.out.println();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：前綴和陣列只需線性走訪一次建立 O(n)，輸出前 k 個也 O(k) ≤ O(n)，總複雜度為 O(n)。
 */
