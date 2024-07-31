package datastructures.stack.problems;

import java.util.Stack;

public class EvaluatePostfixExpression {

    public static void main(String[] args) {
        System.out.println(evaluatePostfix("921*-8-4+"));
    }

    private static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (!Character.isDigit(character)) {
                Integer x = stack.pop();
                Integer y = stack.pop();
                switch (character) {
                    case '+':
                        stack.push(y + x);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(y * x);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                }
            } else
                stack.push(Character.getNumericValue(character));
        }
        return stack.pop();
    }
}
