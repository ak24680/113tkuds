import java.util.Scanner;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        int gcd = gcdSubtraction(a, b);
        long lcm = (long) a * b / gcd;

        System.out.println("LCM: " + lcm);
    }

    // 使用輾轉相減法遞迴求 GCD
    static int gcdSubtraction(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcdSubtraction(a - b, b);
        else return gcdSubtraction(a, b - a);
    }
}

/*
 * 時間複雜度：最壞情況 O(max(a, b))
 * 說明：輾轉相減法每次遞迴至少會減小較大數字，若兩數相差很大時，
 *       需要大量遞迴調用，複雜度較歐幾里得除法高。
 *       計算 LCM 時為常數時間，整體仍以 gcd 計算為主。
 */
