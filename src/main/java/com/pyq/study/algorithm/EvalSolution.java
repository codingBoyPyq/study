package com.pyq.study.algorithm;



import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * <p>
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvalSolution {

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        List<String> oprators = Arrays.asList("+","-","*","/");
        Stack<Integer> stack = new Stack();
        for(int i=0;i<tokens.length;i++) {
            if(!oprators.contains(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            }else {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(evaluate(a,b,tokens[i]));
            }
        }
        return stack.pop();
    }
    private static  int evaluate(int a ,int b ,String oprator) {
        switch(oprator){
            case "+":return a+b;
            case "-":return a-b;
            case "*":return a*b;
            case "/":return a/b;
            default:return 0;
        }
    }

    public static void main(String[] args) {
        String[] expression1 = {"2", "1", "+", "3", "*"};
        String[] expression2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(expression2));
    }
}
