import java.util.*;

public class IsValid {
    public static boolean isValid(String s) {
        // Map of closing symbols to their corresponding opening symbols
        Map<Character, Character> matchingSymbols = new HashMap<>();
        matchingSymbols.put(')', '(');
        matchingSymbols.put('}', '{');
        matchingSymbols.put(']', '[');
        
        // Stack to hold opening symbols
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (matchingSymbols.containsValue(c)) {  // c is an opening symbol
                stack.push(c);
            } else {  // c is a closing symbol
                if (stack.isEmpty()) {  // Stack is empty, unpaired closing symbol
                    return false;
                } else {
                    char x = stack.pop();
                    if (matchingSymbols.get(c) != x) {  // Wrongly paired
                        return false;
                    }
                }
            }
        }
        
        return stack.isEmpty();  // Stack should be empty for a valid string
    }

    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(isValid(s));  // Output: true
    }
}