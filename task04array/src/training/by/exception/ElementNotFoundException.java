package training.by.exception;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(int value){
        super(String.format("Element is not found with value : '%s'", value));
    }
}
