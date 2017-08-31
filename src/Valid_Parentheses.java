import java.util.Stack;

/**
 * Created by equation on 17-8-31.
 */
public class Valid_Parentheses {
    public static boolean is_Valid(String s){
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='('||ch=='['||ch=='{') stack.push(ch);
            else if(ch==')'){
                if(!stack.empty()&&stack.peek()=='(') stack.pop();
                else return false;
            }else if(ch==']'){
                if(!stack.empty()&&stack.peek()=='[') stack.pop();
                else return false;
            }else if(ch=='}'){
                if(!stack.empty()&&stack.peek()=='{') stack.pop();
                else return false;
            }
        }
        if(!stack.empty()) return false;
        return true;
    }
}
