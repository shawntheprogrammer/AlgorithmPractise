import java.util.*;

public class ExpressionEvaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = new String[]{"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
		System.out.print(evaluateExpression(arr));
	}
	
    public static int evaluateExpression(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        
        //take care of first priority, remove ( ) and * /
        for (int i = 0; i < expression.length; i++) {
            String token = expression[i];
            if (stack.isEmpty()) {
                stack.push(token);
            //make it to a number between "(" and ")"
            } else if (token.equals(")")) {
                int res = 0;
                int last = 0;
                while (!stack.peek().equals("(")) {
                    String token1 = stack.pop();
                    if (token1.equals("+")) {
                        res += last;
                    } else if (token1.equals("-")) {
                        res -= last;
                    } else {
                        last = Integer.valueOf(token1);
                    }
                }
                res += last;
                stack.pop();    //pop out "("
                expression[i--] = String.valueOf(res);
                //stack.push(String.valueOf(res));  //push the value within () to stack
            } else if (Character.isDigit(token.charAt(0))) {
                //two conditions.  peek() is a * / sign or + - sign or (
                if (stack.peek().equals("*") || stack.peek().equals("/")) {
                    String sign = stack.pop();
                    int num1 = Integer.valueOf(stack.pop());
                    int num2 = Integer.valueOf(token);
                    if (sign.equals("*")) {
                        stack.push(String.valueOf(num1 * num2));
                    } else {
                        stack.push(String.valueOf(num1 / num2));
                    }
                } else {
                    stack.push(token);
                }
            } else {
                //any signs
                stack.push(token);
            }
        }
        
        if (stack.size() == 1) {
            return Integer.valueOf(stack.pop());
        }
        
        
        //take care of +  and  -
        int res = 0;
        int last = 0;
        while (!stack.isEmpty()) {
            String token = stack.pop();
            if (token.equals("+")) {
                res += last;
            } else if (token.equals("-")) {
                res -= last;
            } else {
                last = Integer.valueOf(token);
            }
        }
        res += last;
        return res;
    }
}
