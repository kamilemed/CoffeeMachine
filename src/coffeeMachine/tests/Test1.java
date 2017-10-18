package coffeeMachine.tests;

import coffeeMachine.main.CoffeeMachine;
import coffeeMachine.main.CoffeeType;
import coffeeMachine.main.UnableToMakeCoffeeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static coffeeMachine.main.CoffeeMachineService.makeCoffeeMachine;
import static coffeeMachine.main.CoffeeType.LATTE;

public class Test1 {
    @Test
    public void givenCoffeeMachineFilledWithNotEnoughProducts_DoNotMakeCoffee() throws Exception {
        //given
        CoffeeMachine coffeeMachine = makeCoffeeMachine(10,10,10,10,10,10);
        try {
            coffeeMachine.makeCoffee(LATTE);
        } catch (UnableToMakeCoffeeException e) {
            Assertions.assertTrue(coffeeMachine.getSugarAmount() == 10);
            Assertions.assertTrue(coffeeMachine.getBeansAmount() == 10);
            Assertions.assertTrue(coffeeMachine.getWaterAmount() == 10);
            Assertions.assertTrue(coffeeMachine.getMilkAmount() == 10);
            Assertions.assertTrue(coffeeMachine.getChocolateAmount() == 10);
            Assertions.assertTrue(coffeeMachine.getUsageCount() == 10);
        }
    }

    @Test
    public void givenCoffeeMachineFilledWithEnoughProducts_MakeCoffee() throws Exception {
        //given
        CoffeeMachine coffeeMachine = makeCoffeeMachine();

        try {
            coffeeMachine.makeCoffee(LATTE);
        } catch (UnableToMakeCoffeeException e) {
            Assertions.assertTrue(coffeeMachine.getSugarAmount() == (CoffeeMachine.SUGAR_MAX - LATTE.sugar));
            Assertions.assertTrue(coffeeMachine.getBeansAmount() == (CoffeeMachine.BEANS_MAX - LATTE.beans));
            Assertions.assertTrue(coffeeMachine.getWaterAmount() == (CoffeeMachine.WATER_MAX - LATTE.water));
            Assertions.assertTrue(coffeeMachine.getMilkAmount() == (CoffeeMachine.MILK_MAX - LATTE.milk));
            Assertions.assertTrue(coffeeMachine.getChocolateAmount() == (CoffeeMachine.CHOCOLATE_MAX - LATTE.chocolate));
            Assertions.assertTrue(coffeeMachine.getUsageCount() == (1));
        }
    }
}
