import java.util.Stack;
/*
Evaluate Reverse Polish Notation
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class EvaluateReversePolishNumber {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for(String s: tokens){
                switch(s){
                    case "+":
                        stack.push(stack.pop()+stack.pop());
                        break;
                    case "-":
                        int second =stack.pop();
                        int first = stack.pop();
                        stack.push(first-second);
                        break;
                    case "*":
                        stack.push(stack.pop()*stack.pop());
                        break;
                    case "/":
                        int second1 =stack.pop();
                        int first1 = stack.pop();
                        stack.push(first1/second1);
                        break;
                    default:
                        stack.push(Integer.parseInt(s));
                }
            }
            return stack.pop();
        }
        public static void main(String [] args){
            String[] input1 ={"2", "1", "+", "3", "*"};
            String[] input2={"4", "13", "5", "/", "+"};
            String[] input3={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
            EvaluateReversePolishNumber evaluateReversePolishNumber = new EvaluateReversePolishNumber();
            System.out.println("TESTCASE1: "+evaluateReversePolishNumber.evalRPN(input1));
            System.out.println("TESTCASE2: "+evaluateReversePolishNumber.evalRPN(input2));
            System.out.println("TESTCASE3: "+evaluateReversePolishNumber.evalRPN(input3));

        }
}
