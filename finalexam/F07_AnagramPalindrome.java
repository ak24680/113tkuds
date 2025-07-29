import java.util.Scanner;

public class F07_AnagramPalindrome {

    static void countLetters(String s, int index, int[] freq) {
        if (index == s.length()) return;
        
        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            c = Character.toLowerCase(c);
            freq[c - 'a']++;
        }
        countLetters(s, index + 1, freq);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        int[] freq = new int[26];
        countLetters(input, 0, freq);

        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) oddCount++;
        }

        if (oddCount <= 1) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
}
