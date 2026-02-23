import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        while (n-- > 0) {
            String s = sc.nextLine().trim();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= s.length(); i++) {
                sb.append(s, 0, i);
            }
            System.out.println(sb);
        }
    }
}