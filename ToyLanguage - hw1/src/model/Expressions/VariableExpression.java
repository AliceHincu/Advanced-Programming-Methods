package model.Expressions;

import exceptions.InterpreterException;
import model.ADTs.MyDictionaryInterface;
import model.Values.Value;

public class VariableExpression implements Expression{
    private final String id;

    public VariableExpression(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return this.id;
    }

    @Override
    public Value eval(MyDictionaryInterface<String, Value> SymbolTable) throws InterpreterException {
        return SymbolTable.lookup(this.id);
    }
}
