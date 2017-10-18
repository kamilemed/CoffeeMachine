package coffeeMachine.main;

import static coffeeMachine.main.CoffeeType.MOCHA;

public class MochaCup extends CoffeeCup {

    public MochaCup(int sugar, int beans, int water, int milk, int chocolate) {
        products = new Products(sugar, beans, water, milk, chocolate);
        type = MOCHA;
    }
}
