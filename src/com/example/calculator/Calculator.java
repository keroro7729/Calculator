package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        long a = scan.nextLong();
        System.out.print("두 번째 숫자를 입력하세요: ");
        long b = scan.nextLong();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char oper = scan.next().charAt(0);

        String result = "";
        switch(oper){
            case '+': result = add(a, b); break;
            case '-': result = subtract(a, b); break;
            case '*': result = multiply(a, b); break;
            case '/': result = divide(a, b); break;
        }
        System.out.println(result);
    }

    private static String add(long a, long b){
        return String.valueOf(a + b);
    }
    private static String subtract(long a, long b){
        return String.valueOf(a - b);
    }
    private static String multiply(long a, long b){
        return String.valueOf(a * b);
    }
    private static String divide(long a, long b){
        if(b != 0) {
            return String.valueOf((double) a / b);
        }
        else return "나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.";
    }
}