import java.util.Stack;

class BalancedBrackets {
    // Some nice enum review :D
    enum Bracket {
        OPEN('['), CLOSED(']');

        private char bracket;

        private Bracket(char bracket) {
            this.bracket = bracket;
        }

        public char getBracket() {
            return this.bracket;
        }
    }

    /**
     * Assume that the only bracket used is '[' or ']' although it would not be hard
     * to handle more bracket
     * 
     * General plan:
     * 1. Create a stack and push every open bracket.
     * 2. Every time you encounter a closed bracket, pop an open bracket from the
     * stack
     * 3. Once you finish, if the stack is empty the expression is balanced
     * 
     * @param expression
     * @return Whether the expression brackets are balanced
     */
    public static boolean evaluate(String expression) {
        Stack<Bracket> stk = new Stack<Bracket>();

        // Loop through the string
        for (char c : expression.toCharArray()) {
            // If open bracket
            if (c == Bracket.OPEN.getBracket()) {
                stk.push(Bracket.OPEN);
            }
            // If closed bracket
            else if (c == Bracket.CLOSED.getBracket()) {
                // We can't pop if there is nothing to pop
                if (stk.size() <= 0)
                    return false;

                stk.pop();
            }
        }

        return (stk.size() == 0);
    }

    public static void main(String... args) {
        String balanced1 = "[1 + [ 2 + [ 3 + 4 + 5 ] + 6 ]]";

        String notBalanced1 = "] 1 + 4";
        String notBalanced2 = "[[[3 + 4]";

        System.out.println("Balanced1 Result (Expected: true) : " + evaluate(balanced1));
        System.out.println("notBalanced1 Result (Expected: false) : " + evaluate(notBalanced1));
        System.out.println("notBalanced2 Result (Expected: false) : " + evaluate(notBalanced2));
    }
}
