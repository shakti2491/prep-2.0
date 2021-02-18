package algods.maths;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {
    public int calculate(String s) {
        Deque<Object> stack = new ArrayDeque<>();
        int n = 0;
        int operand = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = (int) Math.pow(10, n) * (int) (ch - '0') + operand;
                n += 1;
            } else if (ch != ' ') {
                if (n != 0) {
                    stack.push(operand);
                    n = 0;
                    operand = 0;
                }

                if (ch == '(') {
                    int res = evaluate(stack);
                    stack.pop();
                    stack.push(res);
                } else {
                    stack.push(ch);
                }

            }


        }
        if (n != 0)
            stack.push(operand);
        return evaluate(stack);

    }


    private int evaluate(Deque<Object> stack) {
        int res = 0;

        if (!stack.isEmpty())
            res = (int) stack.pop();

        while(!stack.isEmpty() && !((char)stack.peek() == ')')){
            char sign = (char) stack.pop();
            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;

    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        String test1 = "1 + 1";
        String test2 =" 2-1 + 2 ";
        String test3 ="(1+(4+5+2)-3)+(6+8)";
        if(bc.calculate(test1)==2 && bc.calculate(test2)==3 && bc.calculate(test3)==23)
            System.out.println("All tests passed.");
        else
            System.out.println("Tests failed.");
    }
}
