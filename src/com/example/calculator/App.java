package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();
        long a, b;
        char oper;
        String result = "", input;

        while(true) {
            while(true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                input = scan.next();
                if(isPositiveInteger(input)) {
                    a = Long.parseLong(input);
                    break;
                }
                else{
                    System.out.println("양의 정수를 입력하세요.");
                }
            }
            while(true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                input = scan.next();
                if(isPositiveInteger(input)) {
                    b = Long.parseLong(input);
                    break;
                }
                else{
                    System.out.println("양의 정수를 입력하세요.");
                }
            }
            System.out.print("사칙연산 기호를 입력하세요: ");
            oper = scan.next().charAt(0);

            System.out.println("결과: "+calculator.calculate(a, b, oper));

            System.out.println("더 계산하시켔습니까? (continue, exit, history)");
            input = scan.next();
            if(input.equals("exit")) break;
            else if(input.equals("history")){
                System.out.println("명령어를 입력하세요. (show, last, clear, pop)");
                switch(scan.next()){
                    case "show":
                        for(String h : calculator.getAllHistory())
                            System.out.println(h);
                        break;
                    case "last":
                        System.out.println(calculator.getLastHistory());
                        break;
                    case "clear":
                        System.out.println("cleared "+calculator.clearHistory()+" history");
                        break;
                    case "pop":
                        System.out.println("pop: "+calculator.deleteFirstHistory());
                        break;
                    default:
                        System.out.println("올바른 히스토리 명령어를 입력해주세요.");
                        System.out.println("show: 모든 히스토리 보기");
                        System.out.println("last: 최근 히스토리 보기");
                        System.out.println("clear: 모든 히스토리 삭제");
                        System.out.println("pop: 가장 오래된 히스토리 삭제");
                }
            }
        }
    }

    private static boolean isPositiveInteger(String input){
        char c;
        for(int i=0; i<input.length(); i++){
            c = input.charAt(i);
            if(c < '0' || '9' < c)
                return false;
        }
        return true;
    }
}