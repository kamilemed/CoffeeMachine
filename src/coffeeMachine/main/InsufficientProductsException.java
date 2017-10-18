package coffeeMachine.main;

public class InsufficientProductsException extends Exception {
    public InsufficientProductsException() {
        super("Insufficient products");
    }
}
