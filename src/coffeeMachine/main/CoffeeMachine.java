package coffeeMachine.main;

import static coffeeMachine.main.CoffeeType.*;

public class CoffeeMachine {
    public final static int SUGAR_MAX = 250;
    public final static int BEANS_MAX = 500;
    public final static int WATER_MAX = 2000;
    public final static int MILK_MAX = 500;
    public final static int CHOCOLATE_MAX = 250;
    private final static int USAGE_LIMIT = 100;

    private Products availableProducts;
    private int usageCount;

    // Constructors
    public CoffeeMachine(int sugar, int beans, int water, int milk, int chocolate, int usageCount) {
        availableProducts = new Products(sugar, beans, water, milk, chocolate);
        this.usageCount = usageCount;
    }

    public CoffeeMachine(Products products) {
        this(products.getSugar(), products.getBeans(), products.getWater(), products.getMilk(), products.getChocolate(), 0);
    }

    // getters
    public Products getAvailableProducts() {
        return availableProducts;
    }

    public int getSugarAmount() {
        return availableProducts.getSugar();
    }

    public int getBeansAmount() {
        return availableProducts.getBeans();
    }

    public int getWaterAmount() {
        return availableProducts.getWater();
    }

    public int getMilkAmount() {
        return availableProducts.getMilk();
    }

    public int getChocolateAmount() {
        return availableProducts.getChocolate();
    }

    public int getUsageCount() {
        return usageCount;
    }

    // setters
    public void setAvailableProducts(Products products) {
        availableProducts = products;
    }

    public void setAvailableProducts(int sugar, int beans, int water, int milk, int chocolate) {
        setSugarAmount(sugar);
        setBeansAmount(beans);
        setWaterAmount(water);
        setMilkAmount(milk);
        setChocolateAmount(chocolate);
    }

    public void setSugarAmount(int sugar) {
        availableProducts.setSugar(sugar);
    }

    public void setBeansAmount(int beans) {
        availableProducts.setBeans(beans);
    }

    public void setWaterAmount(int water) {
        availableProducts.setWater(water);
    }

    public void setMilkAmount(int milk) {
        availableProducts.setMilk(milk);
    }

    public void setChocolateAmount(int chocolate) {
        availableProducts.setChocolate(chocolate);
    }

    public void setUsageCount(int count) {
        usageCount = count;
    }

    // fill products
    public void fillSugar() {
        availableProducts.setSugar(SUGAR_MAX);
    }

    public void fillBeans() {
        availableProducts.setBeans(BEANS_MAX);
    }

    public void fillWater() {
        availableProducts.setWater(WATER_MAX);
    }

    public void fillMilk() {
        availableProducts.setMilk(MILK_MAX);
    }

    public void fillChocolate() {
        availableProducts.setChocolate(CHOCOLATE_MAX);
    }

    public void fillAllProducts() {
        availableProducts.setSugar(SUGAR_MAX);
        availableProducts.setBeans(BEANS_MAX);
        availableProducts.setWater(WATER_MAX);
        availableProducts.setMilk(MILK_MAX);
        availableProducts.setChocolate(CHOCOLATE_MAX);
    }

    public CoffeeCup makeCoffee(CoffeeType type) throws UnableToMakeCoffeeException {
        switch (type) {
            case LATTE:
                return this.makeCoffee(LATTE, LATTE.sugar);
            case MOCHA:
                return this.makeCoffee(MOCHA, MOCHA.sugar);
            case FRAPPE:
                return this.makeCoffee(FRAPPE, FRAPPE.sugar);
            default:
                return this.makeCoffee(BLACK, BLACK.sugar);
        }
    }

    public CoffeeCup makeCoffee(CoffeeType type, int sugar) throws UnableToMakeCoffeeException {
        CoffeeCup cup;
        switch (type) {
            case LATTE:
                cup = this.makeCoffee(LATTE, sugar,  LATTE.chocolate);
                break;
            case MOCHA:
                cup = this.makeCoffee(MOCHA, sugar, MOCHA.chocolate);
                break;
            case FRAPPE:
                cup = this.makeCoffee(FRAPPE, sugar, FRAPPE.chocolate);
                break;
            default:
                cup = this.makeCoffee(BLACK, sugar, BLACK.chocolate);
                break;
        }

        return cup;
    }

