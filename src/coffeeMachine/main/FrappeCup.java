package coffeeMachine.main;

import static coffeeMachine.main.CoffeeType.FRAPPE;

public class FrappeCup extends CoffeeCup {

    public FrappeCup(int sugar, int beans, int water, int milk, int chocolate) {
        products = new Products(sugar, beans, water, milk, chocolate);
        type = FRAPPE;
    }
}
