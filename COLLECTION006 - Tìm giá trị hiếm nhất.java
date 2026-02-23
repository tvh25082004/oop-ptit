import java.util.*;

class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine().trim());
        
        for (int t = 0; t < T; t++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            
            // Đếm tần suất xuất hiện của từng giá trị
            Map<Integer, Integer> freq = new HashMap<>();
            for (int i = 1; i < tokens.length; i += 2) {
                int val = Integer.parseInt(tokens[i]);
                freq.put(val, freq.getOrDefault(val, 0) + 1);
            }
            
            // Tìm tần suất nhỏ nhất
            int minFreq = Collections.min(freq.values());
            
            // Tìm giá trị nhỏ nhất trong các giá trị có tần suất nhỏ nhất
            int result = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == minFreq) {
                    result = Math.min(result, entry.getKey());
                }
            }
            
            System.out.println(result);
        }
    }
}