import java.util.Scanner;

public class ds_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入圓的半徑：");
        double r = sc.nextDouble();
        double area = Math.PI * r * r;
        System.out.println("圓面積是：" + area);
    }
}