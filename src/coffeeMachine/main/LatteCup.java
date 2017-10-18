package coffeeMachine.main;

import static coffeeMachine.main.CoffeeType.LATTE;

public class LatteCup extends CoffeeCup {

//    protected Products products;

    public LatteCup(int sugar, int beans, int water, int milk, int chocolate) {
        products = new Products(sugar, beans, water, milk, chocolate);
        type = LATTE;
    }
}

