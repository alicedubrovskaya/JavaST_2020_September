package training.by.exception;

import java.util.InputMismatchException;

public class IncorrectTypeOfElementsException extends InputMismatchException {
    public IncorrectTypeOfElementsException(){
        super(String.format("Incorrect type of entered elements"));
    }
}
