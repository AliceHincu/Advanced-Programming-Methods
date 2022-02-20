package model;

import model.ADTs.MyDictionaryInterface;
import model.ADTs.MyListInterface;
import model.ADTs.MyStackInterface;
import model.Statements.StatementInterface;
import model.Values.Value;

public class ProgramState {
    private MyStackInterface<StatementInterface> exeStack;
    private MyDictionaryInterface<String, Value> symbolTable;
    private MyListInterface<Value> out;
    StatementInterface originalProgram; // optional field, but good to have


    public ProgramState(MyStackInterface<StatementInterface> exeStack, MyDictionaryInterface<String, Value> symbolTable, MyListInterface<Value> out) {
        this.exeStack = exeStack;
        this.symbolTable = symbolTable;
        this.out = out;
    }

    public ProgramState(MyStackInterface<StatementInterface> exeStack, MyDictionaryInterface<String, Value> symbolTable, MyListInterface<Value> out, StatementInterface originalProgram) {
        this.exeStack = exeStack;
        this.symbolTable = symbolTable;
        this.out = out;
        this.originalProgram = originalProgram;
        exeStack.push(this.originalProgram);
    }

    public MyStackInterface<StatementInterface> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyStackInterface<StatementInterface> exeStack) {
        this.exeStack = exeStack;
    }

    public MyDictionaryInterface<String, Value> getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(MyDictionaryInterface<String, Value> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public MyListInterface<Value> getOut() {
        return out;
    }

    public void setOut(MyListInterface<Value> out) {
        this.out = out;
    }

    public StatementInterface getOriginalProgram() {
        return originalProgram;
    }

    public void setOriginalProgram(StatementInterface originalProgram) {
        this.originalProgram = originalProgram;
    }

    @Override
    public String toString() {
        //", originalProgram=" + originalProgram +

        return ">>> ProgramState: " + "\n" +
                "* exeStack= " + exeStack.toString() + "\n" +
                "* symbolTable= " + symbolTable + "\n" +
                "* out=" + out + "\n\n";
    }
}
