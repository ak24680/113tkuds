public class array_mode_count {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 3, 1, 1, 1};

        int mode = numbers[0];  
        int maxCount = 0;        

        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }
            System.out.println("比對中：" + numbers[i] + " 出現次數 = " + count);

                if (count > maxCount) {
                maxCount = count;
                mode = numbers[i];
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}

/*說明此作法的時間複雜度為 O(n²)，是否可改善？是否可改善?
  可以
  如果允許使用 Map（例如 HashMap<Integer, Integer>），只需要單次走訪（O(n)）就能統計每個元素的出現次數，然後再找最大值，整體時間複雜度為 O(n)*/
