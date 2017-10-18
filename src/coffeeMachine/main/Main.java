package coffeeMachine.main;

import java.util.Scanner;

import static coffeeMachine.main.CoffeeMachineService.*;
import static coffeeMachine.main.CoffeeType.*;

public class Main {
    public static void main(String[] args)  {
        CoffeeMachine machine = makeCoffeeMachine();

        String input;
        do {
            printMainMenu();
            input = input();
            switch (input) {
                case "1":
                    prepareCoffee(machine);
                    break;
                case "2":
                    machine.resourcesStatus();
                    break;
                case "3":
                    machine.usageAvailable();
                    break;
                case "4":
                    refillProducts(machine);
                    break;
                case "5":
                    machine.cleanMachine();
                    System.out.println("Aparatas išvalytas");
                    machine.usageAvailable();
                    break;
                case "6":
                    System.out.println("Viso gero");
                    break;
                default:
                    System.out.println("Tokio pasirinkimo nėra");
                    System.out.println();
                    break;
            }
        } while (!input.equals("6"));
    }

    private static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void printMainMenu() {
        System.out.println("Pasirinkite veiksmą:");
        System.out.println("1 - daryti kavos");
        System.out.println("2 - žiūrėti aparate likusių produktų kiekį");
        System.out.println("3 - žiūrėti, kiek dar galima pagaminti kavos puodelių iki aparato valymo");
        System.out.println("4 - papildyti produktu");
        System.out.println("5 - išvalyti aparata");
        System.out.println("6 - išjungti");
    }

    // Methods for making coffee
    private static void printCoffeeMenu() {
        System.out.println("Pasirinkite kavą:");
        System.out.println("1 - Latte");
        System.out.println("2 - Mocha");
        System.out.println("3 - Frappe");
        System.out.println("4 - Juoda");
    }

    private static void prepareCoffee(CoffeeMachine machine) {
        printCoffeeMenu();
        String[] validInput = {"1", "2", "3", "4"};
        CoffeeType type = getCoffeeType(Integer.parseInt(getInput(validInput)));
        try {
            CoffeeCup cup = machine.makeCoffee(type);
            if (cup.isDone) {
                System.out.println("Kava " + type + " pagaminta, paimkite puodelį");
                System.out.println();
            } else {
                System.out.println("Kavos " + type + " pagaminti nepavyko");
                System.out.println();
            }
        } catch (UnableToMakeCoffeeException e) {
            System.out.println();
            System.out.println("Kavos pagaminti nepavyko");
            System.out.println();
        }
    }

    private static String getInput(String[] validInput) {
        while (true) {
            try {
                return readValidInput(validInput);
            } catch (IllegalInputException e) {
                System.out.println("Pasirinktos funkcijos nėra, rinkitės dar kartą");
                System.out.println();
            }
        }
    }

    private static String readValidInput(String[] validInput) throws IllegalInputException {
        String input = input();
        for (String in : validInput) {
            if (in.equals(input)) {
                return input;
            }
        }
        throw new IllegalInputException();
    }

    // methods for refilling products
    private static void printProductsRefillMenu() {
        System.out.println("Pasirinkite, ko norite papildyti");
        System.out.println("1 - papildyti cukraus");
        System.out.println("2 - papildyti pupelių");
        System.out.println("3 - papildyti vandens");
        System.out.println("4 - papildyti pieno");
        System.out.println("5 - papildyti šokolado");
        System.out.println("6 - papildyti visų produktų");
    }

    private static void refillProducts(CoffeeMachine machine) {
        printProductsRefillMenu();
        String[] validInput = {"1", "2", "3", "4", "5", "6"};
        String input = getInput(validInput);
        switch (input) {
            case "1":
                machine.fillSugar();
                System.out.println("Cukraus kiekis papildytas");
                System.out.println("Likęs cukraus kiekis: " + machine.getSugarAmount()+" g");
                System.out.println();
                break;
            case "2":
                machine.fillBeans();
                System.out.println("Pupelių kiekis papildytas");
                System.out.println("Likęs pupelių kiekis: " + machine.getBeansAmount()+" g");
                System.out.println();
                break;
            case "3":
                machine.fillWater();
                System.out.println("Vandens kiekis papildytas");
                System.out.println("Likęs vandens kiekis: " + machine.getBeansAmount()+" ml");
                System.out.println();
                break;
            case "4":
                machine.fillMilk();
                System.out.println("Pieno kiekis papildytas");
                System.out.println("Likęs pieno kiekis: " +machine.getBeansAmount()+" ml");
                System.out.println();
                break;
            case "5":
                machine.fillChocolate();
                System.out.println("Šokolado kiekis papildytas");
                System.out.println("Likęs šokolado kiekis: " + machine.getBeansAmount()+" ml");
                System.out.println();
                break;
            case "6":
                machine.fillAllProducts();
                System.out.println("Produktų kiekis papildytas");
                machine.resourcesStatus();
                System.out.println();
                break;
        }
    }
}

