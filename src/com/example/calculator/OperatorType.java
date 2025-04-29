package com.example.calculator;

public enum OperatorType {
    ADD("+"), SUB("-"), MUL("*"), DIV("/");

    private final String symbol;

    OperatorType(String symbol){
        this.symbol = symbol;
    }

    static OperatorType fromSymbol(String symbol){
        for(OperatorType oper : values()){
            if(oper.symbol.equals(symbol))
                return oper;
        }
        throw new UnknownOperatorException("unknown operator: "+symbol);
    }

    String getSymbol(){ return this.symbol; }
}
