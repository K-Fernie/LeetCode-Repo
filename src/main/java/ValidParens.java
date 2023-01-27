import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParens {
    public static void main(String[] args) {
        String valid = "{[]}";
        System.out.println(isValid(valid));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> maps = new HashMap<>();
        maps.put('}', '{');
        maps.put(')', '(');
        maps.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(maps.containsKey(c)){
                if(stack.empty()||stack.pop()!=maps.get(c))return false;
            }
            else
                stack.push(c);
        }
        return stack.empty();
    }
}
