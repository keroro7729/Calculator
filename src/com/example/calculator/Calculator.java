package com.example.calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private final List<Number> history;

    public Calculator(){
        history = new LinkedList<>();
    }

    private <A extends Number, B extends Number> Number add(A a, B b){
        Number result;
        if(a instanceof Long && b instanceof Long){
            result = a.longValue() + b.longValue();
        }
        else{
            result = a.doubleValue() + b.doubleValue();
        }
        history.add(result);
        return result;
    }

    private <A extends Number, B extends Number> Number subtract(A a, B b){
        Number result;
        if(a instanceof Long && b instanceof Long){
            result = a.longValue() - b.longValue();
        }
        else{
            result = a.doubleValue() - b.doubleValue();
        }
        return result;
    }

    private <A extends Number, B extends Number> Number multiply(A a, B b){
        Number result;
        if(a instanceof Long && b instanceof Long){
            result = a.longValue() * b.longValue();
        }
        else{
            result = a.doubleValue() * b.doubleValue();
        }
        history.add(result);
        return result;
    }

    private <A extends Number, B extends Number> Number divide(A a, B b) throws DivideByZeroException {
        if(b.doubleValue() == 0.0){
            throw new DivideByZeroException("divide by zero error: "+a+" / "+b);
        }
        Number result = a.doubleValue() / b.doubleValue();;
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

    public List<Number> getHistory(){
        return history;
    }

    public List<Number> historyOver(int n){
        return history.stream()
                .filter(v -> v.longValue() > n)
                .collect(Collectors.toList());
    }

    public List<Number> historyUnder(int n){
        return history.stream()
                .filter(v -> v.longValue() < n)
                .collect(Collectors.toList());
    }
}
