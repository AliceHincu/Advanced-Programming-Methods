package repository;

import model.ProgramState;

import java.util.LinkedList;

public class Repository implements RepositoryInterface{
    private LinkedList<ProgramState> programStates;

    public Repository() {
        this.programStates = new LinkedList<>() ;
    }

    @Override
    public void addProgram(ProgramState state) {
        programStates.add(state);
    }

    @Override
    public ProgramState getCurrentProgram() {
        ProgramState current = programStates.get(0);
        programStates.removeFirst();
        return current;
    }
}
