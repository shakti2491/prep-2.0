package algods.maths;

import java.util.*;

//s consists of digits, '+', '-', '*', '/', '(', and ')'.
public class BasicCalculatorWithAllOperators {

    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        q.offer('+');
        return cal(q);
    }

    public int cal(Queue<Character>q)
    {
        char sign = '+';
        int signBeforeOperand = 1;
        int operand = 0;
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty()) {
            char c = q.poll();
            if (c == ' ')
            {
                continue;
            }
            if(Character.isDigit(c))
                operand=operand*10 + c-'0';
            else if (c == '(')
            {
                operand = cal(q);
            }
            else if (c == ')')
            {
                break;
            }
            else
            {
                if(sign=='-')
                    st.push(-operand);
                if(sign=='+')
                    st.push(operand);
                if(sign=='*')
                {
                    st.push(st.pop()*operand);
                }
                if(sign=='/')
                {
                    st.push(st.pop()/operand);
                }

                operand=0;
                sign=c;

            }

        }
        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }


}

