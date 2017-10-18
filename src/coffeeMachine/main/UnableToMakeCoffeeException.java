package coffeeMachine.main;

public class UnableToMakeCoffeeException extends Exception {
    public UnableToMakeCoffeeException() {
        super("Unable to make coffee");
    }
}
