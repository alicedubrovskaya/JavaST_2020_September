package by.training.exception;

public class BasketNotFoundException extends Exception  {
    public BasketNotFoundException(int id){
        super(String.format("Basket is not found with id : '%s'", id));
    }
}
