package coffeeMachine.main;

import static coffeeMachine.main.CoffeeMachine.*;

public class CoffeeMachineService {

    public void setProducts(int sugar, int beans, int water, int milk, int chocolate) {
        this.setProducts(sugar, beans, water, milk, chocolate);
    }

    //metodai, kurie kreipiasi i konstruktorius ir sukuria aparata
    public static CoffeeMachine makeCoffeeMachine(int sugar, int beans, int water, int milk, int chocolate, int usageCount) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(sugar, beans, water, milk, chocolate, usageCount);
        return coffeeMachine;
    }

    public static CoffeeMachine makeCoffeeMachine(int sugar, int beans, int water, int milk, int chocolate) {
        return makeCoffeeMachine(sugar, beans, water, milk, chocolate, 0);
    }

    public static CoffeeMachine makeCoffeeMachine(int sugar, int beans, int water) {
        return makeCoffeeMachine(sugar, beans, water, 0, 0, 0);
    }

    public static CoffeeMachine makeCoffeeMachine() {
        return makeCoffeeMachine(SUGAR_MAX, BEANS_MAX, WATER_MAX, MILK_MAX, CHOCOLATE_MAX, 0);
    }

    public static CoffeeMachine makeCoffeeMachine(Products products) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(products);
        return coffeeMachine;
    }

    // valo aparata
    public static CoffeeMachine cleanCoffeeMachine(CoffeeMachine machine) {
        machine.cleanMachine();
        return machine;
    }

    //sukuria daug aparatu
    public static CoffeeMachine[] makeMultipleCoffeeMachines(int n) {
        CoffeeMachine[] multipleMachines = new CoffeeMachine[n];
        for (int i = 0; i < n; i++) {
            multipleMachines[i] = makeCoffeeMachine();
        }

        return multipleMachines;
    }

//    Kuri išvalytų visus paduotų aparatų produktus ir pasakytų sumą kiek ko išvalė.
    public static void cleanProductsInMultipleMachines(CoffeeMachine[] machines) {
        int cleanedSugar = 0;
        int cleanedBeans = 0;
        int cleanedWater = 0;
        for (int i = 0; i < machines.length; i++) {
            cleanedSugar += machines[i].getSugarAmount();
            cleanedBeans += machines[i].getBeansAmount();
            cleanedWater += machines[i].getWaterAmount();

            machines[i].setAvailableProducts(0, 0, 0, 0,0);
        }

        System.out.println("Iš viso išvalyta cukraus: " + cleanedSugar);
        System.out.println("Iš viso išvalyta pupelių: " + cleanedBeans);
        System.out.println("Iš viso išvalyta vandens: " + cleanedWater);
    }

//    Išplautų visus per masyvą perduotus aparatus.
    public static void cleanMultipleMachines(CoffeeMachine[] machines) {
        for (int i = 0; i < machines.length; i++) {
            machines[i].cleanMachine();
        }
    }

//    Visiems aparatams priskirtų tą patį produktų objektą.
    public static void setSameProducts(CoffeeMachine[] machines, Products products) {
        for (int i = 0; i < machines.length; i++) {
            machines[i].setAvailableProducts(products);
        }
    }

//    Visiems aparatams priskirtų skirtingus produktų objektus.
    public static void setDifferentProducts(CoffeeMachine[] machines, Products products) {
        for (int i = 0; i < machines.length; i++) {
            Products products1 = machines[i].getAvailableProducts().getCopy();
            machines[i].setAvailableProducts(products1);
        }
    }
}

