package model.Expressions;
import exceptions.ExpressionException;
import model.ADTs.MyDictionaryInterface;
import model.Values.Value;

public class ValueExpression implements Expression{
    private final Value expression;

    public ValueExpression(Value expression) {
        this.expression = expression;
    }

    @Override
    public Value eval(MyDictionaryInterface<String, Value> symbolTable) throws ExpressionException {
        return expression;
    }

    @Override
    public String toString() {
        return expression.toString();
    }
}
