package coffeeMachine.main;

public class CoffeeCup extends Cup {
    protected Products products;
    protected CoffeeType type;
    protected boolean isDone = false;

    @Override
    public String toString() {
        return "Kavos puodelis";
    }
}
