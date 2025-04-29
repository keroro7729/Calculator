package com.example.calculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {
    private List<String> history;
    private StringBuilder sb;

    public Calculator(){
        history = new LinkedList<>();
    }

    public Long add(long a, long b){
        sb = new StringBuilder();
        sb.append(a).append('+').append(b).append('=');
        if(a > Long.MAX_VALUE - b) {
            sb.append("overflow error");
            history.add(sb.toString());
            return null;
        }
        else {
            sb.append(a + b);
            history.add(sb.toString());
            return a + b;
        }
    }

    public Long subtract(long a, long b){
        sb = new StringBuilder();
        sb.append(a).append('-').append(b).append('=').append(a-b);
        history.add(sb.toString());
        return a - b;
    }

    public Long multiply(long a, long b){
        sb = new StringBuilder();
        sb.append(a).append('*').append(b).append('=');
        if(b != 0 && a > Long.MAX_VALUE / b) {
            sb.append("overflow error");
            history.add(sb.toString());
            return null;
        }
        else {
            sb.append(a * b);
            history.add(sb.toString());
            return a * b;
        }
    }

    public Double divide(long a, long b){
        sb = new StringBuilder();
        sb.append(a).append('/').append(b).append('=');
        if(b == 0) {
            sb.append("divide by zero error");
            history.add(sb.toString());
            return null;
        }
        else {
            sb.append((double)a / b);
            history.add(sb.toString());
            return (double)a / b;
        }
    }

    public String calculate(long a, long b, char oper){
        Long longResult;
        Double doubleResult;
        switch (oper){
            case '+':
                longResult = add(a, b);
                if(longResult == null)
                    return getLastHistory();
                else return longResult.toString();
            case '-':
                longResult = subtract(a, b);
                if(longResult == null)
                    return getLastHistory();
                else return longResult.toString();
            case '*':
                longResult = multiply(a, b);
                if(longResult == null)
                    return getLastHistory();
                else return longResult.toString();
            case '/':
                doubleResult = divide(a, b);
                if(doubleResult == null)
                    return getLastHistory();
                else return doubleResult.toString();
            default:
                return "unknown operator error";
        }
    }

    public String getLastHistory(){
        if(history.isEmpty())
            return "";
        return history.get(history.size()-1);
    }

    public List<String> getAllHistory(){
        return history;
    }

    public String deleteFirstHistory(){
        String first = history.get(0);
        history.remove(0);
        return first;
    }

    public int clearHistory(){
        int size = history.size();
        history.clear();
        return size;
    }
}
