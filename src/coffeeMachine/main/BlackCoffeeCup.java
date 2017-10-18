package coffeeMachine.main;

import static coffeeMachine.main.CoffeeType.BLACK;

public class BlackCoffeeCup extends CoffeeCup {

    public BlackCoffeeCup(int sugar, int beans, int water, int milk, int chocolate) {
        products = new Products(sugar, beans, water, milk, chocolate);
        type = BLACK;
    }
}
