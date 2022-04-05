import java.util.Stack;

class EvalPostfix {

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

        // Loop through every character
        for (char token : expression.toCharArray()) {
            if (isDigit(token)) {
                numStk.push(toNum(token));
            }
            // Otherwise pop 2 and apply operation
            else {
                double first = numStk.pop();
                double second = numStk.pop();

                // *** Notice thats its second OP first which is different from evaluating prefix
                switch (token) {
                    case '+':
                        numStk.push(second + first);
                        break;

                    case '-':
                        numStk.push(second - first);
                        break;

                    case '*':
                        numStk.push(second * first);
                        break;

                    case '/':
                        numStk.push(second / first);
                        break;

                    default:
                        throw new IllegalArgumentException();
                }
            }

        }

        return numStk.pop();
    }

    public static void main(String... args) {
        String example1 = "1 2 8 * + 3 -";
        double e1Result = evaluate(example1);

        String example2 = "1 5 + 9 6 / * 3 5 * +";
        double e2Result = evaluate(example2);

        System.out.println("Example 1 result (Expected: 14) : " + e1Result);
        System.out.println("Example 2 result (Expected: 24) : " + e2Result);
    }
}