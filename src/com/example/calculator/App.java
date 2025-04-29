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

            System.out.println("더 계산하시켔습니까? (exit 입력 시 종료)");
            if(scan.next().equals("exit")) break;
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