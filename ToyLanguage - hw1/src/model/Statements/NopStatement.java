package model.Statements;

import model.ProgramState;

public class NopStatement implements StatementInterface{
    public NopStatement() {}

    @Override
    public ProgramState execute(ProgramState state) {
        return state;
    }

    @Override
    public String toString() {
        return "\n";
    }
}
