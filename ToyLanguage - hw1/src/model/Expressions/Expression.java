package model.Expressions;

import exceptions.InterpreterException;
import model.ADTs.MyDictionaryInterface;
import model.Values.Value;

public interface Expression {
    Value eval(MyDictionaryInterface<String, Value> SymbolTable) throws InterpreterException;
}
