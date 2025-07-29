import java.util.Scanner;

public class F06_ArraySecondLargest {
    static class Pair {
        int max;
        int second;
        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }
    
    static Pair findSecondLargest(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }
        int mid = (left + right) / 2;
        Pair leftPair = findSecondLargest(arr, left, mid);
        Pair rightPair = findSecondLargest(arr, mid + 1, right);

        int max, second;
        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.max);
        } else if (rightPair.max > leftPair.max) {
            max = rightPair.max;
            second = Math.max(rightPair.second, leftPair.max);
        } else { 
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.second);
        }
        return new Pair(max, second);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Pair result = findSecondLargest(arr, 0, n-1);
        System.out.println("SecondMax: " + result.second);
    }
}

/*
時間複雜度：O(n)
說明：遞迴過程中，每次分割陣列後向上合併結果，總共處理 n 個元素，每個元素最多被比較常數次，故整體時間為線性時間 O(n)。
*/
