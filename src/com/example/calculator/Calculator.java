package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
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

            result = "";
            switch (oper) {
                case '+':
                    result = add(a, b);
                    break;
                case '-':
                    result = subtract(a, b);
                    break;
                case '*':
                    result = multiply(a, b);
                    break;
                case '/':
                    result = divide(a, b);
                    break;
                default:
                    result = "사칙연산 기호를 입력하세요. (+, -, *, /)";
            }
            System.out.println("결과: "+result);

            System.out.println("더 계산하시켔습니까? (exit 입력 시 종료)");
            if(scan.next().equals("exit")) break;
        }
    }

    private static String add(long a, long b){
        if(a > Long.MAX_VALUE - b){
            return "add() overflow error";
        }
        return String.valueOf(a + b);
    }
    private static String subtract(long a, long b){
        return String.valueOf(a - b);
    }
    private static String multiply(long a, long b){
        if(b != 0 && a > Long.MAX_VALUE / b){
            return "multiply() overflow error!";
        }
        return String.valueOf(a * b);
    }
    private static String divide(long a, long b){
        if(b == 0) {
            return "나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.";
        }
        else return String.valueOf((double) a / b);
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