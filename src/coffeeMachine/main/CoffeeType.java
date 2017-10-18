package coffeeMachine.main;

public enum CoffeeType {
    LATTE("latte", 20, 30, 170, 50, 0),
    MOCHA("mocha", 20, 30, 150, 50, 30),
    FRAPPE("frappe", 20, 20, 200, 50, 30),
    BLACK("black", 20, 50, 100, 0, 0);

    String type;
    public final int sugar;
    public final int beans;
    public final int water;
    public final int milk;
    public final int chocolate;

    CoffeeType(String type, int sugar, int beans, int water, int milk, int chocolate) {
        this.type = type;
        this.sugar = sugar;
        this.beans= beans;
        this.water = water;
        this.milk = milk;
        this.chocolate = chocolate;
    }

    public static CoffeeType getCoffeeType(int type) {
        switch (type) {
            case 1: return LATTE;
            case 2: return MOCHA;
            case 3: return FRAPPE;
            default: return BLACK;
        }
    }

    public static CoffeeType getCoffeeType(String type) {
        switch (type.toLowerCase()) {
            case "latte": return LATTE;
            case "mocha": return MOCHA;
            case "frappe": return FRAPPE;
            default: return BLACK;
        }
    }
}
