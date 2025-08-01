import java.util.Scanner;

public class F08_ClimbStairsMemo {

    static long[] memo;

    static long ways(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;  

        if (memo[n] != -1) return memo[n];

        memo[n] = ways(n - 1) + ways(n - 2) + ways(n - 3);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        memo = new long[n + 1];
        for (int i = 0; i <= n; i++) memo[i] = -1;

        long result = ways(n);
        System.out.println("Ways: " + result);
    }
}
