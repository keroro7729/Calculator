package com.example.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class App {
    private static final String EXIT = "exit", HISTORY = "history", OVER = "over", UNDER = "under";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        Calculator calculator = new Calculator();
        Number a, b;
        OperatorType oper;
        int n;

        while(true){
            System.out.println("수식 또는 명령어를 입력하세요.");
            input = reader.readLine().split(" ");

            if((a = parse(input[0])) != null){
                try {
                    oper = OperatorType.fromSymbol(input[1]);
                } catch (UnknownOperatorException e){
                    System.out.println(e.getMessage());
                    continue;
                }
                if((b = parse(input[2])) != null){
                    System.out.println("결과: "+calculator.calculate(a, b, oper));
                }
                else{
                    System.out.println("유효하지 않은 숫자입니다: "+input[2]);
                }
            }
            else if(input[0].equals(HISTORY)){
                try{
                    n = Integer.parseInt(input[2]);
                } catch(Exception e){
                    System.out.println("over/under 숫자를 입력하세요. (history over 3)");
                    continue;
                }
                switch(input[1]){
                    case OVER -> System.out.println(calculator.historyOver(n));
                    case UNDER -> System.out.println(calculator.historyUnder(n));
                    default -> System.out.println("over/under 숫자를 입력하세요. (history over 3)");
                }
            }
            else if(input[0].equals(EXIT)){
                break;
            }
            else{
                System.out.println("수식 (1 + 2) 또는");
                System.out.println("명령어 (history, exit)을 입력하세요.");
            }
        }
    }

    private static Number parse(String input){
        try{
            return Long.parseLong(input);
        } catch(Exception e1){
            try{
                return Double.parseDouble(input);
            } catch(Exception e2){
                return null;
            }
        }
    }
}