    public CoffeeCup makeCoffee(CoffeeType type, int sugar, int chocolate) throws UnableToMakeCoffeeException {
        CoffeeCup cup;
        switch (type) {
            case LATTE:
                cup = this.makeCoffee(LATTE, sugar, LATTE.beans, LATTE.water, LATTE.milk, chocolate);
                break;
            case MOCHA:
                cup = this.makeCoffee(MOCHA, sugar, MOCHA.beans, MOCHA.water, MOCHA.milk, chocolate);
                break;
            case FRAPPE:
                cup = this.makeCoffee(FRAPPE, sugar, FRAPPE.beans, FRAPPE.sugar, FRAPPE.milk, chocolate);
                break;
            default:
                cup = this.makeCoffee(BLACK, sugar, BLACK.beans, BLACK.sugar, BLACK.milk , chocolate);
                break;
        }

        return cup;
    }

    public CoffeeCup makeCoffee(CoffeeType type, int sugar, int beans, int water, int milk, int chocolate) throws UnableToMakeCoffeeException {
        if (!isClean()) {
            System.out.println("Išplaukite kavos aparatą");
            throw new UnableToMakeCoffeeException();
        }

        CoffeeCup cup;
        switch (type) {
            case LATTE:
                cup = new LatteCup(sugar, beans, water, milk, chocolate);
                break;
            case MOCHA:
                cup = new MochaCup(sugar, beans, water, milk, chocolate);
                break;
            case FRAPPE:
                cup = new FrappeCup(sugar, beans, water, milk, chocolate);
                break;
            default:
                cup = new BlackCoffeeCup(sugar, beans, water, milk, chocolate);
                break;
        }

        try {
            makeCoffee(cup);
        } catch (InsufficientProductsException e) {
            throw new UnableToMakeCoffeeException();
        }

        return cup;
    }

    public void makeCoffee(CoffeeCup cup) throws InsufficientProductsException {
        if (checkResources(cup.products)) {
            System.out.println("Aparatas pasiruošęs pagaminti kavą");
            availableProducts.setSugar(availableProducts.getSugar() - cup.products.getSugar());
            availableProducts.setBeans(availableProducts.getBeans() - cup.products.getBeans());
            availableProducts.setWater(availableProducts.getWater() - cup.products.getWater());
            availableProducts.setMilk(availableProducts.getMilk() - cup.products.getMilk());
            availableProducts.setChocolate(availableProducts.getChocolate() - cup.products.getChocolate());
            cup.isDone = true;
            this.usageCount++;
        } else {
            throw new InsufficientProductsException();
        }
    }

    public boolean checkResources(Products products) {
        boolean available = true;

        if (availableProducts.getSugar() < products.getSugar()) {
            System.out.println("Papildykite cukraus kiekį");
            available = false;
        }

        if (availableProducts.getBeans() < products.getBeans()) {
            System.out.println("Papildykite pupelių kiekį");
            available = false;
        }

        if (availableProducts.getWater() < products.getWater()) {
            System.out.println("Papildykite vandens kiekį");
            available = false;
        }

        if (availableProducts.getMilk() < products.getMilk()) {
            System.out.println("Papildykite pieno kiekį");
            available = false;
        }

        if (availableProducts.getChocolate() < products.getChocolate()) {
            System.out.println("Papildykite šokolado kiekį");
            available = false;
        }

        return available;
    }

    public void resourcesStatus() {
        System.out.println("Likęs cukraus kiekis: " + availableProducts.getSugar() + " g");
        System.out.println("Likęs kavos pupelių kiekis: " + availableProducts.getBeans() + " g");
        System.out.println("Likęs vandens kiekis: " + availableProducts.getWater() + " ml");
        System.out.println("Likęs pieno kiekis: " + availableProducts.getMilk() + " ml");
        System.out.println("Likęs šokolado kiekis: " + availableProducts.getChocolate() + " ml");
        System.out.println();
    }

    public void cleanMachine() {
        this.usageCount = 0;
    }

    public boolean isClean() {
        return this.usageCount < USAGE_LIMIT;
    }

    public void usageAvailable() {
        System.out.println("Liko iki plovimo: " + (USAGE_LIMIT - usageCount));
        System.out.println();
    }
}
