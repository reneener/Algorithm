import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : number.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && c > stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // 역순으로 정렬되어있는 경우 
        while(k > 0){
            stack.pop();
            k--;
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}