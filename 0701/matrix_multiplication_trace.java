public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = {
            {5, 6},
            {7, 8}
        };

        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {         
            for (int j = 0; j < 2; j++) {     
                int sum = 0;
                StringBuilder trace = new StringBuilder();
                trace.append("計算位置 c[" + i + "][" + j + "]：");
                for (int k = 0; k < 2; k++) { 
                    sum += a[i][k] * b[k][j];
                    trace.append(a[i][k] + "*" + b[k][j]);
                    if (k < 1) {
                        trace.append(" + ");
                    }
                }
                trace.append(" = " + (a[i][0] * b[0][j]) + " + " + (a[i][1] * b[1][j]));
                trace.append(" = " + sum);
                System.out.println(trace);
                c[i][j] = sum;
            }
        }

        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*若矩陣維度為 n × n，則：

外層兩層 i、j 負責走訪結果矩陣的所有元素（n²）。

內層 k 負責內積運算，需要 n 次乘法加總。

總複雜度：O(n³)*/