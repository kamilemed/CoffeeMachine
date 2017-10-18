package coffeeMachine.main;

public enum ProductType {
    SUGAR,
    BEANS,
    WATER,
    MILK,
    CHOCOLATE;

    public static ProductType getProductType(int type) {
        switch (type) {
            case 1: return SUGAR;
            case 2: return BEANS;
            case 3: return WATER;
            case 4: return MILK;
            default: return CHOCOLATE;
        }
    }
}
