package controller;


import exceptions.InterpreterException;
import model.ADTs.MyStackInterface;
import model.ProgramState;
import model.Statements.StatementInterface;
import repository.RepositoryInterface;

public class Controller {
    private RepositoryInterface repo;
    boolean displayFlag;

    public Controller(RepositoryInterface repo) {
        this.repo = repo;
        this.displayFlag = false;
    }

    public void addProgram(ProgramState newProgram) {
        this.repo.addProgram(newProgram);
    }


    public ProgramState oneStep(ProgramState state) throws InterpreterException {
        MyStackInterface<StatementInterface> stack = state.getExeStack();
        if(stack.isEmpty())
            throw new InterpreterException("prgstate stack is empty");
        StatementInterface currentStatement = stack.pop();
        return currentStatement.execute(state);
    }

    public String displayState(ProgramState state) {
        return state.toString();
    }

    public void setDisplayAll(Boolean flag) {
        this.displayFlag = flag;
    }

    public void allSteps() throws InterpreterException{
        ProgramState prg = repo.getCurrentProgram(); // repo is the controller field of type MyRepoInterface
        if(this.displayFlag)
            System.out.println(displayState(prg));
        while(!prg.getExeStack().isEmpty()){
            try{
                oneStep(prg);
            }catch(Exception e){
                throw new InterpreterException(e.getMessage());
            }
            if(this.displayFlag)
                System.out.println(displayState(prg));
        }
        if(!this.displayFlag) {
            System.out.println(displayState(prg));
        }
    }

}
