package algods.maths;

public class BasicCalculatorOptimal {
    int i = 0;
    public int calculate(String s) {

        int operand  = 0;
        int result = 0;
        int nextOperandSign = 1;


        while(i<s.length()){

            char ch = s.charAt(i++);
            if(Character.isDigit(ch)){

                operand = 10*operand+(int)(ch-'0');
            }
            else if(ch == ' '){}
            else if(ch == '('){
                operand = calculate(s);
            }
            else if(ch == ')'){
                break;
            }

            // if + or - operator
            else{
                result +=nextOperandSign*operand;
                nextOperandSign = ch=='+'?1:-1;
                operand = 0;
            }

        }
        return result + (nextOperandSign*operand);
    }

    public static void main(String[] args) {
        new BasicCalculatorOptimal().calculate("2147483647");
    }
}
