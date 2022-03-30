import java.util.Stack;

class EvalPrefix {

    // This method takes advantage of ascii values
    public static boolean isDigit(char token) {
        return (token >= '0' && token <= '9');
    }

    // This method also takes advantage of ascii values
    public static double toNum(char token) {
        return 1.0 * (token - '0');
    }

    /**
     * Goal: Evaulate a prefix expression
     * 
     * @precondition The prefix expression only contains + - / * or any single digit
     *               number
     * 
     * @param expression
     * @return the result of the expression
     */
    public static double evaluate(String expression) {
        // Get rid of whitespace
        expression = expression.replace(" ", "");

        Stack<Double> numStk = new Stack<>();

        // Loop through the string - character by character IN REVERSE
        char[] arr = expression.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            char token = arr[i];

            if (isDigit(token)) {
                numStk.push(toNum(token));
            }
            // Otherwise its an operator
            else {
                double first = numStk.pop();
                double second = numStk.pop();

                switch (token) {
                    case '+':
                        numStk.push(first + second);
                        break;

                    case '-':
                        numStk.push(first - second);
                        break;

                    case '*':
                        numStk.push(first * second);
                        break;

                    case '/':
                        numStk.push(first / second);
                        break;
                }
            }
        }

        return numStk.pop();
    }

    public static void main(String... args) {
        String example1 = "* + 6 9 - 3 1";
        double e1Result = evaluate(example1);

        String example2 = "+ - 8 2 4";
        double e2Result = evaluate(example2);

        String example3 = "+ - + / * 2 2 2 * + 3 4 - 3 2 6 5";
        double e3Result = evaluate(example3);

        System.out.println("Example 1 result (Expected: 30) : " + e1Result);
        System.out.println("Example 2 result (Expected: 10) : " + e2Result);
        System.out.println("Example 3 result (Expected: 08) : " + e3Result);

    }
}