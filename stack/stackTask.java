package stack;

import Exception.emptyStack;
import Exception.invalidValue;
import Exception.stackFull;

public class stackTask {

    public int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '/' || ch == '*') {
            return 2;
        }
        if (ch == '^') {
            return 3;
        }
        return 0;
    }

    //Simplified Algorithm for Parsing: 1+3*5-8/2
    public String infixTopostfix(String infix) throws emptyStack, invalidValue, stackFull {
        stackArrayDynamic operators = new stackArrayDynamic();
        infix += "-";//to push the last operators in postfix
        String postfix = "";
        for (int i = 0; i < (int) infix.length(); i++) {
            if (Character.isDigit(infix.charAt(i)) || Character.isLetter(infix.charAt(i))) {
                postfix += infix.charAt(i);
            } else if (infix.charAt(i) == '(') {//if current is (
                operators.Push(infix.charAt(i));
            } else if (infix.charAt(i) == ')') {//if current is )
                while ((char) operators.peek() != '(') {
                    postfix += operators.pop();
                }
                operators.pop();
            } else {
                //if current is ^
                if (infix.charAt(i) == '^') {
                    while (!operators.isEmpty() && precedence((char) operators.peek()) > precedence(infix.charAt(i))) {
                        postfix += operators.pop();
                    }
                } else {
                    while (!operators.isEmpty() && precedence((char) operators.peek()) >= precedence(infix.charAt(i))) {
                        postfix += operators.pop();
                    }
                }
                operators.Push(infix.charAt(i));
            }
        }
        return postfix;
    }

    //Postfix to Infix
    public String postfixToinfix(String postfix) throws emptyStack, invalidValue, stackFull {
        stackArrayDynamic operands = new stackArrayDynamic();
        String infix;
        String result;
        String first, second;
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if (ch == '^' || ch == '/' || ch == '*' || ch == '+' || ch == '-') {
                first = (String) operands.pop();
                second = (String) operands.pop();
                result = "(" + second + ch + first + ")";
                operands.Push(result);

            } else {
                operands.Push(ch + "");
            }
        }
        result = (String) operands.pop();
        infix = result;
        return infix;
    }

    public String infixToprefix(String infix) throws emptyStack, invalidValue, stackFull {
        stackArrayDynamic operators = new stackArrayDynamic();
        StringBuilder infix1 = new StringBuilder(infix);
        infix1.reverse();//to reverse String 
        String prefix = "";
        for (int i = 0; i < (int) infix1.length(); i++) {
            if (Character.isDigit(infix1.charAt(i)) || Character.isLetter(infix1.charAt(i))) {//check if number or charachter
                prefix += infix1.charAt(i);
            } else if (infix1.charAt(i) == ')') {//if current is (
                operators.Push(infix1.charAt(i));
            } else if (infix1.charAt(i) == '(') {//if current is )
                while ((char) operators.peek() != ')') {
                    prefix += operators.pop();//push digits untill ')'
                }
                operators.pop();//remove ')'
            } else {//push and pop digits in stack when current digit is lower precedence
                while (!operators.isEmpty() && precedence((char) operators.peek()) > precedence(infix1.charAt(i))) {
                    prefix += operators.pop();
                }
                operators.Push(infix1.charAt(i));
            }
        }
        while (!operators.isEmpty()) {//to add rest of stack elements in prefix String 
            prefix += operators.pop();
        }
        infix1.delete(0, infix1.length());//to delete previous String
        infix1.append(prefix);//to append new String 
        infix1.reverse();//to reverse String 
        prefix = infix1.toString();
        return prefix;
    }

    public double evalaute_postfix(String postfix) throws emptyStack, invalidValue, stackFull {
        stackArrayDynamic operands = new stackArrayDynamic();
        double infix = 0;
        double result = 0;
        double first = 0, second = 0;
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if (ch == '^' || ch == '/' || ch == '*' || ch == '+' || ch == '-') {
                first = Double.parseDouble(String.valueOf(operands.pop()));//convert Char to Double
                second = Double.parseDouble(String.valueOf(operands.pop()));
                switch (ch) {
                    case '+' ->
                        result = second + first;
                    case '-' ->
                        result = second - first;
                    case '*' ->
                        result = second * first;
                    case '/' ->
                        result = second / first;
                    case '^' ->
                        result = ((int) second ^ (int) first);
                }
                operands.Push(result);
            } else {
                operands.Push(Double.parseDouble(String.valueOf(ch)));
            }
        }
        infix = Double.parseDouble(String.valueOf(operands.pop()));
        return infix;
    }

    //task 2 dr mostafa saad (data structure c++ course)
    public String reverse_stack(String word) {
        String result = "";
        word += " ";
        task1 s = new task1(word.length());
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                while (!s.isEmpty()) {
                    result += s.popp();
                }
                result += " ";
            } else {
                s.Push(word.charAt(i));
            }
        }
        return result;
    }

    //task 3 dr mostafa saad->  (int)1234>(int)4321
    public static int reverseNum(int num) throws invalidValue, stackFull, emptyStack {
        if (num == 0) {
            return 0;
        }
        stackArr s = new stackArr(30);
        while (num > 0) {
            s.Push(num % 10);
            num /= 10;
        }
        int tens = 1;
        while (!s.isEmpty()) {
            num = (int) s.pop() * tens + num;
            tens *= 10;
        }
        return num;
    }

    static char getOpenMatch(char ch) {
        if (ch == ')') {
            return '(';
        }
        if (ch == ']') {
            return '[';
        }
        return '{';
    }

    //task 4 dr mostafa saad (data structure c++ course)
    public static boolean isValid(String str) throws invalidValue, stackFull, emptyStack {
        stackArr s = new stackArr(30);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                s.Push(ch);
            } else if (s.isEmpty() || (char) s.pop() != getOpenMatch(ch)) {
                return false;
            }
        }
        return s.isEmpty();
    }

    //task 5 dr mostafa saad (data structure c++ course)
    public static stackArr removeDub(String str) throws invalidValue, stackFull, emptyStack {
        stackArr s = new stackArr(40);
        for (int i = 0; i < str.length(); i++) {
            if (!s.isEmpty() && s.peek().equals(str.charAt(i))) {
                s.pop();
            } else {
                s.Push(str.charAt(i));
            }
        }
        return s;
    }

    //check number is negative or not
    public static boolean isNegative(int n) {
        if (Math.signum(n) == -1) {
            return true;
        } else {
            return false;
        }
    }

    //Problem #1: Asteroid Collision
    public static stackArr Asteroid_Collision(int[] arr) throws emptyStack, invalidValue, stackFull {
        stackArr<Integer> st = new stackArr(30);
        for (int i = 0; i < arr.length; i++) {
            if (isNegative(arr[i]) && !st.isEmpty()) {
                if ((arr[i] * -1) >= st.peek() && !isNegative(st.peek())) {
                    st.pop();
                } else if (isNegative(st.peek())) {
                    st.Push(arr[i]);
                }
            } else {
                st.Push(arr[i]);
            }
        }
        return st;
    }

    //scoreOfParentheses
    public static int scoreOfParentheses(String str) throws invalidValue, stackFull, emptyStack {
        stackArr<Integer> s = new stackArr(str.length());
        s.Push(0);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                s.Push(0);
            } else {
                int last = s.peek();
                s.pop();
                if (last == 0) {
                    last = 1;
                } else {
                    last *= 2;
                }
                int parent = last + s.peek();
                s.pop();
                s.Push(parent);
            }
        }
        return s.peek();
        /*
Let's parse
	    (()(()))(()(()))    Stack: 0  			[initial]
(            ()(()))(()(()))    Stack: 0, 0			[if ( just add 0: root value for this new (something)
((	 )(()))(()(()))    	Stack: 0, 0, 0
(()	 (()))(()(()))    	Stack: 0, 1	[if ) and last = 0, it means empty (), so we know its value is 1. Add to its parent
(()(	()))(()(()))    	Stack: 0, 1, 0
(()((	 )))(()(()))    	Stack: 0, 1, 0, 0
(()(()	  ))(()(()))    	Stack: 0, 1, 1		[3 = 2 * 1 + 1]
(()(())		)(()(()))    	Stack: 0, 3			[6 = 2 * 3 + 0]
(()(()))      (()(()))    	Stack: 6  			[observe single item again; complete sub-expression done]

The remaining does the same and end with 6 + 6 = 12
         */
    }

    public static stackArr Next_Greater_Element(int[] arr) throws invalidValue, stackFull {
        stackArr<Integer> s = new stackArr(30);
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > num) {
                    num = arr[j];
                    s.Push(num);
                    break;
                } else if (j == arr.length - 1) {
                    num = -1;
                    s.Push(-1);
                }
            }
        }
        return s;
    }
}
