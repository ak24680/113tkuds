import java.util.Scanner;

public class F03_ConvenienceHotItems {
    static class Item {
        String name;
        int qty;
        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            items[i] = new Item(name, qty);
        }

        for (int i = 1; i < n; i++) {
            Item key = items[i];
            int j = i - 1;
            while (j >= 0 && items[j].qty < key.qty) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }

        int limit = Math.min(10, n);
        for (int i = 0; i < limit; i++) {
            System.out.println(items[i].name + " " + items[i].qty);
        }

        sc.close();
    }
}

/*
 * 時間複雜度：O(n²)
 * 說明：使用插入排序法將陣列依銷量由大到小排序。
 *       插入排序在最壞情況下，需比較和搬移元素約 n² 次，
 *       其中 n 為輸入的商品數量。
 *       由於 n 最大為 200，使用此方法效能尚可接受。
 */

