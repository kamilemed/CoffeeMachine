package coffeeMachine.main;

public class Products {

    protected int sugar;
    protected int beans;
    protected int water;
    protected int milk;
    protected int chocolate;

    public Products(int sugar, int beans, int water, int milk, int chocolate) {
        this.sugar = sugar;
        this.beans = beans;
        this.water = water;
        this.milk = milk;
        this.chocolate = chocolate;
    }

    public Products(int sugar, int beans, int water) {
        this(sugar, beans, water, 0, 0);
    }

    public Products(int sugar) {
        this(sugar, 40, 100, 0, 0);
    }

    public Products() {
        this(10, 20, 100, 50, 10);
    }

    public Products getCopy() {
        Products products1 = new Products(this.sugar, this.beans, this.water, this.milk, this.chocolate);
        return products1;
    }

    public int getSugar() {
        return sugar;
    }

    public int getBeans() {
        return beans;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getChocolate() {
        return chocolate;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setChocolate(int chocolate) {
        this.chocolate = chocolate;
    }
}

