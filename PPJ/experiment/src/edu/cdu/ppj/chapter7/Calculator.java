package edu.cdu.ppj.chapter7;


import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    private Deque<Integer> operands;//操作数栈
    private Deque<Character> operators;//操作符栈
    private String expression;//四则运算表达式

    public Calculator(String expression) {
        operands = new ArrayDeque<>();
        operators = new ArrayDeque<>();
        this.expression = expression;
    }

    public static void main(String[] args) {
        Calculator cc = new Calculator("9-6/2*7+3+9*5+4/2+6*8/4-8-8+6/8+6*8/8=");
        try {
            System.out.println(cc.expression + cc.processing());
        } catch (IllegalArgumentException e) {
            System.out.println("表达式错误[只允许一位非负整数的加减乘除运算]");
        } catch (ArithmeticException e) {
            System.out.println("算术运算错误[" + e.getMessage() + "]");
        }
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    private boolean highPriority(char operator1, char operator2) {
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
            return true;
        }
        return false;
    }

    private int compute(int operand1, int operand2, char operator) {
        int rs = 0;
        switch (operator) {
            case '+':
                rs = operand1 + operand2;
                break;
            case '-':
                rs = operand1 - operand2;
                break;
            case '*':
                rs = operand1 * operand2;
                break;
            case '/':
                rs = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return rs;
    }

    public int processing() {
        boolean alterOcurrs = true;//true:operand,false:operator
        for (int index = 0; index < expression.length(); index++) {
            char unknown = expression.charAt(index);
            boolean decision = false;
            if (alterOcurrs && (unknown >= '0' && unknown <= '9')) {
                operands.push(unknown - '0');
                decision = true;
                alterOcurrs = false;
            } else if (!alterOcurrs && (unknown == '+' || unknown == '-' || unknown == '*' ||
                    unknown == '/' || unknown == '=')) {
                if (operators.isEmpty()) {
                    operators.push(unknown);
                    decision = true;
                } else {
                    while (!decision) {
                        if (operators.isEmpty() || highPriority(unknown, operators.peek())) {
                            operators.push(unknown);
                            decision = true;
                        } else {
                            char operator = operators.pop();
                            int operand2 = operands.pop();
                            int operand1 = operands.pop();
                            operands.push(compute(operand1, operand2, operator));
                        }
                    }
                }
                alterOcurrs = true;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return operands.peek();
    }
}