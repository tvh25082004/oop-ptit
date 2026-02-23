import java.util.*;

class NotContainVowelException extends Exception {
    public NotContainVowelException(String message) {
        super(message);
    }
}

class Main {
    static void checkVowel(String s) throws NotContainVowelException {
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                return;
            }
        }
        throw new NotContainVowelException("String not contain vowels");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine().trim();
            try {
                checkVowel(s);
                System.out.println("String has vowels");
            } catch (NotContainVowelException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}