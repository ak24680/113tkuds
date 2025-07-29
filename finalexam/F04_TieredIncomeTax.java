import java.util.Scanner;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] brackets = {540000, 1210000, 2420000, 4530000};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};

        double totalTax = 0;

        for (int i = 0; i < n; i++) {
            int income = sc.nextInt();
            double tax = calculateTax(income, brackets, rates);
            totalTax += tax;
            System.out.printf("Tax: $%.0f\n", tax);
        }

        double avgTax = n > 0 ? totalTax / n : 0;
        System.out.printf("Average: $%.0f\n", avgTax);
        sc.close();
    }

    static double calculateTax(int income, int[] brackets, double[] rates) {
        double tax = 0;
        int prevLimit = 0;

        for (int i = 0; i < brackets.length; i++) {
            if (income <= brackets[i]) {
                tax += (income - prevLimit) * rates[i];
                return tax;
            } else {
                tax += (brackets[i] - prevLimit) * rates[i];
                prevLimit = brackets[i];
            }
        }
        tax += (income - prevLimit) * rates[rates.length - 1];
        return tax;
    }
}

/*
 * 時間複雜度：O(n)
 * 說明：對 n 筆收入，每筆計算稅額時段階稅率的判斷固定次數(5級距)，
 *       因此對每筆輸入都是常數時間，整體為線性時間 O(n)。
 */
