package com.example.calculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {
    private final List<Double> history;

    public Calculator(){
        history = new LinkedList<>();
    }

    private <A extends Number, B extends Number> Double add(A a, B b){
        double result = a.doubleValue() + b.doubleValue();
        history.add(result);
        return result;
    }

    private <A extends Number, B extends Number> Double subtract(A a, B b){
        double result = a.doubleValue() - b.doubleValue();
        history.add(result);
        return result;
    }

    private <A extends Number, B extends Number> Double multiply(A a, B b){
        double result = a.doubleValue() * b.doubleValue();
        history.add(result);
        return result;
    }

    private <A extends Number, B extends Number> Double divide(A a, B b) throws DivideByZeroException {
        if(b.doubleValue() == 0){
            throw new DivideByZeroException("divide by zero error: "+a+" / "+b);
        }
        double result = a.doubleValue() / b.doubleValue();
        history.add(result);
        return result;
    }

    public <A extends Number, B extends Number> String calculate(A a, B b, OperatorType oper){
        switch(oper){
            case ADD: return add(a, b).toString();
            case SUB: return subtract(a, b).toString();
            case MUL: return multiply(a, b).toString();
            case DIV:
                try{
                    return divide(a, b).toString();
                } catch(DivideByZeroException e) {
                    return e.getMessage();
                }
            default: return "unknown operator error";
        }
    }

    public List<Double> getHistory(){
        return history;
    }

    public List<Double> historyOver(int n){
        return history.stream()
                .filter(v -> v > n)
                .toList();
    }

    public List<Double> historyUnder(int n){
        return history.stream()
                .filter(v -> v < n)
                .toList();
    }
}
