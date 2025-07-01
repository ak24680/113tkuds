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

