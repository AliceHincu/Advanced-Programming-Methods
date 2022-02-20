package repository;

import model.ProgramState;

public interface RepositoryInterface {
    ProgramState getCurrentProgram();
    void addProgram(ProgramState state);
}
