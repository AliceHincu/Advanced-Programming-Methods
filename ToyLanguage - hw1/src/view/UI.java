package view;

import controller.Controller;
import model.ADTs.MyDictionary;
import model.ADTs.MyList;
import model.ADTs.MyStack;
import model.ProgramState;
import model.Statements.StatementInterface;

import java.util.Objects;
import java.util.Scanner;

public class UI {
    private Controller controller;
    private StatementInterface[] examples;

    public UI(Controller controller){
        this.controller = controller;
        this.examples = new Examples().exampleList();
    }

    public void printMenu(){
        System.out.println("""
                0. Exit
                1. See all programs
                2. Choose a program to execute""");

    }

    public void seePrograms(){
        System.out.println("""
                1 - int v; v=2; Print(v)
                2 - int a; int b; a=2+3*5;b=a+1; Print(b)
                3 - bool a; int v; a=true; (If a Then v=2 Else v=3); Print(v)
                
                """);
    }


    public void loadProgram(StatementInterface statement){
        ProgramState program = new ProgramState(
                new MyStack<>(),
                new MyDictionary<>(),
                new MyList<>(),
                statement);
        this.controller.addProgram(program);
    }

    public void executeProgram(){
        System.out.println("Which program do you want to execute?");
        Scanner scanner = new Scanner(System.in);
        System.out.println(">>");
        int option = scanner.nextInt();
        System.out.println("1 - With intermediate steps");
        System.out.println("0 - Without intermediate steps");
        System.out.println(">>");
        int option2 = scanner.nextInt();
        controller.setDisplayAll(Objects.equals(option2, 1));
        try{
            this.loadProgram(examples[option-1]);
            controller.allSteps();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void run(){
        System.out.println(" ----- INTERPRETER ----- ");
        Scanner scanner = new Scanner(System.in);
        printMenu();
        System.out.println(">>");
        String option = scanner.nextLine();
        while(!Objects.equals(option, "0")){
            switch (option) {
                case "1" -> seePrograms();
                case "2" -> executeProgram();
            }
            printMenu();
            System.out.println(">>");
            option = scanner.nextLine();
        }
    }
}
