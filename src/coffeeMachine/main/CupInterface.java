package coffeeMachine.main;

public interface CupInterface {
    /**
     * Metodas, kuris isplauna puodeli ir grazina true/false
     * @return pavyko [true], nepavyko [false]
     */

    boolean clean();

    /**
     * @param product
     * @param amount - įpilama į puoodelį
     */
    void fill(ProductType product, int amount);

    /**puodelis tampa nebenaudojamas
    * */
    void crash();

    /**
     * ant puodelio atspausdinamas kavos pavadinimas
    * @param type - kavos tipas
     * */
    void setCoffeeType(CoffeeType type);

}
