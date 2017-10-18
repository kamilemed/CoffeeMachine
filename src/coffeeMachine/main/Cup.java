package coffeeMachine.main;

public abstract class Cup implements CupInterface {
    private Products products;
    private CoffeeType type;
    private int cupMaxCapacity = 300;
    private boolean usable = true;

    //    Turi metodą rodykInformaciją, kuris atspausdina kokios talpos puodelis
    public void showInformation() {
        System.out.println(cupMaxCapacity);
    }

    @Override
    public boolean clean() {
//        if (this.products.equals(productsEmpty)) {
//            return true;

        if (products.getSugar() == 0 && this.products.getBeans() == 0 && this.products.getWater() == 0 && this.products.getMilk() == 0 && this.products.getChocolate() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void fill(ProductType product, int amount) {
        switch (product) {
            case SUGAR:
                this.products.setSugar(amount);
                return;
            case BEANS:
                this.products.setBeans(amount);
                return;
            case WATER:
                this.products.setWater(amount);
                return;
            case MILK:
                this.products.setMilk(amount);
                return;
            case CHOCOLATE:
                this.products.setChocolate(amount);
                return;
        }
    }

    @Override
    public void crash() {
        usable = false;
    }

    @Override
    public void setCoffeeType(CoffeeType type) {
        this.type = type;
    }
}
