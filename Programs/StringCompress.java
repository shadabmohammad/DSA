import java.util.*;
public class StringCompress {
    public static void main(String[] args) {
        String A = "aabccd";
        System.out.println(superReducedString(A));
    }
    static String superReducedString(String s) {
            char[] characters = s.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty() && characters[i] == stack.peek()) { // Exist
                    stack.pop(); // remove from stack.
                } else {
                    stack.push(characters[i]); // Save to stack
                }
            }

            if (!stack.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (char chr : stack) {
                    sb.append(chr);
                }
                return sb.toString();
            }

            return "Empty String";
    }


}
