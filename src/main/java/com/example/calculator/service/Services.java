package com.example.calculator.service;

import com.example.calculator.models.SinglyLinkedListStack;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
@AllArgsConstructor
@Service
public class Services {
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";
    private static final String POW = "^";

    private HistoryService historyService;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String calculate(String input) throws Throwable {
        String firstInput = input;
        input = new String();
        input = infixToPostfix(firstInput);
        SinglyLinkedListStack<Double> stack = new SinglyLinkedListStack<>();

        String[] inputs = input.split(" ");

        String answer;
        try {
            answer = String.valueOf(handleCalculation(stack, inputs));
            System.out.println(answer);
        }catch (NumberFormatException nf){
            answer = "error";
            System.out.println("Wrong input");
        }
        historyService.addToDB(firstInput,answer);
        return answer;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static Double handleCalculation(SinglyLinkedListStack<Double> stack, String[] el) {
        Double operand1, operand2;

        for(int i = 0; i < el.length; i++) {
            if( el[i].equals(ADD) || el[i].equals(SUB) || el[i].equals(MUL) || el[i].equals(DIV) || el[i].equals(POW)) {
                operand2 = stack.pop();
                operand1 = stack.pop();
                switch(el[i]) {
                    case ADD: {
                        Double local = operand1 + operand2;
                        stack.push(local);
                        break;
                    }

                    case SUB: {
                        Double local = operand1 - operand2;
                        stack.push(local);
                        break;
                    }

                    case MUL: {
                        Double local = operand1 * operand2;
                        stack.push(local);
                        break;
                    }

                    case DIV: {
                        Double local = operand1 / operand2;
                        stack.push(local);
                        break;
                    }

                    case POW:{
                        Double local = 1.0;
                        for(int j =0;j<operand2;j++)
                            local *= operand1;
                        stack.push(local);
                        break;
                    }
                }
            } else {
                stack.push(Double.parseDouble(el[i]));
            }
        }
        return stack.pop();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static int Prec(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static String infixToPostfix(String exp) throws Throwable {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Deque<Character> stack
                = new ArrayDeque<Character>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c)|| c == '.')
                result += c;

                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(') {
                    result+=" ";

                    result += stack.peek();
                    stack.pop();
                }

                try {
                    stack.pop();
                }catch (Exception e){
                    System.out.println("Error");
                    return "Error";
                }

                //stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty()
                        && Prec(c) <= Prec(stack.peek())) {
                    result+=" ";

                    result += stack.peek();
                    stack.pop();

                }
                result+=" ";
                stack.push(c);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                System.out.println("Error");
                return "Error";
            }
            result+=" ";

            result += stack.peek();
            stack.pop();
        }

        System.out.println(result);
        return result;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String sinCalculator(String input){
        String ans;
        try {
            ans = String.valueOf(Math.sin(Double.parseDouble(input)));
        }catch (Exception e){
            System.out.println("Wrong input");
            ans = "error";
        }
        historyService.addToDB("sin" + input,String.valueOf(ans));

        return String.valueOf(ans);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String cosCalculator(String input){
        String ans;
        try {
            ans = String.valueOf(Math.cos(Double.parseDouble(input)));
        }catch (Exception e){
            System.out.println("Wrong input");
            ans = "error";
        }
        historyService.addToDB("cos" + input,String.valueOf(ans));
        return String.valueOf(ans);

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String tanCalculator(String input){
        String ans;
        try {
            ans = String.valueOf(Math.tan(Double.parseDouble(input)));
        }catch (Exception e){
            System.out.println("Wrong input");
            ans = "error";
        }
        historyService.addToDB("Tan" + input,String.valueOf(ans));
        return String.valueOf(ans);

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////







}
