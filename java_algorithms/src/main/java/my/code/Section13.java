package my.code;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Section13
{
    public static void main(String[] args)
    {
        StdOut.println(">>>>>>>>> Start Execution");
        StdOut.printf(">>>>>>>>> Working dir:%s\n", System.getProperty("user.dir"));
        StdOut.printf(">>>>>>>>> Java Version:%s\n", System.getProperty("java.version"));
        StdOut.printf(">>>>>>>>> JAVA_HOME:%s\n", System.getProperty("java.home"));
        StdOut.printf(">>>>>>>>> CLASSPATH:%s\n", System.getProperty("java.class.path"));
        long start = System.currentTimeMillis();

        exercise_1_3_4();

        long end = System.currentTimeMillis();
        StdOut.printf(">>>>>>>>> total time in milliseconds:%s\n", end - start);
        StdOut.println(">>>>>>>>> End Execution");
    }

    public static boolean checkMatchingParentheses(String expression)
    {
        char c, p;

        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++)
        {
            c = expression.charAt(i);
            switch (c)
            {
                case '(':
                case '{':
                case '[':
                    s.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if (s.isEmpty())
                        return false;
                    p = s.pop();
                    if (p != '(' && c == ')' ||
                            p != '{' && c == '}' ||
                            p != '[' && c == ']')
                    {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }

        return s.isEmpty();
    }

    public static void exercise_1_3_4()
    {
        // Write a stack client Parentheses that reads in a text stream from standard
        // input and uses a stack to determine whether its parentheses are properly
        // balanced. For example, your program should print true for [()]{}{[()()]()}
        // and false for [(]).
        String expression = "[()]{}{[()()]()}"; // true
        StdOut.printf("%s: %s\n", expression, checkMatchingParentheses(expression));

        expression = "[{()()({[]}{{}})}]"; // true
        StdOut.printf("%s: %s\n", expression, checkMatchingParentheses(expression));

        expression = "[()]{{[())]()}"; // false
        StdOut.printf("%s: %s\n", expression, checkMatchingParentheses(expression));

    }

}
