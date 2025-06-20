import java.util.*;

public class FirstNonRepeating {
    public static void firstNonRepeating(String s) {
        // Initialize queue and frequency map
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            
            if (frequencyMap.get(c) == 1) {  // c is unique so far
                queue.add(c);
            }
            
            // Remove repeating characters from the front of the queue
            while (!queue.isEmpty() && frequencyMap.get(queue.peek()) > 1) {
                queue.poll();
            }
            
            // Print the first non-repeating character or 0 if none
            if (queue.isEmpty()) {
                System.out.print("0");
            } else {
                System.out.print(queue.peek());
            }
        }
    }

    public static void main(String[] args) {
        String s = "aabc";
        firstNonRepeating(s);  // Output: a00b
    }
}
