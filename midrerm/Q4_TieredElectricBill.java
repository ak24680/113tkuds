import java.util.Scanner;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            int bill = calc(kWh);
            System.out.println("Bill: $" + bill);
            total += bill;
        }

        int avg = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }

    static int calc(int kWh) {
        double cost = 0;

        if (kWh <= 120) {
            cost = kWh * 1.68;
        } else if (kWh <= 330) {
            cost = 120 * 1.68 + (kWh - 120) * 2.45;
        } else if (kWh <= 500) {
            cost = 120 * 1.68 + 210 * 2.45 + (kWh - 330) * 3.70;
        } else if (kWh <= 700) {
            cost = 120 * 1.68 + 210 * 2.45 + 170 * 3.70 + (kWh - 500) * 5.04;
        } else if (kWh <= 1000) {
            cost = 120 * 1.68 + 210 * 2.45 + 170 * 3.70 + 200 * 5.04 + (kWh - 700) * 6.24;
        } else {
            cost = 120 * 1.68 + 210 * 2.45 + 170 * 3.70 + 200 * 5.04 + 300 * 6.24 + (kWh - 1000) * 8.46;
        }

        return (int) Math.round(cost);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆電費計算只需常數次判斷與加減乘除，走訪 n 筆資料，故總複雜度為 O(n)。
 */
