import java.util.Stack;
/*
Valid Parentheses
  Go to Discuss
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */

public class ValidParenthesis {
        public boolean isValid(String s) {
            if(s == null) return false;
            int size = s.length();
            if(size%2 == 1) return false;
            Stack<String> stack = new Stack<>();
            boolean flag = true;
            for(int i =0 ;i<size;i++){
                String str = s.substring(i,i+1);

                if(str.equals("[") || str.equals("{") || str.equals("(") ){
                    stack.push(str);
                }
                if(stack.empty()){
                    return false;
                }

                if(str.equals("]")){
                    String temp = stack.pop();
                    if(!temp.equals("[")) return false ;
                }
                if(str.equals("}")){
                    String temp = stack.pop();
                    if(!temp.equals("{")) return false;
                }
                if(str.equals(")")){
                    String temp = stack.pop();
                    if(!temp.equals("(")) return false;
                }
            }

            if(!stack.empty())
                return false;

            return true;
        }
        public static void main(String [] args){
            ValidParenthesis checkParenthesis = new ValidParenthesis();

            String input1="()";
            String input2="()[]{}";
            String input3="(]";
            String input4="([)]";
            String input5="{[]}";
            System.out.println("TestCase1 : "+checkParenthesis.isValid(input1));
            System.out.println("TestCase2 : "+checkParenthesis.isValid(input2));
            System.out.println("TestCase3 : "+checkParenthesis.isValid(input3));
            System.out.println("TestCase4 : "+checkParenthesis.isValid(input4));
            System.out.println("TestCase5 : "+checkParenthesis.isValid(input5));

        }
}
