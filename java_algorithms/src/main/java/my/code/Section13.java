package my.code;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Section13
{
    public static void main(String[] args) throws Exception
    {
        StdOut.println(">>>>>>>>> Start Execution");
        StdOut.printf(">>>>>>>>> Working dir:%s\n", System.getProperty("user.dir"));
        StdOut.printf(">>>>>>>>> Java Version:%s\n", System.getProperty("java.version"));
        StdOut.printf(">>>>>>>>> JAVA_HOME:%s\n", System.getProperty("java.home"));
        StdOut.printf(">>>>>>>>> CLASSPATH:%s\n", System.getProperty("java.class.path"));
        long start = System.currentTimeMillis();

        // for (int i = 0; i < 100; i++)
        // {
        // StdOut.printf("%s/%s/%s\n", StdRandom.uniformInt(1, 13),
        // StdRandom.uniformInt(1, 32),
        // StdRandom.uniformInt(1900, 3000));
        // }

        exercise_1_3_16();

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

    public static void exercise_1_3_9() throws Exception
    {
        // Note: the expression should have spaces in between each term and parenthesis
        String expression = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        Stack<String> s = new Stack<>();

        String[] tokens = expression.split("\\s");
        String op, v1, v2;
        for (int i = 0; i < tokens.length; i++)
        {
            String token = tokens[i];
            if (token.equals(")"))
            {
                v2 = s.pop();
                op = s.pop();
                v1 = s.pop();
                s.push(String.format("( %s %s %s )", v1, op, v2));
            }
            else if (token.matches("\\d+|[/\\*\\-\\+]"))
            {
                s.push(token);
            }
            else
            {
                throw new Exception(String.format("token:'%s' in the expression is invalid", token));

            }
        }

        StringBuilder sb = new StringBuilder();
        for (String x : s)
        {
            sb.insert(0, x);
        }

        StdOut.printf("Infix form: %s\n", sb.toString());
    }

    public static String infixToPostfix(String expression)
    {
        // Note: assumes the expression is fully parenthesized, thus no handling of
        // precedence rules is necessary
        Stack<String> s = new Stack<>();

        String[] tokens = expression.split("\\s");
        String op, v1, v2;
        for (String token : tokens)
        {
            if (token.equals("("))
                continue;
            if (token.equals(")"))
            {
                v2 = s.pop();
                op = s.pop();
                v1 = s.pop();
                s.push(String.format("%s %s %s", v1, v2, op));
            }
            else if (token.matches("\\d+|[/\\*\\-\\+]"))
            {
                s.push(token);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty())
        {
            sb.insert(0, s.pop());
        }
        return sb.toString();
    }

    public static void exercise_1_3_10()
    {
        String infixExpression;
        String postfixExpression;

        infixExpression = "( ( 1 + 22 ) * ( ( 3 - 444 ) * ( 5 - 6 ) ) )";
        postfixExpression = infixToPostfix(infixExpression);
        StdOut.printf("Postfix: %s\n", postfixExpression);
    }

    public static double evaluatePostfix(String postfixExpression) throws Exception
    {
        String[] tokens = postfixExpression.split("\\s");
        Stack<Object> s = new Stack<>();
        double v1, v2;
        for (String token : tokens)
        {
            if (token.matches("[/\\*\\+\\-]"))
            {
                v2 = (double) s.pop();
                v1 = (double) s.pop();
                switch (token)
                {
                    case "/":
                        s.push(v1 / v2);
                        break;
                    case "*":
                        s.push(v1 * v2);
                        break;
                    case "+":
                        s.push(v1 + v2);
                        break;
                    case "-":
                        s.push(v1 - v2);
                        break;

                }
            }
            else if (token.matches("\\-?\\d+(\\.?\\d+)?"))
            {
                s.push(Double.parseDouble(token));
            }
        }

        if (s.size() != 1)
        {
            for (Object o : s)
            {
                StdOut.println(o.toString());
            }
            throw new Exception("invalid postfix expression");
        }

        return (double) s.pop();
    }

    public static void exercise_1_3_11() throws Exception
    {
        String postfixExpression;

        postfixExpression = "1 22 + 3 444 - 5 6 - * *";
        StdOut.printf("Postfix: %s = %s\n", postfixExpression, evaluatePostfix(postfixExpression));
    }

    public static void exercise_1_3_15()
    {
        Queue<String> q = new Queue<>();
        int k = 10;
        int i = k;
        while (!StdIn.isEmpty() && i-- > 0)
        {
            q.enqueue(StdIn.readString());
        }

        while (!StdIn.isEmpty())
        {
            q.dequeue();
            q.enqueue(StdIn.readString());
        }

        StdOut.printf("%sth from last item is: '%s'\n", k, q.dequeue());
    }

    public static void exercise_1_3_16()
    {
        for (Date d : readDates())
        {
            StdOut.printf("%s\n", d.toString());
        }
    }

    public static Date[] readDates()
    {
        Queue<Date> q = new Queue<Date>();
        while (!StdIn.isEmpty())
        {
            q.enqueue(new Date(StdIn.readString()));
        }

        int n = q.size();
        Date[] arr = new Date[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = q.dequeue();
        }
        return arr;
    }
}
